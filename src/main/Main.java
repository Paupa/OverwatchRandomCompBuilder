package main;

import java.util.*;

import logic.RandomCompCreator;
import model.HeroClass;
import model.Heroes;

public class Main {

	public static void main(String[] args) {
		
		/*
		List<String> comp = createRandomComp();
		
		for(int i = 0; i < comp.size(); i++) {
			System.out.println(comp.get(i));
		}
		
		System.out.println("------------------");
		*/
		
		String[] playerNames = {"Shyro", "Pipeem", "Paupa"};
		
		List<String> playerComp = RandomCompCreator.create(playerNames);
		
		for(int i = 0; i < playerComp.size(); i++) {
			System.out.println(playerComp.get(i));
		}
		
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

	}
	
	
}
