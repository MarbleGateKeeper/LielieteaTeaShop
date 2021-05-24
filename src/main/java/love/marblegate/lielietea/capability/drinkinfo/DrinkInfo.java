package love.marblegate.lielietea.capability.drinkinfo;

import love.marblegate.lielietea.datastructure.enumeration.IngredientFeature;
import love.marblegate.lielietea.datastructure.IngredientInfo;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DrinkInfo {
    @CapabilityInject(IDrinkInfo.class)
    public static Capability<IDrinkInfo> DRINK_INFO = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(IDrinkInfo.class, new Storage(), DrinkInfoStandardImpl::new);
    }

    public static class Storage implements Capability.IStorage<IDrinkInfo> {

        @Nullable
        @Override
        public INBT writeNBT(Capability<IDrinkInfo> capability, IDrinkInfo instance, Direction side) {
            CompoundNBT compoundNBT = new CompoundNBT();
            //Ingredient List
            //SHOULD IT RECORD THE COUNT OF TOTAL INGREDIENTS?
            //WILL IT CAUSE PROBLEM IF NO RECORD WHEN readNBT?
            compoundNBT.putInt("drink_ingredient_count",instance.getIngredients().size()); //TOTAL COUNT
            for (int i = 0; i < instance.getIngredients().size(); i++) {
                CompoundNBT ingredientInfoNBT = instance.getIngredients().get(i).serializeNBT();
                compoundNBT.put("drink_ingredient_" + i, ingredientInfoNBT);
            }

            //Special Feature List
            List<Integer> features = new ArrayList<>();
            for (int i = 0; i < instance.getFeatures().size(); i++) {
                features.add(instance.getFeatures().get(i).getValue());
            }
            compoundNBT.putIntArray("drink_features", features);

            //Food Level
            compoundNBT.putInt("drink_foodlevel", instance.getFoodlevel());

            //Remaining Drink
            compoundNBT.putInt("drink_remaining", instance.getRemaining());

            return compoundNBT;
        }

        @Override
        public void readNBT(Capability<IDrinkInfo> capability, IDrinkInfo instance, Direction side, INBT nbt) {
            //Ingredient List
            int ingredientsTotal = ((CompoundNBT)nbt).getInt("drink_ingredient_count"); //TOTAL COUNT
            List<IngredientInfo> ingredientInfos = new ArrayList<>();
            for (int i = 0; i < ingredientsTotal; i++) {
                IngredientInfo ingredientInfo = new IngredientInfo();
                ingredientInfo.deserializeNBT(((CompoundNBT)nbt).getCompound("ingredient_" + i));
                ingredientInfos.add(ingredientInfo);
            }
            instance.setIngredients(ingredientInfos);

            //Special Feature List
            List<IngredientFeature> features = new ArrayList<>();
            int[] featureCodes = ((CompoundNBT)nbt).getIntArray("drink_features");
            for(int value : featureCodes){
                features.add(IngredientFeature.valueOf(value));
            }
            instance.setFeatures(features);

            //Food Level
            int foodlevel = ((CompoundNBT)nbt).getInt("drink_foodlevel");
            instance.setFoodlevel(foodlevel);

            //Remaining Drink
            int remaining = ((CompoundNBT)nbt).getInt("drink_remaining");
            instance.setFoodlevel(remaining);
        }
    }
}
