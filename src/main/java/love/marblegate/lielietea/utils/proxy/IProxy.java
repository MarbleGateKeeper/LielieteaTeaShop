package love.marblegate.lielietea.utils.proxy;

import net.minecraft.particles.IParticleData;

public interface IProxy {
    default void addParticleForceNear(IParticleData particleData, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed){}
}
