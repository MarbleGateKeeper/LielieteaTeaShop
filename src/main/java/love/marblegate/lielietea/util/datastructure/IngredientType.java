package love.marblegate.lielietea.util.datastructure;

import java.util.HashMap;
import java.util.Map;

public enum IngredientType {
    GREEN_TEA(0),
    BLACK_TEA(1),
    DARK_TEA(2),
    OOLONG_TEA(3),
    WHITE_TEA(4),
    YELLOW_TEA(5),
    FLOWER_TEA(6),
    MILK(7),
    JUICE(8),
    ALCOHOL(9),
    JAM(10),
    SYRUP(11),
    FRUIT(12),
    PRESERVED_FRUIT(13);

    private int value;
    private static Map map = new HashMap<>();

    private IngredientType(int value) {
        this.value = value;
    }

    static {
        for (IngredientType ingredientType : IngredientType.values()) {
            map.put(ingredientType.value, ingredientType);
        }
    }

    public static IngredientType valueOf(int ingredientType) {
        return (IngredientType) map.get(ingredientType);
    }

    public int getValue() {
        return value;
    }
}
