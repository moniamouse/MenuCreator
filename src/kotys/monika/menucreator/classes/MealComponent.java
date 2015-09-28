package kotys.monika.menucreator.classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class MealComponent {

    public MealComponent(FoodComponent foodComponent) {
        this.foodComponent = foodComponent;
        this.name = foodComponent.getName();
        amount = 0;
        setNutritionComponent(foodComponent.getNutritionTable());
    }

    public MealComponent(FoodComponent foodComponent, float amount) {
        this.foodComponent = foodComponent;
        this.name = foodComponent.getName();
        setAmount(amount);
    }

    private FoodComponent foodComponent;

    private float amount;

    private NutritionComponent[] nutrition;

    private String name;

    public FoodComponent getFoodComponent() {
        return foodComponent;
    }

    public void setFoodComponent(FoodComponent foodComponent) {
        this.foodComponent = foodComponent;
        this.name = foodComponent.getName();
        setAmount(amount);
    }

    public float getAmount() {
        return amount;
    }

    public final void setAmount(float amount) throws IllegalArgumentException, NullPointerException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be above or zero equal");
        }
        if (foodComponent == null || foodComponent.getNutritionTable() == null) {
            throw new NullPointerException("FoodComponent was not set properly");
        }
        this.amount = amount;
        setNutritionComponent(foodComponent.getNutritionTable());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NutritionComponent[] getNutrition() {
        return nutrition;
    }

    private void setNutritionComponent(NutritionComponent[] nutritionTable) throws NullPointerException {
        if (nutritionTable == null) {
            throw new NullPointerException("FoodComponent was not set properly");
        }
        int length = nutritionTable.length;
        this.nutrition = new NutritionComponent[length];
        for (int i = 0; i < length; i++) {
            try {
                this.nutrition[i] = (NutritionComponent) nutritionTable[i].clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(MealComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.nutrition[i].setAmount((amount > 0 ? amount / 100 : 0) * this.nutrition[i].getAmount());
        }
    }

    
}

