package com.ncpbails.modestmining;

import com.mojang.logging.LogUtils;
import com.ncpbails.modestmining.block.ModBlocks;
import com.ncpbails.modestmining.block.entity.ModBlockEntities;
import com.ncpbails.modestmining.effect.ModEffects;
import com.ncpbails.modestmining.entity.ModEntityTypes;
import com.ncpbails.modestmining.entity.client.ClamRenderer;
import com.ncpbails.modestmining.item.ModItems;
import com.ncpbails.modestmining.recipe.ModRecipes;
import com.ncpbails.modestmining.screen.ForgeScreen;
import com.ncpbails.modestmining.screen.ModMenuTypes;
import com.ncpbails.modestmining.world.feature.ModConfiguredFeatures;
import com.ncpbails.modestmining.world.feature.ModPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModestMining.MOD_ID)
public class ModestMining
{
    public static final String MOD_ID = "modestmining";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ModestMining()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);

        ModEffects.register(eventBus);
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);
        ModEntityTypes.register(eventBus);
        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        SpawnPlacements.register(ModEntityTypes.CLAM.get(),
                SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR,
                WaterAnimal::checkMobSpawnRules);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntityTypes.CLAM.get(), ClamRenderer::new);
            MenuScreens.register(ModMenuTypes.FORGE_MENU.get(), ForgeScreen::new);
        }
    }
}
