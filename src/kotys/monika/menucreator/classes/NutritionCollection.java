/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kotys.monika.menucreator.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author oem
 */
public class NutritionCollection implements Cloneable{

    protected ArrayList<NutritionComponent> nutritionList;
       
    public NutritionCollection() {
        nutritionList = new ArrayList<>();
    }
    
    public NutritionComponent get(Integer i){
        return nutritionList.get(i);
    }
    
    public ArrayList<NutritionComponent> getNutritionList(){
        return nutritionList;
    }
    
    public void set(Integer i, NutritionComponent nutrition){
        nutritionList.set(i, nutrition);
    }
    
    public void add(NutritionComponent nutrition){
        nutritionList.add(nutrition);
    }
    
    public void remove(NutritionComponent nutrition){
        nutritionList.remove(nutrition);
    }
    
    public List<NutritionComponent> findByName(String name){
        return nutritionList.stream().filter( n -> n.getName().equals(name)).collect(Collectors.toList());
    }
    
    public List<NutritionComponent> findByType(String type){
        return nutritionList.stream().filter( n -> n.getType().equals(type)).collect(Collectors.toList());
    }
    
    public List<NutritionComponent> findByNameTypeUnit(String name, String type, String unit){
        return nutritionList.stream()
                .filter( n -> n.getName().equals(name) && n.getType().equals(type) && n.getUnit().equals(unit))
                .collect(Collectors.toList());
    }
    
    public Integer size(){
        return nutritionList.size();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        NutritionCollection objClone = (NutritionCollection) super.clone();
        objClone.nutritionList = (ArrayList<NutritionComponent>) nutritionList.stream()
                .map(n -> new NutritionComponent(n.getName(), n.getType(), n.getUnit(), n.getAmount()))
                .collect(Collectors.toList());
        return objClone;
    }
}
