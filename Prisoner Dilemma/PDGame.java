package src;

/* Author: Cody McAntire
 * 
 * The PDGame class contains an array list for keeping the user history
 * an array list of strings for each strategy implemented
 * a gamestat null reference object that will be filled with game stats, a scanner, 
 *  and an int to determine the computers strategy
 * 
 */
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class PDGame {
  //array list for keeping the user history
  private ArrayList<Integer> userHistory = new ArrayList<>();
  
  //array list of strings for each strategy implemented
  private ArrayList<String> compStrat = new ArrayList<>();
  
  //a gamestat reference object that will be filled with game stats
  private GameStat gameStats = new GameStat();
  
  //a scanner
  public Scanner scan;
 
  //PDGame constructor to read file of ones and twos which will be used as computers strategy
  public PDGame(String file) {
    //add 3 strats to ArrayList
    compStrat.add("From File");  
	compStrat.add("Tit-For-Tat");
	compStrat.add("Random");

	try {
	  File input = new File(file); //check if input file exists
	  scan = new  Scanner(input); //initialize scanner
	}//end try
	catch (FileNotFoundException e) { //if file does not exist
	  System.out.println("No input file found "); //let user know
	  System.exit(0); //end program
	}//end catch
  }//end constructor
  
  
  //method that generates the computers decision based on the strategy selected
  public String playRound(int Decision) {
    int computer;
    int user; 
    
    int  compDecision = findStrat();
    userHistory.add(Decision); //add decision to the userHistory array list
    
    //calculate scores
    if (Decision == 1 && compDecision == 1) {
      computer = 2;
      user = 2;
      
      gameStats.update(user,computer); //update game stats
      return "You and your partner remain silent. \n\nYou both get 2 years in prison. \n";

    }else if (Decision == 2 && compDecision == 1) {
      computer = 5;
      user = 1;
        
      gameStats.update(user,computer); //update game stats
      return "You testify against your partner and they remain silent. \n\nYou get 1 year in prison and they get 5. \n";

    }else if (Decision == 1 && compDecision == 2) {
       computer = 1;
       user = 5;
          
       gameStats.update(user,computer); //update game stats
       return "You remain silent and your partner testifies against you. \n\nYou get 5 year in prison and they get 1. \n";

    }else //(Decision == 2 && compDecision == 2) 
      {
        computer = 3;
        user = 3;
        
        gameStats.update(user,computer); //update game stats
        return "You both testify against each other \n\nYou both get 3 years in prison\n";
      }//end if else statements
  }//end playRound
  
  
  //method to determine which strategy the computer used
  private int findStrat() {
	//Strat 1. Find File
	if(Strategy == 1) {
	  return scan.nextInt();	
	}//end strat 1
	
	//Strat 3. Random
	else if(Strategy == 3) {
	  return(int)(Math.random()*2+1);  //generate random int between 1 and 2	
	}//end strat 3
	
	//Strat 2. Tit-For-Tat
	else if(userHistory.isEmpty()) {
	  return 1; //cooperate on first move	
	}
	else {
	  int lastChoice = userHistory.get(userHistory.size() - 1); //get players last move
	  return lastChoice; //computer plays last choice
	}//end strat 2
	
  }//end findStrat
  
  
  //get and set for strategies
  private int Strategy;
  public ArrayList<String> getStrats(){
	return compStrat;
  }
  public void setStrats(int Strategy) {
	this.Strategy = Strategy;  
    gameStats.setComputerStrategy(compStrat.get(Strategy - 1));
  }
  public GameStat getStat() {
	return gameStats;
  }
  
  //getScores returns a string message indicating what the final scores are
  public String getScores() {
	return "Your prison sentence is: " + gameStats.getUserSentence() + " \nYour partner's prison sentence is: " + gameStats.getCompSentence();
  }//end getScores
  
  
}//end PDGame class
