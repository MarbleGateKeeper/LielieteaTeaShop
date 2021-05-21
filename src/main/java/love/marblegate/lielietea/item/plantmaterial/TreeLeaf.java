package love.marblegate.lielietea.item.plantmaterial;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class TreeLeaf extends AbstractPlantMaterial{
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("lielietea.plant_material.tree_leaf").mergeStyle(TextFormatting.GOLD).mergeStyle(TextFormatting.BOLD));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
