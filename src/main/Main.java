package main;

import java.util.*;

import model.Heroes;

public class Main {

	public static void main(String[] args) {
		
		Heroes[] comp = createRandomComp();
		
		for(int i = 0; i < comp.length; i++) {
			System.out.println(comp[i]);
		}
		
		System.out.println("------------------");
		
		String[] playerNames = {"Agra", "Shyro", "Tsuki"};
		
		String[] playerComp = createRandomCompFor(playerNames);
		
		for(int i = 0; i < playerComp .length; i++) {
			System.out.println(playerComp [i]);
		}

	}
	
	private static String[] createRandomCompFor(String[] players) {
		
		String[] playersNames = players.clone();
		
		Heroes[] heroes = createRandomComp(playersNames.length);
		
		//TODO Shuffle the players
		
		for(int i = 0; i < players.length; i++) {
			playersNames[i] += " → " + heroes[i];
		}
		
		return playersNames;
	}
	
	private static Heroes[] createRandomComp() {
		return createRandomComp(6);
	}
	
	private static Heroes[] createRandomComp(int numberOfPlayers) {
		
		checkIfNumberOfPlayersIsValid(numberOfPlayers);
		
		Heroes[] h = Heroes.values();
		List<Heroes> heroes = new ArrayList<>();
		
		for(int i = 0; i < h.length; i++) {
			heroes.add(h[i]);
		}
		
		Random r = new Random();
		
		Heroes[] comp = new Heroes[numberOfPlayers];
		
		for(int i = 0; i < numberOfPlayers; i++) {
			int index = r.nextInt(heroes.size());
			
			comp[i] = heroes.get(index);
			
			heroes.remove(index);
		}
		
		return comp;
	}
	
	private static void checkIfNumberOfPlayersIsValid(int numberOfPlayers) {
		if(numberOfPlayers < 1)
			throw new IllegalArgumentException("The number of players needs to be at least one.");
		
		if(numberOfPlayers > 12)
			throw new IllegalArgumentException("The number of players needs to be twelve at maximum.");
	}

}
