package love.marblegate.lielietea;

import love.marblegate.lielietea.registry.ItemRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("lielietea")
public class LIeLieTea {
    public LIeLieTea(){
        ItemRegistry.ITEM.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
