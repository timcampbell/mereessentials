package com.sopa89.mereessentials;

import org.bukkit.plugin.java.JavaPlugin;

import com.sopa89.mereessentials.commands.BackCommand;
import com.sopa89.mereessentials.commands.FlyCommand;
import com.sopa89.mereessentials.commands.HomeCommand;
import com.sopa89.mereessentials.commands.NickCommand;
import com.sopa89.mereessentials.commands.SpawnCommand;
import com.sopa89.mereessentials.commands.SuicideCommand;
import com.sopa89.mereessentials.listeners.PlayerDeathListener;
import com.sopa89.mereessentials.listeners.PlayerTeleportListener;
import com.sopa89.mereessentials.recipes.CraftingRecipes;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		saveDefaultConfig();
		//Recipes
		new CraftingRecipes(this);
		
		//Commands
		new FlyCommand(this);
		new BackCommand(this);
		new SuicideCommand(this);
		new HomeCommand(this);
		new SpawnCommand(this);
		new NickCommand(this);
		
		//Listeners
		new PlayerDeathListener(this);
		new PlayerTeleportListener(this);
	}
	
}
