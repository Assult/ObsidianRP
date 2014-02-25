package obsidianrp.java.commands;

import java.util.Random;

import obsidianrp.java.src.Plugin;
import obsidianrp.java.src.VoteManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JobCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
		if(!(sender instanceof Player)){
			return true;
		}
		
		Player player = (Player) sender;
		
		
		
		Inventory inv = Bukkit.createInventory(null, 9 * 4 , "Jobs GUI");
		
		for(int i = 0; i < Plugin.getJobs().size(); i++){
			ItemStack itemstack = new ItemStack(Material.WOOL, 1, (short) new Random().nextInt(16));
			ItemMeta meta = itemstack.getItemMeta();
			meta.setDisplayName(Plugin.getJobs().get(i).getName().toUpperCase());
			itemstack.setItemMeta(meta);
			inv.setItem(i, itemstack);
		}
		
		
		
		
		
		player.openInventory(inv);
		
		return false;
	}

}
