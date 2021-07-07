package love.marblegate.lielietea.item.drink;

import love.marblegate.lielietea.group.ProductGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class AbstractDrink extends Item {
    public AbstractDrink() {
        super(new Properties().group(ProductGroup.INSTANCE)
                .maxDamage(10)
                .rarity(Rarity.EPIC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(playerIn.getHeldItem(handIn));
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }
}
