package love.marblegate.lielietea;

import love.marblegate.lielietea.registry.ItemRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("lielietea")
public class LIeLieTea {
    public static final Logger LOGGER = LogManager.getLogger();
    public LIeLieTea(){
        ItemRegistry.ITEM.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
