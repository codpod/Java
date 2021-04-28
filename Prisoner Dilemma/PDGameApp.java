package src;

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
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.InputMismatchException;
import java.util.Date;
import java.util.Set;


public class PDGameApp {
	
  public static void main(String[] args) {
	 
	//scanner to retrieve input from console  
    Scanner scan = new Scanner(System.in);
    
    //HashMap to store the GameStat objects from each PDGame
    HashMap<String, GameStat> hashMap = new HashMap<>();
    
    //name of file used for first strategy
    String file = "input.txt";
    
    //decision variable to be used when in game
    int decision = 0;
    
    //let user know a session has started
    System.out.println(" ***Starting A Session of Prisoner's Dilemma*** -5 rounds in this version of game- \n");
    
    //Set<String> keySet = hashMap.keySet();
    //force into loop to get a session going
    boolean playSession = true;
    //play loop
    while(playSession) {
      PDGame currentGamePtr1 = new PDGame(file); //fills in pointer above with current game to be played (5 rounds)
      //"get" pointer to strategy arraylist in PDGame
      ArrayList<String> compStrats = currentGamePtr1.getStrats(); 
      
      
      //show user the strategies avail in strategyArrayList
      System.out.println(" --HERE ARE STRATEGIES AVAILABLE FOR THE COMPUTER-- \n");
      ListIterator<String> it = compStrats.listIterator();
      //go through the arraylist
      int i = 1;
      while(it.hasNext()) {
    	String stratz = it.next(); //count will return next piece of content
    	System.out.println("    " + i + "." + stratz); //show the strategy
    	i++; //go through the rest
      }//end going through and displaying computer strategies
           
      //set the strategy (int) user chooses for their game in PDGame
      int rounds = 5; //initialize the total number of rounds, each game has 5
      System.out.println("\n\n Select a stretegy from above for the Computer to use in the " + rounds + " rounds:\n");  
      boolean stratSelect = true; 
      int userStrat = 0; //
      while(stratSelect) {
    	try {
    	  userStrat = scan.nextInt();
    	  if(userStrat > 0 && userStrat < 4) { //strategy can only be 1 - 3
    		stratSelect = false; //strategy has been selected
    	  }//end if
    	  else {
    		System.out.println(" Please enter a number between 1 and 3 to select a strategy.\n");
    	  }//end else  
    	}//end try
    	catch (InputMismatchException e) {
    	  scan.nextLine();
    	}//end catch
      }//end stratSelect
      
      
      //get pointer to gameStat object out of PDGame
      GameStat stats;
      stats = currentGamePtr1.getStat();
      
      
      //fill in hashMap entry with current date/time and the gameStatPtr
      String date = (new Date()).toString();
      hashMap.put(date, stats);
      
      
      //play 5 rounds: in each round get users choice/decision (1 or 2), and call method:...
      currentGamePtr1.setStrats(userStrat); 
      int numRounds = 0; //set variable for number of rounds to 0
      
      while(numRounds < rounds) {
    	//display choices
    	System.out.println(" BEGIN A ROUND - Here are your 2 choices \n");
    	System.out.println(" 1. Remain silent. \n");
    	System.out.println(" 2. Betray and testify against. \n\n");
    	System.out.println(" ...What is your decision this round? \n");
    	
    	boolean choice = true;
    	while(choice) { 
    	  try {
    		decision = scan.nextInt();
    		if(decision == 1 || decision == 2) {
    		  choice = false; //input was correct	
    		}//end if
    		else {
    		  System.out.println(" Please choose either 1 or 2 to make a decision. \n"); //let user know how to enter correct input	
    		}//end else
    	  }//end try
    	  catch (InputMismatchException e) {
    		scan.nextLine(); 
    	  }//end catch
    	}//end while in choice
    	
    	//show the results each round
    	String result = currentGamePtr1.playRound(decision);
    	System.out.println(result); 
    	numRounds++; 	  
      }//end of while in game
      
      //indicate to user the game has ended
      System.out.println(" -- END OF ROUNDS. GAME OVER  --");
      //Call getScores() method in PDGame to receive String with totals and who won and lost
      System.out.println(currentGamePtr1.getScores());
      
      //ask user if they want to keep playing in this session?.. 
      System.out.println(" -- Would you like to play another game in this session (y/n)? ");
      String Continue = scan.next(); //move scanner read answer
      //in case input is wrong...
      while((!Continue.equalsIgnoreCase("y")) && (!Continue.equalsIgnoreCase("Y")) && (!Continue.equalsIgnoreCase("n")) && (!Continue.equalsIgnoreCase("N"))){
    	System.out.println(" Enter 'y' to keep playing or 'n' to quit."); //repeat the option
    	Continue = scan.next(); //get answer
      }//end continue
      //...If no, playSession=false
      if((Continue.equalsIgnoreCase("n")) && (Continue.equalsIgnoreCase("N"))) {
        playSession = false;    
      }//end if no
	
    }//end playSession
    
    //print out the hashMap with a for:each showing all the dates and times of games played with winner and strat
    System.out.println("\n\n           Summary of games and session time:       \n\n");
    Set<String> keySet = hashMap.keySet();
    for(String searchKey : keySet) {
      GameStat statResult = hashMap.get(searchKey);
      System.out.println(searchKey + "\nWinner is -- " + statResult.getWinner()+ "The strategy the computer used was " + statResult.getComputerStrategy() + ".\n"); //print time, winner, and strategy used
    }//end key
    
    
  scan.close();  
  }//end main
}//end PDGameApp


  