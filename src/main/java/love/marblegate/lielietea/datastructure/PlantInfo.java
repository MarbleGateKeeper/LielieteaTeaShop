package love.marblegate.lielietea.datastructure;

import love.marblegate.lielietea.datastructure.enumeration.UniversalPlantType;
import net.minecraft.nbt.CompoundNBT;

public class PlantInfo {
    UniversalPlantType type;
    int nameCode;
    String randName;

    public PlantInfo() {
        this.type = UniversalPlantType.VANILLA;
        this.nameCode = 0;
        this.randName = "NA";
    }

    public PlantInfo(UniversalPlantType type, int nameCode, String randName) {
        this.type = type;
        this.nameCode = nameCode;
        this.randName = randName;
    }


    public UniversalPlantType getType() {
        return type;
    }

    public int getNameCode() {
        return nameCode;
    }

    public String getRandName() {
        return randName;
    }

    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("plant_type",type.getValue());
        compoundNBT.putInt("name_code", nameCode);
        compoundNBT.putString("randName", randName);
        return compoundNBT;
    }

    public void deserializeNBT(CompoundNBT compoundNBT) {
        this.type = UniversalPlantType.valueOf(compoundNBT.getInt("plant_type"));
        this.nameCode = compoundNBT.getInt("name_code");
        this.randName = compoundNBT.getString("randName");
    }


}
