package com.sopa89.mereessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sopa89.mereessentials.Main;
import com.sopa89.mereessentials.utils.Utils;

public class NickCommand implements CommandExecutor{
	
	private Main plugin;
	
	public NickCommand(Main plugin)
	{
		this.plugin = plugin;
		
		plugin.getCommand("nick").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!(sender instanceof Player))
		{
			if(args.length <= 1)
			{
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("console_error_message")));
				return true;
			}
			
			Player target = sender.getServer().getPlayer(args[0]);
			
			if(target == null)
			{
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("player_not_found_message")));
				return true;
			}
			
			String nick = args[1];
			
			if((nick.charAt(0) != '"') || (nick.charAt(nick.length()-1) != '"'))
			{
				return false;
			}
			
			target.setDisplayName(nick.substring(1, nick.length()-1));
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("NickCommand.success") + target.getDisplayName()));
			return true;
		}
		
		Player p = (Player)sender;
		
		if(p.hasPermission("mereessentials.nick"))
		{
			if(args.length >= 2)
			{
				if(p.hasPermission("mereessentials.nick_other"))
				{
					Player target = sender.getServer().getPlayer(args[0]);
					
					if(target == null)
					{
						sender.sendMessage(Utils.chat(plugin.getConfig().getString("player_not_found_message")));
						return true;
					}
					
					String nick = args[1];
					
					if((nick.charAt(0) != '"') || (nick.charAt(nick.length()-1) != '"'))
					{
						return false;
					}
					
					target.setDisplayName(nick.substring(1, nick.length()-1));
					sender.sendMessage(Utils.chat(plugin.getConfig().getString("NickCommand.success") + target.getDisplayName()));
					return true;
				}
				else
				{
					p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm_message")));
					return true;
				}
			}
			else if(args.length == 1)
			{
				String nick = args[0];
				
				if((nick.charAt(0) != '"') || (nick.charAt(nick.length()-1) != '"'))
				{
					return false;
				}
				
				p.setDisplayName(nick.substring(1, nick.length()-1));
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("NickCommand.success") + p.getDisplayName()));
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm_message")));
			return true;
		}
	}

}
