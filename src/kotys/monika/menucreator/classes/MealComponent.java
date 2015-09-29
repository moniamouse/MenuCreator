package kotys.monika.menucreator.classes;

public class MealComponent {
    
    private FoodComponent foodComponent;
    private float amount;
    private NutritionCollection nutrition;
    private String name;
    
    public MealComponent(FoodComponent foodComponent) throws NullPointerException, CloneNotSupportedException {
        this.foodComponent = foodComponent;
        this.name = foodComponent.getName();
        amount = 0;
        setNutritionComponent(foodComponent.getNutritionTable());
    }

    public MealComponent(FoodComponent foodComponent, float amount) throws IllegalArgumentException, NullPointerException, CloneNotSupportedException {
        this.foodComponent = foodComponent;
        this.name = foodComponent.getName();
        setAmount(amount);
    }

    public FoodComponent getFoodComponent() {
        return foodComponent;
    }

    public void setFoodComponent(FoodComponent foodComponent) throws IllegalArgumentException, NullPointerException, CloneNotSupportedException {
        this.foodComponent = foodComponent;
        this.name = foodComponent.getName();
        setAmount(amount);
    }

    public float getAmount() {
        return amount;
    }

    public final void setAmount(float amount) throws IllegalArgumentException, NullPointerException, CloneNotSupportedException {
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

    public NutritionCollection getNutrition() {
        return nutrition;
    }

    private void setNutritionComponent(NutritionCollection nutritionTable) throws NullPointerException, CloneNotSupportedException {
        if (nutritionTable == null) {
            throw new NullPointerException("FoodComponent was not set properly");
        }
        
        this.nutrition = (NutritionCollection) nutritionTable.clone();
        this.nutrition.nutritionList.forEach(n -> n.setAmount((amount > 0 ? amount / 100 : 0) * n.getAmount()));
                
        
        //int length = nutritionTable.size();
        //this.nutrition = new NutritionCollection();
        //for (int i = 0; i < length; i++) {
        //    try {
        //        this.nutrition.get(i) = (NutritionComponent) nutritionTable[i].clone();
        //   } catch (CloneNotSupportedException ex) {
        //        Logger.getLogger(MealComponent.class.getName()).log(Level.SEVERE, null, ex);
        //    }
        //    this.nutrition[i].setAmount((amount > 0 ? amount / 100 : 0) * this.nutrition[i].getAmount());
        //}
    }

    
}

