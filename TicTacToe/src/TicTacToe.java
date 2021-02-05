import java.util.Scanner;

public class TicTacToe {
	private static final int firstSpot = 1;
	private static final int secondSpot = 2;
	private static final int thirdSpot = 3;
	
	private static final int fRow = 0;
	private static final int sRow = 2;
	private static final int tRow = 4;
	
	private static final int fCol = 0;
	private static final int sCol = 2;
	private static final int tCol = 4;
	
	private static final int win = 3;
	
	private static final char X = 'X';
	private static final char O = 'O';
	
	private static final String oWins = "O wins!";
	private static final String xWins = "X wins!";

	public static void main(String[] args) {
		boolean gameDone = false;
		char[][] gameBoard = 
			    {{' ' , '|', ' ', '|', ' '}, //row 1 [0] columns = [0][2][4]
				{'-' , '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '},  //row 2 [2] columns = [0][2][4]
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};  //row 3 [4] columns = [0][2][4]

		printGameBoard(gameBoard);
		
		while(gameDone == false) {
			choiceOfPositioning(gameBoard, X);
			gameDone = checkGameState(gameBoard, X, O);
			
			if(gameDone == true) {
				break;
			}
			
			choiceOfPositioning(gameBoard, O);
			gameDone = checkGameState(gameBoard, X, O);
		}
		System.out.println("DONE");
		System.out.println("FINAL BOARD STATE");
		printGameBoard(gameBoard);
	}
	
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
	
	public static boolean isBoardFull(char[][] gameBoard) {
		boolean boardFull = true; // bool used to remember if board is full
		
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
	 * Checks for that
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
	 * Checks for that
	 */
	public static boolean downDiagCheck(char[][] gameBoard, char x, char o) {
		char checker = gameBoard[fRow][tCol];
		if(checker == ' ' ) {
			return false;
		}
		
		if(gameBoard[sRow][sCol] != checker) {
			return false;
		}
		
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
	 */
	public static boolean horizontalCheck(char[][] gameBoard, char x, char o) {
		char checker = ' ';
		for(int i = fRow; i <= tRow; i+=2) {
			checker = gameBoard[i][fCol];
			if(checker == ' ') {
				continue;
			}
			for(int j = fCol; j <= tCol; j+=2) {
				char check = gameBoard[i][j];
				if(check != checker) {
					break;
				}
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
	 */
	public static boolean verticalCheck(char[][] gameBoard, char x, char o) {
		char checker = ' ';
		for(int i = fCol; i <= tCol; i+=2) {
			checker = gameBoard[fRow][i];
			if(checker == ' ') {
				continue;
			}
			for(int j = fRow; j <= tRow; j+=2) {
				char check = gameBoard[j][i];
				if(check != checker) {
					break;
				}
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
	public static boolean verticalCheck(char[][] gameBoard, char x, char o) {	
		for(int i = 1; i <= thirdSpot; i++) {
			int winLine = 0; //checks if there is three in a column for a symbol
			boolean isX = false; //bool used to see if the symbol for check is x
			int col = positionCorrection(i); //corrects position of column
			
			//starts the check for three in a column for x
			if(gameBoard[0][col] == x) {
				winLine++;
				isX = true;
			}
			
			//starts the check for three in a column for o			
			else if(gameBoard[0][col] == o) {
				winLine++;
			}
			
			//if there's nothing on the top row, then there isn't three in a column
			else {
				continue;
			}
			
			//if checking for x
			if(isX == true) {
				for(int j = 2; j <= thirdSpot; j++) {
					
					int row = positionCorrection(j); //corrects row position
	
					//breaks if the column isn't strictly x
					if(gameBoard[row][col] != x) {
						break;
					}
					
					else {
						winLine++;
						if(winLine == win) {
							System.out.println(xWins);
						}
					}
					
				
				} //end for loop for j

			} //end if statement
			
			//checks for column of o
			else {
				for(int j = 2; j <= thirdSpot; j++) {
					
					int row = positionCorrection(j);
					
					if(gameBoard[row][col] != o) {
						break;
					}
					
					else {
						winLine++;
						if(winLine == win) {
							System.out.println(oWins); 
						}
					}
				} //end for loop for j
					
			} //end else statement
			
			//if there was a three in a column anywhere, return true
			if(winLine == win) {
				return true;
			}
			
		} //end for loop for i
		
		return false;
	}
	*/
	public static void choiceOfPositioning(char[][] gameBoard, char symbol) {
		boolean loop = true;
		while(loop == true) {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Enter the row you want to input in (1-3): ");
			int rowPosition = scan.nextInt();
			
			while(rowPosition > thirdSpot || rowPosition < firstSpot) {
				System.out.println("Invalid row! Please enter a valid row. ");
				System.out.print("Enter the row you want to input in (1-3): ");
				rowPosition = scan.nextInt();
			}
			
			System.out.print("Enter the column you want to input in (1-3): ");
			int colPosition = scan.nextInt();
			
			while(colPosition > thirdSpot || colPosition < firstSpot) {
				System.out.println("Invalid column! Please enter a valid column. ");
				System.out.print("Enter the column you want to input in (1-3): ");
				colPosition = scan.nextInt();
			}
			
			rowPosition = positionCorrection(rowPosition);
			colPosition = positionCorrection(colPosition);
			
			if(gameBoard[rowPosition][colPosition] == ' ') {
				gameBoard[rowPosition][colPosition] = symbol;
				printGameBoard(gameBoard);
				loop = false;
			}
			
			else {
				System.out.println("That spot already has a symbol, try another spot");
				printGameBoard(gameBoard);
			}
		}
	}
	
	public static int positionCorrection(int position) {
		if(position == firstSpot) {
			position = position - 1;
		}
		else if(position == thirdSpot) {
			position = position + 1;
		}
		return position;
	}
	
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
