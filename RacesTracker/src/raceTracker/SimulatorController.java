package raceTracker;

import Exceptions.ApplicationException;
import Racedata.IAthleteUpdateHandler;
import Racedata.SimulatedDataSource;

public class SimulatorController {
	private SimulatedDataSource simulatedData = null;
	private IAthleteUpdateHandler handler;

	public void run(String inputFileName){
		this.handler = new DataProcessor();
		simulatedData = new SimulatedDataSource();
		simulatedData.setInputFilename(inputFileName);
		simulatedData.setHandler(handler);
		
		try {
			simulatedData.Start();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void stop(){
		simulatedData.Stop();
	}
	
	public IAthleteUpdateHandler getHandler(){
		return this.handler;
	}
}
