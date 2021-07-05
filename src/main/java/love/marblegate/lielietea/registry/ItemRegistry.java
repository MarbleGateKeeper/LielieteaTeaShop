package love.marblegate.lielietea.registry;

import love.marblegate.lielietea.group.CraftingGroup;
import love.marblegate.lielietea.item.drink.RedstoneLemonade;
import love.marblegate.lielietea.item.misc.CoalCake;
import love.marblegate.lielietea.item.misc.Lemon;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "lielietea");
    public static final RegistryObject<Item> lemon = ITEMS.register("lemon", Lemon::new);
    public static final RegistryObject<Item> coal_cake = ITEMS.register("coal_cake", CoalCake::new);

    public static final RegistryObject<Item> redstone_lemonade = ITEMS.register("redstone_lemonade", RedstoneLemonade::new);

    public static final RegistryObject<Item> slime_catcher = ITEMS.register("slime_catcher", () -> new BlockItem(BlockRegistry.slime_catcher.get(), new Item.Properties().group(CraftingGroup.INSTANCE)));
    public static final RegistryObject<Item> slime_cage = ITEMS.register("slime_cage", () -> new BlockItem(BlockRegistry.slime_cage.get(), new Item.Properties().group(CraftingGroup.INSTANCE)));



}
