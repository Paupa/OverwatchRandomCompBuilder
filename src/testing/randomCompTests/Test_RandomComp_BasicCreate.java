package testing.randomCompTests;

import java.util.List;

import org.junit.Test;

import logic.RandomCompBuilder;
import model.Heroes;

public class Test_RandomComp_BasicCreate {

	@Test
	public void testCreateBasic() {
		
		List<Heroes> comp = RandomCompBuilder.create();
		
		assert(comp.size() == 6);
	}

}
