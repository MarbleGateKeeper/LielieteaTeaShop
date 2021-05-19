package love.marblegate.lielietea.util.datastructure;

import java.util.HashMap;
import java.util.Map;

public enum IngredientType {
    LEAVE(0),
    FLOWER(1),
    FRUIT(2),
    ROOT(3),
    MUSHROOM(4);

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
