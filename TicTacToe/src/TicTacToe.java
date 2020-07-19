import java.util.Scanner;

public class TicTacToe {
	private static final int firstSpot = 1;
	private static final int secondSpot = 2;
	private static final int thirdSpot = 3;
	
	private static final int win = 3;
	
	private static final char X = 'X';
	private static final char O = 'O';

	public static void main(String[] args) {
		boolean gameDone = false;
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};

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
		printGameBoard(gameBoard);
	}
	
	public static boolean checkGameState(char[][] gameBoard, char x, char o) {
		boolean gameEnd = verticalCheck(gameBoard, x, o);
		if(gameEnd == false) {
			gameEnd = horizontalCheck(gameBoard, x, o);
			gameEnd = diagonalCheck(gameBoard, x, o);
		}
		return gameEnd;
	}
	
	//TODO: make a lot less if-else statements and replace the magic numbers
	public static boolean diagonalCheck(char[][] gameBoard, char x, char o) {
		int winLine = 0;
		boolean isX = false;
		boolean leftDown = false;
		
		if(gameBoard[0][0] == x) {
			winLine++;
			isX = true;
			
		}
		else if (gameBoard[0][0] == o) {
			winLine++;
		}
		
		else {
			if(gameBoard[0][4] == x) {
				winLine++;
				isX = true;
				leftDown = true;
			}
			
			else if (gameBoard[0][4] == o) {
				winLine++;
				leftDown = true;
			}
			
			else {
				return false;
			}
		}
		
		if(isX == true) {
			if(gameBoard[2][2] == x) {
				winLine++;
			}
			else {
				return false;
			}
		}
		
		else {
			if(gameBoard[2][2] == o) {
				winLine++;
			}
			else {
				return false;
			}
		}
		
		if(leftDown == false) {
			if(isX == true && gameBoard[4][4] == x) {
				winLine++;
			}
			else if(isX == false && gameBoard[4][4] == o) {
				winLine++;
			}
			else {
				return false;
			}
		}
		
		else {
			if(isX == true && gameBoard[4][0] == x) {
				winLine++;
			}
			else if(isX == false && gameBoard[4][0] == o) {
				winLine++;
			}
			else {
				return false;
			}
		}
		
		if(winLine == win) {
			return true;
		}
		
		return false;
		
	}
	public static boolean horizontalCheck(char[][] gameBoard, char x, char o) {
		for(int i = 1; i <= thirdSpot; i++) {
			int winLine = 0; //checks if there is three in a column for a symbol
			boolean isX = false; //bool used to see if the symbol for check is x
			int row = positionCorrection(i); //corrects position of column
			
			//starts the check for three in a row for x
			if(gameBoard[row][0] == x) {
				winLine++;
				isX = true;
			}
			
			//starts the check for three in a row for o
			else if(gameBoard[row][0] == o) {
				winLine++;
			}
			
			//if there's nothing on the first col, then there isn't three in a row
			else {
				continue;
			}
			
			//if checking for x
			if(isX == true) {
				for(int j = 2; j <= thirdSpot; j++) {
					
					int col = positionCorrection(j); //corrects row position
	
					//breaks if the row isn't strictly x
					if(gameBoard[row][col] != x) {
						break;
					}
					
					else {
						winLine++;
					}
		
				} //end for loop for j

			} //end if statement
			
			//checks for column of o
			else {
				for(int j = 2; j <= thirdSpot; j++) {
					
					int col = positionCorrection(j);
					
					if(gameBoard[row][col] != o) {
						break;
					}
					
					else {
						winLine++;
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
	
	public static void choiceOfPositioning(char[][] gameBoard, char symbol) {
		boolean loop = true;
		while(loop == true) {
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
