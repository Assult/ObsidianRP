package obsidianrp.java.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VoteManager {
	
	private static ArrayList<Vote> votes = new ArrayList<Vote>();
	
	public static ArrayList<Vote> getVotes(){
		return votes;
	}
	
	public Vote getVoteByPlayer(String name){
		for(int i = 0; i < votes.size(); i++){
			if(votes.get(i).getPlayer().equalsIgnoreCase(name)){
				return votes.get(i);
			}
		}
		return null;
	}
	
	public void startVote(Vote vote){
		votes.add(vote);
		vote.execute();
	}

}
