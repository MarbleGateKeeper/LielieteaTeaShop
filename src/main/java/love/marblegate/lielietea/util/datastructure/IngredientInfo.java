package love.marblegate.lielietea.util.datastructure;

import net.minecraft.nbt.CompoundNBT;

public class IngredientInfo {
    IngredientType type;
    byte nameFormat;
    int nameCode;
    ProductSeries series;

    public IngredientInfo() {
        this.type = IngredientType.valueOf(0);
        this.nameFormat = 0;
        this.nameCode = 0;
        this.series = ProductSeries.valueOf(0);
    }

    public IngredientInfo(IngredientType type, byte nameFormat, int nameCode, ProductSeries series) {
        this.type = type;
        this.nameFormat = nameFormat;
        this.nameCode = nameCode;
        this.series = series;
    }

    public IngredientType getType() {
        return type;
    }

    public byte getNameFormat() {
        return nameFormat;
    }

    public int getNameCode() {
        return nameCode;
    }

    public ProductSeries getSeries() {
        return series;
    }

    public CompoundNBT serializeNBT() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("ingredient_type", type.getValue());
        compoundNBT.putByte("name_format",nameFormat);
        compoundNBT.putInt("name_code", nameCode);
        compoundNBT.putInt("product_series", series.getValue());
        return compoundNBT;
    }

    public void deserializeNBT(CompoundNBT compoundNBT) {
        this.type = IngredientType.valueOf(compoundNBT.getInt("slot_count"));
        this.nameFormat = compoundNBT.getByte("name_format");
        this.nameCode = compoundNBT.getInt("name_code");
        this.series = ProductSeries.valueOf(compoundNBT.getInt("product_series"));
    }
}
