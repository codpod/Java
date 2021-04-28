public class GameStat {
  //private ints to track sentence and rounds
  String compStrategy;
  int userSentence;
  int compSentence;
  int rounds;

  
  //getComputerStrategy returns the string strategy computer used in the game
  public String getComputerStrategy() {
    return compStrategy;  
  }//end getComputerStrategy
  //set computer strategy
  public void setComputerStrategy(String compStrategy) {
	this.compStrategy = compStrategy;
  }
  
  //update Increments the stats and is called from pdgame
  public void update(int userSentence, int compSentence) {
	this.userSentence += userSentence;
	this.compSentence += compSentence;
	rounds++;
  }//end update
  //GameStat constructor sets sentences to 0
  public GameStat() {
	userSentence = 0;
	compSentence = 0;
	rounds = 0;
  }//end GameStat constructor
  //getWinner returns the winner of the game, after comparing the years of the player and computer
  public String getWinner() {
	if (userSentence < compSentence) {//if user has less prison time
		return "you, the player.\n"; //they win
	}//end player win
	else if (userSentence > compSentence) { //if computer has less prison time
		return "the computer.\n"; //computer wins
	}//end comp win
	else {
		return "no one! It's a tie!\n"; //if they have the same time its a tie
	}//end tie
  }//end getWinner

  //get sentences
  public int getUserSentence() {
	return userSentence;
  }
  public int getCompSentence() {
	return compSentence;
  }
  
  public int getRounds(){
	return rounds;
  }

}//end class GameStat
