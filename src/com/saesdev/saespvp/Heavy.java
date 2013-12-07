package com.saesdev.saespvp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Heavy implements CommandExecutor {
	
	ArrayList<String> kit = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    if ((commandLabel.equalsIgnoreCase("heavy")) && ((sender instanceof Player))) {
    	Player player = (Player)sender;
    
	      if (player.hasPermission("SaesPvP.kit.Heavy")) {
	    	  
	    	
	      
	        if (!this.kit.contains(player.getName())) {
	        	
	          player.sendMessage(ChatColor.YELLOW + "You chose the " + ChatColor.BOLD + "Heavy " + ChatColor.YELLOW + "kit");
	          this.kit.add(player.getName());
	          player.getInventory().clear();
	          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.DIAMOND_AXE) });
	          player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
	          player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
	          player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
	          player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
	            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2147483647, 1));
	            for (int i = 0; i < 35; i++) {
		            player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
	            }
	          }
	        }
	        else {
	          player.sendMessage(ChatColor.RED + "You already have a kit!");
	        }
	      }
	      else {
	    	  Player player = (Player)sender;
	    	  player.sendMessage(ChatColor.RED + "Invalid Permission!");
	    }
	return true;

	
}
	
	

}




