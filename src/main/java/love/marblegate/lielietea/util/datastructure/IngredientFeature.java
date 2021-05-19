package love.marblegate.lielietea.util.datastructure;

import java.util.HashMap;
import java.util.Map;

public enum IngredientFeature {
    TEST(0);

    private int value;
    private static Map map = new HashMap<>();

    private IngredientFeature(int value) {
        this.value = value;
    }

    static {
        for (IngredientFeature ingredientFeature : IngredientFeature.values()) {
            map.put(ingredientFeature.value, ingredientFeature);
        }
    }

    public static IngredientFeature valueOf(int ingredientFeature) {
        return (IngredientFeature) map.get(ingredientFeature);
    }

    public int getValue() {
        return value;
    }
}
