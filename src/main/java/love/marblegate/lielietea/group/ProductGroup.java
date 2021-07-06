package love.marblegate.lielietea.group;

import love.marblegate.lielietea.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ProductGroup extends ItemGroup {
    public static final ProductGroup INSTANCE = new ProductGroup();

    ProductGroup() {
        super("lielietea.product_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.redstone_lemonade.get());
    }
}
