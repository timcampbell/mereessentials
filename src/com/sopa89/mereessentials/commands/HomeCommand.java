package com.sopa89.mereessentials.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sopa89.mereessentials.Main;
import com.sopa89.mereessentials.utils.Utils;

public class HomeCommand implements CommandExecutor 
{
	private Main plugin;
	
	public HomeCommand(Main plugin)
	{
		this.plugin = plugin;
		
		plugin.getCommand("home").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console_error_message")));
			return true;
		}
		
		Player p = (Player)sender;
		
		if(!p.hasPermission("mereessentials.home"))
		{
			p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm_message")));
			return true;
		}
		
		Location loc = p.getBedSpawnLocation();
		
		if(loc == null)
		{
			p.sendMessage(Utils.chat(plugin.getConfig().getString("HomeCommand.invalid_location_message")));
			return true;
		}
		
		p.teleport(loc);
		return true;
	}
	
	
}
