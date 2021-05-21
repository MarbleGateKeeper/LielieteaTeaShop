package love.marblegate.lielietea.registry;

import love.marblegate.lielietea.item.drink.*;
import love.marblegate.lielietea.item.greenhouseplant.GreenhousePlantMaterial;
import love.marblegate.lielietea.item.greenhouseplant.GreenhousePlantSeeds;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, "lielietea");
    public static final RegistryObject<Item> green_tea = ITEM.register("green_tea", GreenTea::new);
    public static final RegistryObject<Item> black_tea = ITEM.register("black_tea", BlackTea::new);
    public static final RegistryObject<Item> dark_tea = ITEM.register("dark_tea", DarkTea::new);
    public static final RegistryObject<Item> oolong_tea = ITEM.register("oolong_tea", OolongTea::new);
    public static final RegistryObject<Item> white_tea = ITEM.register("white_tea", WhiteTea::new);
    public static final RegistryObject<Item> yellow_tea = ITEM.register("yellow_tea", YellowTea::new);
    public static final RegistryObject<Item> flower_tea = ITEM.register("flower_tea", FlowerTea::new);
    public static final RegistryObject<Item> milk_tea = ITEM.register("milk_tea", MilkTea::new);
    public static final RegistryObject<Item> fruit_tea = ITEM.register("fruit_tea", FruitTea::new);
    public static final RegistryObject<Item> milk = ITEM.register("milk", Milk::new);
    public static final RegistryObject<Item> soured_milk = ITEM.register("soured_milk", SouredMilk::new);
    public static final RegistryObject<Item> juice = ITEM.register("juice", Juice::new);
    public static final RegistryObject<Item> flavored_milk = ITEM.register("flavored_milk", FlavoredMilk::new);
    public static final RegistryObject<Item> soup = ITEM.register("soup", Soup::new);
    public static final RegistryObject<Item> brewage = ITEM.register("brewage", Brewage::new);
    public static final RegistryObject<Item> soda_drink = ITEM.register("soda_drink", SodaDrink::new);

    public static final RegistryObject<Item> tree_leaf = ITEM.register("tree_leaf", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> tree_flower = ITEM.register("tree_flower", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> tree_fruit = ITEM.register("tree_fruit", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> shrub_leaf = ITEM.register("shrub_leaf", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> shrub_flower = ITEM.register("shrub_flower", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> shrub_fruit = ITEM.register("shrub_fruit", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> juicy_shrub_root = ITEM.register("juicy_shrub_root", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> brewable_shrub_root = ITEM.register("brewable_shrub_root", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> vine_leaf = ITEM.register("vine_leaf", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> juicy_vine_leaf = ITEM.register("juicy_vine_leaf", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> vine_flower = ITEM.register("vine_flower", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> juice_vine_stem = ITEM.register("juice_vine_stem", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> milkable_vine_stem = ITEM.register("milkable_vine_stem", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> brewable_vine_stem = ITEM.register("brewable_vine_stem", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> vine_fruit = ITEM.register("vine_fruit", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> juicy_vine_root = ITEM.register("juicy_vine_root", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> brewable_vine_root = ITEM.register("brewable_vine_root", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> juicy_mushroom = ITEM.register("juicy_mushroom", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> milkable_mushroom = ITEM.register("milkable_mushroom", GreenhousePlantMaterial::new);
    public static final RegistryObject<Item> brewable_mushroom = ITEM.register("brewable_mushroom", GreenhousePlantMaterial::new);

    public static final RegistryObject<Item> tree_sapling = ITEM.register("tree_sapling", GreenhousePlantSeeds::new);
    public static final RegistryObject<Item> shrub_seed = ITEM.register("shrub_seed", GreenhousePlantSeeds::new);
    public static final RegistryObject<Item> vine_seed = ITEM.register("vine_seed", GreenhousePlantSeeds::new);
    public static final RegistryObject<Item> mushroom_spawn = ITEM.register("mushroom_spawn", GreenhousePlantSeeds::new);

}
