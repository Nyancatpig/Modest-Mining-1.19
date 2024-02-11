package com.ncpbails.modestmining.integration;

import com.ncpbails.modestmining.ModestMining;
import com.ncpbails.modestmining.block.ModBlocks;
import com.ncpbails.modestmining.recipe.ForgeShapedRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ForgingShapedRecipeCategory implements IRecipeCategory<ForgeShapedRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ModestMining.MOD_ID, "forging_shaped");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ModestMining.MOD_ID, "textures/gui/forge_gui_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public ForgingShapedRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FORGE.get()));
    }

    @Override
    public RecipeType<ForgeShapedRecipe> getRecipeType() {
        return JEIModestMiningPlugin.FORGING_SHAPED_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Shaped Forging");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ForgeShapedRecipe recipe, IFocusGroup focuses) {
        int startX = 30;
        int startY = 19;
        int index = 0;

        for (int y = 0; y < recipe.getHeight(); y++) {
            for (int x = 0; x < recipe.getWidth(); x++) {
                builder.addSlot(RecipeIngredientRole.INPUT, startX + x * 18, startY + y * 18)
                        .addIngredients(recipe.getIngredients().get(index));
                index++;
            }
        }

        // Add fuel slot
        builder.addSlot(RecipeIngredientRole.INPUT, 93, 55).addIngredients(recipe.getFuel());

        // Add output slot
        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 21).addItemStack(recipe.getResultItem());
    }
}