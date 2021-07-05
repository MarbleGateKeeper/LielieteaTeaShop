package love.marblegate.lielietea.registry;

import love.marblegate.lielietea.block.MagmaCubeCage;
import love.marblegate.lielietea.block.SlimeCage;
import love.marblegate.lielietea.block.SlimeCatcher;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "lielietea");
    public static final RegistryObject<Block> slime_catcher = BLOCKS.register("slime_catcher", SlimeCatcher::new);

    public static final RegistryObject<Block> slime_cage = BLOCKS.register("slime_cage", SlimeCage::new);
    public static final RegistryObject<Block> magma_cube_cage = BLOCKS.register("magma_cube_cage", MagmaCubeCage::new);
}
