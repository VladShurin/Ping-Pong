package pong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends KeyAdapter {
  void jframe(JFrame frame) {
    frame.setUndecorated(true);
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.setLocationRelativeTo(null);
  }

  void buttons(JButton buttons, int corX, int corY) {
    Font font = new Font("segoe print", Font.BOLD, 27);
    buttons.setBackground(Color.GREEN);
    buttons.setForeground(Color.RED);
    buttons.setSize(200, 50);
    buttons.setLocation(corX, corY);
    buttons.setCursor(new Cursor(Cursor.HAND_CURSOR));
    buttons.setFont(font);
  }

  void labels(JLabel label, int sizeX, int sizeY, int corY, int corX, int _font) {
    Font font = new Font("Verdana", Font.BOLD, _font);
    label.setFont(font);
    label.setSize(sizeX, sizeY);
    label.setLocation(corX, corY);
    label.setForeground(Color.GREEN);
  }

  void active(JButton button, final JFrame frame1, final JFrame frame2) {
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        frame2.setVisible(true);
      }
    });
  }

  void start(final JFrame closeFrame, JButton button, final JFrame Menu, final int speed,
      final int speed_paddle) {
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JButton MenuPlayerTwo = new JButton("Menu");
        MenuPlayerTwo.setBackground(Color.GREEN);
        MenuPlayerTwo.setForeground(Color.RED);
        // Two Players
        Menu menu = new Menu();
        PongPanel pongPanelTwo = new PongPanel(speed, speed_paddle, 2);
        final JFrame PlayTwoPLayers = new JFrame("Pong");
        menu.jframe(PlayTwoPLayers);
        closeFrame.setVisible(false);
        PlayTwoPLayers.setVisible(true);
        menu.active(MenuPlayerTwo, PlayTwoPLayers, Menu);
        PlayTwoPLayers.add(pongPanelTwo);
        PlayTwoPLayers.add(pongPanelTwo);
        pongPanelTwo.add(MenuPlayerTwo);
      }
    });
  }
}
