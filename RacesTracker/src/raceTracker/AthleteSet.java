package raceTracker;

import java.util.HashMap;
import java.util.Map;

public class AthleteSet {

	private Map<Integer, Athlete> athletes;
	
	public AthleteSet(){
		athletes = new HashMap<Integer, Athlete>();
	}
	
	public void add(Athlete athlete){
		this.athletes.put(athlete.getBibNumber(), athlete);
	}
	
	public Athlete get(int bibNumber){
		return this.athletes.get(bibNumber);
	}
	
	public Map<Integer, Athlete> getAthletes(){
		return athletes;
	}
}
