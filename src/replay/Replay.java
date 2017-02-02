package replay;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import pong.PongPanel;

public class Replay {
  private List<State> stateList = null;
  int listIndex = 0;
  PongPanel pongPanel;
  int i;
  
  public Replay() {
    stateList = new ArrayList<State>();
    i = 0;
  }
  
  public Replay(int i) {
    stateList = new ArrayList<State>();
    this.i=i;
  }

  public void addState(int playerOneY, int playerTwoY, int ballX, int ballY,
      int playerOneScore, int playerTwoScore) {
    stateList.add(new State(playerOneY, playerTwoY, ballX, ballY, playerOneScore, playerTwoScore));
  }
  
  public void setPongPanel(PongPanel pongPanel){
    this.pongPanel = pongPanel;
  }
  
  public void writeToFile() throws IOException {
    if (pongPanel == null) {
      return;
    }
    i++;
    System.out.println("asfasfa");
    FileOutputStream fileOutput = new FileOutputStream("replays/"+Integer.toString(i)+".rep");
    ObjectOutputStream objectOut = new ObjectOutputStream(fileOutput);
    
    for (int i = 0; i < stateList.size(); ++i) {
      objectOut.writeObject(stateList.get(i));
    }

    objectOut.flush();
    objectOut.close();
    fileOutput.flush();
    fileOutput.close();
  }
  
  public void readFromFile(String replayName) throws IOException, ClassNotFoundException {

    FileInputStream fileInput = new FileInputStream("replays/" + replayName + ".rep");
    ObjectInputStream objectInput = new ObjectInputStream(fileInput);
    
    System.out.println(replayName+"read");

    while (true) {
      State state;
      try {
        state = (State) objectInput.readObject();
      } catch (EOFException e) {
        break;
      }

      if (state == null) {
        break;
      }

      stateList.add(state);
    }
  }
  
  public void stopReplay() {
    stateList = new ArrayList<State>();
  }
  
  /*
   * Controls game object using values from loaded list
   */
  public void startReplay() {
    if (listIndex == stateList.size()) {
      return;
    }
    pongPanel.setPlayerOneY(stateList.get(listIndex).getPlayerOneY());
    pongPanel.setPlayerTwoY(stateList.get(listIndex).getPlayerTwoY());
    pongPanel.setBallX(stateList.get(listIndex).getBallX());
    pongPanel.setBallY(stateList.get(listIndex).getBallY());
    pongPanel.setPlayerOneScore(stateList.get(listIndex).getPlayerOneScore());
    pongPanel.setPlayerTwoScore(stateList.get(listIndex).getPlayerTwoScore());
    listIndex++;
  }
}
