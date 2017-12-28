package personMatcher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TxtFileExporter implements Exporter {

	@Override
	public void write(List<MatchPair> matches, String filename) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(filename);
			bw = new BufferedWriter(fw);
			for(int i = 0; i < matches.size(); i++){
				bw.write(matches.get(i).getPerson1().getObjectId().toString());
				bw.write(", ");
				bw.write(matches.get(i).getPerson2().getObjectId().toString());
				bw.write("\n");
			}
			System.out.println("Done writing file");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
