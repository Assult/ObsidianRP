package obsidianrp.java.commands;

import obsidianrp.java.src.Plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class VotesCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		
		if(args.length == 1){
			
			
			if(!(Plugin.getVoteManager().getVoteByPlayer(args[0]) == null)){
				if(args[0].equalsIgnoreCase(sender.getName())){
					
					sender.sendMessage("[RP] You can't vote for yourself!");
				}else{
					Plugin.getVoteManager().getVoteByPlayer(args[0]).addVote();
					sender.sendMessage("[RP] Thanks for voting for " + args[0]);
				}
			}
			
				
		}else{
			sender.sendMessage("[RP] Usage: /vote <player>");
		}
		
		return false;
	}

}
