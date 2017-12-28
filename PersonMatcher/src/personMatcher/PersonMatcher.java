package personMatcher;

import java.util.List;
import java.util.ArrayList;

public class PersonMatcher {

	private List<Person> people;
	private List<MatchPair> matches;
 	private Importer importer;
	private Exporter exporter;
	private MatchAlgorithm algorithm;
	
	public PersonMatcher(){
		this.people = new ArrayList<Person>();
		this.matches = new ArrayList<MatchPair>();
	}

	public Importer getImporter() {
		return importer;
	}

	public void setImporter(Importer importer) {
		this.importer = importer;
	}

	public Exporter getExporter() {
		return exporter;
	}

	public void setExporter(Exporter exporter) {
		this.exporter = exporter;
	}

	public MatchAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(MatchAlgorithm alg) {
		this.algorithm = alg;
	}

	public void addPerson(Person person) {
		people.add(person);
	}

	public void read(String filename) {
		importer.read(this.people, filename);
	}

	public void write(String filename) {
		exporter.write(this.matches, filename);
	}

	public void match() {
		try{ 
			for (int i = 0; i < this.people.size(); i++) {
				for (int j = i + 1; j < this.people.size(); j++) {
					Person p1 = this.people.get(i);
					Person p2 = this.people.get(j);
					if (algorithm.match(p1, p2)) {
						matches.add(new MatchPair(p1, p2));
					}
				}
			}
		}catch(NullPointerException e ){
			e.printStackTrace();
		}
	}

}
