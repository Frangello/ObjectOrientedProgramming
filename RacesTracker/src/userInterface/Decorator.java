package userInterface;

import raceTracker.Athlete;

public abstract class Decorator extends Display {

	public abstract String getInfo();
	public abstract Athlete getAthlete();
	
}
