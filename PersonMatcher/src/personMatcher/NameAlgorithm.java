package personMatcher;

public class NameAlgorithm implements MatchAlgorithm {

	@Override
	public boolean match(Person person1, Person person2) {
		try {
			if(person1.getFirstName().equals(person2.getFirstName())  && person1.getLastName().equals(person2.getLastName())){
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
