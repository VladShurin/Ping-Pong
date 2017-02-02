package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pong.PongPanel;
import pong.PongPanel.StateReplay;
import pong.PongPanel.States;
import replay.Sort;

public class Main {
  static private States state;
  static private StateReplay stateReplay;
  static int range = 10;
  public static void main(String[] args) throws Exception {
   
    final Menu menu = new Menu();
    final JFrame Menu1 = new JFrame(); // Menu
    menu.jframe(Menu1);
    JPanel panelMenu = new JPanel();
    panelMenu.setBackground(Color.BLUE);
    panelMenu.setLayout(null);
    JLabel PING_PONG = new JLabel("PING-PONG");
    Font font1 = new Font("Courier New", Font.PLAIN, 125);
    PING_PONG.setFont(font1);
    PING_PONG.setSize(825, 75);
    PING_PONG.setLocation(50, 50);
    PING_PONG.setForeground(Color.BLACK);
    final JButton Easy = new JButton("Easy");
    menu.buttons(Easy, 50, 300);
    JButton Normal = new JButton("Normal");
    menu.buttons(Normal, 50, 350);
    JButton Hard = new JButton("Hard");
    menu.buttons(Hard, 50, 400);
    JButton button_players1 = new JButton("One Player");
    menu.buttons(button_players1, 50, 250);
    JButton automatic_mode = new JButton("Automatic");
    menu.buttons(automatic_mode, 50, 200);
    final JButton Replay = new JButton("Replay");
    menu.buttons(Replay, 500, 425);
    JButton button_exit = new JButton("Exit");
    menu.buttons(button_exit, 300, 500);
    button_exit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    menu.Start(Menu1, Easy, Menu1, 15, 5); // Easy mode
    menu.Start(Menu1, Normal, Menu1, 25, 3); // Normal mode
    menu.Start(Menu1, Hard, Menu1, 35, 2); // Hard mode

    PongPanel pongPanelOne = new PongPanel(30, 5, 1, false); // One Player
    JFrame PlayOnePLayers = new JFrame("Pong");
    menu.jframe(PlayOnePLayers);
    JButton MenuPlayerOne = new JButton("Menu");
    MenuPlayerOne.setSize(75, 50);
    MenuPlayerOne.setLocation(350, 15);
    MenuPlayerOne.setBackground(Color.GREEN);
    MenuPlayerOne.setForeground(Color.RED);

    PongPanel pongPanelAutomatic = new PongPanel(30, 5, 0, false); // Automatic Mode
    JFrame PlayAutomatic = new JFrame("Pong");
    menu.jframe(PlayAutomatic);
    JButton MenuPlayerAutomatic = new JButton("Menu");
    MenuPlayerAutomatic.setSize(75, 50);
    MenuPlayerAutomatic.setLocation(350, 15);
    MenuPlayerAutomatic.setBackground(Color.GREEN);
    MenuPlayerAutomatic.setForeground(Color.RED);

    Replay.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        PongPanel pongPanelReplay = new PongPanel(30, 5, 0, true);
        JFrame PlayReplay = new JFrame("Pong");
        menu.jframe(PlayReplay);
        JButton MenuPlayerReplay = new JButton("Menu");
        MenuPlayerReplay.setSize(75, 50);
        MenuPlayerReplay.setLocation(350, 15);
        MenuPlayerReplay.setBackground(Color.GREEN);
        MenuPlayerReplay.setForeground(Color.RED);
        menu.active(Replay, Menu1, PlayReplay);
        menu.active(MenuPlayerReplay, PlayReplay, Menu1);
        PlayReplay.add(pongPanelReplay);
        pongPanelReplay.add(MenuPlayerReplay);
        System.out.println("Первый игрок забил гол!!!");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        System.out.println("Второй игрок забил гол!!!");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        System.out.println("Второй игрок забил гол!!!");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        System.out.println("Первый игрок забил гол!!!");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        System.out.println("Второй игрок забил гол!!!");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        System.out.println("Второй игрок забил гол!!!");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        System.out.println("Второй игрок забил гол!!!");
      }
    });
    
    
    
    JLabel SCALA = new JLabel("Scala:");
    Font font2 = new Font("Courier New", Font.PLAIN, 30);
    SCALA.setFont(font2);
    SCALA.setSize(200, 75);
    SCALA.setLocation(420, 175);
    SCALA.setForeground(Color.BLACK);
    
    JLabel JAVA = new JLabel("Java:");
    JAVA.setFont(font2);
    JAVA.setSize(200, 75);
    JAVA.setLocation(630, 175);
    JAVA.setForeground(Color.BLACK);
    
    final JButton javaShortest = new JButton("shortest game");
    javaShortest.setBounds(600, 250, 150, 50);
    javaShortest.setBackground(Color.red);
    panelMenu.add(javaShortest);
    
    javaShortest.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        state = States.SORTING;
        stateReplay = StateReplay.BEST;
        Sort sort = new Sort(range);
        try {
          sort.readLengths();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        sort.javaSort();
        PongPanel pongPanelReplay = new PongPanel(30, 5, 0, true);
        JFrame PlayReplay = new JFrame("Pong");
        menu.jframe(PlayReplay);
        JButton MenuPlayerReplay = new JButton("Menu");
        MenuPlayerReplay.setSize(75, 50);
        MenuPlayerReplay.setLocation(350, 15);
        MenuPlayerReplay.setBackground(Color.GREEN);
        MenuPlayerReplay.setForeground(Color.RED);
        menu.active(javaShortest, Menu1, PlayReplay);
        menu.active(MenuPlayerReplay, PlayReplay, Menu1);
        PlayReplay.add(pongPanelReplay);
        pongPanelReplay.add(MenuPlayerReplay);
      }
    });
    
    final JButton javaLongest = new JButton("longest game");
    javaLongest.setBounds(600, 300, 150, 50);
    javaLongest.setBackground(Color.red);
    panelMenu.add(javaLongest);
    
    javaLongest.addActionListener(new ActionListener() {
      @SuppressWarnings("static-access")
      public void actionPerformed(ActionEvent e) {
        state = States.SORTING;
        stateReplay = stateReplay.WORST;
        Sort sort = new Sort(range);
        try {
          sort.readLengths();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        sort.javaSort();
        PongPanel pongPanelReplay = new PongPanel(30, 5, 0, true);
        JFrame PlayReplay = new JFrame("Pong");
        menu.jframe(PlayReplay);
        JButton MenuPlayerReplay = new JButton("Menu");
        MenuPlayerReplay.setSize(75, 50);
        MenuPlayerReplay.setLocation(350, 15);
        MenuPlayerReplay.setBackground(Color.GREEN);
        MenuPlayerReplay.setForeground(Color.RED);
        menu.active(javaLongest, Menu1, PlayReplay);
        menu.active(MenuPlayerReplay, PlayReplay, Menu1);
        PlayReplay.add(pongPanelReplay);
        pongPanelReplay.add(MenuPlayerReplay);
      }
    });
    
    final JButton scalaShortest = new JButton("shortest game");
    scalaShortest.setBounds(400, 250, 150, 50);
    scalaShortest.setBackground(Color.GREEN);
    panelMenu.add(scalaShortest);
    
    scalaShortest.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        state = States.SORTING;
        stateReplay = stateReplay.BEST;
        Sort sort = new Sort(range);
        try {
          sort.readLengths();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        sort.scalaSort();
        PongPanel pongPanelReplay = new PongPanel(30, 5, 0, true);
        JFrame PlayReplay = new JFrame("Pong");
        menu.jframe(PlayReplay);
        JButton MenuPlayerReplay = new JButton("Menu");
        MenuPlayerReplay.setSize(75, 50);
        MenuPlayerReplay.setLocation(350, 15);
        MenuPlayerReplay.setBackground(Color.GREEN);
        MenuPlayerReplay.setForeground(Color.RED);
        menu.active(scalaShortest, Menu1, PlayReplay);
        menu.active(MenuPlayerReplay, PlayReplay, Menu1);
        PlayReplay.add(pongPanelReplay);
        pongPanelReplay.add(MenuPlayerReplay);
      }
    });
    
    final JButton scalaLongest = new JButton("longest game");
    scalaLongest.setBounds(400, 300, 150, 50);
    scalaLongest.setBackground(Color.GREEN);
    panelMenu.add(scalaLongest);
    
    scalaLongest.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        state = States.SORTING;
        stateReplay = stateReplay.WORST;
        Sort sort = new Sort(range);
        
        try {
          sort.readLengths();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        sort.scalaSort();
        PongPanel pongPanelReplay = new PongPanel(30, 5, 0, true);
        JFrame PlayReplay = new JFrame("Pong");
        menu.jframe(PlayReplay);
        JButton MenuPlayerReplay = new JButton("Menu");
        MenuPlayerReplay.setSize(75, 50);
        MenuPlayerReplay.setLocation(350, 15);
        MenuPlayerReplay.setBackground(Color.GREEN);
        MenuPlayerReplay.setForeground(Color.RED);
        menu.active(scalaLongest, Menu1, PlayReplay);
        menu.active(MenuPlayerReplay, PlayReplay, Menu1);
        PlayReplay.add(pongPanelReplay);
        pongPanelReplay.add(MenuPlayerReplay);

      }
    });

    menu.active(automatic_mode, Menu1, PlayAutomatic);
    menu.active(MenuPlayerAutomatic, PlayAutomatic, Menu1);
    menu.active(button_players1, Menu1, PlayOnePLayers);
    menu.active(MenuPlayerOne, PlayOnePLayers, Menu1);

    panelMenu.add(PING_PONG);
    panelMenu.add(SCALA);
    panelMenu.add(JAVA);
    pongPanelOne.add(MenuPlayerOne);
    pongPanelOne.add(Replay);
    PlayOnePLayers.add(pongPanelOne);

    PlayAutomatic.add(pongPanelAutomatic);
    pongPanelAutomatic.add(MenuPlayerAutomatic);
    Menu1.add(panelMenu);
    panelMenu.add(Easy);
    panelMenu.add(Normal);
    panelMenu.add(Hard);
    panelMenu.add(Replay);
    panelMenu.add(button_players1);
    panelMenu.add(automatic_mode);
    panelMenu.add(button_exit);
    Menu1.setVisible(true);
  }
}
