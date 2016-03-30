package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PongPanelTwoPlayer extends JPanel implements ActionListener {
  private boolean upPressed = false;
  private boolean downPressed = false;
  private boolean wPressed = false;
  private boolean sPressed = false;
  private boolean playing = false;
  private boolean gameOver = false;
  private boolean Bot = false;
  private boolean automatic = false;

  private int ballX = 50;
  private int ballY = 250;
  private int diameter = 20;
  private int ballDeltaX = -3;
  private int ballDeltaY = 3;

  private int playerOneX = 25;
  private int playerOneY = 250;
  private int playerOneWidth = 10;
  private int playerOneHeight = 150;

  private int playerTwoX = 775;
  private int playerTwoY = 250;
  private int playerTwoWidth = 10;
  private int playerTwoHeight = 150;

  private int paddleSpeed = 5;
  private int playerOneScore = 0;
  private int playerTwoScore = 0;

  String playerNameOne = "Player 1";
  String playerNameTwo = "Player 2";

  public PongPanelTwoPlayer(int Speed, int PaddleSpeed, int Players) {
    if (Players == 1)
      Bot = true;
    else if (Players == 0)
      automatic = true;
    paddleSpeed = PaddleSpeed;
    setBackground(Color.GREEN);
    Timer timer = new Timer(100 / Speed, this);
    timer.start();
    addKeyListener(new Keyboard<Object>());
    setFocusable(true);
  }

  public void actionPerformed(ActionEvent e) {
    step();
  }

  public void step() {
    if (playing) {
      if (automatic == false) {
        if (Bot == false) {
          // move player 1
          if (upPressed) {
            if (playerOneY - paddleSpeed > 45) {
              playerOneY -= paddleSpeed;
            }
          }
          if (downPressed) {
            if (playerOneY + paddleSpeed + playerOneHeight < getHeight()) {
              playerOneY += paddleSpeed;
            }
          }
        } else {
          if (ballY + playerOneHeight < getHeight())
            playerOneY = ballY;
        }

        // move player 2
        if (wPressed) {
          if (playerTwoY - paddleSpeed > 45) {
            playerTwoY -= paddleSpeed;
          }
        }
        if (sPressed) {
          if (playerTwoY + paddleSpeed + playerTwoHeight < getHeight()) {
            playerTwoY += paddleSpeed;
          }
        }
      } else {
        if (ballY + playerOneHeight < getHeight() && ballY + playerTwoHeight < getHeight()) {
          playerOneY = ballY;
          playerTwoY = ballY;
        }
      }
      // where will the ball be after it moves?
      int nextBallLeft = ballX + ballDeltaX;
      int nextBallRight = ballX + diameter + ballDeltaX;
      int nextBallTop = ballY + ballDeltaY;
      int nextBallBottom = ballY + diameter + ballDeltaY;

      int playerOneRight = playerOneX + playerOneWidth;
      int playerOneTop = playerOneY;
      int playerOneBottom = playerOneY + playerOneHeight;

      float playerTwoLeft = playerTwoX;
      float playerTwoTop = playerTwoY;
      float playerTwoBottom = playerTwoY + playerTwoHeight;
      // ball bounces off top and bottom of screen
      if (nextBallTop < 50 || nextBallBottom == getHeight()) {
        ballDeltaY *= -1;
      }

      if (nextBallLeft == playerOneRight) {
        // is it going to miss the paddle?
        if (nextBallTop > playerOneBottom || nextBallBottom < playerOneTop) {
          playerTwoScore++;
          playing = false;
          if (playerTwoScore == 5) {
            playing = false;
            gameOver = true;
          }
          playerOneY = 250;
          playerTwoY = 250;
          ballX = 50;
          ballY = 250;
        } else {
          ballDeltaX *= -1;
        }
      }

      // will the ball go off the right side?
      if (nextBallRight == playerTwoLeft) {
        // is it going to miss the paddle?
        if (nextBallTop >= playerTwoBottom || nextBallBottom <= playerTwoTop) {
          playerOneScore++;
          playing = false;
          if (playerOneScore == 5) {
            playing = false;
            gameOver = true;
          }
          playerOneY = 250;
          playerTwoY = 250;
          ballX = 740;
          ballY = 250;
        } else {
          ballDeltaX *= -1;
        }
      }

      if (nextBallRight == getWidth()) {
        ballDeltaX *= -1;
      }

      // move the ball
      ballX += ballDeltaX;
      ballY += ballDeltaY;
    }
    // stuff has moved, tell this JPanel to repaint itself
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (playing == false && gameOver != true) {
      g.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
      g.drawString("Press 'SPACE' to play.", 250, 300);
    } else if (gameOver) {
      g.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
      if (playerOneScore > playerTwoScore)
        g.drawString("Player 1 Wins!", 325, 300);
      else
        g.drawString("Player 2 Wins!", 325, 300);
      g.drawString("Press 'R' to restart.", 290, 400);
    }
    int playerOneRight = playerOneX + playerOneWidth;
    int playerTwoLeft = playerTwoX;
    g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
    g.drawString(playerNameOne, 165, 40);
    g.drawString(playerNameTwo, 525, 40);
    // draw dashed line down center
    g.setColor(Color.BLACK);
    for (int lineY = 0; lineY < getHeight(); lineY += 50) {
      g.drawLine(400, lineY, 400, lineY + 25);
    }
    // draw "goal lines" on each side
    g.drawLine(playerOneRight, 0, playerOneRight, getHeight());
    g.drawLine(playerTwoLeft, 0, playerTwoLeft, getHeight());
    g.drawLine(35, 50, 775, 50);
    g.drawLine(35, 599, 775, 599);
    // draw the scores
    g.setFont(new Font(Font.DIALOG, Font.BOLD, 36));
    g.drawString(String.valueOf(playerOneScore), 50, 40);
    g.drawString(String.valueOf(playerTwoScore), 725, 40);
    // draw the boll and paddles
    g.setColor(Color.MAGENTA);
    g.fillOval(ballX, ballY, diameter, diameter);
    g.setColor(Color.RED);
    g.fillRect(playerOneX, playerOneY, playerOneWidth, playerOneHeight);
    g.setColor(Color.BLUE);
    g.fillRect(playerTwoX, playerTwoY, playerTwoWidth, playerTwoHeight);
  }

  private class Keyboard<keyPressed> extends KeyAdapter {
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
      if (gameOver != true) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
          if (playing == false) {
            playing = true;
          } else if (playing == true)
            playing = false;
        }
      }
      if (playing) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
          upPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
          downPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
          wPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          sPressed = true;
        }
      } else if (gameOver) {
        if (e.getKeyCode() == KeyEvent.VK_R) {
          gameOver = false;
          playerOneY = 250;
          playerTwoY = 250;
          ballX = 50;
          ballY = 250;
          playerOneScore = 0;
          playerTwoScore = 0;
        }
      }
    }

    public void keyReleased(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_W) {
        upPressed = false;
      } else if (e.getKeyCode() == KeyEvent.VK_S) {
        downPressed = false;
      } else if (e.getKeyCode() == KeyEvent.VK_UP) {
        wPressed = false;
      } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        sPressed = false;
      }
    }
  }
}

