package raceTracker;

public interface Subject {
	public void subscribe(Observer o);
	public void unsubscribe(Observer o);	
}
