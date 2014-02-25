package obsidianrp.java.src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import obsidianrp.java.commands.JobCommand;
import obsidianrp.java.commands.VotesCommand;
import obsidianrp.java.commands.WalletCommand;
import obsidianrp.java.listeners.ChatEvent;
import obsidianrp.java.listeners.ClickEvent;
import obsidianrp.java.listeners.JoinEvent;
import obsidianrp.java.listeners.ReloadEvent;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

	private static EventManager eventmanager;
	private static ArrayList<Job> jobs = new ArrayList<Job>();
	private static API api;
	private static File jobsfile = new File("plugins/obsidianrp/jobs.yml");
	private static FileConfiguration jobsConf;
	private static FileConfiguration conf;
	private static File confFile = new File("plugins/obsidianrp/config.yml");
	private static VoteManager votemanager = new VoteManager();

    private static HashMap<String, Long> cooldowns = new HashMap<String, Long>();

	public void onEnable() {
		
		
		
		//load the config configurations;
		loadConfigurations();
		
		//Call the registration methods when plugin gets enabled
		
		registerJobs();
		registerCommands();
		
			
		
		api = new API();
		
		
		eventmanager = new EventManager(this);
		registerEvents();
	}

	public void onDisable() {

	}

	private void loadConfigurations(){
		
		createConfigs();
		
		conf = YamlConfiguration.loadConfiguration(confFile);
		jobsConf = YamlConfiguration.loadConfiguration(jobsfile);
		
	}
	
	private void createConfigs(){
		if(!jobsfile.exists()){
			this.saveResource("jobs.yml", false);
		}
		
		saveDefaultConfig();
	}
	
	
	private void registerCommands(){
		getCommand("wallet").setExecutor(new WalletCommand());
		getCommand("job").setExecutor(new JobCommand());
		getCommand("vote").setExecutor(new VotesCommand());
	}
	
	private void registerEvents() {
		
		//get the plugin manager
		PluginManager pm = Bukkit.getPluginManager();

		// register the events
		pm.registerEvents(new JoinEvent(), this);
		pm.registerEvents(new ChatEvent(), this);
		pm.registerEvents(new ClickEvent(this), this);
		pm.registerEvents(new ReloadEvent(), this);
	}

	// register a job
	
	private void registerJobs(){
		List<String> list =getJobsConf().getStringList("enabled-jobs");
		for(String job : list){
			registerJob(job);
		}
	
	}
	
	private void registerJob(String name) {
		Job job = new Job(name);
		getJobs().add(job);
	}

	// Get shit instead of creating a new instance.
	public static EventManager getEventManager() {
		return eventmanager;
	}

	public static ArrayList<Job> getJobs() {
		return jobs;
	}

	public static API getAPI() {
		return api;
	}

	public static FileConfiguration getJobsConf() {
		return jobsConf;
	}
	
	public static FileConfiguration getDefaultConfig(){
		return conf;
	}
	
	public static VoteManager getVoteManager(){
		return votemanager;
	}
	
	public static HashMap<String, Long> getCooldownMap(){
		return cooldowns;
	}
	
	


}
