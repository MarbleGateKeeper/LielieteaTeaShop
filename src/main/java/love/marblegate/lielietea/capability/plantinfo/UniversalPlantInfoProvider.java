package love.marblegate.lielietea.capability.plantinfo;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class UniversalPlantInfoProvider implements ICapabilitySerializable<CompoundNBT> {
    private final IUniversalPlantInfo imp = new UniversalPlantInfoStandardImpl();
    private final LazyOptional<IUniversalPlantInfo> impOptional = LazyOptional.of(() -> imp);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == UniversalPlantInfo.UNIVERSAL_PLANT_INFO){
            return impOptional.cast();
        }
        else return LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        if (UniversalPlantInfo.UNIVERSAL_PLANT_INFO == null) {
            return new CompoundNBT();
        } else {
            return (CompoundNBT) UniversalPlantInfo.UNIVERSAL_PLANT_INFO.writeNBT(imp, null);
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (UniversalPlantInfo.UNIVERSAL_PLANT_INFO != null) {
            UniversalPlantInfo.UNIVERSAL_PLANT_INFO.readNBT(imp, null, nbt);
        }
    }
}
