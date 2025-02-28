package caro;

import java.util.Scanner;


class Game {
	 
    Board b1 = new Board();
 
    Player player1 = new Player("X");
    Player player2 = new Player("O");
    Player currentPlayer = player1;
 
    // this method will be later used to play the game
    void play() {
 
        b1.addElements();
        // using an infinite loop to run the game
        // we will later add conditions to terminate the loop
        String message = "enter the position (1 - 9):";
 
        while (true) {
            try {
                message = "enter the position (1 - 9):";
                System.out.println(currentPlayer.name + " " + message);
                Scanner input = new Scanner(System.in);
                int position = input.nextInt();
 
                // the updateBoard() method return true if
                // the user selected position is not already filled
                if (b1.updateBoard(position, currentPlayer.type)) {
 
                    b1.printBoard();
 
                    // checking winner each time after updating the board
                    if (b1.checkWinner(currentPlayer.type)) {
                        System.out.println(currentPlayer.name + " wins!");
                        break;
                    }
 
                    // checking draw each time after updating the board
                    else if (b1.checkDraw()) {
                        System.out.println("Game is a draw!");
                        break;
                    }
 
                    // changing current player when board is updated
                    else {
                        if (currentPlayer == (player1)) {
                            currentPlayer = player2;
                        }
 
                        else {
                            currentPlayer = player1;
 
                        }
                    }
 
                }
 
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number between 1 and 9.");
            }
        }
 
    }
}