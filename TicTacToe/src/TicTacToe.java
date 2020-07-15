public class TicTacToe {
	private static final int firstSpot = 1;
	private static final int secondSpot = 2;
	private static final int thirdSpot = 3;

	public static void main(String[] args) {
		boolean finishedGame = false;
		
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
				{'-', '+', '-', '+', '-'}, 
				{' ', '|', ' ', '|', ' '}, 
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'} };

		printGameBoard(gameBoard);
				
		choiceOfPositioning(gameBoard, 'X');
		System.out.println(gameBoard[0][0]);
	
		printGameBoard(gameBoard);

	}
	
	public static void choiceOfPositioning(char[][] gameBoard, char symbol) {
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

}
