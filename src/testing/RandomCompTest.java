package testing;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import logic.RandomCompCreator;
import model.*;

public class RandomCompTest {

	@Test
	public void testCreateBasic() {
		
		List<Heroes> comp = RandomCompCreator.create();
		
		assert(comp.size() == 6);
	}
	
	@Test
	public void testCreateLessThanMinimumPlayers() {
		testCreateOffLimits(0);
		
	}
	
	@Test
	public void testCreateMoreThanMaximumPlayers() {
		testCreateOffLimits(30);
		
	}
	
	@Test
	public void testCreateOne() {
		testCreateOnLimits(1);
		
	}
	
	@Test
	public void testCreateLessThanSix() {
		testCreateOnLimits(5);
		
	}
	
	@Test
	public void testCreateMoreThanSix() {
		testCreateOnLimits(8);
		
	}
	
	@Test
	public void testCreateNullArray() {
		
		try {
			String[] players = null;
			
			RandomCompCreator.create(players);
			
			fail();
			
		} catch (IllegalArgumentException e) {
			
		}
		
	}
	
	@Test
	public void testCreateNullMap() {
		
		try {
			
			Map<HeroRole, Integer> build = null;
			
			RandomCompCreator.create(build);
			
			fail();
		} catch (IllegalArgumentException e) {
			
		}
		
	}
	
	@Test
	public void testCreateEmptyArray() {
		
		try {
			String[] players = {};
			
			RandomCompCreator.create(players);
			
			fail();
			
		} catch (IllegalArgumentException e) {
			
		}
		
	}
	
	public void testCreateOffLimits(int numberOfPlayers) {
		try {
			RandomCompCreator.create(numberOfPlayers);
			
			//If the comp can be created the test must fail
			fail();
		}
		
		catch (IllegalArgumentException e){
			//If we get through here it means the creation failed, which is what we wanted
		}
		
	}
	
	public void testCreateOnLimits(int numberOfPlayers) {
		
		List<Heroes> build = RandomCompCreator.create(numberOfPlayers);
		
		assert(build.size() == numberOfPlayers);
	}

}
