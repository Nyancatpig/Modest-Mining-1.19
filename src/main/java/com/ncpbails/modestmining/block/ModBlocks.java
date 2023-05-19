package com.ncpbails.modestmining.block;

import com.ncpbails.modestmining.ModestMining;
import com.ncpbails.modestmining.block.custom.BrushingBlock;
import com.ncpbails.modestmining.block.custom.ForgeBlock;
import com.ncpbails.modestmining.block.entity.custom.RockBlock;
import com.ncpbails.modestmining.block.entity.custom.ShellBlock;
import com.ncpbails.modestmining.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModestMining.MOD_ID);

    //BLOCKS
    public static final RegistryObject<Block> COKE_BLOCK = registerBlock("coke_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS, true, 64000);

    public static final RegistryObject<Block> COAL_POWDER_BLOCK = registerBlock("coal_powder_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND)), CreativeModeTab.TAB_BUILDING_BLOCKS, true, 24000);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> ROSEGOLD_BLOCK = registerBlock("rosegold_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> PRISMARITE_BLOCK = registerBlock("prismarite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> CEMENT = registerBlock("cement",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> CEMENT_POWDER = registerBlock("cement_powder",
            () -> new ConcretePowderBlock(CEMENT.get(), BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE_POWDER)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> ADOBE_BRICKS = registerBlock("adobe_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> ADOBE_BRICK_SLAB = registerBlock("adobe_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> ADOBE_BRICK_STAIRS = registerBlock("adobe_brick_stairs",
            () -> new StairBlock(() -> Blocks.STONE_BRICK_STAIRS.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> ADOBE_BRICK_WALL = registerBlock("adobe_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> CRACKED_ADOBE_BRICKS = registerBlock("cracked_adobe_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> MOSSY_ADOBE_BRICKS = registerBlock("mossy_adobe_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> MOSSY_ADOBE_BRICK_SLAB = registerBlock("mossy_adobe_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_SLAB)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> MOSSY_ADOBE_BRICK_STAIRS = registerBlock("mossy_adobe_brick_stairs",
            () -> new StairBlock(() -> Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.MOSSY_STONE_BRICK_STAIRS)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> MOSSY_ADOBE_BRICK_WALL = registerBlock("mossy_adobe_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);


    public static final RegistryObject<Block> FORGE = registerBlock("forge",
            () -> new ForgeBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY)
                    .strength(5.0f, 6.0f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_DECORATIONS, false, 0);

    public static final RegistryObject<Block> COMPACT_AMETHYST_BLOCK = registerBlock("compact_amethyst_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> OCEANIC_REMAINS = registerBlock("oceanic_remains",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> DIAMOND_SHARD_BLOCK = registerBlock("diamond_shard_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).sound(SoundType.METAL)), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);


    public static final RegistryObject<Block> SUSPICIOUS_DIRT = registerBlock("suspicious_dirt",
            () -> new BrushingBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> SUSPICIOUS_SAND = registerBlock("suspicious_sand",
            () -> new BrushingBlock(BlockBehaviour.Properties.copy(Blocks.SAND).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> SUSPICIOUS_GRAVEL = registerBlock("suspicious_gravel",
            () -> new BrushingBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);
    public static final RegistryObject<Block> SUSPICIOUS_STONE = registerBlock("suspicious_stone",
            () -> new BrushingBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS, false, 0);

    public static final RegistryObject<Block> SHELL = registerBlock("shell",
            () -> new ShellBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
                    .strength(0.5f, 0.5f)), CreativeModeTab.TAB_MISC, false, 0);

    public static final RegistryObject<Block> ROCKS = registerBlock("rocks",
            () -> new RockBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
                    .strength(0.5f, 0.5f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC, false, 0);

    public static final RegistryObject<Block> VARIED_PLANKS = registerBlock("varied_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> VARIED_PLANK_SLAB = registerBlock("varied_plank_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).noOcclusion())
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> VARIED_PLANK_STAIRS = registerBlock("varied_plank_stairs",
            () -> new StairBlock(() -> Blocks.OAK_STAIRS.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).noOcclusion())
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> VARIED_PLANK_FENCE = registerBlock("varied_plank_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).noOcclusion())
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_DECORATIONS, true, 300);

    public static final RegistryObject<Block> VARIED_PLANK_FENCE_GATE = registerBlock("varied_plank_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).noOcclusion())
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_DECORATIONS, true, 300);

    public static final RegistryObject<Block> VARIED_PLANK_BUTTON = registerBlock("varied_plank_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noOcclusion().noCollission())
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_REDSTONE, true, 300);

    public static final RegistryObject<Block> VARIED_PLANK_PRESSURE_PLATE = registerBlock("varied_plank_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).noOcclusion())
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_REDSTONE, true, 300);


    public static final RegistryObject<Block> OAK_PILLAR = registerBlock("oak_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
                }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> SPRUCE_PILLAR = registerBlock("spruce_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> BIRCH_PILLAR = registerBlock("birch_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> JUNGLE_PILLAR = registerBlock("jungle_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> ACACIA_PILLAR = registerBlock("acacia_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> DARK_OAK_PILLAR = registerBlock("dark_oak_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> WARPED_PILLAR = registerBlock("warped_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, false, 300);

    public static final RegistryObject<Block> CRIMSON_PILLAR = registerBlock("crimson_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, false, 300);

    public static final RegistryObject<Block> MANGROVE_PILLAR = registerBlock("mangrove_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> OAK_BOARDS = registerBlock("oak_boards",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> SPRUCE_BOARDS = registerBlock("spruce_boards",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> BIRCH_BOARDS = registerBlock("birch_boards",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> JUNGLE_BOARDS = registerBlock("jungle_boards",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> ACACIA_BOARDS = registerBlock("acacia_boards",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> DARK_OAK_BOARDS = registerBlock("dark_oak_boards",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> WARPED_BOARDS = registerBlock("warped_boards",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, false, 300);

    public static final RegistryObject<Block> CRIMSON_BOARDS = registerBlock("crimson_boards",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, false, 300);

    public static final RegistryObject<Block> MANGROVE_BOARDS = registerBlock("mangrove_boards",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> OAK_TILES = registerBlock("oak_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> SPRUCE_TILES = registerBlock("spruce_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> BIRCH_TILES = registerBlock("birch_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> JUNGLE_TILES = registerBlock("jungle_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> ACACIA_TILES = registerBlock("acacia_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> DARK_OAK_TILES = registerBlock("dark_oak_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> WARPED_TILES = registerBlock("warped_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, false, 300);

    public static final RegistryObject<Block> CRIMSON_TILES = registerBlock("crimson_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, false, 300);

    public static final RegistryObject<Block> MANGROVE_TILES = registerBlock("mangrove_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CARVED_OAK_PLANKS = registerBlock("carved_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CARVED_SPRUCE_PLANKS = registerBlock("carved_spruce_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CARVED_BIRCH_PLANKS = registerBlock("carved_birch_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CARVED_JUNGLE_PLANKS = registerBlock("carved_jungle_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CARVED_ACACIA_PLANKS = registerBlock("carved_acacia_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CARVED_DARK_OAK_PLANKS = registerBlock("carved_dark_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CARVED_WARPED_PLANKS = registerBlock("carved_warped_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, false, 300);

    public static final RegistryObject<Block> CARVED_CRIMSON_PLANKS = registerBlock("carved_crimson_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, false, 300);

    public static final RegistryObject<Block> CARVED_MANGROVE_PLANKS = registerBlock("carved_mangrove_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CHISELED_OAK_PLANKS = registerBlock("chiseled_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CHISELED_SPRUCE_PLANKS = registerBlock("chiseled_spruce_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CHISELED_BIRCH_PLANKS = registerBlock("chiseled_birch_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CHISELED_JUNGLE_PLANKS = registerBlock("chiseled_jungle_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CHISELED_ACACIA_PLANKS = registerBlock("chiseled_acacia_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CHISELED_DARK_OAK_PLANKS = registerBlock("chiseled_dark_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);

    public static final RegistryObject<Block> CHISELED_WARPED_PLANKS = registerBlock("chiseled_warped_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, false, 300);

    public static final RegistryObject<Block> CHISELED_CRIMSON_PLANKS = registerBlock("chiseled_crimson_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, false, 300);

    public static final RegistryObject<Block> CHISELED_MANGROVE_PLANKS = registerBlock("chiseled_mangrove_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            }, CreativeModeTab.TAB_BUILDING_BLOCKS, true, 300);




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, Boolean isFuel, Integer fuelAmount) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, isFuel, fuelAmount);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockNoItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab, Boolean isFuel, Integer fuelAmount) {
        if(isFuel == false) {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().tab(tab)));
        } else {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)){
            @Override public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {return fuelAmount;}});
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}