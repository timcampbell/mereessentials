package com.sopa89.mereessentials.listeners;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import com.sopa89.mereessentials.Main;

public class PlayerTeleportListener implements Listener
{
	private Main plugin;
	
	public PlayerTeleportListener(Main plugin)
	{
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent e)
	{
		if(e.getCause() != PlayerTeleportEvent.TeleportCause.PLUGIN && e.getCause() != PlayerTeleportEvent.TeleportCause.COMMAND)
			return;
		Player p = e.getPlayer();
		
		Location loc = p.getLocation();
		
		File file=new File("plugins/MereEssentials/Back", p.getUniqueId() + ".yml");
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		double x = loc.getX();
		double y = loc.getY();
		double z = loc.getZ();
		double yaw = loc.getYaw();
		double pitch = loc.getPitch();
		String worldName = loc.getWorld().getName();
		
		config.set("X", x);
		config.set("Y", y);
		config.set("Z", z);
		config.set("Yaw", yaw);
		config.set("Pitch", pitch);
		config.set("WorldName", worldName);
		
		try {
			config.save(file);
		} catch (IOException e1) {}
	}
}
