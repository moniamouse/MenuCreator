package kotys.monika.menucreator.classes;

import java.util.ArrayList;
import java.util.Date;

public class MealsCollection {

    private String name;

    private Date detailedDate;

    private ArrayList<Meal> meals;

    private String type;

    public MealsCollection(String name) {
        this.name = name;
        this.detailedDate = new Date();
        this.meals = new ArrayList<>();
        type = "";
    }

    public int getMealsCount() {
        return meals.size();
    }

    public void addMeal(Meal meal) {
        if(!meals.contains(meal))
            meals.add(meal);
    }

    public void removeMeal(Meal meal) {
        if(meals.contains(meal))
            meals.remove(meal);
    }

    public ArrayList<Meal> findMeal(String name) {
        ArrayList<Meal> founded = new ArrayList<>();
        meals.forEach(c -> {if(name.equals(c.getName())) founded.add(c);});
        return founded;
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
     * @return the detailedDate
     */
    public Date getDetailedDate() {
        return detailedDate;
    }

    /**
     * @param detailedDate the detailedDate to set
     */
    public void setDetailedDate(Date detailedDate) {
        this.detailedDate = detailedDate;
    }

    /**
     * @return the meals
     */
    public ArrayList<Meal> getMeals() {
        return meals;
    }

    /**
     * @param meals the meals to set
     */
    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
