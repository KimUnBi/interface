package com;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import javazoom.jl.player.MP3Player;

public class ChanceSelect {

	private String[] chance = { "ºÎÈ°", "ÆÐ½º", "´ë¸®ÀÎ", "²Î....." };
	private String[] mp3 = { this.getClass().getResource("resurrection.mp3").getPath(),
			this.getClass().getResource("pass.mp3").getPath(),this.getClass().getResource("agent.mp3").getPath(),
			this.getClass().getResource("failfail.mp3").getPath()
			};
	private Random random = new Random();
	private MP3Player mp3Player = new MP3Player();
	
	
	private JFrame frame;
	private JTable table;
	private JLabel result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChanceSelect window = new ChanceSelect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChanceSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		String tt = this.getClass().getResource("pbk.jpg").getPath();
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 817);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel label = new JLabel("\u3148\uC81C\uC82D\uC81C\uBC14\uBC1C\uBC14\u3142\u3142");
		springLayout.putConstraint(SpringLayout.EAST, label, -46, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel(new ImageIcon(tt));
		springLayout.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 49, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 572, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -54, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Java Festival \uCC2C\uC2A4 \uBF51\uAE30\u2605");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 28, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 49, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -694, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -54, SpringLayout.EAST, frame.getContentPane());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("³ª´®½ºÄù¾î", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel_1);

		table = new JTable();
		frame.getContentPane().add(table);

		JLabel lblVerMake = new JLabel("ver 1.0 Make. \uD638\uB450\uC544\uBE60");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 31, SpringLayout.SOUTH, lblVerMake);
		springLayout.putConstraint(SpringLayout.NORTH, lblVerMake, 16, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblVerMake, -160, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblVerMake, 34, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblVerMake, 0, SpringLayout.EAST, frame.getContentPane());
		lblVerMake.setFont(new Font("³ª´®½ºÄù¾î", Font.PLAIN, 15));
		frame.getContentPane().add(lblVerMake);

		JButton btnNewButton = new JButton("\uBF51\uAE30");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ChanceThread chanceThread = new ChanceThread();
				chanceThread.start();
			}
		});
		btnNewButton.setFont(new Font("³ª´®½ºÄù¾î Bold", Font.BOLD, 30));
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 114, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -24, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -121, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);

		result = new JLabel("\uACFC\uC5F0 \uACB0\uACFC\uB294..?");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 21, SpringLayout.SOUTH, result);
		result.setFont(new Font("³ª´®½ºÄù¾î Bold", Font.PLAIN, 29));
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, result, 25, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, result, -93, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, result, 77, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, result, -99, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(result);
	}

	public class ChanceThread extends Thread {

		@Override
		public void run() {
			int cnt = 0;
			if(mp3Player.isPlaying()) {
				mp3Player.stop();
			}

			mp3Player.play(this.getClass().getResource("winning.mp3").getPath());
			while (true) {
				try {
					Thread.sleep(50);
					cnt++;
					result.setText(chance[random.nextInt(chance.length)]);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (cnt == 50) {
					break;
				}
			}
			if (mp3Player.isPlaying()) {
				mp3Player.stop();
			}
			int num = random.nextInt(chance.length);
			result.setText("°á°ú : " + chance[num]);
			mp3Player.play(mp3[num]);

		}

	}
}
