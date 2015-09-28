package kotys.monika.menucreator.classes;

public class FoodComponent {

    public FoodComponent(String name, String code, NutritionComponent[] nutritionTable) {
        this.name = name;
        this.code = code;
        this.nutritionTable = nutritionTable;
    }

    private String name;

    private String code;

    private NutritionComponent nutritionTable[];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public FoodComponent() {
    }

    public NutritionComponent[] getNutritionTable() {
        return nutritionTable;
    }

    public void setNutritionTable(NutritionComponent[] nutritionTable) {
        this.nutritionTable = nutritionTable;
    }
}
