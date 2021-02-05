import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeTest {

	@Test
	void testUpDiagCheck() {
		char x = 'x';
		char o = 'o';
		char[][] xBoard = 
		    {{'x' , '|', ' ', '|', ' '}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{' ', '|', 'x', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', 'x'}};  //row 3 [4] columns = [0][2][4]
		assertTrue(TicTacToe.upDiagCheck(xBoard, x, o), "x should win");
		
		char[][] oBoard = 
		    {{'o' , '|', ' ', '|', ' '}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{' ', '|', 'o', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', 'o'}};  //row 3 [4] columns = [0][2][4]
		assertTrue(TicTacToe.upDiagCheck(oBoard, x, o), "o should win");
		
		char[][] noOne = 
		    {{'o' , '|', ' ', '|', ' '}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{' ', '|', 'x', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', 'o'}};  //row 3 [4] columns = [0][2][4]
		assertFalse(TicTacToe.upDiagCheck(noOne, x, o),  "no one should win");
		
		char[][] noOne2 = 
		    {{'o' , '|', ' ', '|', ' '}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{' ', '|', ' ', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', 'o'}};  //row 3 [4] columns = [0][2][4]
		assertFalse(TicTacToe.upDiagCheck(noOne2, x, o),  "no one should win");
		System.out.println("testUpDiagCheck worked");
	}

	@Test
	void testDownDiagCheck() {
		char x = 'x';
		char o = 'o';
		char[][] xBoard = 
		    {{' ' , '|', ' ', '|', 'x'}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{' ', '|', 'x', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{'x', '|', ' ', '|', ' '}};  //row 3 [4] columns = [0][2][4]
		assertTrue(TicTacToe.downDiagCheck(xBoard, x, o), "x should win");
		
		char[][] oBoard = 
		    {{' ' , '|', ' ', '|', 'o'}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{' ', '|', 'o', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{'o', '|', ' ', '|', ' '}};  //row 3 [4] columns = [0][2][4]
		assertTrue(TicTacToe.downDiagCheck(oBoard, x, o), "o should win");
		
		char[][] noOne = 
		    {{'o' , '|', ' ', '|', 'x'}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{' ', '|', 'x', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{'o', '|', ' ', '|', 'o'}};  //row 3 [4] columns = [0][2][4]
		assertFalse(TicTacToe.downDiagCheck(noOne, x, o),  "no one should win");
		
		char[][] noOne2 = 
		    {{'o' , '|', ' ', '|', 'x'}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{' ', '|', ' ', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{'x', '|', ' ', '|', 'o'}};  //row 3 [4] columns = [0][2][4]
		assertFalse(TicTacToe.downDiagCheck(noOne2, x, o),  "no one should win");
		System.out.println("testDownDiagCheck worked");
	}

	@Test
	void testHorizontalCheck() {
		char x = 'x';
		char o = 'o';
		char[][] xBoard1 = 
		    {{'x' , '|', 'x', '|', 'x'}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{'o', '|', 'o', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{'x', '|', ' ', '|', ' '}};  //row 3 [4] columns = [0][2][4]
		assertTrue(TicTacToe.horizontalCheck(xBoard1, x, o), "x row1 should win");
		
		char[][] xBoard2 = 
		    {{' ' , '|', ' ', '|', 'x'}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{'x', '|', 'x', '|', 'x'},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{' ', '|', ' ', '|', ' '}};  //row 3 [4] columns = [0][2][4]
		assertTrue(TicTacToe.horizontalCheck(xBoard2, x, o), "x  row2 should win");
		
		char[][] xBoard3 = 
		    {{' ' , '|', 'x', '|', 'x'}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{'x', '|', ' ', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{'x', '|', 'x', '|', 'x'}};  //row 3 [4] columns = [0][2][4]
		assertTrue(TicTacToe.horizontalCheck(xBoard3, x, o), "x  row3 should win");
		
		char[][] oBoard1 = 
		    {{'o' , '|', 'o', '|', 'o'}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{' ', '|', 'o', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{'o', '|', ' ', '|', ' '}};  //row 3 [4] columns = [0][2][4]
		assertTrue(TicTacToe.horizontalCheck(oBoard1, x, o), "o row1 should win");
		
		char[][] noOne = 
		    {{'o' , '|', ' ', '|', 'x'}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{'o', '|', 'x', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{'o', '|', ' ', '|', 'o'}};  //row 3 [4] columns = [0][2][4]
		assertFalse(TicTacToe.horizontalCheck(noOne, x, o),  "no one should win");
		
		char[][] noOne2 = 
		    {{'o' , '|', ' ', '|', 'x'}, //row 1 [0] columns = [0][2][4]
			{'-' , '+', '-', '+', '-'}, 
			{' ', '|', ' ', '|', ' '},  //row 2 [2] columns = [0][2][4]
			{'-', '+', '-', '+', '-'},
			{'x', '|', ' ', '|', 'o'}};  //row 3 [4] columns = [0][2][4]
		assertFalse(TicTacToe.horizontalCheck(noOne2, x, o),  "no one should win");
		System.out.println("testHorizontalCheck worked");
	}

	/*
	@Test
	void testVerticalCheck() {
		fail("Not yet implemented");
	}

	@Test
	void testPositionCorrection() {
		fail("Not yet implemented");
	}
	*/

}
