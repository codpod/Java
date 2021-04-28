package assignment6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class AnimationPanel extends JPanel implements Runnable{
	ArrayList<Ball> ballList = new ArrayList<Ball>(); //arrayList of Ball object
	Dimension dimObjPtr = null; //a reference to a dimension object that is initially set to null
	Thread threadObjPtr = null; //reference to thread object, initially null
	public AnimationPanel() {
		Dimension dim = new Dimension(350,425); //fit to appropriate size
		this.setPreferredSize(dim);
		this.setBackground(Color.WHITE); //set right side of panel white
	}//end animation panel
	
	public void start() { 
		if(threadObjPtr == null) { //if the thread reference is null
		threadObjPtr = new Thread(this);//create a new thread object 
		threadObjPtr.start();  //and call its start() method to make it runnable
		}
	}//end start method
	
	public void stop(){
		threadObjPtr = null;//set the thread reference to null. this will cause the loop in the run() method to exit. once the loop is finished, the method is finished as well, so the thread will terminate
		}//end stop method

	public void run() { //this is effectively the "main" method that will run in separate background thread
		while (threadObjPtr != null) {
			try {
				Thread.sleep(100); //put thread sleep for short amount of time
			}
			catch(InterruptedException e) {
				System.out.println("Exception error occured while trying to run"); //display error
			}
			this.repaint(); //repaint will eventually result in paintComponent being executed
		}
	}//end run method
	
	@Override
	protected void paintComponent(Graphics g){ //should be overridden
		super.paintComponent(g);
		if (dimObjPtr == null){ // if dimension object reference is null
			dimObjPtr = this.getSize();

			Ball ball1 = new Ball(Color.GREEN, 13, dimObjPtr.width -110, dimObjPtr.height - 90, 6, -7); //create the balls
			Ball ball2 = new Ball(Color.YELLOW, 25, dimObjPtr.width -90, dimObjPtr.height - 100, 8, 20);
			Ball ball3 = new Ball(Color.BLUE, 15, dimObjPtr.width -200, dimObjPtr.height - 250, -50, -30);
			Ball ball4 = new Ball(Color.RED, 8, dimObjPtr.width -200, dimObjPtr.height - 300, -25, 20);
			Ball ball5 = new Ball(Color.BLACK, 20, dimObjPtr.width -180, dimObjPtr.height - 400, -21, -10);
			Ball ball6 = new Ball(Color.CYAN, 27, dimObjPtr.width -150, dimObjPtr.height - 150, 16, -27);
			Ball ball7 = new Ball(Color.MAGENTA, 23, dimObjPtr.width -190, dimObjPtr.height  - 350, -35, 15);

			ballList.add(ball1); //add balls to array list
			ballList.add(ball2);
			ballList.add(ball3);
			ballList.add(ball4);
			ballList.add(ball5);	
			ballList.add(ball6);	
			ballList.add(ball7);	
		}//end loop when dimension object pointer no longer null
		for(Ball b : ballList) { //for each ball, call move and draw method
			b.move(dimObjPtr); //call move, passing the dimensions of the panel to the method
			b.draw(g); //call draw, passing the graphics context to the method
		}
	}//end paint component
}//end animation panel class