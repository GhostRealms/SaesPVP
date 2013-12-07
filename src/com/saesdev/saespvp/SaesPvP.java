package com.saesdev.saespvp;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import com.saesdev.saespvp.Archer;
import com.saesdev.saespvp.Default;
import com.saesdev.saespvp.Heavy;
import com.saesdev.saespvp.Ninja;
import com.saesdev.saespvp.Pyro;
import com.saesdev.saespvp.Reset;



public class SaesPvP extends JavaPlugin implements Listener {
	
	static ArrayList<String> kit = new ArrayList<String>();
	
	public void onEnable() {
		System.out.println("[SaesPvP] Enabled");
		this.saveDefaultConfig();
		getCommand("reset").setExecutor(new Reset());
		getCommand("ninja").setExecutor(new Ninja());
		getCommand("default").setExecutor(new Default());
		getCommand("archer").setExecutor(new Archer());
		getCommand("heavy").setExecutor(new Heavy());
		getCommand("pyro").setExecutor(new Pyro());
		getCommand("kit").setExecutor(new kit(this));

		getServer().getPluginManager().registerEvents(this, this);
		CustomKits ckits = new CustomKits(this);
		
	}

	public void onDisable() {
		System.out.println("[SaesPvP] Disabled");
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		SaesPvP.kit.remove(event.getEntity().getName());
	}
	
	@EventHandler
	public void onPotionEffect(PlayerRespawnEvent event) {
	    Player player = event.getPlayer();
	    for (PotionEffect effect : player.getActivePotionEffects())
	      player.removePotionEffect(effect.getType()); 
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		event.getPlayer().setFoodLevel(20);
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent event) {
		event.setCancelled(true);
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
    
      int soup = 7;
      if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getItemInHand().getType() == Material.MUSHROOM_SOUP) {
        player.setHealth(player.getHealth() + soup > player.getMaxHealth() ? player.getMaxHealth() : player.getHealth() + soup);
        event.getPlayer().getItemInHand().setType(Material.BOWL);
      }
    } 
    
	
	
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		event.setCancelled(true);
		event.getPlayer().sendMessage(ChatColor.RED + "You cant drop kit items!");

		}
	
	
		
		
		
		
	}
