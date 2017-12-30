package userInterface;

import raceTracker.Athlete;

public class NameDecorator extends Decorator {

	private Display display;
	private Athlete athlete; 
	
	public NameDecorator(Display display) {
		this.display = display;
		this.athlete = display.getAthlete();
	} 
	
	public Athlete getAthlete(){
		return athlete;
	}

	public String getInfo(){
		return display.getInfo() + " Name: " + athlete.getFirstName();
	}
	
}
