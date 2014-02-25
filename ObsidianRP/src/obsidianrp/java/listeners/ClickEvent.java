package obsidianrp.java.listeners;

import obsidianrp.java.src.Plugin;
import obsidianrp.java.src.Vote;
import obsidianrp.java.src.VoteManager;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent implements Listener {

	private Plugin plugin;

	public ClickEvent(Plugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {

	int cooldownTime = 60;
	
	
	if(e.getInventory().getTitle().equalsIgnoreCase("Jobs GUI")){
		try{
			ItemStack stack = e.getCurrentItem();
			String itemname = stack.getItemMeta().getDisplayName();
		
		
		
		if (!(itemname == null && Plugin.getAPI().getJob(itemname) == null)) {
			
			if (Plugin.getAPI().getJob(itemname).requiresVote()) {
				if(Plugin.getCooldownMap().containsKey(e.getWhoClicked().getName())){
					 long secondsLeft = ((Plugin.getCooldownMap().get(e.getWhoClicked().getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
					 if(secondsLeft>0) {
			            
			              ((CommandSender) e.getWhoClicked()).sendMessage("[RP] You need to wait " + secondsLeft + " seconds before you can start a new vote");
			             return;
			         }
				}
				Plugin.getVoteManager().startVote(new Vote(plugin, Plugin.getAPI().getJob(itemname), e.getWhoClicked().getName()));
				Plugin.getCooldownMap().put(e.getWhoClicked().getName(), System.currentTimeMillis());
			} else {
				Plugin.getAPI().setPlayersJob(Bukkit.getPlayer(e.getWhoClicked().getName()), Plugin.getAPI().getJob(itemname));
				Bukkit.getPlayer(e.getWhoClicked().getName()).sendMessage("[RP] You are now a " + itemname);
			}
		}
	
		

			e.setCancelled(true);
			}catch(Exception exception){
			
			}
		}
	}
}