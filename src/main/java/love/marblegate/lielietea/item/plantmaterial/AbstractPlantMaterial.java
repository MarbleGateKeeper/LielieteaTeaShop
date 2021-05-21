package love.marblegate.lielietea.item.plantmaterial;

import love.marblegate.lielietea.capability.plantinfo.IUniversalPlantInfo;
import love.marblegate.lielietea.capability.plantinfo.UniversalPlantInfo;
import love.marblegate.lielietea.capability.plantinfo.UniversalPlantInfoProvider;
import love.marblegate.lielietea.itemgroup.ModGroup;
import love.marblegate.lielietea.util.UniversalPlantlUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractPlantMaterial extends Item {
    public AbstractPlantMaterial() {
        super(new Properties()
                .group(ModGroup.itemGroup)
                .maxStackSize(8));
    }

    // The CapabilityProvider returned from this method is used to specify which capabilities the it has
    @Nonnull
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT oldCapNbt) {
        return new UniversalPlantInfoProvider();
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        LazyOptional<IUniversalPlantInfo> uni_plant_info_cap = stack.getCapability(UniversalPlantInfo.UNIVERSAL_PLANT_INFO);
        uni_plant_info_cap.ifPresent(
                cap-> {
                    UniversalPlantlUtils.addPotionTooltip(stack,tooltip,cap.getPlant(),cap.getFeatures());
                });
    }
}
