package love.marblegate.lielietea.group;

import love.marblegate.lielietea.registry.BlockRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CraftingGroup extends ItemGroup {
    public static final CraftingGroup INSTANCE = new CraftingGroup();

    CraftingGroup() {
        super("lielietea.crafting_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(BlockRegistry.slime_catcher.get());
    }
}
