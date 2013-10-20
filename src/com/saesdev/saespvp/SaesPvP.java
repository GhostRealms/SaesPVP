package com.saesdev.saespvp;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SaesPvP extends JavaPlugin implements Listener {
	
	ArrayList<String> kits = new ArrayList<String>();
	
	public void onEnable() {
System.out.println("[SaesPvP] Enabled");

Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	public void onDisable() {
		System.out.println("[SaesPvP] Disabled");
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		this.kits.remove(event.getEntity().getName());
	}
	
	@EventHandler
	public void onPotionEffect(PlayerRespawnEvent event) {
	    Player player = event.getPlayer();
	    for (PotionEffect effect : player.getActivePotionEffects())
	      player.removePotionEffect(effect.getType()); 
	}
	
	@EventHandler
	public void onPlayerSoup(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		int soup = 7;
		if(((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (player.getItemInHand().getType() == Material.MUSHROOM_SOUP)) {
			player.setHealth(player.getHealth() + soup > player.getMaxHealth() ? player.getMaxHealth() : player.getHealth() + soup);
	        event.getPlayer().getItemInHand().setType(Material.BOWL);
		}
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	
	// @EventHandler
	//public void onPlayerInteract(PlayerInteractEvent event) {
		//Player player = event.getPlayer();
		//
		//player.teleport(player.getTargetBlock(null, 30).getLocation().add(0, 1, 0));
        //player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 10);
		
		//}
	
	@EventHandler
    public void DefaultSign(PlayerInteractEvent e){
        Sign sign = (Sign) e.getClickedBlock().getState();
        Player player = e.getPlayer();
      if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
          if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN){
              if(sign.getLine(0).equalsIgnoreCase("[Default]")){
            	  player.getPlayer().getServer().dispatchCommand(player, "default");
              }
          }
      }
              
      }
	
	@EventHandler
    public void NinjaSign(PlayerInteractEvent e){
        Sign sign = (Sign) e.getClickedBlock().getState();
        Player player = e.getPlayer();
      if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
          if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN){
              if(sign.getLine(0).equalsIgnoreCase("[Ninja]")){
            	  player.getPlayer().getServer().dispatchCommand(player, "ninja");
              }
          }
      }
              
      }
	
	@EventHandler
    public void ArcherSign(PlayerInteractEvent e){
        Sign sign = (Sign) e.getClickedBlock().getState();
        Player player = e.getPlayer();
      if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
          if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN){
              if(sign.getLine(0).equalsIgnoreCase("[Archer]")){
            	  player.getPlayer().getServer().dispatchCommand(player, "archer");
              }
          }
      }
              
      }

		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		    Player player = (Player)sender;
		    if ((commandLabel.equalsIgnoreCase("default")) && ((sender instanceof Player))) {
		      if (player.hasPermission("SaesPvP.Default")) {
		        if (!this.kits.contains(player.getName())) {
		          player.sendMessage(ChatColor.YELLOW + "You chose the " + ChatColor.BOLD + "Default " + ChatColor.YELLOW + "kit!");
		          this.kits.add(player.getName());
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
		    else if ((commandLabel.equalsIgnoreCase("archer")) && ((sender instanceof Player))) {
		      if (player.hasPermission("SaesPvP.Archer")) {
		        if (!this.kits.contains(player.getName())) {
		          ItemStack ABow = new ItemStack(Material.BOW);
		          ABow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		          ItemStack Sword = new ItemStack(Material.WOOD_SWORD);
		          Sword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
		          player.sendMessage(ChatColor.YELLOW + "You have the " + ChatColor.BOLD + "Archer " + ChatColor.YELLOW + "kit!");
		          this.kits.add(player.getName());
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
		    else if ((commandLabel.equalsIgnoreCase("ninja")) && ((sender instanceof Player))) {
		      if (player.hasPermission("SaesPvP.Ninja")) {
		        if (!this.kits.contains(player.getName())) {
		        	
		          player.sendMessage(ChatColor.YELLOW + "You chose the " + ChatColor.BOLD + "Ninja " + ChatColor.YELLOW + "kit");
		          this.kits.add(player.getName());
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
		  //  else if ((commandLabel.equalsIgnoreCase("ender")) && ((sender instanceof Player))) {
		    //	if (player.hasPermission("SaesPvP.Ender")) {
		    	//	player.sendMessage(ChatColor.YELLOW + "You chose the " + ChatColor.BOLD + "Ender " + ChatColor.YELLOW + "kit");
		    		//this.kits.add(player.getName());
		    		//player.getInventory().clear();
//		    		player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
	//	    		player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		//    		player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		  //  		player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
		    //		player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
		    	//	player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GOLD_HOE) });
		    		//for (int i = 0; i < 34; i++) {
			          //  player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
		    	//}
		    	
		   // }
		    	else if (commandLabel.equalsIgnoreCase("reset"))
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
		              }
		              else if (args.length == 1) {
		            	  Player target = Bukkit.getServer().getPlayer(args[0]);
			               target.sendMessage(ChatColor.RED + "A staff member removed your kit.");
			               target.getInventory().setHelmet(null);
				    		target.getInventory().setChestplate(null);
				    		target.getInventory().setLeggings(null);
				    		target.getInventory().setBoots(null);
				    		target.getInventory().clear();
				    	    for (PotionEffect effect : target.getActivePotionEffects())
				    	        target.removePotionEffect(effect.getType());
		                } else {
		                  player.sendMessage(ChatColor.RED + "This person has not chosen a kit!");
		                } 

		            }
		   // }
			return true;
		}
}
