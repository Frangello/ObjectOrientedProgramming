package personMatcher;

public class PersonMatcherTest {
	
	//Array of possible importers
	//TODO: make this a dictionary
	//the string type is key and the class initialization is value
	//so don't have to worry about order of the following 2 arrays
	private static Importer[] importers = new Importer[]{
                new JsonImporter(),
                new XmlImporter()
    };
	
	private static String[] importerTypes = new String[]{
			".json", ".xml"
	};
	
	//Array of possible exporters
	private static Exporter[] exporters = new Exporter[]{
                new TxtFileExporter(),
                new CmdLineExporter()
    };
	
	private static String[] exporterTypes = new String[]{
			".txt"
	};
	
	//Array of possible algorithms
	private static MatchAlgorithm[] algorithms = new MatchAlgorithm[]{
			new IdAlgorithm(), new NameAlgorithm(), new BirthAlgorithm()
	};

	public static void main(String[] args) {
		PersonMatcher pm = new PersonMatcher();
		if (args.length > 0) {
		    try {
				//Sets algorithm type
				pm.setAlgorithm(algorithms[Integer.parseInt(args[0]) - 1]);
				
				//Sets importer type
		    	for(int i = 0; i < importerTypes.length; i++){
		    		if(args[1].endsWith(importerTypes[i])){
		    			pm.setImporter(importers[i]);
				    	//Reads content of importer file
			    		pm.read(args[1]);
		    		}
		    	}
	    		
	    		//Matches content of importer file
	    		pm.match();
	    		
	    		//Writes matches to file
	    		if(args.length > 2){
	    			//Sets exporter type
	    			for(int i = 0; i < exporterTypes.length; i++){
			    		if(args[2].endsWith(exporterTypes[i])){
			    			pm.setExporter(exporters[i]);
			    			pm.write(args[2]);
			    		}
	    			}
	    		}
	    		//Write matches to terminal if no exporter file given
	    		else {
	    			pm.setExporter(exporters[exporters.length - 1]);
	    			pm.write(null);
	    		}
	    		
		    } catch (NumberFormatException e) {
		        System.out.println("Argument" + args[0] + " must be an integer.");
		        System.exit(1);
		    };
		}
	}
}
