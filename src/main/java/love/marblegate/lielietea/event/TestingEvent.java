package love.marblegate.lielietea.event;

import love.marblegate.lielietea.capability.plantinfo.IUniversalPlantInfo;
import love.marblegate.lielietea.capability.plantinfo.UniversalPlantInfo;
import love.marblegate.lielietea.datastructure.PlantInfo;
import love.marblegate.lielietea.datastructure.enumeration.UniversalPlantType;
import love.marblegate.lielietea.item.greenhouseplant.GreenhousePlantMaterial;
import love.marblegate.lielietea.util.NameGenerator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;


@Mod.EventBusSubscriber()
public class TestingEvent {
    @SubscribeEvent
    public static void test(PlayerInteractEvent.RightClickItem event){
            ItemStack stack = event.getPlayer().getHeldItem(event.getHand());
            if(stack.getItem() instanceof GreenhousePlantMaterial){
                LazyOptional<IUniversalPlantInfo> uni_plant_info_cap = stack.getCapability(UniversalPlantInfo.UNIVERSAL_PLANT_INFO);
                uni_plant_info_cap.ifPresent(
                        cap-> {
                            Random rand = event.getPlayer().getRNG();
                            int randSeed = rand.nextInt(99999999)+100;
                            UniversalPlantType type = UniversalPlantType.valueOf(rand.nextInt(3)+3);
                            String randName = "NA";
                            switch (type){
                                case GREENHOUSE_C:
                                case GREENHOUSE_B:
                                    randName = NameGenerator.generateRandName(type,randSeed);
                                    break;
                                default:
                            }
                            PlantInfo plantInfo = new PlantInfo(type,randSeed,randName);
                            cap.setPlant(plantInfo);
                        });
            }
    }
}
