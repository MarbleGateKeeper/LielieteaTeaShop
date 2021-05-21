package love.marblegate.lielietea.itemgroup;

import love.marblegate.lielietea.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class DrinkGroup extends ItemGroup {
    public DrinkGroup() {
        super("lielietea.drink");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.green_tea.get());
    }
}
