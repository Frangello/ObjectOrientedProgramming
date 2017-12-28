package personMatcher;

import java.util.List;

public interface Importer {
	
	public String getString(Object obj, String tagName);
	
	public Long getLong(Object obj, String tagName);
	
	public void read(List<Person> people, String filename);
	
}
