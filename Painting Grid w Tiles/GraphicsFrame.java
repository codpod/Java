package assignment5;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class GraphicsFrame extends JFrame{

	public static void main(String[] args) {
		GraphicsFrame frame = new GraphicsFrame(); //create out frame and constructor puts large main panel over entire frame
		frame.setName("Frame"); //name frame
		frame.setSize(400, 400); //size frame
		frame.setVisible(true); //make frame visible
	}//end main

	public GraphicsFrame() {//constructor
		super();
		MainPanel mainPanelPtr = new MainPanel(); //create mainpanel that will overwrite the frame. will add subpanels to the large main panel in its constructor
		this.add(mainPanelPtr, BorderLayout.CENTER); //main panel covers entire frame
	}//end constructor
	
}//end graphics frame
