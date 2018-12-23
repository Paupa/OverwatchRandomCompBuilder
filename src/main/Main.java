package main;

import java.util.*;

import com.google.common.collect.*;

import logic.ChallengeAssigner;
import logic.RandomCompBuilder;
import model.*;

public class Main {

	public static void main(String[] args) {
		
		/*
		List<String> comp = createRandomComp();
		
		for(int i = 0; i < comp.size(); i++) {
			System.out.println(comp.get(i));
		}
		
		System.out.println("------------------");
		*/
		
		/*
		String[] playerNames = {"Shyro", "Pipeem", "Paupa"};
		
		List<String> playerComp = RandomCompCreator.create(playerNames);
		
		for(int i = 0; i < playerComp.size(); i++) {
			System.out.println(playerComp.get(i));
		}
		*/
		
		/*
		Map<HeroeClass, Integer> build = new HashMap<>();
		
		build.put(HeroeClass.tank, 2);
		build.put(HeroeClass.damage, 2);
		build.put(HeroeClass.support, 2);
		
		List<String> comp = createRandomComp(build);
		
		for(int i = 0; i < comp.size(); i++) {
			System.out.println(comp.get(i));
		}
		*/
		
		/*
		Map<HeroRole, Integer> build = new HashMap<>();
		
		build.put(HeroSubclass.MainTank, 1);
		build.put(HeroSubclass.OffTank, 1);
		build.put(HeroSubclass.MainHeal, 1);
		build.put(HeroSubclass.OffHeal, 1);
		build.put(HeroSubclass.Hitscan, 1);
		build.put(HeroSubclass.Projectiles, 1);
		
		List<String> comp = RandomCompCreator.create(build);
		
		for(int i = 0; i < comp.size(); i++) {
			System.out.println(comp.get(i));
		}
		*/
		
		/*
		Multimap <HeroRole, String> build = HashMultimap.create();
		
		build.put(HeroSubclass.MainTank, "Paupa");
		build.put(HeroSubclass.MainTank, "Utezas");
		build.put(HeroSubclass.MainHeal, "Shyro");
		build.put(HeroClass.support, "Agra");
		
		List<String> comp = RandomCompCreator.create(build);
		
		for(int i = 0; i < comp.size(); i++) {
			System.out.println(comp.get(i));
		}
		*/
		
		/*
		List<String> players = new ArrayList<>();
		
		players.add("Paupa");
		players.add("Agra");
		players.add("Shyro");
		
		List<String> challenges = ChallengeAssigner.assign(players);
		
		for(int i = 0; i < challenges.size(); i++) {
			
			System.out.println(challenges.get(i));
		}*/
		
		randomCompForParty();

	}
	
	private static void randomCompForParty() {
		
		Map<String, HeroRole> party = new HashMap<>();
		
		party.put("Paupa", HeroSubclass.MainTank);
		party.put("Shyro", HeroSubclass.MainHeal);
		party.put("Utezas", HeroSubclass.OffTank);
		party.put("Agra", HeroSubclass.OffHeal);
		
		Map<Assignation, HeroRole> comp = RandomCompBuilder.createByHeroRoleForPlayer(party);
		
		Set<Assignation> assignations = comp.keySet();
		
		for(Assignation assignation : assignations) {
			
			System.out.println(assignation.getPlayer() + " → " + assignation.getHero() + " (" + comp.get(assignation) + ")");
			
		}
	}
	
	
}
