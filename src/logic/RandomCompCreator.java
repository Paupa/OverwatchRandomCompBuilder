package logic;

import java.util.*;

import com.google.common.collect.Multimap;

import model.*;

public class RandomCompCreator {
	
	public static List<String> create() {
		return create(6);
	}
	
	public static List<String> create(int numberOfPlayers) {

		return create(numberOfPlayers, getAllHeroes());
	}
	
	public static List<String> create(String[] players) {
		
		List<String> playersNames = Utilities.arrayToList(players);
		
		List<String> heroes = create(playersNames.size());
		
		Utilities.shuffleList(playersNames);
		
		for(int i = 0; i < players.length; i++) {
			
			String playerName = playersNames.get(i);
			
			playerName += " → " + heroes.get(i);
			playersNames.set(i, playerName);
		}
		
		return playersNames;
	}
	
	public static List<String> create(Map<HeroRole, Integer> build) {
		
		List<String> comp = new ArrayList<>();
		
		Iterator<HeroRole> buildIterator = build.keySet().iterator();
		while (buildIterator.hasNext()) {
			
			HeroRole role = buildIterator.next();
			comp.addAll(create(build.get(role), getEligibleHeroes(role)));
		}
		
		return comp;
	}
	
	public static List<String> create(Multimap<HeroRole, String> build) {
		
		List<String> comp = new ArrayList<>();
		
		Iterator<HeroRole> buildIterator = build.keySet().iterator();
		while (buildIterator.hasNext()) {
			
			HeroRole role = buildIterator.next();
			
			Collection<String> players = build.get(role);
			
			List<String> heroes = create(players.size(), getEligibleHeroes(role));
			
			Iterator<String> playersIterator = players.iterator();
			
			for (int i = 0; i < heroes.size(); i++) {
				
				String heroe = heroes.get(i);
				
				String player = playersIterator.next();
				
				comp.add(player + " → " + heroe);
			}
		}
		
		return comp;
	}
	
	public static List<String> create(int numberOfPlayers, List<Heroes> eligibleHeroes) {
		checkIfNumberOfPlayersIsValid(numberOfPlayers, eligibleHeroes.size());
		
		Random r = new Random();
		
		List<String> comp = new ArrayList<>();
		
		for(int i = 0; i < numberOfPlayers; i++) {
			int index = r.nextInt(eligibleHeroes.size());
			
			comp.add(eligibleHeroes.get(index).toString());
			
			eligibleHeroes.remove(index);
		}
		
		return comp;
	}
	
	private static List<Heroes> getAllHeroes() {
		Heroes[] heroes = Heroes.values();
		
		List<Heroes> allHeroes = new ArrayList<>();
		
		for(int i = 0; i < heroes.length; i++) {
			allHeroes.add(heroes[i]);
		}
		
		return allHeroes;
	}
	
	private static List<Heroes> getEligibleHeroes(HeroRole role) {
		
		Heroes[] heroes = Heroes.values();
		
		List<Heroes> eligibleHeroes = new ArrayList<>();
		
		for(int i = 0; i < heroes.length; i++) {
			
			Heroes hero = heroes[i];
			
			if(hero.getRoles().contains(role))
				eligibleHeroes.add(hero);
			
		}
		
		return eligibleHeroes;
	}

	private static void checkIfNumberOfPlayersIsValid(int numberOfPlayers, int numberOfEligibleHeroes) {
		if(numberOfPlayers < 1)
			throw new IllegalArgumentException("The number of players needs to be at least one.");
		
		if(numberOfPlayers > numberOfEligibleHeroes)
			throw new IllegalArgumentException("The build is impossible to make");
	}

}
