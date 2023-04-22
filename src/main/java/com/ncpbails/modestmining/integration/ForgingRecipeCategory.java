package com.ncpbails.modestmining.integration;

import com.ncpbails.modestmining.ModestMining;
import com.ncpbails.modestmining.block.ModBlocks;
import com.ncpbails.modestmining.item.ModItems;
import com.ncpbails.modestmining.recipe.ForgeRecipe;
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
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class ForgingRecipeCategory implements IRecipeCategory<ForgeRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ModestMining.MOD_ID, "forging");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ModestMining.MOD_ID, "textures/gui/forge_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public ForgingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FORGE.get()));
    }

    @Override
    public RecipeType<ForgeRecipe> getRecipeType() {
        return JEIModestMiningPlugin.FORGING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Forge");
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
    public void setRecipe(IRecipeLayoutBuilder builder, ForgeRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 21, 20).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 39, 20).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 20).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 75, 20).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 21, 38).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 39, 38).addIngredients(recipe.getIngredients().get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 38).addIngredients(recipe.getIngredients().get(6));
        builder.addSlot(RecipeIngredientRole.INPUT, 75, 38).addIngredients(recipe.getIngredients().get(7));
        builder.addSlot(RecipeIngredientRole.INPUT, 75, 62).addIngredients(Ingredient.of(ModItems.COKE.get()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 135, 30).addItemStack(recipe.getResultItem());
    }
}