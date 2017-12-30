package raceTracker;

import Messages.AthleteUpdate;

public class StartedUpdate extends Update {

	@Override
	public void update(AthleteSet athletes, AthleteUpdate update) {
		Athlete athlete = athletes.get(update.getBibNumber());
		athlete.setStatus(update.getUpdateType());
		athlete.setUpdateTime(update.getTimestamp());
		athlete.setStartTime(((Messages.StartedUpdate) update).getOfficialStartTime());
	}

}
