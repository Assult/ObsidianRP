package obsidianrp.java.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class EventManager {

		
		
	public EventManager(Plugin plugin) {
		startSalaryTimer(plugin);
	
	}
	
	

	private void startSalaryTimer(Plugin plugin){
		
		API api = Plugin.getAPI();
	    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	     
	     scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {
				
				new AddSalary().run();
			}
	            
	        },0L, api.getTimeBetweenSalary());
	}
	
	
}

