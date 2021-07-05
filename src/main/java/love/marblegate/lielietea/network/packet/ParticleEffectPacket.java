package love.marblegate.lielietea.network.packet;

import love.marblegate.lielietea.utils.proxy.ClientProxy;
import love.marblegate.lielietea.utils.proxy.IProxy;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ParticleEffectPacket {
    private final EffectType type;
    private final double x;
    private final double y;
    private final double z;
    private final double[] args;
    public static IProxy proxy = new IProxy() {};

    public ParticleEffectPacket(EffectType type, double x, double y, double z, double... args) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.args = args;
    }

    public ParticleEffectPacket(PacketBuffer buffer) {
        this.type = buffer.readEnumValue(EffectType.class);
        this.x = buffer.readDouble();
        this.y = buffer.readDouble();
        this.z = buffer.readDouble();
        int argsSum = buffer.readInt();
        this.args = new double[argsSum];
        for (int i = 0; i < argsSum; i++) {
            this.args[i] = buffer.readDouble();
        }
    }


    public void toBytes(PacketBuffer buffer) {
        buffer.writeEnumValue(this.type);
        buffer.writeDouble(this.x);
        buffer.writeDouble(this.y);
        buffer.writeDouble(this.z);
        buffer.writeInt(this.args.length);
        for (double arg : this.args) {
            buffer.writeDouble(arg);
        }
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,()-> () -> {
            ctx.get().enqueueWork(() -> {
                proxy = new ClientProxy();
                if(type== EffectType.SLIME_CATCHED){
                    //需要重写

                }
                else if(type== EffectType.MAGMA_CUBE_CATCHED){
                    //需要重写

                }
            });
            ctx.get().setPacketHandled(true);
        });
    }

    public enum EffectType {
        SLIME_CATCHED,
        MAGMA_CUBE_CATCHED
    }




}
