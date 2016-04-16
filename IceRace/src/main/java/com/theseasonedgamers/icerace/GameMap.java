package com.theseasonedgamers.icerace;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;

public class GameMap {
	
	private static boolean isBuilt;
	
	public GameMap() {
		isBuilt = false;
	}
	
	@SuppressWarnings("deprecation")
	
	public static boolean build() {
		Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN +"The game map is being built!");
		List<World> worlds = Bukkit.getWorlds();
		IceRace.getGc().resetBarriers();
		isBuilt = true;
		return isBuilt;		 
		
		
		
		
		/*if(b.getLocation().getBlock().getTypeId() == 0) { //just tests if the block has been changed
			return true;
		} else {
			return false;
		}*/
	}

}