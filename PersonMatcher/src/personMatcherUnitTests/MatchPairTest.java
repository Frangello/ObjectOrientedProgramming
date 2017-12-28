package personMatcherUnitTests;
import static org.junit.Assert.*;

import org.junit.Test;

import personMatcher.MatchPair;
import personMatcher.Person;

public class MatchPairTest {

	@Test
	public void testMatchPairsContainsTwoPeople(){
		Person person1 = new Person(Long.parseLong("1"), "123" ,"345","","","",Long.parseLong("0"),
				Long.parseLong("0"),Long.parseLong("0"),"","","",Long.parseLong("0"),"","","","","","");
		Person person2 = new Person(Long.parseLong("2"), "123" ,"345","","","",Long.parseLong("0"),
				Long.parseLong("0"),Long.parseLong("0"),"","","",Long.parseLong("0"),"","","","","","");
		MatchPair pair = new MatchPair(person1, person2);
		
		assertEquals(person1, pair.getPerson1());
		assertEquals(person2, pair.getPerson2());
	}

}
