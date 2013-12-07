package com.saesdev.saespvp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Default implements CommandExecutor {
	
	ArrayList<String> kit = new ArrayList<String>();

	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	    Player player = (Player)sender;
	    if ((commandLabel.equalsIgnoreCase("default")) && ((sender instanceof Player))) {
	      if (player.hasPermission("SaesPvP.kit.Default")) {
	        if (!SaesPvP.kit.contains(player.getName())) {
	          player.sendMessage(ChatColor.YELLOW + "You chose the " + ChatColor.BOLD + "Default " + ChatColor.YELLOW + "kit!");
	          SaesPvP.kit.add(player.getName());
	          player.getInventory().clear();
	          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.DIAMOND_SWORD) });
	          player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
	          player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
	          player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
	          player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
	          for (int i = 0; i < 35; i++)
	            player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
	        }
	        else {
	          player.sendMessage(ChatColor.RED + "You have already have a kit!");
	        }
	      }
	      else
	        player.sendMessage(ChatColor.RED + "Invalid Permissions!");
	    }
		return true;



	}
	

	
}
          


