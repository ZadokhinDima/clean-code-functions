package com.epam.training.exercise3;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueens {

	public static void main(String[] args) {
		ArrayList<Board> solutions = new ArrayList<>();

		Board board = new Board();
		
		solveAllNQueens(board, 0, solutions);
		
		System.out.println(solutions.size());

		solutions.forEach(System.out::println);
	}

	private static void solveAllNQueens(Board board, int col, ArrayList<Board> solutions) {
		if (col == board.getSize()) {
			Board copy = new Board(board);
			solutions.add(copy);
		} else {
			for (int row = 0; row < board.getSize(); row++) {
                final boolean safe = board.tryToInsertQueen(row, col);
                if (safe)
					solveAllNQueens(board, col + 1, solutions);
				board.clearCell(row, col);
			}
		}
	}

}