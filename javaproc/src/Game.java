public class Game {
	
	Integer[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	private String player1;
	private String player2;
	
	public Game(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	//Prints board while still in play
	public void printBoard() {
		System.out.println(" " + xo(1) + " | " + xo(2) + " | " + xo(3) + " ");
		System.out.println("-----------");
		System.out.println(" " + xo(4) + " | " + xo(5) + " | " + xo(6) + " ");
		System.out.println("-----------");
		System.out.println(" " + xo(7) + " | " + xo(8) + " | " + xo(9) + " ");
	}
	
	//Provides symbols (X, O, or number) for printBoard()
	private String xo(int spot) {

			switch (board[spot-1]) {
			case 1:
				return "X";
			case 2:
				return "O";
			}
		
		return spot + "";
		
	}
	
	//Prints board WITHOUT numbers for after win
	public void printBoardWin() {
		System.out.println(" " + xoWin(1) + " | " + xoWin(2) + " | " + xoWin(3) + " ");
		System.out.println("-----------");
		System.out.println(" " + xoWin(4) + " | " + xoWin(5) + " | " + xoWin(6) + " ");
		System.out.println("-----------");
		System.out.println(" " + xoWin(7) + " | " + xoWin(8) + " | " + xoWin(9) + " ");
	}
	
	//Provides spaces or symbols for printBoardWin()
	private String xoWin(int spot) {

		switch (board[spot-1]) {
		case 1:
			return "X";
		case 2:
			return "O";
		}
	
	return " ";
	
}
	
	//Assigns number to spot in board, doesn't let the play choose a taken space
	public boolean player1Turn(int spot) {
		
		if (board[spot-1] == 0) {
			board[spot-1] = 1;
			return true;
		} else {
			System.out.println("This spot is taken! Try again.");
			return false;
		}
		
	}
	
	public boolean player2Turn(int spot) {
		
		if (board[spot-1] == 0) {
			board[spot-1] = 2;
			return true;
		} else {
			System.out.println("This spot is taken! Try again.");
			return false;
		}
		
	}
	
	//Shows if there is a win
	public boolean isWin() {
		
		if (board[0] != 0) {
			
			//Across top row
			if (board[0] == board[1] && board[0] == board[2]) {
				return true;
			}
			//Across left column
			if (board[0] == board[3] && board[0] == board[6]) {
				return true;
			}
			//Across left diagonal
			if (board[0] == board[4] && board[0] == board[8]) {
				return true;
			}
			
		}
		
		if (board[2] != 0) {
			
			//Across right column
			if (board[2] == board[5] && board[2] == board[8]) {
				return true;
			}
			//Across right diagonal
			if (board[2] == board[4] && board[2] == board[6]) {
				return true;
			}
			
		}
		
		//Across middle row
		if (board[3] != 0 && board[3] == board[4] && board[3] == board[5] ) {
			return true;
		}
		
		//Across bottom row
		if (board[6] != 0 && board[6] == board[7] && board[6] == board[8] ) {
			return true;
		}
		
		//Across middle column
		if (board[1] != 0 && board[1] == board[4] && board[1] == board[7] ) {
			return true;
		}
		
		return false;
		
	}
	
	//if all spots are full and there is no win, then tie
	public boolean isTie() {
		
		for (int i = 0; i < 9; i++) {
			if (board[i] == 0) {
				return false;
			}
		}
		
		return true;
		
	}

}