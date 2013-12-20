package com.saesdev.saespvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.saesdev.saespvp.listeners.DropItem;
import com.saesdev.saespvp.listeners.Soup;

public class SaesPvP extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable(){
		System.out.println("Enabled");
		
		//Commands
		
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new Soup(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DropItem(), this);
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective kills = board.registerNewObjective("Kills", "playerKillCount");
		Objective deaths = board.registerNewObjective("Deaths", "deathCount");
		kills.setDisplaySlot(DisplaySlot.SIDEBAR);
		deaths.setDisplaySlot(DisplaySlot.SIDEBAR);
		kills.setDisplayName(ChatColor.AQUA + "Kills:");
		deaths.setDisplayName(ChatColor.AQUA + "Deaths:");
		
		  if (!this.getDataFolder().exists()) {
		      this.getDataFolder().mkdirs();
		     }
		  getConfig().options().copyDefaults(true);
		  saveConfig();
	}
	
	@Override
	public void onDisable() {
		System.out.println("Disabled");
	}

	@EventHandler
	public void onHunger(FoodLevelChangeEvent event) {
		event.setCancelled(getConfig().getBoolean("listeners.hunger-enabled"));
	}
	
	@EventHandler
	public void onHungerJoin(PlayerJoinEvent event) {
		event.getPlayer().setFoodLevel(getConfig().getInt("listeners.hunger-level"));
	}
	
	@EventHandler
	public void onJoinMessage(PlayerJoinEvent event) {
		if (getConfig().getBoolean("listeners.join-message") == false) {
			event.setJoinMessage(null);
		}
	}
	
	@EventHandler
	public void onDeathMessage(PlayerDeathEvent event) {
		if (getConfig().getBoolean("listeners.death-message") == false) {
			event.setDeathMessage(null);
		}
		
	}
	
	@EventHandler
	public void onQuitMessage(PlayerQuitEvent event) {
		if (getConfig().getBoolean("listeners.quit-message") == false) {
			event.setQuitMessage(null);
		}
	}
	

	
}
