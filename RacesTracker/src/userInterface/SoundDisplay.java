package userInterface;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import raceTracker.Athlete;
import raceTracker.AthleteSet;
import raceTracker.Observer;

public class SoundDisplay implements Observer{
	private AthleteSet athletes;

	private JFrame frame;
	private JPanel mainPanel;
	private SoundDisplay instance;
	private ArrayList<Integer> subjects = new ArrayList<Integer>(); 

	public SoundDisplay(AthleteSet athletes) {
		this.instance = this;
		this.athletes = athletes;
		
		//Start GUI
		initializeGui();
	}

	public void update(Athlete athlete) {
		if(athlete.getStatus().toString().equals("Finished")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(frame, athlete.getBibNumber() + " Finished");
		}
	}
	
	private void initializeGui(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sound Display");
		frame.setSize(325,150);
		frame.setLocationRelativeTo(null);
		mainPanel = new JPanel();
		JTextField subscribeText = new JTextField(5);
		JButton subscribeButton = new JButton("Subscribe");
	    JLabel subjectsLabel = new JLabel("Watching Atheletes: " + subjects);
		subscribeButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	athletes.get(Integer.parseInt(subscribeText.getText())).subscribe(instance);
	        	subjects.add(Integer.parseInt(subscribeText.getText()));
	        	subjectsLabel.setText("Watching Atheletes: " + subjects);
	        }
	    });
		
		mainPanel.add(subscribeText);
		mainPanel.add(subscribeButton);
	    mainPanel.add(subjectsLabel);
		frame.add(mainPanel);
		frame.setVisible(true);
	}
}
