package kotys.monika.menucreator.classes;

import java.util.ArrayList;

public class MealType {

    private ArrayList<String> mealType;

    public MealType() {
        mealType = new ArrayList<String>();
    }

    public ArrayList<String> getMealType() {
        return mealType;
    }

    public void setMealType(ArrayList<String> mealType) {
        this.mealType = mealType;
    }

    public void defaultSetup() {
        if (!mealType.contains("Breakfast"))
            mealType.add("Breakfast");
        if (!mealType.contains("Breakfast II"))
            mealType.add("Breakfast II");
        if (!mealType.contains("Dinner"))
            mealType.add("Dinner");
        if (!mealType.contains("Afternoon snack"))
            mealType.add("Afternoon snack");
        if (!mealType.contains("Supper"))
            mealType.add("Supper");
    }
}
