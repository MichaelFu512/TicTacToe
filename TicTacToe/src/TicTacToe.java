import java.util.Scanner;

public class TicTacToe {
	private static final int firstSpot = 1;
	private static final int secondSpot = 2;
	private static final int thirdSpot = 3;

	public static void main(String[] args) {
		boolean gameDone = false;
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};

		printGameBoard(gameBoard);
		
		while(gameDone == false) {
			choiceOfPositioning(gameBoard, 'X');
			choiceOfPositioning(gameBoard, 'O');
		}
	
		printGameBoard(gameBoard);

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
