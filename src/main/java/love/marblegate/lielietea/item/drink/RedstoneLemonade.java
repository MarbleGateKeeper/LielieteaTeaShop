package love.marblegate.lielietea.item.drink;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RedstoneLemonade extends AbstractDrink{

    public RedstoneLemonade() {
        super();
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        stack.damageItem(1,entityLiving,(entity)->{});
        return stack;
    }
}
