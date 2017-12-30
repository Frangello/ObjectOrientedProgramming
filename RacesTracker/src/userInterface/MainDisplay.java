package userInterface;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import raceTracker.DataProcessor;
import raceTracker.SimulatorController;
import userInterface.ListDisplay;

public class MainDisplay {

	String raceFileName;
	
	public MainDisplay() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Race Tracker");
		frame.setSize(150,300);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JLabel raceLabel = new JLabel("Select Race");
		raceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(raceLabel);
		
		String[] racesString = { "Short Race Simulation-01.csv", "Century Simulation-01.csv" };
		JComboBox racesList = new JComboBox(racesString);
		racesList.setSelectedIndex(1);
		racesList.setAlignmentX(Component.CENTER_ALIGNMENT);
		racesList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JComboBox cb = (JComboBox)e.getSource();
                raceFileName = (String)cb.getSelectedItem();
            }
        });
		panel.add(racesList);
		
		JLabel simulatorStatus = new JLabel("Not Running");
		simulatorStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(simulatorStatus);

		SimulatorController s = new SimulatorController();
		JButton startButton = new JButton("Start Simulation");
		startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	s.run(raceFileName);
            	simulatorStatus.setText("Running");
            }
        });
		panel.add(startButton);
		
		JButton stopButton = new JButton("Stop Simulation");
		stopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.stop();
            	simulatorStatus.setText("Not Running");
            }
        });
		panel.add(stopButton);
		
		JButton listButton = new JButton("See All Athletes");
		listButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		listButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	new ListDisplay(((DataProcessor) s.getHandler()).getAthletes());
	        }
	    });
		panel.add(listButton);
		
		JButton consoleButton = new JButton("Print To Console");
		consoleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		consoleButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	new ConsoleDisplay(((DataProcessor) s.getHandler()).getAthletes());
	        }
	    });
		panel.add(consoleButton);
		
		JButton soundButton = new JButton("Finished Alert");
		soundButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		soundButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	new SoundDisplay(((DataProcessor) s.getHandler()).getAthletes());
	        }
	    });
		panel.add(soundButton);
		
		JButton emailButton = new JButton("Email Updates");
		emailButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		emailButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	new EmailDisplay(((DataProcessor) s.getHandler()).getAthletes());
	        }
	    });
		panel.add(emailButton);
		
		frame.add(panel);

		frame.setVisible(true);
	}
	

}
