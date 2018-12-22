package main;

import java.util.*;

import logic.RandomCompCreator;
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
		
		Map<HeroRole, Integer> build = new HashMap<>();
		
		build.put(HeroSubclass.MainTank, 1);
		build.put(HeroSubclass.OffTank, 1);
		build.put(HeroSubclass.MainHeal, 1);
		build.put(HeroSubclass.OffHeal, 1);
		build.put(HeroSubclass.Hitscan, 1);
		build.put(HeroSubclass.Projectiles, 1);
		
		List<String> comp = RandomCompCreator.createByHeroRole(build);
		
		for(int i = 0; i < comp.size(); i++) {
			System.out.println(comp.get(i));
		}

	}
	
	
}
