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
		
		Set<HeroRole> roles = build.keySet();
		
		List<Heroes> bannedHeroes = new ArrayList<>();
		
		for(HeroRole role : roles) {
			
			List<Heroes> heroes = create(build.get(role), getEligibleHeroes(role, bannedHeroes));
			
			comp.put(role, heroes);
			
			bannedHeroes.addAll(heroes);
		}
		
		return comp;
	}
	
	public static Map<Assignation, HeroRole> createByHeroRoleForPlayer(Map<String, HeroRole> build) {
		
		checkIfNull(build);
		
		Set<String> players = build.keySet();
		
		Multimap<HeroRole, String> multimap = HashMultimap.create();
		
		for(String player : players) {
			
			HeroRole role = build.get(player);
			
			multimap.put(role, player);
		}
		
		return create(multimap);
	}
	
	private static Map<Assignation, HeroRole> create(Multimap<HeroRole, String> build) {
		
		checkIfNull(build);
		
		Map<Assignation, HeroRole> comp = new HashMap<>();
		
		Set<HeroRole> roles = build.keySet();
		
		List<Heroes> bannedHeroes = new ArrayList<>();
		
		for (HeroRole role : roles) {
			
			Collection<String> players = build.get(role);
			
			List<Heroes> heroes = create(players.size(), getEligibleHeroes(role, bannedHeroes));
			
			Iterator<String> playersIterator = players.iterator();
			
			for(Heroes hero : heroes) {
				
				String player = playersIterator.next();
				
				Assignation assignation = new Assignation(player, hero);
				
				comp.put(assignation, role);
				
				bannedHeroes.add(hero);
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
	
	private static List<Heroes> getEligibleHeroes(HeroRole role, List<Heroes> bannedHeroes) {
		
		if(bannedHeroes == null)
			bannedHeroes = new ArrayList<>();
		
		List<Heroes> heroes = getAllHeroes();
		
		List<Heroes> heroesToRemove = new ArrayList<>();
		
		for(Heroes hero : heroes) {
			if(bannedHeroes.contains(hero) || !hero.getRoles().contains(role))
				heroesToRemove.add(hero);
		}
		
		heroes.removeAll(heroesToRemove);
		
		return heroes;
	}
	
	private static void checkIfNull(Object object) {
		if(object == null)
			checkIfNumberOfPlayersIsValid(-1, 0);
	}

	private static void checkIfNumberOfPlayersIsValid(int numberOfPlayers, int numberOfEligibleHeroes) {
		if(numberOfPlayers < 0 || numberOfPlayers > numberOfEligibleHeroes)
			throw new IllegalArgumentException("The build is impossible to make");
	}

}
