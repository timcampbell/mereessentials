package com.sopa89.mereessentials.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.sopa89.mereessentials.Main;

public class CraftingRecipes 
{
	private Main plugin;
	
	public CraftingRecipes(Main plugin)
	{
		this.plugin = plugin;
		
		//Resulting ItemStack
		ItemStack smoothStone = new ItemStack(Material.SMOOTH_STONE, 2);
		ItemStack smoothSandStone = new ItemStack(Material.SMOOTH_SANDSTONE, 2);
		ItemStack smoothRedSandStone = new ItemStack(Material.SMOOTH_RED_SANDSTONE, 2);
		
		//NameSpacedKeys
		NamespacedKey smoothStoneKey = new NamespacedKey(plugin, "smooth_stone");
		NamespacedKey smoothSandStoneKey = new NamespacedKey(plugin, "smooth_sand_stone");
		NamespacedKey smoothRedSandStoneKey = new NamespacedKey(plugin, "smooth_red_sand_stone");
		
		//Create Recipe
		ShapedRecipe smoothStoneRecipe = new ShapedRecipe(smoothStoneKey, smoothStone);
		smoothStoneRecipe.shape("ss", "ss").setIngredient('s', Material.STONE_SLAB);
		
		ShapedRecipe smoothSandStoneRecipe = new ShapedRecipe(smoothSandStoneKey, smoothSandStone);
		smoothSandStoneRecipe.shape("ss","ss").setIngredient('s', Material.SANDSTONE_SLAB);
		
		ShapedRecipe smoothRedSandStoneRecipe = new ShapedRecipe(smoothRedSandStoneKey, smoothRedSandStone);
		smoothRedSandStoneRecipe.shape("ss","ss").setIngredient('s', Material.RED_SANDSTONE_SLAB);
		
		//Add Recipe
		Bukkit.addRecipe(smoothStoneRecipe);
		Bukkit.addRecipe(smoothSandStoneRecipe);
		Bukkit.addRecipe(smoothRedSandStoneRecipe);
	}
}
