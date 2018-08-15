package com.sopa89.mereessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sopa89.mereessentials.Main;
import com.sopa89.mereessentials.utils.Utils;

public class SuicideCommand implements CommandExecutor
{
	private Main plugin;
	
	public SuicideCommand(Main plugin)
	{
		this.plugin = plugin;
		
		plugin.getCommand("suicide").setExecutor(this);
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
		
		if(!(p.hasPermission("mereessentials.suicide")))
		{
			p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm_message")));
			return true;
		}
		
		p.damage(20);
		p.getServer().broadcastMessage(Utils.chat("&6" + p.getDisplayName() + plugin.getConfig().getString("SuicideCommand.suicide_message")));
		
		return true;
	}
}
