package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
  public static void main(String[] args) throws Exception {
    final Menu menu = new Menu();
    final JFrame menu1 = new JFrame(); // Menu
    menu.jframe(menu1);
    JPanel panelMenu = new JPanel();
    panelMenu.setBackground(Color.BLUE);
    panelMenu.setLayout(null);
    JLabel tittle_text = new JLabel("PING-PONG");
    Font font1 = new Font("Courier New", Font.PLAIN, 125);
    tittle_text.setFont(font1);
    tittle_text.setSize(825, 100);
    tittle_text.setLocation(50, 50);
    tittle_text.setForeground(Color.BLACK);
    final JButton easy = new JButton("Easy");
    menu.buttons(easy, 100, 275);
    JButton normal = new JButton("Normal");
    menu.buttons(normal, 100, 350);
    JButton hard = new JButton("Hard");
    menu.buttons(hard, 100, 425);
    JButton players1 = new JButton("One Player");
    menu.buttons(players1, 500, 315);
    JButton automatic_mode = new JButton("Automatic");
    menu.buttons(automatic_mode, 500, 385);
    JButton button_exit = new JButton("Exit");
    menu.buttons(button_exit, 300, 500);
    button_exit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    menu.start(menu1, easy, menu1, 10, 5); // Easy mode
    menu.start(menu1, normal, menu1, 20, 3); // Normal mode
    menu.start(menu1, hard, menu1, 30, 2); // Hard mode

    PongPanel pongPanelOne = new PongPanel(30, 5, 1); // One Player
    JFrame playOnePLayers = new JFrame("Pong");
    menu.jframe(playOnePLayers);
    JButton menuPlayerOne = new JButton("Menu");
    menuPlayerOne.setSize(75, 50);
    menuPlayerOne.setLocation(350, 15);
    menuPlayerOne.setBackground(Color.GREEN);
    menuPlayerOne.setForeground(Color.RED);

    PongPanel pongPanelAutomatic = new PongPanel(30, 5, 0); // Automatic Mode
    JFrame playAutomatic = new JFrame("Pong");
    menu.jframe(playAutomatic);
    JButton menuPlayerAutomatic = new JButton("Menu");
    menuPlayerAutomatic.setSize(75, 50);
    menuPlayerAutomatic.setLocation(350, 15);
    menuPlayerAutomatic.setBackground(Color.GREEN);
    menuPlayerAutomatic.setForeground(Color.RED);

    menu.active(automatic_mode, menu1, playAutomatic);
    menu.active(menuPlayerAutomatic, playAutomatic, menu1);
    menu.active(players1, menu1, playOnePLayers);
    menu.active(menuPlayerOne, playOnePLayers, menu1);

    panelMenu.add(tittle_text);
    pongPanelOne.add(menuPlayerOne);
    playOnePLayers.add(pongPanelOne);
    playAutomatic.add(pongPanelAutomatic);
    pongPanelAutomatic.add(menuPlayerAutomatic);
    menu1.add(panelMenu);
    panelMenu.add(easy);
    panelMenu.add(normal);
    panelMenu.add(hard);
    panelMenu.add(players1);
    panelMenu.add(automatic_mode);
    panelMenu.add(button_exit);
    menu1.setVisible(true);
  }
}
