package com.saesdev.saespvp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Ninja implements CommandExecutor {
	ArrayList<String> kit = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    if ((commandLabel.equalsIgnoreCase("ninja")) && ((sender instanceof Player))) {
    	Player player = (Player)sender;
    
	      if (player.hasPermission("SaesPvP.kit.Ninja")) {
	    	  
	    	  
	      
	        if (!SaesPvP.kit.contains(player.getName())) {
	        	
	          player.sendMessage(ChatColor.YELLOW + "You chose the " + ChatColor.BOLD + "Ninja " + ChatColor.YELLOW + "kit");
	          SaesPvP.kit.add(player.getName());
	          player.getInventory().clear();
	          ItemStack NSword = new ItemStack(Material.GOLD_SWORD);
	          NSword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
	          player.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
	          player.getInventory().addItem(new ItemStack[] { NSword });
	          for (int i = 0; i < 35; i++) {
	            player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
	            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2147483647, 2));
	            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 214748367, 2));
	          }
	        }
	        else {
	          player.sendMessage(ChatColor.RED + "You already have a kit!");
	        }
	      }
	      else player.sendMessage(ChatColor.RED + "Invalid Permission!");
	    }
	return true;

	
}
	

}
