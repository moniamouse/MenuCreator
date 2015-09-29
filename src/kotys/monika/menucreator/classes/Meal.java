package kotys.monika.menucreator.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Meal {

    private final ArrayList<MealComponent> menu;
    private final NutritionCollection nutritionList;
    private ArrayList<String> prescription;
    private String name;
    private String type;

    public Meal() {
        menu = new ArrayList();
        type = "";
        nutritionList = new NutritionCollection();
        prescription = new ArrayList<>();
    }

    public void addMealComponent(MealComponent mealComponent) {
        menu.add(mealComponent);
        updateNutritionList();
    }

    public void removeMealComponent(MealComponent mealComponent) {
        menu.remove(mealComponent);
        updateNutritionList();
    }

    public NutritionCollection getNutritionList() {
        return nutritionList;
    }

    public ArrayList<MealComponent> getComponentsList() {
        return menu;
    }

    public ArrayList<MealComponent> findComponent(String name) {
        ArrayList<MealComponent> founded = new ArrayList();
        menu.forEach( c->{
    if (c.getName().equals(name))
        founded.add(c);
});
        return founded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private void updateNutritionList() {
        // nie działa to tak jak ma, nutrition jest zerowy
        
        //final List<ArrayList<NutritionComponent>> nutr = menu.stream().map(mealComponent -> mealComponent.getNutrition().getNutritionList()).collect(Collectors.toList());
        //Kopiowanie nowych nutritioncomponents, jesli produkty różnią się między sobą
        final List<NutritionCollection> nutr = menu.stream()
                .map(mealComponent -> mealComponent.getNutrition()).collect(Collectors.toList());
        
        nutr.forEach(nc -> {
            nc.getNutritionList().forEach(n -> {
                    if(nutritionList.findByNameTypeUnit(n.getName(), n.getType(), n.getUnit()).isEmpty())
                        try {
                            nutritionList.add((NutritionComponent) n.clone());
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Meal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
        });
        
        nutritionList.getNutritionList().forEach( c->{c.setAmount(0);});
        nutritionList.getNutritionList().forEach ( c -> 
       {
           c.setAmount(nutr.stream()
                   .map(n -> n.findByNameTypeUnit(c.getName(), c.getType(), c.getUnit()).get(0).getAmount())
                   .collect(Collectors.summingDouble(d -> d.doubleValue())).floatValue());
                   
       });
       
    }
// int length = nutrition.size();
//    for (int i = 0; i < length; i++) {
//        if (!nutritionListContains(nutrition[i].getName())) {
//            try {
//                nutritionList.add((NutritionComponent) nutrition[i].clone());
//            } catch (CloneNotSupportedException ex) {
//                Logger.getLogger(Meal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            NutritionComponent nutrToUpdate = nutritionListFound(nutrition[i].getName()).get(0);
//            float updatedAmount = nutrToUpdate.getAmount() + nutrition[i].getAmount();
//            nutrToUpdate.setAmount(updatedAmount);
//        }
//    }
//});
//    }
//
//    private ArrayList<NutritionComponent> nutritionListFound(String name) {
//        ArrayList<NutritionComponent> founded = new ArrayList();
//        nutritionList.forEach( c->{
//    if (c.getName().equals(name))
//        founded.add(c);
//});
//        return founded;
//    }
//
//    private boolean nutritionListContains(String name) {
//        return !nutritionListFound(name).isEmpty();
//    }

    public void setPrescritption(ArrayList<String> prescription) {
        this.prescription = prescription;
    }

    public String getPrescritption() {
        StringBuilder prescPlainText = new StringBuilder();
        prescription.forEach(c-> {prescPlainText.append(c); prescPlainText.append(System.lineSeparator());});
        return prescPlainText.toString();
    }

    public ArrayList<String> getPrescritptionArray() {
        return this.prescription;
    }
    
}
