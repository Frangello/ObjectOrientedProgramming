package userInterface;

import raceTracker.Athlete;

public abstract class Display {
	
	private String description = null;
	private Athlete athlete;
	
	public String getInfo() { 
		return description;
	}
	
	public Athlete getAthlete(){
		return athlete;
	}

}
