package testing;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import logic.RandomCompBuilder;
import model.*;

public class RandomCompTest {

	@Test
	public void testCreateBasic() {
		
		List<Heroes> comp = RandomCompBuilder.create();
		
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
	public void testCreateNullSet() {
		
		try {
			Set<String> players = null;
			
			RandomCompBuilder.create(players);
			
			fail();
			
		} catch (IllegalArgumentException e) {
			
		}
		
	}
	
	@Test
	public void testCreateNullMap() {
		
		try {
			
			Map<HeroRole, Integer> build = null;
			
			RandomCompBuilder.create(build);
			
			fail();
		} catch (IllegalArgumentException e) {
			
		}
		
	}
	
	public void testCreateOffLimits(int numberOfPlayers) {
		try {
			RandomCompBuilder.create(numberOfPlayers);
			
			//If the comp can be created the test must fail
			fail();
		}
		
		catch (IllegalArgumentException e){
			//If we get through here it means the creation failed, which is what we wanted
		}
		
	}
	
	public void testCreateOnLimits(int numberOfPlayers) {
		
		List<Heroes> build = RandomCompBuilder.create(numberOfPlayers);
		
		assert(build.size() == numberOfPlayers);
	}

}
