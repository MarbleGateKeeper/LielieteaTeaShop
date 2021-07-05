package love.marblegate.lielietea;

import love.marblegate.lielietea.registry.BlockRegistry;
import love.marblegate.lielietea.registry.ItemRegistry;
import love.marblegate.lielietea.registry.TileEntityRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("lielietea")
public class LIeLieTea {
    public LIeLieTea(){
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TileEntityRegistry.TE.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
