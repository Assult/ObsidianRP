package obsidianrp.java.listeners;

import obsidianrp.java.src.API;
import obsidianrp.java.src.Plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
			Player p = e.getPlayer();
		
			
			try{
			API api = Plugin.getAPI();
		
			api.setPlayersJob(p, api.getDefaultJob());
			if(api.checkForProperty(p) == null){
				api.setMoney(p, api.getStartMoney());
			}else{
				
			}
			}catch(Exception exception){
				
			}
			
	}

}
