package assignment6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Ball {
	Color color;  //color
	int radius = 10;   //radius
	int x = 10; int y = 10;     //coordinates
	int dx = 25; int dy = 36;   //movement

	Ball(Color col, int rad, int x, int y, int dx, int dy){ //constructor statement
		this.color = col;
		this.radius = rad;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;	
	}//end ball constructor
	
	public void move(Dimension dimObjPtr) { //move function
		if(x <= radius || x >= (dimObjPtr.width - (2 * radius))) //checks to see if ball has hit edge of panel
			dx = -dx; //if so, switch x direction
		if(y <= radius || y >= (dimObjPtr.height - (2 * radius))) //check if ball hit top or bottom
			dy = -dy; //switch y direction
		
		x += dx; //continue moving the ball in the direction and modify the coordinates to reflex the move
		y += dy;
	}//end move function
	
	public void draw(Graphics g) { //draws the ball in its new location, changing x and y each time
		g.setColor(color); //set the color to whatever the balls color was
		g.fillOval(x, y, 2 * radius, 2 * radius); //draws the ball in the new location
	}//end draw
}//end ball class