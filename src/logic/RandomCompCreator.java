package logic;

import java.util.*;

import model.*;

public class RandomCompCreator {
	
	public static List<String> create() {
		return create(6);
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
	
	public static List<String> create(int numberOfPlayers) {

		return create(numberOfPlayers, getAllHeroes());
	}
	
	public static List<String> createByHeroSubclass(Map<HeroSubclass, Integer> build) {
		
		List<String> comp = new ArrayList<>();
		
		Iterator<HeroSubclass> buildIterator = build.keySet().iterator();
		while (buildIterator.hasNext()) {
			
			HeroSubclass hSubclass = buildIterator.next();
			comp.addAll(create(build.get(hSubclass), getEligibleHeroes(hSubclass)));
		}
		
		return comp;
	}

	public static List<String> createByHeroClass(Map<HeroClass, Integer> build) {
		
		List<String> comp = new ArrayList<>();
		
		Iterator<HeroClass> buildIterator = build.keySet().iterator();
		while (buildIterator.hasNext()) {
			
			HeroClass hClass = buildIterator.next();
			comp.addAll(create(build.get(hClass), getEligibleHeroes(hClass)));
		}
		
		return comp;
	}
	
	public static List<String> create(int numberOfPlayers, List<Heroes> eligibleHeroes) {
		checkIfNumberOfPlayersIsValid(numberOfPlayers);
		
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
	
	private static List<Heroes> getEligibleHeroes(HeroClass hClass) {
		
		Heroes[] heroes = Heroes.values();
		
		List<Heroes> eligibleHeroes = new ArrayList<>();
		
		for(int i = 0; i < heroes.length; i++) {
			
			Heroes hero = heroes[i];
			
			if(hero.getHeroClass().equals(hClass))
				eligibleHeroes.add(hero);
			
		}
		
		return eligibleHeroes;
	}
	
	private static List<Heroes> getEligibleHeroes(HeroSubclass hSubclass) {
		
		Heroes[] heroes = Heroes.values();
		
		List<Heroes> eligibleHeroes = new ArrayList<>();
		
		for(int i = 0; i < heroes.length; i++) {
			
			Heroes hero = heroes[i];
			
			if(hero.getHeroSubclass().equals(hSubclass))
				eligibleHeroes.add(hero);
			
		}
		
		return eligibleHeroes;
	}

	private static void checkIfNumberOfPlayersIsValid(int numberOfPlayers) {
		if(numberOfPlayers < 1)
			throw new IllegalArgumentException("The number of players needs to be at least one.");
		
		if(numberOfPlayers > 12)
			throw new IllegalArgumentException("The number of players needs to be twelve at maximum.");
	}

}
