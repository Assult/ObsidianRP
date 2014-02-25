package obsidianrp.java.src;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitScheduler;

public class Vote {
	
	private Job job;
	private Plugin plugin;
	private int votes = 0;
	private String player;
	
	public Vote(Plugin plugin, Job job, String player){
		this.job = job;
		this.plugin = plugin;
		this.player = player;
	}
	
	
	public String getPlayer(){
		return player;
	}
	
	public void addVote(){
		votes++;
	}
	
	public void execute(){
		BukkitScheduler scheduler = Bukkit.getScheduler();
		
		Bukkit.broadcastMessage("[RP] " + ChatColor.RED + player + ChatColor.RESET + " wants to become a(n) " + job.getName() + ". Type /vote '" + player + "' to vote for him!");
		
		scheduler.scheduleSyncDelayedTask(plugin, new Runnable(){
			
	
			
			
			@Override
			public void run() {
				VoteManager.getVotes().remove(this);
				
				if(votes >= Plugin.getJobsConf().getInt(job.getName() + ".votes-needed")){
					Plugin.getAPI().setPlayersJob(Bukkit.getPlayer(player), job);
					Bukkit.getPlayer(player).sendMessage("[RP] You are now a(n) " + job.getName());
				}else{
					Bukkit.getPlayer(player).sendMessage("[RP] You didn't get enough votes to become a(n) " + job.getName());
				}
				
			}
			
			}, 1200L);
			
		
	}
	
	

}
