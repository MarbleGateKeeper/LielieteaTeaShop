package love.marblegate.lielietea.capability.plantinfo;

import love.marblegate.lielietea.datastructure.enumeration.IngredientFeature;
import love.marblegate.lielietea.datastructure.PlantInfo;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class UniversalPlantInfo {
    @CapabilityInject(IUniversalPlantInfo.class)
    public static Capability<IUniversalPlantInfo> UNIVERSAL_PLANT_INFO = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(IUniversalPlantInfo.class, new Storage(), UniversalPlantInfoStandardImpl::new);
    }

    public static class Storage implements Capability.IStorage<IUniversalPlantInfo> {

        @Nullable
        @Override
        public INBT writeNBT(Capability<IUniversalPlantInfo> capability, IUniversalPlantInfo instance, Direction side) {
            CompoundNBT compoundNBT = new CompoundNBT();
            CompoundNBT plantInfoNBT = instance.getPlant().serializeNBT();
            compoundNBT.put("plant_info", plantInfoNBT);
            List<Integer> features = new ArrayList<>();
            for (int i = 0; i < instance.getFeatures().size(); i++) {
                features.add(instance.getFeatures().get(i).getValue());
            }
            compoundNBT.putIntArray("plant_features", features);
            return compoundNBT;
        }

        @Override
        public void readNBT(Capability<IUniversalPlantInfo> capability, IUniversalPlantInfo instance, Direction side, INBT nbt) {
            PlantInfo plantInfo = new PlantInfo();
            plantInfo.deserializeNBT(((CompoundNBT)nbt).getCompound("plant_info"));
            instance.setPlant(plantInfo);
            List<IngredientFeature> features = new ArrayList<>();
            int[] featureCodes = ((CompoundNBT)nbt).getIntArray("plant_features");
            for(int value : featureCodes){
                features.add(IngredientFeature.valueOf(value));
            }
            instance.setFeatures(features);

        }
    }
}
