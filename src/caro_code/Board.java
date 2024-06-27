package caro_code;

import java.util.ArrayList;

public class Board {
	ArrayList board = new ArrayList<>();
	int count = 0;
	void addElements() {
		board.add(" ");
		board.add(" ");
		board.add(" ");
		board.add(" ");
		board.add(" ");
		board.add(" ");
		board.add(" ");
		board.add(" ");
		board.add(" ");
	}
	
	void printBoard() {
		System.out.println(" " + board.get(0) + " | " + board.get(1) + " | " + board.get(2));
		System.out.println("-----------");
		System.out.println(" " + board.get(3) + " | " + board.get(4) + " | " + board.get(5));
		System.out.println("-----------");
		System.out.println(" " + board.get(6) + " | " + board.get(7) + " | " + board.get(8));
	}
	
	boolean updateBoard(int position, String type) {
		boolean returnValue = false;
		try {
			if(board.get(position - 1).equals(" ")) {
				board.set(position-1, type);
				count = count + 1;
				returnValue = true;
			}else {
				System.out.println("Position already selected. Select another position");
				returnValue = false;
			}
		}catch (Exception e) {
			System.err.println("Invalid position! Please chose another one");
		}
		return returnValue;
	}
	
	boolean checkDraw() {
		if(count == 9) {
			return true;
		}
		return false;
	}
	
	boolean checkWinner(String type) {
		if ((board.get(0).equals(type) && board.get(1).equals(type) && board.get(2).equals(type))
                || (board.get(3).equals(type) && board.get(4).equals(type) && board.get(5).equals(type))
                || (board.get(6).equals(type) && board.get(7).equals(type) && board.get(8).equals(type))
                || (board.get(0).equals(type) && board.get(3).equals(type) && board.get(6).equals(type))
                || (board.get(1).equals(type) && board.get(4).equals(type) && board.get(7).equals(type))
                || (board.get(2).equals(type) && board.get(5).equals(type) && board.get(8).equals(type))
                || (board.get(0).equals(type) && board.get(4).equals(type) && board.get(8).equals(type))
                || (board.get(2).equals(type) && board.get(4).equals(type) && board.get(6).equals(type))) {
            return true;
        }
		return false;
	}
}
