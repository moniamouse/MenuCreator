package kotys.monika.menucreator.classes;

import java.util.Objects;

public class NutritionComponent implements Cloneable {

    public NutritionComponent(String name, String type, String unit, float amount) {
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.amount = amount;
    }

    private String name;

    private String type;

    private String unit;

    private float amount;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.type);
        hash = 47 * hash + Objects.hashCode(this.unit);
        hash = 47 * hash + Float.floatToIntBits(this.amount);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NutritionComponent))
            return false;
        NutritionComponent comp = (NutritionComponent) o;
        return this.getAmount() == comp.getAmount() && this.getName().equals(comp.getName()) && this.getType().equals(comp.getType()) && this.getUnit().equals(comp.getUnit());
    }
}
