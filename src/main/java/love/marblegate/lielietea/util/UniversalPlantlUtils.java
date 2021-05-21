package love.marblegate.lielietea.util;

import love.marblegate.lielietea.util.datastructure.IngredientFeature;
import love.marblegate.lielietea.util.datastructure.PlantInfo;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class UniversalPlantlUtils {
    private static final IFormattableTextComponent no_feature = (new TranslationTextComponent("lielietea.feature.none")).mergeStyle(TextFormatting.WHITE);

    @OnlyIn(Dist.CLIENT)
    public static void addPotionTooltip(ItemStack itemIn, List<ITextComponent> lores,
                                        PlantInfo plantInfo, List<IngredientFeature> features) {
        lores.add(new TranslationTextComponent("lielietea.plant_status_head.come_from").mergeStyle(TextFormatting.WHITE));
        /* 等待添加

        */
        if (features.isEmpty()) {
            lores.add(no_feature);
        } else {
            if(features.size()==1){
                lores.add(new TranslationTextComponent("lielietea.plant_status_head.feature").mergeStyle(TextFormatting.WHITE));
                //等待添加

            } else {
                lores.add(new TranslationTextComponent("lielietea.plant_status_head.features").mergeStyle(TextFormatting.WHITE));
                for(IngredientFeature ingredientFeature : features) {
                    //等待添加

                }
            }
        }
    }
}
