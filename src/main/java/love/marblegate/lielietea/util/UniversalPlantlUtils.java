package love.marblegate.lielietea.util;

import love.marblegate.lielietea.datastructure.enumeration.IngredientFeature;
import love.marblegate.lielietea.datastructure.PlantInfo;
import love.marblegate.lielietea.datastructure.enumeration.UniversalPlantType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class UniversalPlantlUtils {

    @OnlyIn(Dist.CLIENT)
    public static void addPotionTooltip(ItemStack itemIn, List<ITextComponent> lores,
                                        PlantInfo plantInfo, List<IngredientFeature> features) {
        lores.add(new TranslationTextComponent("lielietea.plant_status_head.come_from").mergeStyle(TextFormatting.WHITE));
        UniversalPlantType type = plantInfo.getType();
        switch (type){
            case VANILLA:
                lores.add(new StringTextComponent(plantInfo.getRandName()).mergeStyle(TextFormatting.GRAY));
                break;
            case GROWABLE_REGULAR:
                lores.add(new StringTextComponent(plantInfo.getRandName()).mergeStyle(TextFormatting.GRAY));
                break;
            case GROWABLE_SPECIAL:
                lores.add(new StringTextComponent(plantInfo.getRandName()).mergeStyle(TextFormatting.GRAY));
                break;
            case GREENHOUSE_C:
                lores.add(new TranslationTextComponent("lielietea.planttype.greenhouse_c.pre_"+plantInfo.getNameCode()%6)
                                .mergeStyle(TextFormatting.GRAY)
                                .appendSibling(new StringTextComponent(" "+plantInfo.getRandName())));
                break;
            case GREENHOUSE_B:
                int temp = plantInfo.getNameCode()%10;
                StringTextComponent textComponent = new StringTextComponent(plantInfo.getRandName());
                textComponent.appendSibling(new StringTextComponent(" ")).appendSibling( new TranslationTextComponent("lielietea.planttype.greenhouse_b.suf_"+temp));
                lores.add(textComponent.mergeStyle(TextFormatting.GRAY));
                break;
            case GREENHOUSE_A:
                //Need To Specify How Many Kind
                lores.add(new TranslationTextComponent("lielietea.planttype.greenhouse_a.pre_"+plantInfo.getNameCode()%5).mergeStyle(TextFormatting.GRAY)
                        .appendString("-")
                        .appendSibling(new TranslationTextComponent("lielietea.planttype.greenhouse_a.pre_"+plantInfo.getNameCode()%5+".series_"+(plantInfo.getNameCode()/10)%5)));
                break;
            case GREENHOUSE_UNKNOWN:
                lores.add(new TranslationTextComponent("lielietea.planttype.greenhouse_a.unidentified").mergeStyle(TextFormatting.GRAY));
                break;
            default:
        }
        if (!features.isEmpty()){
            if(features.size()==1){
                lores.add(new TranslationTextComponent("lielietea.plant_status_head.feature").mergeStyle(TextFormatting.WHITE));
                lores.add(new TranslationTextComponent("lielietea.features."+features.get(0).getValue()).mergeStyle(TextFormatting.GRAY));
            } else {
                lores.add(new TranslationTextComponent("lielietea.plant_status_head.features").mergeStyle(TextFormatting.WHITE));
                for(IngredientFeature ingredientFeature : features) {
                    lores.add(new TranslationTextComponent("lielietea.features."+ingredientFeature.getValue()).mergeStyle(TextFormatting.GRAY));
                }
            }
        }
    }
}
