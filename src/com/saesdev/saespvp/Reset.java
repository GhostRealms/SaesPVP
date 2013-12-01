package com.saesdev.saespvp;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class Reset implements CommandExecutor {

	ArrayList<String> kit = new ArrayList<String>();

	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	Player player = (Player)sender;
		if (commandLabel.equalsIgnoreCase("reset"))
        if (player.hasPermission("SaesPvP.Staff")) {
        
          if (args.length == 0) {
           player.sendMessage(ChatColor.RED + "Clearing your inventory. To clear someone elses inventory, do /reset <Player>");
           player.getInventory().setHelmet(null);
    		player.getInventory().setChestplate(null);
    		player.getInventory().setLeggings(null);
    		player.getInventory().setBoots(null);
    		player.getInventory().clear();
    	    for (PotionEffect effect : player.getActivePotionEffects())
    	        player.removePotionEffect(effect.getType());
    	    SaesPvP.kit.remove(player.getName());
          }
          else if (args.length == 1) {
        	  Player target = Bukkit.getServer().getPlayer(args[0]);
               target.sendMessage(ChatColor.RED + "A staff member removed your kit.");
               target.getInventory().setHelmet(null);
	    		target.getInventory().setChestplate(null);
	    		target.getInventory().setLeggings(null);
	    		target.getInventory().setBoots(null);
	    		target.getInventory().clear();
	    		SaesPvP.kit.remove(player.getName());
	    	    for (PotionEffect effect : target.getActivePotionEffects())
	    	        target.removePotionEffect(effect.getType());
            } else {
              player.sendMessage(ChatColor.RED + "This person has not chosen a kit!");
            } 
        }
		return true;
	}
}
