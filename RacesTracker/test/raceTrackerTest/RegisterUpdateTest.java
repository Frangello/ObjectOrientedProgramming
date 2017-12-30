package raceTrackerTest;

import raceTracker.Athlete;
import raceTracker.AthleteSet;
import raceTracker.RegisterUpdate;

import org.junit.Test;

import Exceptions.ApplicationException;
import Messages.AthleteUpdate;
import Messages.RegistrationUpdate;
import Racedata.AthleteRaceStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

public class RegisterUpdateTest {
	
	@Test
	 public void testRegisterUpdate(){
		AthleteSet athletes = new AthleteSet();
		RegistrationUpdate update;
		try {
			update = (RegistrationUpdate) AthleteUpdate.Create("Registered,14,8/15/2017 7:02:05 AM,Jane,Jones,F,16");
			assertNotNull(update);
	        
	        new RegisterUpdate().update(athletes, update);
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
        
	}
	
}
