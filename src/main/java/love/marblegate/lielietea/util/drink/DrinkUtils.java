package love.marblegate.lielietea.util.drink;

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
    private static final IFormattableTextComponent no_ingredient = (new TranslationTextComponent("ingredient.none")).mergeStyle(TextFormatting.GRAY);
    private static final IFormattableTextComponent no_feature = (new TranslationTextComponent("feature.none")).mergeStyle(TextFormatting.GRAY);

    @OnlyIn(Dist.CLIENT)
    public static void addPotionTooltip(ItemStack itemIn, List<ITextComponent> lores,
                                        List<IngredientInfo> ingredients, List<IngredientFeature> features,
                                        int foodlevel, int remaining) {
        lores.add(new TranslationTextComponent("drink_status_head.contained_ingredients").mergeStyle(TextFormatting.WHITE));
        if (ingredients.isEmpty()) {
            lores.add(no_ingredient);
        } else {
            for(IngredientInfo ingredientInfo : ingredients) {
                //等待添加
            }
        }
        lores.add(new TranslationTextComponent("drink_status_head.features").mergeStyle(TextFormatting.WHITE));
        if (features.isEmpty()) {
            lores.add(no_feature);
        } else {
            for(IngredientFeature ingredientFeature : features) {
                //等待添加
            }
        }
        lores.add(new TranslationTextComponent("drink_status_head.provide_foodlevel").mergeStyle(TextFormatting.WHITE)
                .appendSibling(new StringTextComponent(String.valueOf(foodlevel)).mergeStyle(TextFormatting.GRAY)));
        lores.add(new TranslationTextComponent("drink_status_head.drink_remaining").mergeStyle(TextFormatting.WHITE)
                .appendSibling(new StringTextComponent(String.valueOf(remaining)+" mL").mergeStyle(TextFormatting.GRAY)));

    }
}
