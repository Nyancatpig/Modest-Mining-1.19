package com.ncpbails.modestmining.block.entity.custom;

import com.ncpbails.modestmining.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

import static net.minecraft.world.level.block.Block.dropResources;

public class BrushingBlockEntity extends BlockEntity {
    public int playerProgress = 0;
    public int brushProgress = 0;
    public int maxProgress = 120;
    public boolean canProgress = false;

    public BrushingBlockEntity(BlockPos pPos, BlockState pState) {
        super(ModBlockEntities.BRUSHING_BLOCK_ENTITY.get(), pPos, pState);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
    }

    @Nullable
    @Nonnull
    public static void tick(Level worldIn, BlockPos pos, BlockState state, BrushingBlockEntity pBlockEntity) {
        Random random = new Random();
        if (pBlockEntity.canProgress) {
            if (pBlockEntity.brushProgress < pBlockEntity.maxProgress) {
                pBlockEntity.brushProgress++;
                if (pBlockEntity.playerProgress - 16 > pBlockEntity.brushProgress) {
                    worldIn.removeBlock(pos, true);
                }
                if (pBlockEntity.playerProgress + 8 < pBlockEntity.brushProgress) {
                    worldIn.removeBlock(pos, true);
                }
            } else {
                dropResources(state, worldIn, pos);
                worldIn.removeBlock(pos, true);
                worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 0.25F, 0.5F);
                worldIn.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, state), (double) pos.getX() + (double) random.nextFloat(), (double) pos.getY() + 1.1D, (double) pos.getZ() + (double) random.nextFloat(), 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
