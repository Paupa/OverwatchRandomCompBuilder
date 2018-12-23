package logic;

import java.util.*;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import model.*;

public class RandomCompBuilder {
	
	public static List<Heroes> create() {
		return create(6);
	}
	
	public static List<Heroes> create(int numberOfPlayers) {

		return create(numberOfPlayers, getAllHeroes());
	}
	
	public static List<Assignation> create(Set<String> players) {
		
		checkIfNull(players);
		
		List<Heroes> heroes = create(players.size());
		
		List<Assignation> assignations = new ArrayList<>();
		
		int heroIndex = 0;
		
		for(String player: players) {
			
			Heroes hero = heroes.get(heroIndex++);
			
			Assignation assignation = new Assignation(player, hero);
			
			assignations.add(assignation);
		}
		
		return assignations;
	}
	
	public static Map<HeroRole, List<Heroes>> create(Map<HeroRole, Integer> build) {
		
		checkIfNull(build);
		
		Map<HeroRole, List<Heroes>> comp = new HashMap<>();
		
		Iterator<HeroRole> buildIterator = build.keySet().iterator();
		while (buildIterator.hasNext()) {
			
			HeroRole role = buildIterator.next();
			
			List<Heroes> heroes = create(build.get(role), getEligibleHeroes(role));
			
			comp.put(role, heroes);
		}
		
		return comp;
	}
	
	public static Map<Assignation, HeroRole> createByHeroRoleForPlayer(Map<String, HeroRole> build) {
		
		checkIfNull(build);
		
		Iterator<String> iterator = build.keySet().iterator();
		
		Multimap<HeroRole, String> multimap = HashMultimap.create();
		
		while(iterator.hasNext()) {
			
			String player = iterator.next();
			HeroRole role = build.get(player);
			
			multimap.put(role, player);
		}
		
		return create(multimap);
	}
	
	private static Map<Assignation, HeroRole> create(Multimap<HeroRole, String> build) {
		
		checkIfNull(build);
		
		Map<Assignation, HeroRole> comp = new HashMap<>();
		
		Iterator<HeroRole> buildIterator = build.keySet().iterator();
		while (buildIterator.hasNext()) {
			
			HeroRole role = buildIterator.next();
			
			Collection<String> players = build.get(role);
			
			List<Heroes> heroes = create(players.size(), getEligibleHeroes(role));
			
			Iterator<String> playersIterator = players.iterator();
			
			for (int i = 0; i < heroes.size(); i++) {
				
				Heroes heroe = heroes.get(i);
				
				String player = playersIterator.next();
				
				Assignation assignation = new Assignation(player, heroe);
				
				comp.put(assignation, role);
			}
		}
		
		return comp;
	}
	
	public static List<Heroes> create(int numberOfPlayers, List<Heroes> eligibleHeroes) {
		
		checkIfNumberOfPlayersIsValid(numberOfPlayers, eligibleHeroes.size());
		
		Random r = new Random();
		
		List<Heroes> comp = new ArrayList<>();
		
		for(int i = 0; i < numberOfPlayers; i++) {
			int index = r.nextInt(eligibleHeroes.size());
			
			comp.add(eligibleHeroes.get(index));
			
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
	
	private static void checkIfNull(Object object) {
		if(object == null)
			checkIfNumberOfPlayersIsValid(0, 0);
	}

	private static void checkIfNumberOfPlayersIsValid(int numberOfPlayers, int numberOfEligibleHeroes) {
		if(numberOfPlayers < 1)
			throw new IllegalArgumentException("The number of players needs to be at least one.");
		
		if(numberOfPlayers > numberOfEligibleHeroes)
			throw new IllegalArgumentException("The build is impossible to make");
	}

	//TODO Hacer que no se pueda repetir heroe (Si uno elige en build main healer y otro support, se puede repetir. Evitarlo)
}
