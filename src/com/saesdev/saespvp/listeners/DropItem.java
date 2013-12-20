package com.saesdev.saespvp.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItem implements Listener{
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event) {
		event.setCancelled(true);
		event.getPlayer().sendMessage(ChatColor.RED + "You can't drop items!");
		if (event.getItemDrop().equals(Material.BOWL)) {
			event.setCancelled(true);
			event.getPlayer().getInventory().remove(Material.BOWL);
		}
	}

}
