package love.marblegate.lielietea.util;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import love.marblegate.lielietea.util.datastructure.IngredientFeature;
import love.marblegate.lielietea.util.datastructure.IngredientInfo;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.util.text.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.awt.TextComponent;
import java.util.List;
import java.util.Map;

public class DrinkUtils {
    private static final IFormattableTextComponent no_ingredient = (new TranslationTextComponent("lielietea.ingredient.none")).mergeStyle(TextFormatting.DARK_RED).mergeStyle(TextFormatting.BOLD);

    @OnlyIn(Dist.CLIENT)
    public static void addPotionTooltip(ItemStack itemIn, List<ITextComponent> lores,
                                        List<IngredientInfo> ingredients, List<IngredientFeature> features,
                                        int foodlevel, int remaining) {

        if (ingredients.isEmpty()) {
            lores.add(no_ingredient);
        } else {
            if(ingredients.size()==1){
                lores.add(new TranslationTextComponent("lielietea.drink_status_head.contained_ingredient").mergeStyle(TextFormatting.WHITE));
                //等待添加

            } else {
                lores.add(new TranslationTextComponent("lielietea.drink_status_head.contained_ingredients").mergeStyle(TextFormatting.WHITE));
                for(IngredientInfo ingredientInfo : ingredients) {
                    //等待添加

                }
            }
        }

        if (!features.isEmpty()) {
            if(features.size()==1){
                lores.add(new TranslationTextComponent("lielietea.drink_status_head.feature").mergeStyle(TextFormatting.WHITE));
                //等待添加

            } else {
                lores.add(new TranslationTextComponent("lielietea.drink_status_head.features").mergeStyle(TextFormatting.WHITE));
                for(IngredientFeature ingredientFeature : features) {
                    //等待添加

                }
            }
        }
        lores.add(new TranslationTextComponent("lielietea.drink_status_head.provide_foodlevel").mergeStyle(TextFormatting.WHITE)
                .appendSibling(new StringTextComponent(String.valueOf(foodlevel)).mergeStyle(TextFormatting.GRAY)));
        lores.add(new TranslationTextComponent("lielietea.drink_status_head.drink_remaining").mergeStyle(TextFormatting.WHITE)
                .appendSibling(new StringTextComponent(String.valueOf(remaining)+" mL").mergeStyle(TextFormatting.GRAY)));

    }
}
