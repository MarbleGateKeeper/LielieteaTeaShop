package love.marblegate.lielietea.util.datastructure;

import net.minecraft.nbt.CompoundNBT;

import java.util.HashMap;
import java.util.Map;

public enum ProductSeries {
    REGULAR(0),
    LIMITED(1),
    EXPERIMENTAL(2);

    private int value;
    private static Map map = new HashMap<>();

    private ProductSeries(int value) {
        this.value = value;
    }

    static {
        for (ProductSeries productSeries : ProductSeries.values()) {
            map.put(productSeries.value, productSeries);
        }
    }

    public static ProductSeries valueOf(int productSeries) {
        return (ProductSeries) map.get(productSeries);
    }

    public int getValue() {
        return value;
    }
}
