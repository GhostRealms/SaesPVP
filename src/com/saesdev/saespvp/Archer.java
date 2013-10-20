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

public class Archer implements CommandExecutor{
	
	ArrayList<String> kit = new ArrayList<String>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    if ((commandLabel.equalsIgnoreCase("archer")) && ((sender instanceof Player))) {
    Player player = (Player)sender;	
    
	      if (player.hasPermission("SaesPvP.Archer")) {
	        if (!this.kit.contains(player.getName())) {
	          ItemStack ABow = new ItemStack(Material.BOW);
	          ABow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
	          ItemStack Sword = new ItemStack(Material.WOOD_SWORD);
	          Sword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
	          player.sendMessage(ChatColor.YELLOW + "You have the " + ChatColor.BOLD + "Archer " + ChatColor.YELLOW + "kit!");
	          this.kit.add(player.getName());
	          player.getInventory().clear();
	          player.getInventory().addItem(new ItemStack[] { Sword });
	          player.getInventory().addItem(new ItemStack[] { ABow });
	          player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
	          player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
	          player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
	          player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
	          for (int i = 0; i < 33; i++) {
	            player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
	          }
	          player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW) });
	        }
	        else {
	          player.sendMessage(ChatColor.RED + "You have a kit!");
	        }
	      }
	      else player.sendMessage(ChatColor.RED + "Invalid Permission!");
	    }
	return true;

}
}
