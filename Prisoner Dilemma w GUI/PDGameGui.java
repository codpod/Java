

/* Author: Cody McAntire
 * Assignment 3
 * Due: 02/21/21
 * JAVA 470
 * 
 * The PDGameApp class provides an interface for user input.
 * Within the main() method there is a Scanner to retrieve input from the console
 * a PDGame osbject will control the play of each game
 * a HashMap will store the GameStat objects from each PDGame
 * 
 */

import java.util.HashMap;
import java.util.Date;


import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class PDGameGui extends JFrame implements ActionListener, ListSelectionListener
{

	//instance variables for PDGameGui, all methods can access these
	private final DefaultListModel<String> listModelPtr = new DefaultListModel<String>();
		//default list model is the standard "mode for how Jlist will be operated, will put in next statement below
	
	//this is list on top left side and will show times of games played that user will click to see stats of a game
	//private JList<String>finishedGamesListPtr = newJList<String>(listModelPtr); //?
	private final JList<String>finishedGamesListPtr; // maybe use this?
	
	//this is large test area on right side
	private final JTextArea gameResultsTA = new JTextArea(15,30);
	
	private PDGame currentPDGame = null;
	private String gameStartTimeStr = null;
	private JComboBox<Object> computerStrategyCB=null;
	private final HashMap<String, GameStat> hashMap = new HashMap<>(); // keep same hashmap for games played
	
	
	//this will be filled in by the choice made by user in combo box
	private int computerStrategy = 1; 
	
	
	//below are text fields
	private final JTextField roundsTF = new JTextField(10);
	private final JTextField computerStrategyTF = new JTextField(10);
	private final JTextField playerSentenceTF = new JTextField(10);
	private final JTextField computerSentenceTF = new JTextField(10);
	private final JTextField winnerTF = new JTextField(10);
	
	
	private final JButton startB = new JButton("Start New Game");
	private final JButton buttonLB = new JButton("Remain Silent"); //left button
	private final JButton buttonRB = new JButton("Testify"); //right button
	private final JLabel decisionL = new JLabel("Your decision this round?"); //label to prompt user decision

	
	private final JLabel roundsPlayedL = new JLabel("Rounds Played");
	private final JLabel leftcomputerStrategyL = new JLabel("Computer Strategy");
	private final JLabel playerSentenceL = new JLabel("Player Sentence");
	private final JLabel computerSentenceL = new JLabel("Computer Sentence");
	private final JLabel winnerL = new JLabel("Winner");
	private final JLabel computerStrategyL = new JLabel("Computer Strategy-Combo Box");


	private final int NUM_ROUNDS = 5;
	
	public static void main(String[] args)
	{
		createAndShowGUI();
	}
	
	//create and show gui
	public static void createAndShowGUI()
	{
		//create and set up the window
		PDGameGui pdg1 = new PDGameGui(); //call constructor below to set the window to user
		pdg1.addListeners(); // method will add listeners to buttons
		pdg1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit game

		//display the window and pack together all the panels, etc
		pdg1.pack();
		pdg1.setVisible(true);
	}//end createAndShowGUI
	
	//constructor where you build the swing interface
	public PDGameGui()
	{
		super("Prisoner's Dilemma"); //fills in the menu are of jframe with message
		currentPDGame = new PDGame("input.txt");
		
		Color c1 = new Color(211,211,55); //set color 1 (higher numbers means lighter colors)
		//myPanel.setBackground(c1); // sets the color
		Color c2 = new Color(170,170,50); //set color 2
		
		
		super.setLayout(new BorderLayout()); //border layout container
		
		//make panel 1 (west yellow panel)
		JPanel panel1 = new JPanel(new BorderLayout());
		//"JList of Games holding a List Model"));
		super.add(panel1,BorderLayout.WEST); //add to frame
		finishedGamesListPtr = new JList<>(listModelPtr);
		//set up JLIST and put it in a scroll pane for scrolling
	    finishedGamesListPtr.setFont(new Font("SansSerif", Font.BOLD, 20)); //set font
	    finishedGamesListPtr.setVisibleRowCount(10); //set rows
	    finishedGamesListPtr.setFixedCellWidth(600); //set width
	    finishedGamesListPtr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
	    panel1.add(new JScrollPane(finishedGamesListPtr), BorderLayout.NORTH); //add scroll pane for scrolling
	    panel1.setBackground(c2); //set background color
	    
	    
	    //make panel 2 (southwest area)
	    JPanel panel2 = new JPanel();
	    panel2.setLayout(new GridLayout(5,2,5,5)); //create rows columns and gaps
	    
	    panel2.add(roundsPlayedL); //show label rounds played
	    panel2.add(roundsTF); //add text field
	    roundsTF.setEditable(false); //prevent user from adding text to wrong field
	    
	    panel2.add(leftcomputerStrategyL); //show label computer strategy  
	    panel2.add(computerSentenceTF); //add text field for computer sentence
	    computerStrategyTF.setEditable(false); //prevent user from adding text to wrong field
	    
	    panel2.add(playerSentenceL); //show player sentence header
	    panel2.add(playerSentenceTF); //add text field for player sentence
	    playerSentenceTF.setEditable(false); //prevent user from adding text to wrong field
	    
	    panel2.add(computerSentenceL); //show computer sentence header
	    panel2.add(computerSentenceTF); //add text field for computer sentence
	    computerSentenceTF.setEditable(false); //prevent user from adding text to wrong field
	    
	    panel2.add(winnerL); //show winner label
	    panel2.add(winnerTF); //add text field for winner
	    winnerTF.setEditable(false); //prevent user from adding text to wrong field
	    
	    panel2.setBackground(c2); //set background color
	    panel1.add(panel2, BorderLayout.SOUTH); //add it to the first panel
	    
	    TitledBorder title; //create title border
	    title = BorderFactory.createTitledBorder("List of Games"); //create bordered title for panel1
	    panel1.setBorder(title); //set to panel 1
	    
	    
	    //make panel 3 (east)
	    JPanel panel3 = new JPanel(new BorderLayout()); //create panel
	    super.add(panel3,BorderLayout.EAST); //add border layout to east panel
	    
	    
	    //make panel 4 (east)
	    JPanel panel4 = new JPanel(); //create panel for user to select strategy start game
	    panel4.setLayout(new GridLayout(2, 1)); //set a 2 by 1 grid
	    
	    
	    //make panel 5 (north east - above panel 4)
	    JPanel panel5 = new JPanel(new FlowLayout()); //creates center aligned object with horizontal and vertical gaps
	    panel5.add(computerStrategyL); //add computer strategy label
	    //two statements below prepare the combo box with computer strategies
	    //need to convert the strategies array list to an array and then it gets placed in combo box
	    Object[] strategyArray = currentPDGame.getStrats().toArray();//convert AL to array
	    computerStrategyCB = new JComboBox<Object>(strategyArray);   //place array in combo box
	    computerStrategyCB.setEditable(false); //prevent user from adding text to wrong field
	    computerStrategyCB.setSelectedIndex(0); //this sets starting value to first string in array
	    panel5.add(computerStrategyCB); //add combo box to panel 5
	    panel5.add(startB); //add start button to panel
	    panel5.setBackground(c1); //set background color
	    
	    
	    //make panel 6 (south)
	    JPanel panel6 = new JPanel(new FlowLayout());
	    panel6.add(decisionL); //add decision label

	    panel6.add(buttonLB); //add left button (silent)
	    panel6.add(buttonRB); //add right button(testify)
	    panel6.setBackground(c1); //set background color for panel 6
	    
	    
	    panel4.add(panel5); //add combo box to panel 4
	    panel4.add(panel6); //add decision buttons to panel 4
	    panel3.add(panel4, BorderLayout.NORTH); //add panel 4 to panel 3
	    panel3.add(new JScrollPane(gameResultsTA), BorderLayout.SOUTH); //add text area
	    
	    gameResultsTA.setEditable(false); //prevent user from adding text to wrong field
	    buttonLB.setEnabled(false); //restrict editing left button
	    buttonRB.setEnabled(false); //restrict editing right button
	    startB.setEnabled(true);  
	}//end PDGameGui constructor
	
	
	
	//hook up listeners to buttons
	public void addListeners()
	{
		computerStrategyCB.addActionListener(this); //Combo-Box button
		startB.addActionListener(this); //start button...do this for all buttons
		buttonLB.addActionListener(this); //remain silent button
		buttonRB.addActionListener(this); //testify button
		finishedGamesListPtr.addListSelectionListener(this); //the JLIST event listener code is addListSelectionListener		
	}//end addListeners
	
	
	//handles what button was clicked and what was chosen by combo box
	//calls appropriate method
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == startB) //when user presses start button
		{
			startGame(); //call function to start game
		}
		else if(e.getSource() == buttonLB) //when user chooses left button (silent)
		{
			cooperate(); //call cooperate
		}
		else if(e.getSource() == buttonRB) //when user chooses right button (betray)
		{
			betray(); //call betray
		}
		else if(e.getSource() == computerStrategyCB) //when user chooses an item in combo box, this handles it
		{
			computerStrategy = computerStrategyCB.getSelectedIndex() + 1; //fills in this variable up top
		}
	}//end action performed
	
	
	//methods that are called by actionPerformed
	public void startGame()
	{
		currentPDGame = new PDGame("input.txt"); //file to read from
		currentPDGame.setStrats(computerStrategy); //other strategies to use
		
		gameStartTimeStr = (new Date()).toString(); //convert date to string
		hashMap.put(gameStartTimeStr, currentPDGame.getStat()); //put hash map together
		
		buttonLB.setEnabled(true); //allow left button to be pressed
		buttonRB.setEnabled(true); //allow right button to be pressed
		startB.setEnabled(false);
		promptPlayer(); //call prompt player
	}//end start game
	
	//prompt player decision 
	public void promptPlayer()
	{
		String prompt = "\n 1. Remain silent. " + //show user first choice
				"\n 2. Betray and testify against." + //show user second choice
				"\n\n ...What is your decision this round? \n\n"; //ask user what they choose
		
		gameResultsTA.append(prompt); //display prompt to user at end of document
	}//end prompt player

	//when user chooses first option
	public void cooperate()
	{
		String results = currentPDGame.playRound(1); //string to return result
		gameResultsTA.append(results + "\n"); //display the result
		if(currentPDGame.getStat().getRounds() >= NUM_ROUNDS) //if all rounds have played
		{
			endGame(); //end the game
		}
		else //still rounds to be played
		{
			promptPlayer(); //prompt player to keep playing
		}
	}//end cooperate
	
	//when user chooses second option
	public void betray()
	{
		String results = currentPDGame.playRound(2); //string to return result
		gameResultsTA.append(results + "\n"); //display the result
		if(currentPDGame.getStat().getRounds() >= NUM_ROUNDS) //if all rounds have played
		{
			endGame(); //end the game
		}
		else //still rounds to be played
		{
			promptPlayer(); //prompt player to keep playing
		}
	}//end betray
	
	//when game is over
	public void endGame()
	{
		String endResults = currentPDGame.getScores(); //string for end of game scores
		gameResultsTA.append(endResults + "\n"); //display final scores
		hashMap.put(gameStartTimeStr, currentPDGame.getStat()); //put info in hash map
		listModelPtr.addElement(gameStartTimeStr); //put info into list
		
		buttonLB.setEnabled(false);
		buttonRB.setEnabled(false);
		startB.setEnabled(true);
	}//end end game
	
	//user has clicked on a finished game in upper left JList box
	//show results from game
	public void valueChanged(ListSelectionEvent e)
	{
		String searchKey; //declare search key
		if(!finishedGamesListPtr.isSelectionEmpty())
		{
			searchKey = (String)finishedGamesListPtr.getSelectedValue();//get out time of game and loop up in hash map
			GameStat gameStatsInfo; //
			gameStatsInfo = hashMap.get(searchKey); //get values from 
			
			roundsTF.setText(Integer.toString(gameStatsInfo.getRounds())); //display rounds played
			//roundsTF.setText(new Integer (gameStatsInfo.).toString());
			roundsTF.setFont(new Font("SansSerif",Font.BOLD,20)); 
			
			//player sentence
			int playerSentenceYrs = gameStatsInfo.getUserSentence();
			playerSentenceTF.setFont(new Font("SansSerif",Font.BOLD,20));
			playerSentenceTF.setText(String.format("%d %s", playerSentenceYrs,
					((playerSentenceYrs > 1) ? " years" : " year")));
			
			//computer sentence
			int compSentenceYrs = gameStatsInfo.getCompSentence();
			computerSentenceTF.setText(String.format("%d %s", compSentenceYrs, 
					((compSentenceYrs > 1) ? " years" : " years")));
			
			String win = gameStatsInfo.getWinner();
			winnerTF.setText(String.format("%s", win));
			
			
		}
	}
	
}//end PDGameGui














  