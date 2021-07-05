package love.marblegate.lielietea.registry;

import love.marblegate.lielietea.tileentity.SlimeCageTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityRegistry {
    public static final DeferredRegister<TileEntityType<?>> TE = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, "lielietea");
    public static RegistryObject<TileEntityType<SlimeCageTileEntity>> slime_cage_tileentity = TE.register("slime_cage_tileentity", () -> TileEntityType.Builder.create(SlimeCageTileEntity::new, BlockRegistry.slime_cage.get()).build(null));
}
