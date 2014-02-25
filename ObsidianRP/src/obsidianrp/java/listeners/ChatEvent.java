package obsidianrp.java.listeners;

import obsidianrp.java.src.Plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener{

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		e.setFormat(Plugin.getAPI().getPlayersJob(p).getPrefix() + ChatColor.RESET + " <" + p.getName() + "> " + e.getMessage());
	}
	

}
