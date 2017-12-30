package raceTracker;

import Messages.AthleteUpdate;
import Messages.RegistrationUpdate;

public class RegisterUpdate extends Update {

	@Override
	public void update(AthleteSet athletes, AthleteUpdate update) {
		Athlete athlete = new Athlete();
		athlete.setBibNumber(update.getBibNumber());
		athlete.setFirstName(((RegistrationUpdate) update).getFirstName());
		athlete.setLastName(((RegistrationUpdate) update).getLastName());
		athlete.setGender(((RegistrationUpdate) update).getGender());
		athlete.setAge(((RegistrationUpdate) update).getAge());
		athlete.setStatus(update.getUpdateType());
		athlete.setUpdateTime(update.getTimestamp());
		athletes.add(athlete);
	}

}
