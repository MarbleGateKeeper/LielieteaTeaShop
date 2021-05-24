package love.marblegate.lielietea.datastructure.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum IngredientSource {
    LEAVE(0),
    FLOWER(1),
    FRUIT(2),
    ROOT(3),
    MUSHROOM(4);

    private int value;
    private static Map map = new HashMap<>();

    private IngredientSource(int value) {
        this.value = value;
    }

    static {
        for (IngredientSource ingredientType : IngredientSource.values()) {
            map.put(ingredientType.value, ingredientType);
        }
    }

    public static IngredientSource valueOf(int ingredientType) {
        return (IngredientSource) map.get(ingredientType);
    }

    public int getValue() {
        return value;
    }
}
