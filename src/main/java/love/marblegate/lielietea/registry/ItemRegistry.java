package love.marblegate.lielietea.registry;

import love.marblegate.lielietea.item.drink.*;
import love.marblegate.lielietea.item.plantmaterial.PlantMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, "lielietea");
    public static final RegistryObject<Item> green_tea = ITEM.register("green_tea", () -> new GreenTea());
    public static final RegistryObject<Item> black_tea = ITEM.register("black_tea", () -> new BlackTea());
    public static final RegistryObject<Item> dark_tea = ITEM.register("dark_tea", () -> new DarkTea());
    public static final RegistryObject<Item> oolong_tea = ITEM.register("oolong_tea", () -> new OolongTea());
    public static final RegistryObject<Item> white_tea = ITEM.register("white_tea", () -> new WhiteTea());
    public static final RegistryObject<Item> yellow_tea = ITEM.register("yellow_tea", () -> new YellowTea());
    public static final RegistryObject<Item> flower_tea = ITEM.register("flower_tea", () -> new FlowerTea());
    public static final RegistryObject<Item> milk_tea = ITEM.register("milk_tea", () -> new MilkTea());
    public static final RegistryObject<Item> fruit_tea = ITEM.register("fruit_tea", () -> new FruitTea());
    public static final RegistryObject<Item> milk = ITEM.register("milk", () -> new Milk());
    public static final RegistryObject<Item> soured_milk = ITEM.register("soured_milk", () -> new SouredMilk());
    public static final RegistryObject<Item> juice = ITEM.register("juice", () -> new Juice());
    public static final RegistryObject<Item> flavored_milk = ITEM.register("flavored_milk", () -> new FlavoredMilk());
    public static final RegistryObject<Item> soup = ITEM.register("soup", () -> new Soup());
    public static final RegistryObject<Item> brewage = ITEM.register("brewage", () -> new Brewage());
    public static final RegistryObject<Item> soda_drink = ITEM.register("soda_drink", () -> new SodaDrink());

    public static final RegistryObject<Item> tree_leaf = ITEM.register("tree_leaf", () -> new PlantMaterial());
}
