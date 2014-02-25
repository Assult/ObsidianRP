package obsidianrp.java.src;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Job {
	
	private String name;
	private int salary;
	private String prefix;
	private String rawprefix;
	private ArrayList<String> players = new ArrayList<String>();
	private FileConfiguration conf = Plugin.getJobsConf();

	public Job(String name) {
		this.name = name;
		prefix = conf.getString(name + ".prefix");
		rawprefix = ChatColor.stripColor(prefix);
		salary = conf.getInt(name + ".salary");
		
	}

	
	//get the job's salary
	public int getSalary() {
		return salary;
	}

	
	//add a player to this job
	public void addPlayer(Player p){
		players.add(p.getName());
	}
	
	//remove a player
	public void removePlayer(Player p){
		players.remove(p.getName());
	}
	
	
	//check if the job object contains a player
	public boolean hasPlayer(Player p){
		if(players.contains(p.getName())){
			return true;
		}else{
			return false;
		}
	}
	
	//get the jobs prefix with colorcodes and formatting
	public String getPrefix() {
		return prefix;
	}

	
	//get the jobs prefix as a raw string
	public String getRawPrefix() {
		return rawprefix;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean requiresVote(){
		if(Plugin.getJobsConf().getBoolean(name + ".requires-vote")){
			return true;
		}else{
			return false;
		}
	}

}
