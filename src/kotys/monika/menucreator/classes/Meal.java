package kotys.monika.menucreator.classes;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Meal {

    private final ArrayList<MealComponent> menu;

    private final ArrayList<NutritionComponent> nutritionList;

    private String name;

    private String type;

    public Meal() {
        menu = new ArrayList();
        type = "";
        nutritionList = new ArrayList();
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

    public ArrayList<NutritionComponent> getNutritionList() {
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
        nutritionList.forEach( c->{
    c.setAmount(0);
});
        menu.forEach( c->{
    NutritionComponent[] nutrition = c.getNutrition();
    int length = nutrition.length;
    for (int i = 0; i < length; i++) {
        if (!nutritionListContains(nutrition[i].getName())) {
            try {
                nutritionList.add((NutritionComponent) nutrition[i].clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Meal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            NutritionComponent nutrToUpdate = nutritionListFound(nutrition[i].getName()).get(0);
            float updatedAmount = nutrToUpdate.getAmount() + nutrition[i].getAmount();
            nutrToUpdate.setAmount(updatedAmount);
        }
    }
});
    }

    private ArrayList<NutritionComponent> nutritionListFound(String name) {
        ArrayList<NutritionComponent> founded = new ArrayList();
        nutritionList.forEach( c->{
    if (c.getName().equals(name))
        founded.add(c);
});
        return founded;
    }

    private boolean nutritionListContains(String name) {
        return !nutritionListFound(name).isEmpty();
    }

    private ArrayList<String> prescription;

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
