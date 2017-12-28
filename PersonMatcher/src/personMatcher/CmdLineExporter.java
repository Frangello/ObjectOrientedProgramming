package personMatcher;

import java.util.List;


public class CmdLineExporter implements Exporter {

	@Override
	public void write(List<MatchPair> matches, String filename) {
		for(int i = 0; i < matches.size(); i++){
			System.out.println("Match:");
			System.out.print("Id: " + matches.get(i).getPerson1().getObjectId());
			System.out.print(", Name: " + matches.get(i).getPerson1().getFirstName()+ " "+ 
			matches.get(i).getPerson1().getMiddleName() + " " + matches.get(i).getPerson1().getLastName());
			System.out.println(", BirthDate: " + matches.get(i).getPerson1().getBirthMonth()+ "/"+ 
					matches.get(i).getPerson1().getBirthDay() + "/" + matches.get(i).getPerson1().getBirthYear());
			
			System.out.print("Id: " + matches.get(i).getPerson2().getObjectId());
			System.out.print(", Name: " + matches.get(i).getPerson2().getFirstName()+ " "+ 
			matches.get(i).getPerson2().getMiddleName() + " " + matches.get(i).getPerson2().getLastName());
			System.out.println(", BirthDate: " + matches.get(i).getPerson2().getBirthMonth()+ "/"+ 
					matches.get(i).getPerson2().getBirthDay() + "/" + matches.get(i).getPerson2().getBirthYear());
		}
		System.out.println("Done matching!");
	}
}
