/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import com.opencsv.CSVReader;
import java.io.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotys.monika.menucreator.interfaces.IMenuCreatorLoader;
/**
 *
 * @author oem
 */


public class FoodComponentCollection_CSVLoader implements IMenuCreatorLoader{

    private final String name;
    private final String classNameForLoad;
    private final String dataSourceType;
    private final TreeMap<String, String> parameters;
    private boolean connected;
    private FoodComponentsCollection targetObject;
    private final TreeMap<String, Integer> mapping;
    final TreeMap<String, Integer> headers;
    private ArrayList<NutritionComponent> nutritionHeaders;
    private CSVReader reader;
    
    public FoodComponentCollection_CSVLoader() {
        name = "FoodComponentCollection CSV Loader";
        classNameForLoad = "FoodComponentCollection";
        dataSourceType = "CSV";
        parameters = new TreeMap<>();
        parameters.put("FilePath", "");
        parameters.put("Headears_Count", "");
        parameters.put("Separator", ";");
        parameters.put("DecimalSeparator", ".");
        headers = new TreeMap<>();
        headers.put("Name", 0);
        headers.put("Type", 0);
        headers.put("Unit", 0);
        connected = false;
        mapping = new TreeMap<>();   
        mapping.put("Name", 0);
        mapping.put("Code", 0);
        mapping.put("NutritionValues", 0);
        nutritionHeaders = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLoadedClassName() {
        return classNameForLoad;
    }

    @Override
    public String getDataSourceType() {
        return dataSourceType;
    }
    
    public TreeMap<String, Integer> getHeadersMaping(){
        return headers;
    }

    @Override
    public TreeMap<String, String> getDataSourceParameters() {
        return parameters;
    }

    @Override
    public boolean connect() throws InvalidParameterException {
        
        if(parameters.get("FilePath").isEmpty())
            throw new InvalidParameterException("FilePath is empty");
        try {
            reader = new CSVReader(new FileReader(parameters.get("FilePath")), parameters.get("Separator").charAt(0));
            connected = true;
            return true;
        } catch (FileNotFoundException ex) {
            connected = false;
            throw new InvalidParameterException("File " + parameters.get("FilePath") + " not found");
        }
    }
    
    public boolean disconnect(){
        if(isConnected())
            this.reader = null;
        connected = false;
        return false;
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public void setTargetObject(Object o) throws IllegalArgumentException{
        if (o instanceof FoodComponentsCollection) {              
            targetObject = (FoodComponentsCollection) o;
            if(targetObject.getFoodList().size() > 0){ 
                NutritionComponent[] nut1 = targetObject.getFoodList().get(0).getNutritionTable();
                nutritionHeaders = (ArrayList<NutritionComponent>)Arrays.asList( nut1); 
            }
            else
                nutritionHeaders = new ArrayList<>();
       }
       else
           throw new IllegalArgumentException("Argument should be of class FoodComponentCollection");
          
    }
    
    
    public Object getTargetObject() throws IllegalArgumentException{
      return targetObject;         
    }

    @Override
    public boolean loadData() throws Exception {
        java.io.File file;
        
        if(parameters.get("FilePath").isEmpty())
            throw new InvalidParameterException("FilePath parameter is empty");
        else
            file = new File(parameters.get("FilePath"));
        
        if((!nutritionHeaders.isEmpty() && filledMappings() < nutritionHeaders.size() - 2) || headers.get("Name") == 0)  
            throw new InvalidParameterException("There is no mapping for this CSV File, use getMapping");
            
        if(this.targetObject != null) {
        } else {
            targetObject = new FoodComponentsCollection(file.getName());
        }
        
        if(!connected)
            throw new Exception("Instance is not connected");
        
        String [] nextLine;
        String parameter = parameters.get("Headears_Count");
        int headerCount = 0;
        int nutNumber = 0;
        int nutrShift = 0;
        if(!(parameter.isEmpty()) && parameter.matches("\\d")){
            headerCount = Integer.parseInt(parameter);
            if(headers.get("Name") == 0 )
                throw new IllegalArgumentException("There should be at least header name");
            String[][] allHeaders = new String[headerCount][];
            for(int i = 0; i< headerCount; i++){
                try {
                    allHeaders[i] = reader.readNext();
                } catch (IOException ex) {
                    Logger.getLogger(FoodComponentCollection_CSVLoader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            int nameHeaderNum = headers.get("Name");
            int unitHeaderNum = headers.get("Unit");
            int typeHeaderNum = headers.get("Type");
            nutrShift = mapping.get("NutritionValues") - 1;
            nutNumber = allHeaders[nameHeaderNum].length - nutrShift;
            String type = "nutrition";
            String unit = "g";
            for(int i = 0 ; i < nutNumber; i++){
                if(headers.get("Type") > 0)
                    type = allHeaders[typeHeaderNum - 1][i + nutrShift];
                if(headers.get("Unit") > 0)    
                    unit = allHeaders[unitHeaderNum - 1][i + nutrShift];
                if(!isNutritionExists(allHeaders[nameHeaderNum - 1][i + nutrShift], type, unit))
                    nutritionHeaders.add(new NutritionComponent(allHeaders[nameHeaderNum - 1][i + nutrShift], type, unit, 0));
            } 
        }
        
        String foodComponentName;
        String foodComponentCode;
        NutritionComponent[] nutForCopy = new NutritionComponent[nutNumber];
        nutForCopy = (NutritionComponent[]) nutritionHeaders.toArray(nutForCopy);
        NutritionComponent[] nutr;
        float amount;
        FoodComponent foodComponent;
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(parameters.get("DecimalSeparator").charAt(0));
        DecimalFormat format = new DecimalFormat("0.#");
        format.setDecimalFormatSymbols(symbols);
        try {
            while ((nextLine = reader.readNext()) != null) {
                foodComponentName = nextLine[mapping.get("Name") -1];
                foodComponentCode = nextLine[mapping.get("Code") -1];
                
                int size = nutForCopy.length;
                nutr = new NutritionComponent[size];
                for(int i = 0; i<size; i++)
                    nutr[i] = (NutritionComponent) nutForCopy[i].clone();
                
                if(mapping.size() == 3){                    
                    for( int k = 0; k < nutNumber - nutrShift; k++){
                        amount = format.parse(nextLine[k + headerCount]).floatValue();
                        //amount = Float.parseFloat(nextLine[k + headerCount]);
                        // TODO: Decimal separator
                        nutr[k].setAmount(amount);
                       }
                    
               }
                else
                {
                    for( NutritionComponent nut: nutr)
                       nut.setAmount(Float.parseFloat(nextLine[mapping.get(nut.getName())]));
                }
                foodComponent = new FoodComponent(foodComponentName, foodComponentCode, nutr);
                targetObject.addFoodComponent(foodComponent);
            }   
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FoodComponentCollection_CSVLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean saveData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public TreeMap<String, Integer> getMapping(){
        //ToDo: Return fields from classes, that columns from csv can be assigned to
        if(mapping.size() < nutritionHeaders.size() - 2)
        {
            for(NutritionComponent nut: nutritionHeaders)
                if(mapping.containsKey(nut.getName()))  mapping.put(nut.getName(), 0);
        }
        return mapping;
    }

    private int filledMappings() {
        int count = 0;
        count = mapping.entrySet().stream().filter((entry) -> (entry.getValue() != 0)).map((_item) -> 1).reduce(count, Integer::sum);
        return count;
    }
        
    private boolean isNutritionExists(String nHeader, String type, String unit) {
        return nutritionHeaders.stream().anyMatch((nut) -> (nut.getName().equals(nHeader) && nut.getType().equals(type) && nut.getUnit().equals(unit)));
    }
    
}
