package assignment6;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Graphics;
import javax.swing.JPanel;


/*  TileGridPanel.java  (this is the yellow area in the middle,
 *  we listen for mouse events which is when user clicks 
 *  anywhere on yellow area and then draw the grid with selectedTile
 *  they previously chosen)
 */

class TileGridPanel extends JPanel implements MouseListener {

	int selectedTile = -1; //this is set to 0-4 when user clicks on a button in toolbar in mainpanel
	static final int squareSide = 25; 
	final int GridRow=5,GridCol=5; //create 5x5 grid
	
	int startX, startY; //where grid will begin
	int gridW, gridH; //grid width and height
	
	Image[][] gif2dArray = new Image[GridRow][GridCol]; //we take gifs in here and draw in tilegrid
		
	public TileGridPanel() {	//constructor
		this.addMouseListener(this);  //tells this panel we have routines for mousevents interface
		this.setBackground( Color.yellow ); //make main/center panel yellow	
	}//end constructor
	
	public void patchArray(){
		for (int i = 0; i < MainPanel.imageA.length; i++){
			MainPanel.imageA[i] = (Image) Toolkit.getDefaultToolkit().getImage(MainPanel.imageStringNameA[i]);
		}
	}
	
	public void mouseClicked(MouseEvent event) { //user has click  in the yellow center panel
		// loop to fill the gif2darray above with the selected image out of MainPanel.imagaA[]
		if(selectedTile >= 0) {
			int x = event.getX();
			int y = event.getY();
			
			if(x >= startX && x <= startX + gridW && y >= startY && y <= startY + gridH) {
				int xin = (x - startX) / squareSide;
				int yin = (y - startY) / squareSide;
				gif2dArray[xin][yin] = MainPanel.imageA[selectedTile];
				
				this.repaint(); //show new grid with images from 2D array
			}
		}
	}//end mouse clicked
	
	public void ResetGridTile() { //reset the grid tile
		for (int i = 0; i < GridRow; i++) { // in/out loop to set all to null
			for (int j = 0; j < GridCol; j++) {
				gif2dArray[i][j] = null; 
			}
		}
		this.repaint(); //draw empty grid
	}//end reset grid tile
	
	
	@Override
	public void paintComponent(Graphics g) { //paints the center panel with elements in 2D array
		super.paintComponent(g);
		gridW = GridCol * squareSide; //need to find center area of the center panel
		gridH = GridRow * squareSide;
		int panelWidth = getWidth();
		int panelHeight = getHeight();
		startX = (panelWidth - gridW) / 2; //get starting point to draw grid based
		startY = (panelHeight - gridH) / 2;
		
		//draw the 5x5 grid outline so user knows where to place the patches
		for (int row = 0; row < GridRow; row++) {
			for (int col = 0; col < GridCol; col++) {
				g.drawRect(startX + (squareSide * row), startY + (squareSide * col), squareSide, squareSide);
			}
		}
		
		//inner/ outer loop to copy gif image array over to the drawing grid with 
		for (int row = 0; row < GridRow; row++) {
			for (int col = 0; col < GridCol; col++) {
				g.drawImage(gif2dArray[row][col], startX+(squareSide*row), startY+(squareSide*col), this);
			}
		}
	}

	//- The type TileGridPanel must implement the inherited abstract method MouseListener.mouseEntered(MouseEvent)
	@Override
	public void mouseEntered(MouseEvent event) {
	}
	//- The type TileGridPanel must implement the inherited abstract method MouseListener.mouseReleased(MouseEvent)
	@Override
	public void mouseReleased(MouseEvent event) {	
	}
	//- The type TileGridPanel must implement the inherited abstract method MouseListener.mouseExited(MouseEvent)
	@Override
	public void mouseExited(MouseEvent event) {
	}
	//- The type TileGridPanel must implement the inherited abstract method MouseListener.mousePressed(MouseEvent)
	@Override
	public void mousePressed(MouseEvent event) {		
	}
}//end TileGridPanel