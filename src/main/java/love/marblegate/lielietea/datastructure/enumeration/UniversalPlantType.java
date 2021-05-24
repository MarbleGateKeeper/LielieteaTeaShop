package love.marblegate.lielietea.datastructure.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum UniversalPlantType {
    VANILLA(0),
    GROWABLE_REGULAR(1),
    GROWABLE_SPECIAL(2),
    GREENHOUSE_C(3),
    GREENHOUSE_B(4),
    GREENHOUSE_A(5),
    GREENHOUSE_UNKNOWN(6);

    private int value;
    private static Map map = new HashMap<>();

    private UniversalPlantType(int value) {
        this.value = value;
    }

    static {
        for (UniversalPlantType universalPlantType : UniversalPlantType.values()) {
            map.put(universalPlantType.value, universalPlantType);
        }
    }

    public static UniversalPlantType valueOf(int plantType) {
        return (UniversalPlantType) map.get(plantType);
    }

    public int getValue() {
        return value;
    }
}
