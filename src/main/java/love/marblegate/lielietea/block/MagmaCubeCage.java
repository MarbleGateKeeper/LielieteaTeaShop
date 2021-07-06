package love.marblegate.lielietea.block;

import love.marblegate.lielietea.tileentity.MagmaCubeCageTileEntity;
import love.marblegate.lielietea.tileentity.SlimeCageTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class MagmaCubeCage extends SlimeCage {

    public MagmaCubeCage() {
        super();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity != null) {
                LazyOptional<IItemHandler> iItemHandler = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
                iItemHandler.ifPresent((cap) -> {
                    if(cap.isItemValid(0,player.getHeldItem(Hand.MAIN_HAND))){
                        ItemStack leftover = cap.insertItem(0, player.getHeldItem(Hand.MAIN_HAND), false);
                        player.setHeldItem(Hand.MAIN_HAND,leftover);
                    }
                });
            }
            return ActionResultType.CONSUME;
        }
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.matchesBlock(newState.getBlock())) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof MagmaCubeCageTileEntity) {
                InventoryHelper.dropItems(worldIn, pos, ((MagmaCubeCageTileEntity)tileentity).getInventory());
            }
            super.onReplaced(state, worldIn, pos, newState, isMoving);
        }
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new MagmaCubeCageTileEntity();
    }
}
