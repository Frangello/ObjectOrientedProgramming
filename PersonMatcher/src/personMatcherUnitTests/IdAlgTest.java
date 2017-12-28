package personMatcherUnitTests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import personMatcher.IdAlgorithm;
import personMatcher.Person;

public class IdAlgTest {
	
	@Test
    public void testingIdMatching() {
		IdAlgorithm idAlg = new IdAlgorithm();
		Person person1 = new Person(Long.parseLong("1"), "123" ,"345","","","",Long.parseLong("0"),
				Long.parseLong("0"),Long.parseLong("0"),"","","",Long.parseLong("0"),"","","","","","");
		Person person2 = new Person(Long.parseLong("2"), "123" ,"345","","","",Long.parseLong("0"),
				Long.parseLong("0"),Long.parseLong("0"),"","","",Long.parseLong("0"),"","","","","","");
		Person person3 = new Person(Long.parseLong("3"), "" ,"345","","","",Long.parseLong("0"),
				Long.parseLong("0"),Long.parseLong("0"),"","","",Long.parseLong("0"),"","","","","","");
		Person person4 = new Person(Long.parseLong("4"), null ,"345","","","",Long.parseLong("0"),
				Long.parseLong("0"),Long.parseLong("0"),"","","",Long.parseLong("0"),"","","","","","");
		
		idAlg.match(person1, person2);
		
		assertTrue(idAlg.match(person1, person2));
		assertFalse(idAlg.match(person3, person2));
		assertFalse(idAlg.match(person4, person2));

	}

}
