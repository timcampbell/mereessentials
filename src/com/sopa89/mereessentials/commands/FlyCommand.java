package com.sopa89.mereessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sopa89.mereessentials.Main;
import com.sopa89.mereessentials.utils.Utils;

public class FlyCommand implements CommandExecutor 
{

	private Main plugin;
	
	public FlyCommand(Main plugin) 
	{
		this.plugin = plugin;
		
		plugin.getCommand("fly").setExecutor(this);;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!(sender instanceof Player) && args.length <= 0) 
		{
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console_error_message")));
			return true;
		}
		
		
		if(sender.hasPermission("mereessentials.fly")) 
		{
			if(args.length >= 1)
			{
				Player target = sender.getServer().getPlayer(args[0]);
				if(target != null)
				{
					if(target.getAllowFlight())
					{
						target.setAllowFlight(false);
						target.setFlying(false);
						target.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.fly_disabled")));
						return true;
					}
					else
					{
						target.setAllowFlight(true);
						target.setFlying(true);
						target.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.fly_enabled")));
						return true;
					}
				}
				else
				{
					sender.sendMessage(Utils.chat(plugin.getConfig().getString("player_not_found_message")));
				}
			}
			else
			{
				Player p = (Player) sender;
				
				if(p.getAllowFlight())
				{
					p.setAllowFlight(false);
					p.setFlying(false);
					p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.fly_disabled")));
					return true;
				}
				else
				{
					p.setAllowFlight(true);
					p.setFlying(true);
					p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.fly_enabled")));
					return true;
				}
			}
		}
		else
		{
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm_message")));
		}
		
		return false;
	}
}
