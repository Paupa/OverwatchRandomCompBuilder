package testing.randomCompTests;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import logic.RandomCompBuilder;
import model.*;

public class Test_RandomComp_SetOfPlayersCreate {
	
	
	@Test
	public void testCreateNullSet() {
		
		try {
			Set<String> players = null;
			
			RandomCompBuilder.create(players);
			
			fail();
			
		} catch (IllegalArgumentException e) {
			
		}
		
	}
	
	@Test
	public void testCreateEmptySet() {
		
		List<Assignation> assignations = doCreateWithPlayersNames();
		
		assert(assignations.isEmpty());
	}
	
	@Test
	public void testCreateSetWithEmptyString() {
		
		List<Assignation> assignations = doCreateWithPlayersNames("");
		
		//TODO Deberia permitir nombres vacios?
		
		assert(assignations.size() == 1);
		
	}
	
	@Test
	public void testCreateSetWithOnePlayerName() {
		
		List<Assignation> assignations = doCreateWithPlayersNames("Paupa");
		
		assert(assignations.size() == 1);
		
	}
	
	@Test
	public void testCreateSetWithSixPlayersNames() {
		
		List<Assignation> assignations = doCreateWithNumberOfPlayersNames(6);
		
		assert(assignations.size() == 6);
		
	}
	
	@Test
	public void testCreateSetWithMoreThanMaximumPlayersNames() {
		
		try {
			doCreateWithNumberOfPlayersNames(30);
			
			fail("It shouldn't be able to create a comp for a number of people greater than the heroes existing.");
			
		} catch (Exception e) {
			
		}
		
	}
	
	private List<Assignation> doCreateWithNumberOfPlayersNames(int numberOfPlayersNames) {
		return doCreateWithPlayersNames(createArrayOfPlayerNames(numberOfPlayersNames));
	}
	
	private String[] createArrayOfPlayerNames(int numberOfPlayerNames) {
		
		String[] playersNames = new String[numberOfPlayerNames];
		
		for(int i = 0; i < numberOfPlayerNames; i++) {
			playersNames[i] = String.valueOf(i);
		}
		
		return playersNames;
	}
	
	private List<Assignation> doCreateWithPlayersNames(String...playerNames) {
		
		Set<String> players = createSetOfPlayers(playerNames);
		
		return RandomCompBuilder.create(players);
	}
	
	private Set<String> createSetOfPlayers(String... playerNames) {
		
		Set<String> players = new TreeSet<>();
		
		for(String playerName: playerNames) {
			players.add(playerName);
		}
		
		return players;
	}
	

}
