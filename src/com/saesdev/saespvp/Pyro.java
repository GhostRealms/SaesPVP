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

public class Pyro implements CommandExecutor {
	
	ArrayList<String> kit = new ArrayList<String>();
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	    if ((commandLabel.equalsIgnoreCase("pyro")) && ((sender instanceof Player))) {
	    	Player player = (Player)sender;
	    
		      if (player.hasPermission("SaesPvP.Pyro")) {
		    	  
		    	  
		      
		        if (!SaesPvP.kit.contains(player.getName())) {
		        	
		          player.sendMessage(ChatColor.YELLOW + "You chose the " + ChatColor.BOLD + "Pyro " + ChatColor.YELLOW + "kit");
		          SaesPvP.kit.add(player.getName());
		          player.getInventory().clear();
		          ItemStack PBow = new ItemStack(Material.BOW);
		          PBow.addEnchantment(Enchantment.ARROW_FIRE, 1);
		          PBow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		          player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		          player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
		          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.WOOD_SWORD) });
		          player.getInventory().addItem(new ItemStack[] { PBow });
		          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW) });
		          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FLINT_AND_STEEL) });
		          for (int i = 0; i < 32; i++) {
		            player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
		            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2147483647, 1));
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
