package replay;

import java.io.Serializable;

public class State implements Serializable {
  private int ballX;
  private int ballY;
  private int playerOneY;
  private int playerTwoY;
  private int playerOneScore;
  private int playerTwoScore;
  
  public State(int playerOneY, int playerTwoY, int ballX, int ballY,
      int playerOneScore, int playerTwoScore) {
    this.playerOneY = playerOneY;
    this.playerTwoY = playerTwoY;
    this.ballX = ballX;
    this.ballY = ballY;
    this.playerOneScore = playerOneScore;
    this.playerTwoScore = playerTwoScore;
  }
  
  public State() {
    this.playerOneY = 0;
    this.playerTwoY = 0;
    this.ballX = 0;
    this.ballY = 0;
    this.playerOneScore = 0;
    this.playerTwoScore = 0;
  }
  
  public int getPlayerOneY() {
    return playerOneY;
  }

  public void setPlayerOneY(int playerOneY) {
    this.playerOneY = playerOneY;
  }

  public int getPlayerTwoY() {
    return playerTwoY;
  }

  public void setPlayerTwoY(int playerTwoY) {
    this.playerTwoY = playerTwoY;
  }

  public int getBallX() {
    return ballX;
  }

  public void setBallX(int ballX) {
    this.ballX = ballX;
  }

  public int getBallY() {
    return ballY;
  }

  public void setBallY(int ballY) {
    this.ballY = ballY;
  }

  public int getPlayerOneScore() {
    return playerOneScore;
  }

  public void setPlayerOneScore(int playerOneScore) {
    this.playerOneScore = playerOneScore;
  }

  public int getPlayerTwoScore() {
    return playerTwoScore;
  }

  public void setPlayerTwoScore(int playerTwoScore) {
    this.playerTwoScore = playerTwoScore;
  }
}
