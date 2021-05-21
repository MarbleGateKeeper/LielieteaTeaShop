package love.marblegate.lielietea.itemgroup;

import love.marblegate.lielietea.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class IngredientGroup extends ItemGroup {
    public IngredientGroup() {
        super("lielietea.ingredient");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.tree_fruit.get());
    }
}
