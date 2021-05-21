package love.marblegate.lielietea.itemgroup;

import love.marblegate.lielietea.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ProductionGroup extends ItemGroup {
    public ProductionGroup() {
        super("lielietea.production");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.shrub_seed.get());
    }
}
