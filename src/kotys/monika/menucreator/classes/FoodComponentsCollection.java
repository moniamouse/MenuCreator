package kotys.monika.menucreator.classes;

import java.util.ArrayList;

public class FoodComponentsCollection {

    private String name;

    private ArrayList<FoodComponent> foodList;

    public FoodComponentsCollection(String name) {
       
        this.name = name;
        foodList = new ArrayList<>();
    }

    public void addFoodComponent(FoodComponent food) {
        if(!foodList.contains(food))
            getFoodList().add(food);
    }

    public void removeFoodComponent(FoodComponent food) {
        if(getFoodList().contains(food))
            getFoodList().remove(food);
    }

    public FoodComponent findFoodComponent(String name) {
        ArrayList<FoodComponent> founded = new ArrayList<>();
        getFoodList().forEach(c->{if(name.equals(c.getName())) founded.add(c);});
        if(founded.size()<=0)
            return null;
        else
            return founded.get(0);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the foodList
     */
    public ArrayList<FoodComponent> getFoodList() {
        return foodList;
    }

    /**
     * @param foodList the foodList to set
     */
    public void setFoodList(ArrayList<FoodComponent> foodList) {
        this.foodList = foodList;
    }

}
