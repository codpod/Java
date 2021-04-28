package assignment6;

import javax.swing.JFrame;
import java.awt.BorderLayout;
//import java.awt.Component;

public class GraphicsFrame extends JFrame{

	public static void main(String[] args) {
		GraphicsFrame frame = new GraphicsFrame(); //create out frame and constructor puts large main panel over entire frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setName("Frame"); //name frame
		frame.setSize(745, 500); //size frame
		frame.setVisible(true); //make frame visible
	}//end main

	public GraphicsFrame() {//constructor
		super("Assignment 6"); //shows assignment 6 at top of tab
		MainPanel mainPanelPtr = new MainPanel(); //create main panel that will overwrite the frame. will add subpanels to the large main panel in its constructor
		super.add(mainPanelPtr, BorderLayout.WEST); //main panel covers entire frame
		
		BallAnimation mainPanelPtr2 = new BallAnimation(); 
		super.add(mainPanelPtr2, BorderLayout.EAST); //add to frame
	}//end constructor
}//end graphics frame
