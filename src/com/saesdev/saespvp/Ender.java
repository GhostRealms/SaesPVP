// Currently Doesn't Work! Working on fixing //

package com.saesdev.saespvp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Ender {
	ArrayList<String> kit = new ArrayList<String>();

	


	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
  if ((commandLabel.equalsIgnoreCase("ender")) && ((sender instanceof Player))) {
	  Player player = (Player)sender;
	  
 
    if (player.hasPermission("SaesPvP.Ender")) {
    	player.sendMessage(ChatColor.YELLOW + "You chose the " + ChatColor.BOLD + "Ender " + ChatColor.YELLOW + "kit");
    		this.kit.add(player.getName());
    		player.getInventory().clear();
player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
   		player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
    		player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
	player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
	player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GOLD_HOE) });
    	for (int i = 0; i < 34; i++) {
	       player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
    }
    	
 }


	
}
return true;
	}
}
