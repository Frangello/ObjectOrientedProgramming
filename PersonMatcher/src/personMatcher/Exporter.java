package personMatcher;

import java.util.List;

public interface Exporter {

	public void write(List<MatchPair> matches, String filename);
}
