package userInterface;

import raceTracker.Athlete;

public class StatusDecorator extends Decorator {

	private Display display;
	private Athlete athlete;
	
	public StatusDecorator(Display display) {
		this.display = display;
		this.athlete = display.getAthlete();
	} 

	public String getInfo(){
		return display.getInfo() + " Status: " + athlete.getStatus();
	}
	
	public Athlete getAthlete(){
		return athlete;
	}
}