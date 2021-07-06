package love.marblegate.lielietea.tileentity;

import love.marblegate.lielietea.registry.ItemRegistry;
import love.marblegate.lielietea.registry.TileEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MagmaCubeCageTileEntity extends TileEntity implements ITickableTileEntity {
    private static final double PER_COMBUSTIBLE_TICK_EXCHANGE_RATE = 0.1;
    private static final int PER_COAL_CAKE_COMSUMEPTION_TIME = 1200;

    private final ItemStackHandler feedHandler = createHandler();
    private int remainingTime = 0;
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> feedHandler);

    public MagmaCubeCageTileEntity() {
        super(TileEntityRegistry.magma_cube_cage_tileentity.get());
    }

    @Override
    public void tick() {
        if(!world.isRemote()){
            if(remainingTime>0){
                //Stop Working
                if(remainingTime<=1){
                    //Slime eats feed when possible
                    if(!feedHandler.getStackInSlot(0).isEmpty()){
                        //Formula = Hungar * ( 1 * Saturation Rate ) * PER_HUNGER_COMSUMEPTION_TIME
                        int combustionTime;

                        if(feedHandler.getStackInSlot(0).getItem()==ItemRegistry.coal_cake.get()) combustionTime = PER_COAL_CAKE_COMSUMEPTION_TIME;
                        else combustionTime = feedHandler.getStackInSlot(0).getBurnTime();
                        remainingTime = combustionTime;

                        feedHandler.getStackInSlot(0).shrink(1);
                        markDirty();
                        //Sync Data to Client
                        world.notifyBlockUpdate(pos,getBlockState(),getBlockState(), Constants.BlockFlags.DEFAULT_AND_RERENDER);
                    }
                    else{
                        if(remainingTime == 1 ){
                            remainingTime = 0;
                            markDirty();
                            //Sync Data to Client
                            world.notifyBlockUpdate(pos,getBlockState(),getBlockState(), Constants.BlockFlags.DEFAULT_AND_RERENDER);
                        }
                    }
                }
                //Continue Work
                else {
                    remainingTime -= 1;
                    markDirty();
                }
            }
        }
        System.out.print(world.isRemote+" "+remainingTime+"\n");
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(1) {

            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getBurnTime() > 0 || stack.getItem() == ItemRegistry.coal_cake.get();
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot,stack)) {
                    return stack;
                } else {
                    return super.insertItem(slot, stack, simulate);
                }
            }

            @Nonnull
            @Override
            public ItemStack extractItem(int slot, int amount, boolean simulate) {
                return ItemStack.EMPTY;
            }
        };
    }

    public NonNullList<ItemStack> getInventory() {
        NonNullList<ItemStack> temp = NonNullList.create();
        temp.add(feedHandler.getStackInSlot(0));
        return temp;
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        remainingTime = nbt.getInt("remainingTime");
        feedHandler.deserializeNBT(nbt.getCompound("feedInv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("remainingTime",remainingTime);
        compound.put("feedInv",feedHandler.serializeNBT());
        return super.write(compound);
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT tag = super.getUpdateTag();
        tag.putInt("remainingTime", remainingTime);
        tag.put("feedInv",feedHandler.serializeNBT());
        return tag;
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        remainingTime = tag.getInt("remainingTime");
        feedHandler.deserializeNBT(tag.getCompound("feedInv"));
        super.handleUpdateTag(state, tag);
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT compoundNBT = new CompoundNBT();
        compoundNBT.putInt("remainingTime",remainingTime);
        return new SUpdateTileEntityPacket(pos, 1, compoundNBT);
    }


    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        remainingTime = pkt.getNbtCompound().getInt("remainingTime");
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }
}
