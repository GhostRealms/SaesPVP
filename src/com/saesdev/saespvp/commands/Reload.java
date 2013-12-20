package com.saesdev.saespvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.saesdev.saespvp.SaesPvP;

public class Reload {
	
	public SaesPvP plugin;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("saespvp")) {
        	if (args[0].equalsIgnoreCase("reload")) {
        		plugin.reloadConfig();
        	}
        }
		return true;
	}
}
