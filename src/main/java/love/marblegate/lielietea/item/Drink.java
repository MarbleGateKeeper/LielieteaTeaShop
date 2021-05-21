package love.marblegate.lielietea.item;

import love.marblegate.lielietea.capability.drinkinfo.DrinkInfo;
import love.marblegate.lielietea.capability.drinkinfo.DrinkInfoProvider;
import love.marblegate.lielietea.capability.drinkinfo.IDrinkInfo;
import love.marblegate.lielietea.itemgroup.ModGroup;
import love.marblegate.lielietea.util.DrinkUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Drink extends Item {
    private static final Food food = (new Food.Builder())
            .saturation(1)
            .hunger(0)
            .build();

    public Drink() {
        super(new Properties()
                .group(ModGroup.itemGroup)
                .maxStackSize(1)
                .food(food));
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        LazyOptional<IDrinkInfo> drink_info_cap = stack.getCapability(DrinkInfo.DRINK_INFO);
        PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
        AtomicBoolean enough = new AtomicBoolean(true);
        drink_info_cap.ifPresent(
                cap-> {
                    if(cap.getRemaining()>50){
                        if(!playerentity.abilities.isCreativeMode)
                            cap.setRemaining(cap.getRemaining()-50);
                    } else {
                        enough.set(false);
                    }
                }
        );

        if (!worldIn.isRemote) {
            /* 在此处添加效果

             */
        }

        if(!enough.get()){
            if (playerentity != null) {
                playerentity.addStat(Stats.ITEM_USED.get(this));
                if (!playerentity.abilities.isCreativeMode) {
                    stack.shrink(1);
                }
            }

            if (playerentity == null || !playerentity.abilities.isCreativeMode) {
                //等待修改为返回模组的杯子
                if (stack.isEmpty()) {
                    return new ItemStack(Items.GLASS_BOTTLE);
                }

                if (playerentity != null) {
                    playerentity.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
                }
            }

        }
        return stack;
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(itemstack);
    }


    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        LazyOptional<IDrinkInfo> drink_info_cap = stack.getCapability(DrinkInfo.DRINK_INFO);
        drink_info_cap.ifPresent(
                cap-> {
                    DrinkUtils.addPotionTooltip(stack,tooltip,cap.getIngredients(),cap.getFeatures(),cap.getFoodlevel(),cap.getRemaining());
                });
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    // The CapabilityProvider returned from this method is used to specify which capabilities the it has
    @Nonnull
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT oldCapNbt) {
        return new DrinkInfoProvider();
    }
}
