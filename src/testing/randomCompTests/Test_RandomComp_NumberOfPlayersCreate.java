package testing.randomCompTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import logic.RandomCompBuilder;
import model.Heroes;

public class Test_RandomComp_NumberOfPlayersCreate {

	@Test
	public void testCreateLessThanMinimumPlayers() {
		testCreateOffLimits(-1);
		
	}
	
	@Test
	public void testCreateZeroPlayers() {
		testCreateOnLimits(0);
		
	}

	
	@Test
	public void testCreateOnePlayer() {
		testCreateOnLimits(1);
		
	}
	
	@Test
	public void testCreateLessThanSixPlayers() {
		testCreateOnLimits(5);
		
	}
	
	@Test
	public void testCreateMoreThanSixPlayers() {
		testCreateOnLimits(8);
		
	}
	
	@Test
	public void testCreateMoreThanMaximumPlayers() {
		testCreateOffLimits(30);
		
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
