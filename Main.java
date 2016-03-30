package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Main{
	private static int speed = 30; 
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
		JButton button_players2 = new JButton("Two Players");
		menu.buttons(button_players2, 300, 275);
		JButton button_players1 = new JButton("One Player");
		menu.buttons(button_players1, 300, 350);
		JButton button_settings = new JButton("Settings");
		menu.buttons(button_settings, 300, 425);
		JButton button_exit = new JButton("Exit");
		menu.buttons(button_exit, 300, 500);
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JFrame Settings = new JFrame(); // Settings
		menu.jframe(Settings);
		JPanel panelSettings = new JPanel();
		panelSettings.setBackground(Color.BLUE);
		panelSettings.setLayout(null);
		final JRadioButton EasyRadioButton = new JRadioButton("Easy");
		menu.radioButtons(EasyRadioButton, 100, 50, 250, 225);
		final JRadioButton NormalRadioButton = new JRadioButton("Normal");
		menu.radioButtons(NormalRadioButton, 100, 50, 300, 225);
		NormalRadioButton.setSelected(true);
		final JRadioButton HardRadioButton = new JRadioButton("Hard");
		menu.radioButtons(HardRadioButton, 100, 50, 350, 225);
		JLabel Difficulty = new JLabel("Difficulty:");
		menu.labels(Difficulty, 200, 50, 300, 25, 30);
		JButton button_back = new JButton("Back");
		menu.buttons(button_back, 300, 500);
		JLabel settings = new JLabel("SETTINGS");
		settings.setFont(font1);
		settings.setSize(825, 100);
		settings.setLocation(100, 50);
		settings.setForeground(Color.BLACK);
		
		EasyRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean Easy = false;
				Easy = EasyRadioButton.isSelected();
				if(Easy == true){
					NormalRadioButton.setSelected(false);
					HardRadioButton.setSelected(false);
					speed = 10;
				}
			}
		});
		NormalRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean Normal = false;
				Normal = NormalRadioButton.isSelected();
				if(Normal == true){
					EasyRadioButton.setSelected(false);
					HardRadioButton.setSelected(false);
					speed = 20;
				}
				
			}
		});
		HardRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean Hard = false;
				Hard = HardRadioButton.isSelected();
				if(Hard == true){
					EasyRadioButton.setSelected(false);
					NormalRadioButton.setSelected(false);
					speed = 40;	
				}
			}
		});
		
		PongPanel pongPanelTwo = new PongPanel(speed, 2); //Two Players
		final JFrame PlayTwoPLayers = new JFrame("Pong");
		menu.jframe(PlayTwoPLayers);
		JButton MenuPlayerTwo = new JButton("Menu");
		MenuPlayerTwo.setSize(75, 50);
		MenuPlayerTwo.setLocation(350, 15);
		MenuPlayerTwo.setBackground(Color.GREEN);
		MenuPlayerTwo.setForeground(Color.RED);
		
		PongPanel pongPanelOne = new PongPanel(speed, 1); //One Player
		final JFrame PlayOnePLayers = new JFrame("Pong");
		menu.jframe(PlayOnePLayers);
		JButton MenuPlayerOne = new JButton("Menu");
		MenuPlayerOne.setSize(75, 50);
		MenuPlayerOne.setLocation(350, 15);
		MenuPlayerOne.setBackground(Color.GREEN);
		MenuPlayerOne.setForeground(Color.RED);
	
		menu.active(button_settings, Menu1, Settings);
		menu.active(button_back, Settings, Menu1);
		menu.active(button_players2, Menu1, PlayTwoPLayers);
		menu.active(MenuPlayerTwo, PlayTwoPLayers, Menu1);
		menu.active(button_players1, Menu1, PlayOnePLayers);
		menu.active(MenuPlayerOne, PlayOnePLayers, Menu1);

		Settings.add(settings);
		panelMenu.add(PING_PONG);
		pongPanelTwo.add(MenuPlayerTwo);
		PlayTwoPLayers.add(pongPanelTwo);
		pongPanelOne.add(MenuPlayerOne);
		PlayOnePLayers.add(pongPanelOne);
		
		Settings.add(panelSettings);
		panelSettings.add(HardRadioButton);
		panelSettings.add(NormalRadioButton);
		panelSettings.add(Difficulty);
		panelSettings.add(EasyRadioButton);
		panelSettings.add(button_back);
		Menu1.add(panelMenu);
		panelMenu.add(button_players2);
		panelMenu.add(button_players1);
		panelMenu.add(button_settings);
		panelMenu.add(button_exit);
		Menu1.setVisible(true);

	}
}