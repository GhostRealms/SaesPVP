package com.saesdev.saespvp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.entity.Fireball;


public class SaesPvP extends JavaPlugin implements Listener {
	
	ArrayList<String> kit = new ArrayList<String>();
	
	public void onEnable() {
System.out.println("[SaesPvP] Enabled");
getCommand("reset").setExecutor(new Reset());
getCommand("ninja").setExecutor(new Ninja());
getCommand("default").setExecutor(new Default());
getCommand("archer").setExecutor(new Archer());
getCommand("heavy").setExecutor(new Heavy());
getCommand("pyro").setExecutor(new Pyro());
getServer().getPluginManager().registerEvents(this, this);
	}
	public void onDisable() {
		System.out.println("[SaesPvP] Disabled");
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		this.kit.remove(event.getEntity().getName());
	}
	
	@EventHandler
	public void onPotionEffect(PlayerRespawnEvent event) {
	    Player player = event.getPlayer();
	    for (PotionEffect effect : player.getActivePotionEffects())
	      player.removePotionEffect(effect.getType()); 
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
	
	
	@EventHandler
	public void onInventory (InventoryClickEvent event) {
		if (event.getSlotType().equals(SlotType.ARMOR) && event.getInventory().getItem(event.getSlot()) != null) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void OnPlayerSoup(PlayerInteractEvent event) { 
		Player player = event.getPlayer();
    {
      int soup = 7;
      if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (player.getItemInHand().getType() == Material.MUSHROOM_SOUP)) {
        player.setHealth(player.getHealth() + soup > player.getMaxHealth() ? player.getMaxHealth() : player.getHealth() + soup);
        event.getPlayer().getItemInHand().setType(Material.BOWL);
      }
    } 
    }
	
	@EventHandler
	public void onFireball(PlayerInteractEvent event) {
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.FIREBALL)) {
			event.getPlayer().launchProjectile(Fireball.class);
			event.getPlayer().getInventory().remove(Material.FIREBALL);
		}
	}
	
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.DIAMOND_SWORD)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.WOOD_SWORD)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.DIAMOND_AXE)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.GOLD_SWORD)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.DIAMOND_SWORD)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.BOW)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.MUSHROOM_SOUP)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop full soup!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.BOWL)) {
			event.setCancelled(true);
			event.getPlayer().getInventory().remove(Material.BOWL);
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.ARROW)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.IRON_HELMET)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.IRON_CHESTPLATE)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.IRON_LEGGINGS)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
		if (event.getPlayer().getInventory().getItemInHand().equals(Material.ARROW)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You can't drop kit items!");
		}
	
		

	
	
	}
	
	
}