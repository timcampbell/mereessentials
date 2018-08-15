package com.sopa89.mereessentials.listeners;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.sopa89.mereessentials.Main;

public class PlayerLoginListener implements Listener{

	private Main plugin;
	
	public PlayerLoginListener(Main plugin)
	{
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e)
	{
		Player p = e.getPlayer();
		
		File file = new File("plugins/MereEssentials/Players", p.getUniqueId() + ".yml");
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		p.setDisplayName(config.getString("nick"));
		p.setPlayerListName(config.getString("nick"));
	}
}
