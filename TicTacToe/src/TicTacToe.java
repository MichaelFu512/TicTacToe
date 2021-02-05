import java.util.Scanner;

public class TicTacToe {
	private static final int firstSpot = 1;
	private static final int thirdSpot = 3;
	
	private static final int fRow = 0;
	private static final int sRow = 2;
	private static final int tRow = 4;
	
	private static final int fCol = 0;
	private static final int sCol = 2;
	private static final int tCol = 4;
	
	private static final char X = 'X';
	private static final char O = 'O';
	
	private static final String oWins = "O wins!";
	private static final String xWins = "X wins!";

	/*
	 * Initializes the gameBoard
	 * Runs the game until someone wins
	 * 
	 */
	public static void main(String[] args) {
		boolean gameDone = false;
	
		char[][] gameBoard = 
			    {{' ' , '|', ' ', '|', ' '}, //row 1 [0] columns = [0][2][4]
				{'-' , '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '},  //row 2 [2] columns = [0][2][4]
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};  //row 3 [4] columns = [0][2][4]

		printGameBoard(gameBoard);
		char p1 = chooseSymbol(X, O);
		char p2 = ' ';
		if(p1 == X) {
			p2 = O;
		}
		else {
			p2 = X;
		}
		while(gameDone == false) {
			choiceOfPositioning(gameBoard, p1);
			gameDone = checkGameState(gameBoard, X, O);
			
			if(gameDone == true) {
				break;
			}
			
			choiceOfPositioning(gameBoard, p2);
			gameDone = checkGameState(gameBoard, X, O);
		}
		System.out.println("FINAL BOARD");
		printGameBoard(gameBoard);
	}
	
	/*
	 * Asks the user to choose which symbol they want to be
	 * 
	 * @param 	x = the char 'x'
	 * @param 	o = the char 'o'
	 * 
	 * @return	whatever symbol the user chooses
	 */
	public static char chooseSymbol(char x, char o) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.print("What letter do you want to be (X | O)? ");
		char symbol = scan.next().trim().charAt(0);
		while(Character.toUpperCase(symbol) != x && Character.toUpperCase(symbol) != o) {
			System.out.println("Error: Not a valid symbol, try again!");
			System.out.print("What letter do you want to be? (X | O) ");
			symbol = scan.next().charAt(0);
		}
		symbol = Character.toUpperCase(symbol);
		System.out.println("You are " + symbol + "!");

		return symbol;
	}

	
	/*
	 * Checks if anyone has won yet
	 * 
	 * @param 	gameBoard = the board
	 * @param 	x = the char 'x'
	 * @param	o = the char 'o'
	 * 
	 * @return	true if someone won, false otherwise
	 */
	public static boolean checkGameState(char[][] gameBoard, char x, char o) {
		boolean gameEnd = verticalCheck(gameBoard, x, o);
		
		if(!gameEnd) {
			gameEnd = horizontalCheck(gameBoard, x, o);
			
			if(gameEnd) {
				return gameEnd;
			}
			
			gameEnd = diagonalCheck(gameBoard, x, o);
			
			if(gameEnd) {
				return gameEnd;
			}
			
			gameEnd = isBoardFull(gameBoard);
		}
		return gameEnd;
	}
	
	/*
	 * Checks if the board is full
	 * 
	 * @param	gameBoard = the board
	 * 
	 * @return	true if board is filled and there is no winner, false otherwise
	 */
	public static boolean isBoardFull(char[][] gameBoard) {
		boolean boardFull = true; // used to remember if board is full
		
		//loops through entire board looking for an empty space
		for(char[] x : gameBoard) {
			for(char c : x) {
				
				//if there is an empty space, then board is not full
				if(c == ' ') {
					boardFull = false;
				}
			}	
		}
		
		//if board is full, the game is over
		if(boardFull) {
			System.out.println("Board is full. DRAW!");
		}
		
		return boardFull;
	}
	
	/*
	 * Performs the diagonal checks to determine a winner
	 * Calls upDiagCheck and downDiagCheck
	 * 
	 * @param	gameBoard = the bard
	 * @param 	x = the char 'x'
	 * @param 	o = the char 'o'
	 * 
	 * @return	true if someone won diagonally, false otherwise
	 */
	public static boolean diagonalCheck(char[][] gameBoard, char x, char o) {
		boolean check = false;
		check = upDiagCheck(gameBoard, x, o);
		if(check) {
			return true;
		}
		
		check = downDiagCheck(gameBoard, x, o);
		if(check) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * x - -
	 * - x -
	 * - - x
	 * Checks for the above
	 * 
	 * @param	gameBoard = the board
	 * @param 	x = the char 'x'
	 * @param 	o = the char 'o'
	 * 
	 * @return	true if someone like above, false otherwise
	 */
	public static boolean upDiagCheck(char[][] gameBoard, char x, char o) {
		char checker = gameBoard[fRow][fCol];
		if(checker == ' ' ) {
			return false;
		}
		//this check checks [2][2], [4][4]
		for(int i = sRow; i <= tRow; i+= 2) {
			if(gameBoard[i][i] != checker) {
				return false;
			}
		}
		
		if(checker == x) {
			System.out.println(xWins);
		}
		else {
			System.out.println(oWins);
		}
		
		return true;
	}
	
	/*
	 * - - x
	 * - x -
	 * x - -
	 * Checks for the above
	 * 
	 * @param	gameBoard = the board
	 * @param 	x = the char 'x'
	 * @param 	o = the char 'o'
	 * 
	 * @return	true someone won through the above, false otherwise
	 */
	public static boolean downDiagCheck(char[][] gameBoard, char x, char o) {
		char checker = gameBoard[fRow][tCol];
		if(checker == ' ' ) {
			return false;
		}
		
		//check [2][2]
		if(gameBoard[sRow][sCol] != checker) {
			return false;
		}
		
		//check [4][0]
		if(gameBoard[tRow][fCol] != checker) {
			return false;
		}
		
		if(checker == x) {
			System.out.println(xWins);
		}
		else {
			System.out.println(oWins);
		}
		
		return true;
	}
	
	/*
	 *  x x x
	 *  - - -
	 *  - - -
	 * Checks for the above in all 3 rows
	 * 
	 * @param	gameBoard = the board
	 * @param 	x = the char 'x'
	 * @param 	o = the char 'o'
	 * 
	 * @return	true someone won through the above, false otherwise
	 */
	public static boolean horizontalCheck(char[][] gameBoard, char x, char o) {
		char checker = ' ';
		
		//outer for loop checks [0][x] , [2][x], [4][x] with x being the column number
		for(int i = fRow; i <= tRow; i+=2) {
			
			//set the checker to be [i][0]
			checker = gameBoard[i][fCol];
			if(checker == ' ') {
				continue;
			}
			
			//inner for loop checks [i][2], [i][4]
			for(int j = sCol; j <= tCol; j+=2) {
				char check = gameBoard[i][j];
				
				//if [i][x] != [i][0]
				if(check != checker) {
					break;
				}
				
				//if we made it to [i][4] someone won
				if(j == tCol) {
					if(checker == x) {
						System.out.println(xWins);
					}
					else {
						System.out.println(oWins);
					}
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * x - -
	 * x - -
	 * x - -
	 * Checks for the above in all 3 columns
	 * 
	 * @param	gameBoard = the board
	 * @param 	x = the char 'x'
	 * @param 	o = the char 'o'
	 * 
	 * @return	true someone won through the above, false otherwise
	 */
	public static boolean verticalCheck(char[][] gameBoard, char x, char o) {
		char checker = ' ';
		
		//outer for loop checks [x][i] with x being 0,2,4
		for(int i = fCol; i <= tCol; i+=2) {
			
			//set checker to be [0][i]
			checker = gameBoard[fRow][i];
			
			//go to next column if [0][i] is not a symbol
			if(checker == ' ') {
				continue;
			}
			
			//inner for loop checks [2][i] and [4][i]
			for(int j = sRow; j <= tRow; j+=2) {
				char check = gameBoard[j][i];
				
				//if [x][i] != [0][i]
				if(check != checker) {
					break;
				}
				
				//if we made it to [4][i] someone won
				if(j == tRow) {
					if(checker == x) {
						System.out.println(xWins);
					}
					else {
						System.out.println(oWins);
					}
					return true;
				}
			}
			
		} 
		return false;
	}

	/*
	 * Asks the user where to put their symbol
	 * 
	 * @param	gameBoard = the board
	 * @param 	symbol = the player's symbol
	 * 
	 */
	public static void choiceOfPositioning(char[][] gameBoard, char symbol) {
		System.out.println(symbol + "'s turn!");
		boolean loop = true;
		while(loop == true) {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Enter the row you want to input in (1-3): ");
			int rowPosition = scan.nextInt();
			
			//if they enter out of bounds for row
			while(rowPosition > thirdSpot || rowPosition < firstSpot) {
				System.out.println("Invalid row! Please enter a valid row. ");
				System.out.print("Enter the row you want to input in (1-3): ");
				rowPosition = scan.nextInt();
			}
			
			System.out.print("Enter the column you want to input in (1-3): ");
			int colPosition = scan.nextInt();
			
			//if they enter out of bounds for col
			while(colPosition > thirdSpot || colPosition < firstSpot) {
				System.out.println("Invalid column! Please enter a valid column. ");
				System.out.print("Enter the column you want to input in (1-3): ");
				colPosition = scan.nextInt();
			}
			
			//internally correct the row and col
			rowPosition = positionCorrection(rowPosition);
			colPosition = positionCorrection(colPosition);
			
			//if we can successfully insert the symbol
			if(gameBoard[rowPosition][colPosition] == ' ') {
				gameBoard[rowPosition][colPosition] = symbol;
				printGameBoard(gameBoard);
				loop = false;
			}
			
			else {
				System.out.println();
				System.out.println("That spot already has a symbol, try another spot");
				printGameBoard(gameBoard);
			}
		}
	}
	
	/*
	 * Corrects the user's row and column input for the char[][] gameBoard
	 * 
	 * @param	position = the position to correct
	 * 
	 * @return	corrected position
	 */
	public static int positionCorrection(int position) {
		//If user put 1, turn to 0
		if(position == firstSpot) {
			position = position - 1;
		}
		//if user put 3, turn to 4
		else if(position == thirdSpot) {
			position = position + 1;
		}
		return position;
	}
	
	/*
	 * Prints out the gameBoard
	 * 
	 * @param	gameBoard = the board
	 * 
	 */
	public static void printGameBoard(char[][] gameBoard) {
		System.out.println();
		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println();
	}

}
