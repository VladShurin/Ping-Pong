package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main{
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
		PING_PONG.setSize(825, 100);
		PING_PONG.setLocation(50, 50);
		PING_PONG.setForeground(Color.BLACK);
		final JButton Easy = new JButton("Easy");
		menu.buttons(Easy, 100, 275);
		JButton Normal = new JButton("Normal");
		menu.buttons(Normal, 100, 350);
		JButton Hard = new JButton("Hard");
		menu.buttons(Hard, 100, 425);
		JButton button_players1 = new JButton("One Player");
		menu.buttons(button_players1, 500, 315);
		JButton automatic_mode = new JButton("Automatic");
		menu.buttons(automatic_mode, 500, 385);
		JButton button_exit = new JButton("Exit");
		menu.buttons(button_exit, 300, 500);
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		menu.Start(Menu1, Easy, Menu1, 20, 5); // Easy mode
		menu.Start(Menu1, Normal, Menu1, 35, 3); // Normal mode
		menu.Start(Menu1, Hard, Menu1, 40, 2); // Hard mode
		
		PongPanelTwoPlayer pongPanelOne = new PongPanelTwoPlayer(30, 5, 1); //One Player
		JFrame PlayOnePLayers = new JFrame("Pong");
		menu.jframe(PlayOnePLayers);
		JButton MenuPlayerOne = new JButton("Menu");
		MenuPlayerOne.setSize(75, 50);
		MenuPlayerOne.setLocation(350, 15);
		MenuPlayerOne.setBackground(Color.GREEN);
		MenuPlayerOne.setForeground(Color.RED);
		
		PongPanelTwoPlayer pongPanelAutomatic = new PongPanelTwoPlayer(30, 5, 0); //Automatic Mode
		JFrame PlayAutomatic = new JFrame("Pong");
		menu.jframe(PlayAutomatic);
		JButton MenuPlayerAutomatic = new JButton("Menu");
		MenuPlayerAutomatic.setSize(75, 50);
		MenuPlayerAutomatic.setLocation(350, 15);
		MenuPlayerAutomatic.setBackground(Color.GREEN);
		MenuPlayerAutomatic.setForeground(Color.RED);
		
		menu.active(automatic_mode, Menu1, PlayAutomatic);
		menu.active(MenuPlayerAutomatic, PlayAutomatic, Menu1);
		menu.active(button_players1, Menu1, PlayOnePLayers);
		menu.active(MenuPlayerOne, PlayOnePLayers, Menu1);
		
		panelMenu.add(PING_PONG);
		pongPanelOne.add(MenuPlayerOne);
		PlayOnePLayers.add(pongPanelOne);
		PlayAutomatic.add(pongPanelAutomatic);
		pongPanelAutomatic.add(MenuPlayerAutomatic);
		Menu1.add(panelMenu);
		panelMenu.add(Easy);
		panelMenu.add(Normal);
		panelMenu.add(Hard);
		panelMenu.add(button_players1);
		panelMenu.add(automatic_mode);
		panelMenu.add(button_exit);
		Menu1.setVisible(true);

	}
}