package assignment6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BallAnimation extends JPanel implements ActionListener{
	AnimationPanel AnimationPanelPtr; //an animation  panel to display the animation (this is white area with balls)	
	JButton startbtn, stopbtn; // a pair buttons to start and stop the animation

	public BallAnimation(){ //constructor statement
		this.setLayout(new BorderLayout());
		startbtn = new JButton("Start"); //create start button
		stopbtn  = new JButton("Stop"); //create stop button
		JPanel southPanel = new JPanel(); //make south panel for buttons
		southPanel.setLayout(new FlowLayout());
		
		southPanel.add(startbtn); //add buttons to south panel
		southPanel.add(stopbtn);
		this.add(southPanel, BorderLayout.SOUTH);
		southPanel.setBackground(Color.MAGENTA); //set background color behind start and stop buttons
		startbtn.addActionListener(this); //add action listeners 
		stopbtn.addActionListener(this);		
		AnimationPanelPtr = new AnimationPanel();
		this.add(AnimationPanelPtr,BorderLayout.NORTH); //add layout to north of panel
	}//end ball animation constructor
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startbtn) { //if source of the action event is the start button
			stopbtn.setEnabled(true); //enable the stop button
			startbtn.setEnabled(false); //disable the start button
			AnimationPanelPtr.start(); //call the start method of the animation panel to start the animation
		}
		else if(e.getSource() == stopbtn) { //if the source of the action event is the stop button
			startbtn.setEnabled(true); //enable the start button
			stopbtn.setEnabled(false); //disable the stop button
			AnimationPanelPtr.stop(); //call the stop method of the animation panel to stop the animation
		}
	}//end action performed
}//end ball animation class