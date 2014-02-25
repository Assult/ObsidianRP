package obsidianrp.java.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import com.avaje.ebean.OrderBy.Property;

public class API {

	private Properties properties = new Properties();
	private File moneydata = new File("plugins/obsidianrp/moneydata.properties");

	// Set a players job
	
	public API(){
		if(!moneydata.exists()){
			try {
				moneydata.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	// public method
	public void setPlayersJob(Player p, Job job) {
		if(!(getPlayersJob(p) == null)){
				getPlayersJob(p).removePlayer(p);
		}
	
		
		setJob(p, job);
	}
	
	

	// private method that actually does the stuff
	// Just lookz prettierz
	private void setJob(Player p, Job job) {
		job.addPlayer(p);
	}

	// get a players salary
	public int getMoney(Player p) {

		
		//load the filereader for "moneydata.properties";
		try {
			if(!moneydata.exists()){
				moneydata.createNewFile();
			}
			FileReader reader = new FileReader(moneydata);
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		//parse string to an integer
		Integer money = Integer.parseInt(properties.getProperty(p.getName()));
		
		//return the parsed integer
		return money;
	}
	
	public void setMoney(Player p, int amount){
		try {
			FileInputStream writer = new FileInputStream(moneydata);
			properties.load(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {	
			String am = Integer.toString(amount);
			properties.setProperty(p.getName(), am);
			OutputStream out = new FileOutputStream( moneydata );
			properties.store(out, "MoneyData for ObsidianRP");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//get and return a job
	public Job getJob(String name) {
		ArrayList<Job> list = Plugin.getJobs();
		
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getName().equalsIgnoreCase(name)){
				return list.get(i);
			}
		}
		return null;
	}
	
	
	//get the default job, used for setting their job on join
	public Job getDefaultJob(){
		return getJob(Plugin.getJobsConf().getString("default-job"));
	}
	
	public Job getPlayersJob(Player p){
		Job returnjob = null;
		ArrayList<Job> list = Plugin.getJobs();
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).hasPlayer(p)){
				returnjob = list.get(i);
				break;
			}
		}
		return returnjob;
	}
	
	public int getStartMoney(){
		return Plugin.getDefaultConfig().getInt("start-money");
	}
	
	public int getTimeBetweenSalary(){
		return Plugin.getDefaultConfig().getInt("time-between-salary") * 20;
	}
	
	public File getMoneyData(){
		return moneydata;
	}
	
	public String checkForProperty(Player p){
		Properties properties = new Properties();
		try {
			FileReader reader = new FileReader(moneydata);
			try {
				properties.load(reader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(properties.getProperty(p.getName()) == null){
			return null;
		}else{
			return properties.getProperty(p.getName());
		}
		
	}
	
	
	

}