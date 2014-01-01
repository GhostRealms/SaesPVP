package com.saesdev.saespvp.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Soup implements Listener{
	
	@EventHandler
	public void onSoup(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getPlayer().getInventory().getItemInHand().getType() == Material.MUSHROOM_SOUP) {
				Player player = event.getPlayer();
				int soup = 7;
				player.setHealth(player.getHealth() + soup > player.getMaxHealth() ? player.getMaxHealth() : player.getHealth() + soup);
				event.getPlayer().getInventory().getItemInHand().setType(Material.BOWL);
			} else {
				return;
			}
		}
	}

}
