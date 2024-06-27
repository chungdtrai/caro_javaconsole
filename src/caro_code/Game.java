package caro_code;

import java.util.Scanner;

public class Game {
	Board b1 = new Board();
	
	Player player1 = new Player("X");
	Player player2 = new Player("O");
	Player currentPlayer = player1;
	
	void play() {
		b1.addElements();
		String message = "enter the position(1-9)";
		while(true) {
			message = "enter the position(1-9)";
			System.out.println(currentPlayer.name + " " + message);
			Scanner input = new Scanner(System.in);
			int position = input.nextInt();
			if(b1.updateBoard(position, currentPlayer.type)) {
				b1.printBoard();
				if(b1.checkWinner(currentPlayer.type)) {
					System.out.println(currentPlayer.name + " is winner");
					System.exit(0);
				}else if(b1.checkDraw()) {
					System.out.println("Two player is draw");
					System.exit(0);
				}else {
					if(currentPlayer == player1) {
						currentPlayer = player2;
					}else {
						currentPlayer = player1;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}
}
