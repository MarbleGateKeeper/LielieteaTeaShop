package love.marblegate.lielietea.capability.drinkinfo;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DrinkInfoProvider implements ICapabilitySerializable<CompoundNBT> {
    private final IDrinkInfo imp = new DrinkInfoStandardImpl();
    private final LazyOptional<IDrinkInfo> impOptional = LazyOptional.of(() -> imp);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == DrinkInfo.DRINK_INFO){
            return impOptional.cast();
        }
        else return LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT() {
        if (DrinkInfo.DRINK_INFO == null) {
            return new CompoundNBT();
        } else {
            return (CompoundNBT) DrinkInfo.DRINK_INFO.writeNBT(imp, null);
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (DrinkInfo.DRINK_INFO != null) {
            DrinkInfo.DRINK_INFO.readNBT(imp, null, nbt);
        }
    }
}
