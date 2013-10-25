package me.herman.obsidianrp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public Main plugin;
	File jobs;
	FileConfiguration jobsFile;
	FileConfiguration userData;
	File userFile;

	public Manager manager = new Manager();

	
	
	public void onEnable() {
		saveDefaultConfig();
		
	}

	public void onDisable() {

	}

	
	public void saveDefaultConfig() {
        if (!jobs.exists()) {
           saveResource(jobs.getName(), false);
        }
    }
	
	public void saveJobs() {
		try {
			jobsFile.save(jobs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public void saveUserData() {
		try {
			userData.save(userFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	
    	if(cmd.getName().equalsIgnoreCase("rp")){ 
    		if(!(sender instanceof Player)){
    			sender.sendMessage("This command only works as a player!");
    		}else{
    			sender.sendMessage("holoyolo!");
    		}
    	} 
    	return false; 
    }



}
