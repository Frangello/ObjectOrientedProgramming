package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import raceTracker.Athlete;
import raceTracker.AthleteSet;
import raceTracker.Observer;

public class EmailDisplay implements Observer{
	private AthleteSet athletes;

	private JFrame frame;
	private JPanel mainPanel;
	private EmailDisplay instance;
	private String emailAddress;
	private int count = 0;
	private ArrayList<Integer> subjects = new ArrayList<Integer>(); 

	public EmailDisplay(AthleteSet athletes) {
		this.instance = this;
		this.athletes = athletes;
		
		//Start GUI
		initializeGui();
	}

	public void update(Athlete athlete) {
		count++;
		if(count > 30){
			count = 0;
			sendEmail("Bib: " + Integer.toString(athlete.getBibNumber()) + "Status: " + athlete.getStatus());
		}
	}
	
	private void initializeGui(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Email Display");
		frame.setSize(325,150);
		frame.setLocationRelativeTo(null);
		mainPanel = new JPanel();
		JLabel emailLabel = new JLabel("Enter email to subscribe: ");
		JTextField emailText = new JTextField(25);
		this.emailAddress = emailText.getText();
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
		
		mainPanel.add(emailLabel);
		mainPanel.add(emailText);
		mainPanel.add(subscribeText);
		mainPanel.add(subscribeButton);
	    mainPanel.add(subjectsLabel);
	    
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
	private void sendEmail(String message){
		String to = emailAddress; 
	    String from = "test@gmail.com"; 
	    String host = "localhost";//or IP address  
	  
	     //Get the session object  
	    Properties properties = System.getProperties();  
	    properties.setProperty("mail.smtp.host", host);  
	    Session session = Session.getDefaultInstance(properties);  
	  
	     //compose the message  
	    try{  
	    	MimeMessage email = new MimeMessage(session);  
	    	email.setFrom(new InternetAddress(from));  
	    	email.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	    	email.setSubject("Race Tracking");  
	    	email.setText(message);  
	  
	         // Send message  
	    	Transport.send(email);  
	    	System.out.println("message sent successfully....");  
	    	}catch (MessagingException mex) {mex.printStackTrace();}  
	}  
}
