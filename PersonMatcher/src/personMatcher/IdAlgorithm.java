package personMatcher;

public class IdAlgorithm implements MatchAlgorithm {

	@Override
	public boolean match(Person person1, Person person2) {
		try {
			if(person1.getStateFileNumber().equals(person2.getStateFileNumber()) &&
					person1.getSocialSecurityNum().equals(person2.getSocialSecurityNum())){
				return true;
			}
			else
				return false;
			}
		catch(NullPointerException e ){
			e.printStackTrace();
			return false;
		}
	}
}
