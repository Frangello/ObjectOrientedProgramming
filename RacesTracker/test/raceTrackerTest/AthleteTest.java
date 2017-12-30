package raceTrackerTest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import Racedata.AthleteRaceStatus;
import raceTracker.Athlete;

public class AthleteTest {
	
	@Test
    public void testSettersAndGetters() throws Exception {
		
        Athlete athlete = new Athlete();
        athlete.setStatus(AthleteRaceStatus.OnCourse);
        athlete.setBibNumber(14);
        athlete.setUpdateTime(LocalDateTime.of(2017,8,15,7,2,5));
        athlete.setFirstName("Jane");
        athlete.setLastName("Jones");
        athlete.setGender("F");
        athlete.setAge(16);
        athlete.setStartTime(LocalDateTime.of(2017, 8, 15, 14,33,45));
        athlete.setFinishTime(LocalDateTime.of(2017, 8, 15, 14,33,45));
        athlete.setLocation(680.067495971265);

        assertEquals(AthleteRaceStatus.OnCourse, athlete.getStatus());
        assertEquals(14, athlete.getBibNumber());
        assertEquals(LocalDateTime.of(2017,8,15,7, 2, 5), athlete.getUpdateTime());
        assertEquals("Jane", athlete.getFirstName());
        assertEquals("Jones", athlete.getLastName());
        assertEquals("F", athlete.getGender());
        assertEquals(16, athlete.getAge());
        assertEquals(LocalDateTime.of(2017,8,15,14, 33, 45), athlete.getFinishTime());
        assertEquals(LocalDateTime.of(2017, 8, 15, 14,33,45), athlete.getStartTime());
        assertEquals(680.067495971265, athlete.getLocation(), 0.0001);
 
    }

}
