package love.marblegate.lielietea.util.datastructure;

import net.minecraft.nbt.CompoundNBT;

public class IngredientInfo {
    IngredientType type;
    IngredientSource source;
    PlantInfo plant;

    public IngredientInfo() {
        this.type = IngredientType.valueOf(0);
        this.source = IngredientSource.valueOf(0);
        this.plant = new PlantInfo();
    }

    public IngredientInfo(IngredientType type, IngredientSource source, PlantInfo plant) {
        this.type = type;
        this.source = source;
        this.plant = plant;
    }

    public IngredientType getType() {
        return type;
    }

    public IngredientSource getSource() {
        return source;
    }

    public PlantInfo getPlant() {
        return plant;
    }

    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("ingredient_type", type.getValue());
        compoundNBT.putInt("ingredient_source", source.getValue());
        CompoundNBT plantInfoNBT = plant.serializeNBT();
        compoundNBT.put("plant_info", plantInfoNBT);
        return compoundNBT;
    }

    public void deserializeNBT(CompoundNBT compoundNBT) {
        this.type = IngredientType.valueOf(compoundNBT.getInt("ingredient_type"));
        this.source = IngredientSource.valueOf(compoundNBT.getInt("ingredient_source"));
        PlantInfo plantInfo = new PlantInfo();
        plantInfo.deserializeNBT(compoundNBT.getCompound("plant_info"));
    }


}
