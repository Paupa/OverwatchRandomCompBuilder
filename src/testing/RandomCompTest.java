package testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import logic.RandomCompCreator;

public class RandomCompTest {

	@Test
	public void testCreateBasic() {
		
		List<String> comp = RandomCompCreator.create();
		
		assert(comp.size() == 6);
	}
	
	@Test
	public void testCreate0() {
		try {
			RandomCompCreator.create(0);
			
			fail();
		}
		
		catch (IllegalArgumentException e){
			//If we get through here it means the creation failed, which is what we wanted
		}
		
	}

}
