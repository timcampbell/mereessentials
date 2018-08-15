package com.sopa89.mereessentials.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.sopa89.mereessentials.Main;
import com.sopa89.mereessentials.utils.Utils;

public class BackCommand implements CommandExecutor{
	
	private Main plugin;
	
	public BackCommand(Main plugin)
	{
		this.plugin = plugin;
		
		plugin.getCommand("back").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player))
		{
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console_error_message")));
			return true;
		}
		
		Player p = (Player)sender;
		
		if(p.hasPermission("mereessentials.back"))
		{
			File file = new File("plugins/MereEssentials/Players", p.getUniqueId() + ".yml");
			
			if(file.exists())
			{
				FileConfiguration config = YamlConfiguration.loadConfiguration(file);
				
				double x = config.getDouble("X");
				double y = config.getDouble("Y");
				double z = config.getDouble("Z");
				double yaw = config.getDouble("Yaw");
				double pitch = config.getDouble("Pitch");
				String worldName = config.getString("WorldName");
				World world = Bukkit.getWorld(worldName);
				
				Location loc = p.getLocation();
				
				loc.setX(x);
				loc.setY(y);
				loc.setZ(z);
				loc.setYaw((float)yaw);
				loc.setPitch((float)pitch);
				loc.setWorld(world);
				
				p.teleport(loc);
				return true;
			}
		}
		else
		{
			p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm_message")));
		}
		
		return false;
	}

}
