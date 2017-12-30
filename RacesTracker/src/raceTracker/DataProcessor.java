package raceTracker;

import Messages.AthleteUpdate;
import Racedata.IAthleteUpdateHandler;
import Racedata.SimulatedDataSource;

public class DataProcessor implements IAthleteUpdateHandler {
	private SimulatedDataSource simulatedData;
	private AthleteSet athletes;
	
	public DataProcessor(){
		athletes = new AthleteSet();
	}
	
	public void Initialize(String inputFileName){
		simulatedData = new SimulatedDataSource();
		simulatedData.setHandler(null);
		simulatedData.setInputFilename(inputFileName);
	}

	@Override
	public void ProcessUpdate(AthleteUpdate update) {
//		System.out.println(update.toString());
		switch(update.getUpdateType()){
		case Registered:
			new RegisterUpdate().update(athletes, update);
			break;
		case DidNotStart:
			new DidNotStartUpdate().update(athletes, update);
            break;
        case Started:
        	new StartedUpdate().update(athletes, update);
            break;
        case OnCourse:
        	new OnCourseUpdate().update(athletes, update);
            break;
        case DidNotFinish:
        	new DidNotFinishUpdate().update(athletes, update);
            break;
        case Finished:
        	new FinishedUpdate().update(athletes, update);
            break;
        default:
        	break;
		}
		athletes.get(update.getBibNumber()).notifyObservers(athletes.get(update.getBibNumber()));
	}
	
	public AthleteSet getAthletes(){
		return athletes;
	}
	
	public Athlete getAthlete(int i){
		return athletes.get(i);
	}
	
}
