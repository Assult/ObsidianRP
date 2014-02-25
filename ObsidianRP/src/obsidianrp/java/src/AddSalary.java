package obsidianrp.java.src;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AddSalary implements Runnable {

	@Override
	public void run() {
		API api = Plugin.getAPI();
		for(Player p : Bukkit.getOnlinePlayers()){
			api.setMoney(p, api.getMoney(p) + api.getPlayersJob(p).getSalary());
			p.sendMessage("[RP] " + api.getPlayersJob(p).getSalary() + "$ has been added to your wallet!");
		}

	}

}
