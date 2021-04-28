package assignment6;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class MainPanel extends JPanel implements ActionListener{

	static final String[] imageStringNameA = {"Images/pat1.gif","Images/pat2.gif", "Images/pat3.gif", "Images/pat4.gif", "Images/pat5.gif"};//access image files
	private final JLabel LABEL1 = new JLabel("Choose a color template here:  "); //tell user to pick a patch
	private final JLabel LABEL2 = new JLabel("Click a square to place the patch you chose!\n"); //tell user what to do with it
	static Image[] imageA = new Image[5];//image arr holds 5 possible images of gifs we load using toolkit code only one copy needed
	
	final TileGridPanel tileGridPanelPtr = new TileGridPanel(); //pointer to a panel yellow area where we will "paint" items on a tile Grid
	
	JButton patch1btn, patch2btn, patch3btn, patch4btn, patch5btn, resetbtn; //need to declare 5 buttons for tool bar….and a reset button
	
	public MainPanel() {//constructor
		//code the toolkit shown earlier that loads the images into the one dimensional imageA
		this.setLayout(new BorderLayout()); //we will add items to north, center, and south on main panel
		this.add(tileGridPanelPtr, BorderLayout.CENTER); //prepare center area of main panel that is yellow
		//CenterPanel.setBackground(Color.YELLOW);//Adding yellow centerPanel to mainPanel
		add(tileGridPanelPtr, BorderLayout.CENTER); //Adding yellow centerPanel to mainPanel.
		
		tileGridPanelPtr.add(LABEL2); //show user message
		tileGridPanelPtr.ResetGridTile(); //reset grid and paint empty center area

		JPanel SouthPanel = new JPanel(); //also add panel with reset button to SOUTH of main panel
		SouthPanel.setLayout(new FlowLayout()); //arrange panel
		this.add(SouthPanel, BorderLayout.SOUTH); //add border to south
		SouthPanel.setBackground(Color.RED); //set south panel color to red
		resetbtn = new JButton("RESET"); //label button reset
		SouthPanel.add(resetbtn); //add button to panel
		
		tileGridPanelPtr.patchArray(); //set images on tool bar
		JToolBar MainPanelToolBar = new JToolBar(); //pointer to top tool bar for main panel
		MainPanelToolBar.add(LABEL1); //show user message on tool bar

		//prepare north orange area of main panel with tool bar and patch buttons
		patch1btn = new JButton(new ImageIcon(imageA[0]));  //this how you get a button with an image
		MainPanelToolBar.add(patch1btn); //add button to tool bar, do this for 5 buttons
		
		patch2btn = new JButton(new ImageIcon(imageA[1]));  //this how you get a button with an image
		MainPanelToolBar.add(patch2btn); //add button 2 to tool bar, do this for 5 buttons
		
		patch3btn = new JButton(new ImageIcon(imageA[2]));  //this how you get a button with an image
		MainPanelToolBar.add(patch3btn); //add button 3 to tool bar, do this for 5 buttons
		
		patch4btn = new JButton(new ImageIcon(imageA[3]));  //this how you get a button with an image
		MainPanelToolBar.add(patch4btn); //add button 4 to tool bar, do this for 5 buttons
		
		patch5btn = new JButton(new ImageIcon(imageA[4]));  //this how you get a button with an image
		MainPanelToolBar.add(patch5btn); //add button 5 to tool bar, do this for 5 buttons
		
		patch1btn.addActionListener(this);//sets up button 1 for listening, need 5 of them
		patch2btn.addActionListener(this);//sets up button 2 for listening
		patch3btn.addActionListener(this);//sets up button 3 for listening
		patch4btn.addActionListener(this);//sets up button 4 for listening
		patch5btn.addActionListener(this);//sets up button 5 for listening
		resetbtn.addActionListener(this);//sets up reset button for listening
		
		this.add(MainPanelToolBar, BorderLayout.NORTH); //set north border
		MainPanelToolBar.setBackground(Color.ORANGE); //make north area orange

		tileGridPanelPtr.ResetGridTile(); //reset grid and and paint empty center area		
	}//end constructor
	
	public void actionPerformed(ActionEvent e){  //put in listener method for button clicks on toolbar
		if (e.getSource() == resetbtn) {
			tileGridPanelPtr.ResetGridTile();
			tileGridPanelPtr.selectedTile = -1;
		}
		if (e.getSource() == patch1btn)  //was  button A  clicked in toolbar?
			tileGridPanelPtr.selectedTile = 0;  //this sets the variable in tileGridPanel object,  and do this check for the 5 possible patches they could chose
		if (e.getSource() == patch2btn)  //was  button A  clicked in toolbar?
			tileGridPanelPtr.selectedTile = 1;  //this sets the variable in tileGridPanel object
		if (e.getSource() == patch3btn)  //was  button A  clicked in toolbar?
			tileGridPanelPtr.selectedTile = 2;  //this sets the variable in tileGridPanel object
		if (e.getSource() == patch4btn)  //was  button A  clicked in toolbar?
			tileGridPanelPtr.selectedTile = 3;  //this sets the variable in tileGridPanel object
		if (e.getSource() == patch5btn)  //was  button A  clicked in toolbar?
			tileGridPanelPtr.selectedTile = 4;  //this sets the variable in tileGridPanel object
	}//end listener method
}// end main panel
