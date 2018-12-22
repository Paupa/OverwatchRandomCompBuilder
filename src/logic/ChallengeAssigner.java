package logic;

import java.util.*;

import model.Challenges;

public class ChallengeAssigner {
	
	public static List<String> assign(List<String> players) {
		
		Random r = new Random();
		
		Challenges[] challenges = Challenges.values();
		
		List<String> finalChallenges = new ArrayList<>();
		
		for(int i = 0; i < players.size(); i++) {
			
			if(r.nextBoolean()) {
				
				String player = players.get(i);
				
				Challenges challenge = challenges[r.nextInt(challenges.length)];
				finalChallenges.add(player + " → " + challenge.getTitle() + ": " + challenge.getDescription());
			}
		}
		
		return finalChallenges;
	}

}
