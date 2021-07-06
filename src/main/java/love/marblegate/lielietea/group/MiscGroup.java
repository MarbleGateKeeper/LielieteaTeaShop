package love.marblegate.lielietea.group;

import love.marblegate.lielietea.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MiscGroup extends ItemGroup {
    public static final MiscGroup INSTANCE = new MiscGroup();

    MiscGroup() {
        super("lielietea.misc_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.orange.get());
    }
}
