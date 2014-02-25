package obsidianrp.java.commands;

import obsidianrp.java.src.API;
import obsidianrp.java.src.Plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WalletCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
	
		API api = Plugin.getAPI();
		if(!(sender instanceof Player)){
			sender.sendMessage("You can't use this command!");
			return true;
		}
		
		Player player = (Player) sender;
		player.sendMessage("[RP] Wallet: " + api.getMoney(player) + ". Salary: " + api.getPlayersJob(player).getSalary() + "");

		return false;
	}
	
	

}
