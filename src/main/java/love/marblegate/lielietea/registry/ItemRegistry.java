package love.marblegate.lielietea.registry;

import love.marblegate.lielietea.item.Drink;
import love.marblegate.lielietea.item.plantmaterial.TreeLeaf;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, "lielietea");
    public static final RegistryObject<Item> drink = ITEM.register("drink", () -> new Drink());

    public static final RegistryObject<Item> tree_leaf = ITEM.register("tree_leaf", () -> new TreeLeaf());
}
