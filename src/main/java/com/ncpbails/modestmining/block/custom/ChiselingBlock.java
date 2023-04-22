package com.ncpbails.modestmining.block.custom;

import com.ncpbails.modestmining.block.entity.ModBlockEntities;
import com.ncpbails.modestmining.block.entity.custom.ChiselingBlockEntity;
import com.ncpbails.modestmining.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChiselingBlock extends BaseEntityBlock {
    public static IntegerProperty CHISELING = IntegerProperty.create("chiseling", 0, 3);
    private static final VoxelShape[] SHAPE_BY_CHISEL;

    public ChiselingBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(super.defaultBlockState().setValue(CHISELING, 0));
    }

    public @NotNull VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_CHISEL[state.getValue(this.CHISELING)];
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{CHISELING});
        super.createBlockStateDefinition(builder);
    }

       public int getMaxChiselingStage() {
        return 3;
    }

    static {
        SHAPE_BY_CHISEL = new VoxelShape[]{
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D)};
    }

    protected void spawnDestroyParticles(Level p_152422_, Player p_152423_, BlockPos p_152424_, BlockState p_152425_) {
        p_152422_.levelEvent(p_152423_, 2001, p_152424_, getId(p_152425_));
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(handIn);
        ItemStack offhandStack = player.getOffhandItem();

        if (!worldIn.isClientSide()) {
            BlockEntity entity = worldIn.getBlockEntity(pos);
            if(entity instanceof ChiselingBlockEntity) {

                //Main Hand Copper
                if (handIn.equals(InteractionHand.MAIN_HAND) && heldStack.is(ModItems.COPPER_CHISEL.get())) {
                    chiselAtBlock(state, worldIn, pos, player, handIn, hit, entity, heldStack, 10);
                }
                //Main Hand Exposed
                else if (handIn.equals(InteractionHand.MAIN_HAND) && heldStack.is(ModItems.EXPOSED_COPPER_CHISEL.get())) {
                    chiselAtBlock(state, worldIn, pos, player, handIn, hit, entity, heldStack, 8);
                }
                //Main Hand Weathered
                else if (handIn.equals(InteractionHand.MAIN_HAND) && heldStack.is(ModItems.WEATHERED_COPPER_CHISEL.get())) {
                    chiselAtBlock(state, worldIn, pos, player, handIn, hit, entity, heldStack, 6);
                }
                //Main Hand Oxidized
                else if (handIn.equals(InteractionHand.MAIN_HAND) && heldStack.is(ModItems.OXIDIZED_COPPER_CHISEL.get())) {
                    chiselAtBlock(state, worldIn, pos, player, handIn, hit, entity, heldStack, 4);
                }
                //Off Hand Copper
                else if (handIn.equals(InteractionHand.OFF_HAND) && offhandStack.is(ModItems.COPPER_CHISEL.get())) {
                    chiselAtBlock(state, worldIn, pos, player, handIn, hit, entity, offhandStack, 10);
                }
                //Off Hand Exposed
                else if (handIn.equals(InteractionHand.OFF_HAND) && offhandStack.is(ModItems.EXPOSED_COPPER_CHISEL.get())) {
                    chiselAtBlock(state, worldIn, pos, player, handIn, hit, entity, offhandStack, 8);
                }
                //Off Hand Weathered
                else if (handIn.equals(InteractionHand.OFF_HAND) && offhandStack.is(ModItems.WEATHERED_COPPER_CHISEL.get())) {
                    chiselAtBlock(state, worldIn, pos, player, handIn, hit, entity, offhandStack, 6);
                }
                //Off Hand Oxidized
                else if (handIn.equals(InteractionHand.OFF_HAND) && offhandStack.is(ModItems.OXIDIZED_COPPER_CHISEL.get())) {
                    chiselAtBlock(state, worldIn, pos, player, handIn, hit, entity, offhandStack, 4);
                }

            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }

        }
        return InteractionResult.PASS;
    }

    protected void chiselAtBlock(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
                                BlockHitResult hit, BlockEntity entity, ItemStack itemStack, int inProgress){
        ((ChiselingBlockEntity) entity).canProgress = true;
        ((ChiselingBlockEntity) entity).playerProgress = ((ChiselingBlockEntity) entity).playerProgress + inProgress;
        if(((ChiselingBlockEntity) entity).playerProgress > ((ChiselingBlockEntity) entity).maxProgress/4*3) {
            worldIn.setBlock(pos, state.setValue(CHISELING, 3), 2);
        }
        else if(((ChiselingBlockEntity) entity).playerProgress > ((ChiselingBlockEntity) entity).maxProgress/2) {
            worldIn.setBlock(pos, state.setValue(CHISELING, 2), 2);
        }
        else if(((ChiselingBlockEntity) entity).playerProgress > ((ChiselingBlockEntity) entity).maxProgress/4) {
            worldIn.setBlock(pos, state.setValue(CHISELING, 1), 2);
        }
        worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BASALT_BREAK, SoundSource.BLOCKS, 0.25F, 0.5F);
        spawnDestroyParticles(worldIn, player, pos, state);
        //Damage Chisel
        if (!player.isCreative()) {
            itemStack.setDamageValue(itemStack.getDamageValue() + 1);
            if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) {
                itemStack.shrink(1);
            }
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ChiselingBlockEntity(pPos, pState);
    }
    
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.CHISELING_BLOCK_ENTITY.get(),
                ChiselingBlockEntity::tick);
    }

}
