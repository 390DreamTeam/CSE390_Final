package gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class plyrBoard extends JFrame {
	private Container contents;
	private static Color missed = Color.BLUE;
	private static Color hit = Color.RED;
	private static Color water = Color.CYAN;
	private static Color ship = Color.DARK_GRAY;

	private static JPanel[][] board = new JPanel[10][13];

	//Array to store x and y coordinates of a shot
	static int shot[] = new int[2];



	public plyrBoard() {
		setTitle("Enemy Player");
		contents = getContentPane();
		contents.setLayout(new GridLayout(10,13));
		board[0][0] = new JPanel();
		contents.add(board[0][0]);

		for (int i = 1; i < 13; i++) {
			JLabel label = new JLabel(Character.toString((char) (i+64)));
			board[0][i] = new JPanel();
			board[0][i].add(label);
			contents.add(board[0][i]);
		}


		for (int i = 1; i < 10; i++) {
			int k = 0;
			JLabel label = new JLabel(Integer.toString(i));
			board[i][0] = new JPanel();
			board[i][0].add(label);
			contents.add(board[i][k]);
			while (k < 12) {
				k++;
				board[i][k] = new JPanel();
				board[i][k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				//board[i][k] = '~';
				board[i][k].setBackground(water);
				contents.add(board[i][k]);
			}
		}
	}

	public static void shotSent(boolean good, int[] shot) {
		if (good) {
			board[shot[0]][shot[1]].setBackground(hit);
		} else {
			board[shot[0]][shot[1]].setBackground(missed);
		}
	}
}

