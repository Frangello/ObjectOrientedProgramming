package raceTrackerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Test;

import Exceptions.ApplicationException;
import Messages.AthleteUpdate;
import Messages.RegistrationUpdate;
import Messages.StartedUpdate;
import Racedata.AthleteRaceStatus;
import raceTracker.Athlete;
import raceTracker.AthleteSet;
import raceTracker.RegisterUpdate;

public class StartedUpdateTest {
	
	@Test
	 public void testStartedUpdate(){

		AthleteSet athletes = new AthleteSet();
		RegistrationUpdate rUpdate;
		try {
			rUpdate = (RegistrationUpdate) AthleteUpdate.Create("Registered,14,8/15/2017 7:02:05 AM,Jane,Jones,F,16");
			assertNotNull(rUpdate);
	        
	        new RegisterUpdate().update(athletes, rUpdate);
	        assertEquals(1, athletes.getAthletes().size());
	        
	        Athlete athlete = athletes.get(14);
	        assertEquals(AthleteRaceStatus.Registered, athlete.getStatus());
	        assertEquals(14, athlete.getBibNumber());
	        assertEquals(LocalDateTime.of(2017,8,15,7, 2, 5), athlete.getUpdateTime());
	        assertEquals("Jane", athlete.getFirstName());
	        assertEquals("Jones", athlete.getLastName());
	        assertEquals("F", athlete.getGender());
	        assertEquals(16, athlete.getAge());

		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			StartedUpdate sUpdate = (StartedUpdate) AthleteUpdate.Create("Started,14,8/15/2017 2:34:00 PM,8/15/2017 2:33:45 PM");
	        assertNotNull(sUpdate);
	        
	        new raceTracker.StartedUpdate().update(athletes, sUpdate);
	        assertEquals(1, athletes.getAthletes().size());
	        
	        Athlete athlete = athletes.get(14);
	        assertEquals(AthleteRaceStatus.Started, athlete.getStatus());
	        assertEquals(14, athlete.getBibNumber());
	        assertEquals(LocalDateTime.of(2017,8,15,14, 34, 0), athlete.getUpdateTime());
	        assertEquals(LocalDateTime.of(2017,8,15,14, 33, 45), athlete.getStartTime());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}
