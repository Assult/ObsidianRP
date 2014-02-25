package obsidianrp.java.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class ReloadEvent implements Listener{
	
	@EventHandler
	public void onReload(ServerCommandEvent e){
		if(e.getCommand().equalsIgnoreCase("reload")){
			for(Player p : Bukkit.getOnlinePlayers()){
				p.kickPlayer("[RP] Plugin is reloading!");
			}
		}
	}
	
	@EventHandler
	public void onReloadPlayer(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equalsIgnoreCase("/reload") && e.getPlayer().isOp()){
			for(Player p : Bukkit.getOnlinePlayers()){
				p.kickPlayer("[RP] Plugin is reloading!");
			}
		}
	}

}
