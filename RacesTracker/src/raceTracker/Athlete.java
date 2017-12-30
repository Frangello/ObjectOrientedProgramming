package raceTracker;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Racedata.AthleteRaceStatus;

public class Athlete implements Subject{
	private int bibNumber;
	private String firstName; 
	private String lastName;
	private String gender;
	private int age;
	private AthleteRaceStatus status;
	private double location;
	private LocalDateTime updateTime;
	private LocalDateTime startTime; 
	private LocalDateTime finishTime;
	private ArrayList<Observer> observers;

	public Athlete() {
		observers = new ArrayList<Observer>();
	}

	public int getBibNumber() {
		return bibNumber;
	}

	public void setBibNumber(int bibNumber) {
		this.bibNumber = bibNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public AthleteRaceStatus getStatus() {
		return status;
	}

	public void setStatus(AthleteRaceStatus status) {
		this.status = status;
	}

	public double getLocation() {
		return location;
	}

	public void setLocation(double location) {
		this.location = location;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalDateTime finishTime) {
		this.finishTime = finishTime;
	}
	
	public void notifyObservers(Athlete athlete){
		for(Observer obs : observers){
			obs.update(athlete);
		}
	}

	@Override
	public void subscribe(Observer o) {
		observers.add(o);
	}

	@Override
	public void unsubscribe(Observer o) {
		int i = observers.indexOf(o);
		if(i>=0){
			observers.remove(i);
		}
	}

}
