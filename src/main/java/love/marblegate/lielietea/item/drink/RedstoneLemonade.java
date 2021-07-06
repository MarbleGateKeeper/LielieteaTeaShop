package love.marblegate.lielietea.item.drink;

import love.marblegate.lielietea.group.ProductGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class RedstoneLemonade extends Item {
    public RedstoneLemonade() {
        super(new Properties().group(ProductGroup.INSTANCE)
                .maxDamage(10)
                .rarity(Rarity.EPIC));
    }
}
