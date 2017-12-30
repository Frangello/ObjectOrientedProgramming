package raceTrackerTest;

import Racedata.AthleteRaceStatus;
import raceTracker.Athlete;
import raceTracker.AthleteSet;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AthleteSetTest {
	
	@Test
	public void athleteSetTest(){
		AthleteSet athletes = new AthleteSet();
		Athlete athlete = new Athlete();
	    athlete.setStatus(AthleteRaceStatus.OnCourse);
	    athlete.setBibNumber(14);
	    athletes.add(athlete);
	    
	    assertEquals(1, athletes.getAthletes().size());
	    assertEquals(athlete, athletes.get(14));
	    
	    Map<Integer, Athlete> athletes2 = new HashMap<Integer, Athlete>();
	    athletes2.put(14, athlete);
	    assertEquals(athletes2, athletes.getAthletes());
		
	}

}
