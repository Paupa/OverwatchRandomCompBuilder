package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testing.randomCompTests.*;

@RunWith(Suite.class)
@SuiteClasses({ Test_RandomComp_SetOfPlayersCreate.class, Test_RandomComp_BasicCreate.class, 
	Test_RandomComp_NumberOfPlayersCreate.class })
public class RandomCompTests {

}
