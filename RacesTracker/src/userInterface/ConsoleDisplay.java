package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import raceTracker.Athlete;
import raceTracker.AthleteSet;
import raceTracker.Observer;

public class ConsoleDisplay extends Display implements Observer{
	private AthleteSet athletes;
	private Athlete athlete;

	private JFrame frame;
	private JPanel mainPanel;
	private ConsoleDisplay instance;
	private ArrayList<Integer> subjects = new ArrayList<Integer>(); 

	private Display decorator;

	public ConsoleDisplay(AthleteSet athletes) {
		this.instance = this;
		this.athletes = athletes;
		this.decorator = this;
		
		//Start GUI
		initializeGui();
	}

	public void update(Athlete athlete) {
		this.athlete = athlete;
		System.out.println(decorator.getInfo());
	}
	
	private void initializeGui(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Console Display");
		frame.setSize(325,150);
		frame.setLocationRelativeTo(null);
		mainPanel = new JPanel();
	    JLabel subjectsLabel = new JLabel("Watching Atheletes: " + subjects);
		JTextField subscribeText = new JTextField(5);
		JButton subscribeButton = new JButton("Subscribe");
		subscribeButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	athletes.get(Integer.parseInt(subscribeText.getText())).subscribe(instance);
	        	subjects.add(Integer.parseInt(subscribeText.getText()));
	        	subjectsLabel.setText("Watching Atheletes: " + subjects);
	        }
	    });
		
		JButton unsubscribeButton = new JButton("Unsubscribe");
		unsubscribeButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	athletes.get(Integer.parseInt(subscribeText.getText())).unsubscribe(instance);
	        	subjects.remove(athletes.get(Integer.parseInt(subscribeText.getText())));
	        	subjectsLabel.setText("Watching Atheletes: " + subjects);
	        	frame.repaint();
	        }
	    });
		
		JButton addNameButton = new JButton("Show Names");
		addNameButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	decorator = new NameDecorator(decorator);
	        }
	    });
		mainPanel.add(addNameButton);
		
		JButton addStatusButton = new JButton("Show Status");
		addStatusButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	decorator = new StatusDecorator(decorator);
	        }
	    });
		mainPanel.add(addStatusButton);

		mainPanel.add(subscribeText);
		mainPanel.add(subscribeButton);
		mainPanel.add(unsubscribeButton);
		mainPanel.add(unsubscribeButton);
	    mainPanel.add(subjectsLabel);
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
	public Athlete getAthlete(){
		return athlete;
	}
	
	public String getInfo(){
		return "Bib: " + Integer.toString(athlete.getBibNumber());
	}

}
