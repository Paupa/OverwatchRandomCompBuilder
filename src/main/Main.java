package main;

import java.util.*;

import model.Heroes;

public class Main {

	public static void main(String[] args) {
		
		Heroes[] comp = createRandomComp();
		
		for(int i = 0; i < comp.length; i++) {
			System.out.println(comp[i]);
		}

	}
	
	private static Heroes[] createRandomComp() {
		return createRandomComp(6);
	}
	
	private static Heroes[] createRandomComp(int numberOfPlayers) {
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

}
