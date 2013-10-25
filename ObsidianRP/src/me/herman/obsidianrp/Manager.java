package me.herman.obsidianrp;

import java.io.IOException;

import org.bukkit.entity.Player;

public class Manager {

	public static Main plugin;

	public Manager(Main plugin) {
		Manager.plugin = plugin;

	}

	public Manager() {

	}

	public static int getCash(Player p) {
		String name = p.getName();

		return plugin.userData.getInt(name + ".cash");
	};

	public static void setCash(Player p, int amount) {
		String name = p.getName();
		plugin.userData.set(name + ".cash", amount);

	}



	public void setJob(Player p, String job) {
		
	}
}
