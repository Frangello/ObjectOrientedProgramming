package personMatcher;

public class BirthAlgorithm implements MatchAlgorithm {

	@Override
	public boolean match(Person person1, Person person2) {
		try {
			if(person1.getMotherLastName().equals(person2.getMotherLastName())
					&&  person1.getBirthYear().equals(person2.getBirthYear())){
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
