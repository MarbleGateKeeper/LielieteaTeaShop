package love.marblegate.lielietea.util.datastructure;

import net.minecraft.nbt.CompoundNBT;

public class PlantInfo {
    byte nameFormat;
    int nameCode;
    ProductSeries series;

    public PlantInfo() {
        this.nameFormat = 0;
        this.nameCode = 0;
        this.series = ProductSeries.valueOf(0);
    }

    public PlantInfo(byte nameFormat, int nameCode, ProductSeries series) {
        this.nameFormat = nameFormat;
        this.nameCode = nameCode;
        this.series = series;
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
        compoundNBT.putByte("name_format",nameFormat);
        compoundNBT.putInt("name_code", nameCode);
        compoundNBT.putInt("product_series", series.getValue());
        return compoundNBT;
    }

    public void deserializeNBT(CompoundNBT compoundNBT) {
        this.nameFormat = compoundNBT.getByte("name_format");
        this.nameCode = compoundNBT.getInt("name_code");
        this.series = ProductSeries.valueOf(compoundNBT.getInt("product_series"));
    }
}
