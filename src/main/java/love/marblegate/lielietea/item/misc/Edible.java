package love.marblegate.lielietea.item.misc;

import love.marblegate.lielietea.group.MiscGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class Edible extends Item {
    public Edible(int hunger,float saturation) {
        super(new Properties().group(MiscGroup.INSTANCE)
                .food(new Food.Builder().hunger(2).saturation(0.2F).setAlwaysEdible().build()));
    }
}
