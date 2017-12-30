package userInterface;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import raceTracker.Athlete;
import raceTracker.AthleteSet;
import raceTracker.Observer;

public class ListDisplay implements Observer{
	private AthleteSet athletes;

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel statusPanel;

	public ListDisplay(AthleteSet athletes) {
		
		//Subscribe to AthleteSet
		this.athletes = athletes;
		for(Athlete athlete : athletes.getAthletes().values())
			athlete.subscribe(this);
		
		//Start GUI
		initializeGui();
		getPanel();
	}
	
	private void initializeGui(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("List Display");
		frame.setSize(350,350);
		frame.setLocationRelativeTo(null);
		mainPanel = new JPanel();
	}
	
	public void update(Athlete athlete) {
		getPanel();
	} 
	
	public JPanel getPanel(){
		mainPanel.removeAll();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		for(Athlete athlete : athletes.getAthletes().values()){
			JPanel panel = new JPanel() ;
			panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel bibLabel = new JLabel("Bib: " + Integer.toString(athlete.getBibNumber()));
			JLabel nameLabel = new JLabel("Name: " + athlete.getFirstName());
			JLabel statusLabel = new JLabel("Status: " + athlete.getStatus());
			panel.add(bibLabel);
			panel.add(nameLabel);
			panel.add(statusLabel);
			mainPanel.add(panel);
		}
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		frame.add(scrollPane);
		frame.repaint();
		frame.setVisible(true);

		return statusPanel;
	}

	
}
