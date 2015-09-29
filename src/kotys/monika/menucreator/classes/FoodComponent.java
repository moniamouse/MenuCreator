package kotys.monika.menucreator.classes;

public class FoodComponent {

    private String name;
    private String code;
    private NutritionCollection nutritionTable;
    
    public FoodComponent(String name, String code, NutritionCollection nutritionTable) {
        this.name = name;
        this.code = code;
        this.nutritionTable = nutritionTable;
    }

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

    public NutritionCollection getNutritionTable() {
        return nutritionTable;
    }

    public void setNutritionTable(NutritionCollection nutritionTable) {
        this.nutritionTable = nutritionTable;
    }
}
