package com.theseasonedgamers.icerace;

import java.util.TimerTask;
import java.util.List;
import java.util.Timer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameController {
	private boolean isRunning = false;
	private int numPlayers; //slots for players
	private int numPlayersIn; //players in the game
	private Player[] playerList; //list of the players in the game
	
	public GameController() {
		numPlayers = 0;
		playerList = new Player[numPlayers]; //makes the array with number of players
	}
	
	public void newGame(int players) {
		
		this.numPlayers = players;
		Boolean b = GameMap.build();
		
		if(b == true) {
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN +"The game was successfully built.");
			
		} else {
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED +"The game map build failed!");

		}
		
	}
	
	public void dropBarriers() { //drops the barriers on the map to allow the players to go
		
	}
	
	public void countdown() {
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 10;
            @Override
            public void run() {
            	Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN +"Go in " + i--);
                if (i< 0)
                	Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN +"GO!");
                    timer.cancel();
            }
        }, 0, 1000);
    }
	
	
	public void startRace() { //ran to start the race
		countdown();
		dropBarriers();
	}
	
	public void playerJoinGame(CommandSender sender) {
		Player player = (Player) sender;//converts sender to player
		
		int openArray = 0;

		for(int i = 0; i<playerList.length; i++) { //finds the next empty place in the list
		    if(playerList[i] == null)
		    {
		        openArray = i;
		        break;
		    }
		}
		
		Bukkit.getServer().broadcastMessage(ChatColor.AQUA +"" + sender + " has been added to the game! " + playersLeft() + " slots left!");
		
		
		playerList[openArray] = player; //adds player to array
		//test
		
		List<World> worlds = Bukkit.getWorlds(); //gets the world list
		World w = worlds.get(0); //gets the world 
		Location location = new Location(w, 2, 2, 2); //sets the location (change accordingly)
		player.teleport(location); //Teleport the player to the start or lobby
		
		
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public int getPlayerSlots() {
		return numPlayers;
	}
	
	public int getPlayersIn() {
		return numPlayersIn;
	}

	public CommandSender[] getPlayerList() {
		return playerList;
	}
	
	public int playersLeft() {
		return numPlayers - numPlayersIn;
	}
	
}
