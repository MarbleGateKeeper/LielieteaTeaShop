package love.marblegate.lielietea.block;

import love.marblegate.lielietea.network.Networking;
import love.marblegate.lielietea.network.packet.ParticleEffectPacket;
import love.marblegate.lielietea.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class SlimeCatcher extends Block {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);

    public SlimeCatcher() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(10)
                .sound(SoundType.METAL));
    }


    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isRemote()) {
            if (entityIn instanceof SlimeEntity) {
                if (((SlimeEntity) entityIn).isSmallSlime()) {
                    entityIn.remove();
                    worldIn.setBlockState(pos, BlockRegistry.slime_cage.get().getDefaultState());
                    //Notify Client to Play Catching FX
                    Networking.INSTANCE.send(
                            PacketDistributor.NEAR.with(
                                    () -> new PacketDistributor.TargetPoint(pos.getX(), pos.getY(), pos.getZ(),
                                            192, worldIn.getDimensionKey())),
                            new ParticleEffectPacket(ParticleEffectPacket.EffectType.SLIME_CATCHED, pos.getX(), pos.getY(), pos.getZ(), 24));
                }
            } else if (entityIn instanceof MagmaCubeEntity) {
                if (((MagmaCubeEntity) entityIn).isSmallSlime()) {
                    entityIn.remove();
                    worldIn.setBlockState(pos, BlockRegistry.magma_cube_cage.get().getDefaultState());
                    //Notify Client to Play Catching FX
                    Networking.INSTANCE.send(
                            PacketDistributor.NEAR.with(
                                    () -> new PacketDistributor.TargetPoint(pos.getX(), pos.getY(), pos.getZ(),
                                            192, worldIn.getDimensionKey())),
                            new ParticleEffectPacket(ParticleEffectPacket.EffectType.MAGMA_CUBE_CATCHED, pos.getX(), pos.getY(), pos.getZ(), 24));
                }
            }
        }
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
