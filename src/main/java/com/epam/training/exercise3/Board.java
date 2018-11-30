package com.epam.training.exercise3;

import java.util.Arrays;

public class Board {

    private int size = 8;
    private char[][] board;

    public Board() {
        initBoard();
    }

    public Board(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.size = size;
        initBoard();
    }

    public Board(final Board toCopy) {
        this.size = toCopy.size;
        this.board = new char[size][size];
        for (int r = 0; r < size; r++)
            System.arraycopy(toCopy.board[r], 0, this.board[r], 0, size);
    }

    public boolean tryToInsertQueen(int row, int column) {
        if (board[row][column] == 'q') {
            return true;
        }
        if (rowAvailable(row) && columnAvailable(column) && checkDiagonals(row, column)) {
            board[row][column] = 'q';
            return true;
        } else {
            return false;
        }
    }

    public void clearCell(int row, int column) {
        board[row][column] = '.';
    }

    private boolean rowAvailable(int row) {
        for (final char cell : board[row]) {
            if (cell == 'q') {
                return false;
            }
        }
        return true;
    }

    private boolean columnAvailable(int column) {
        for (final char[] row : board) {
            if (row[column] == 'q') {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals(int row, int column) {
        return checkAdditionalDiagonal(row + column) && checkMainDiagonal(row - column);
    }

    private boolean checkMainDiagonal(int identifier) {
        for (int i = 0; i < size; i++) {
            if (checkBounds(identifier + i, i) && board[i + identifier][i] == 'q') {
                return false;
            }
        }
        return true;
    }

    private boolean checkAdditionalDiagonal(int sumOfIndexes) {
        for (int i = 0; i < size; i++) {
            if (checkBounds(i, sumOfIndexes - i) && board[i][sumOfIndexes - i] == 'q') {
                return false;
            }
        }
        return true;
    }


    private void initBoard() {
        board = new char[size][size];
        for (int r1 = 0; r1 < size; r1++)
            Arrays.fill(board[r1], '.');
    }

    private boolean checkBounds(int row, int column) {
        return row >= 0 && row < size && column >= 0 && column < size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\n");
        for (final char[] row : board) {
            for (final char element : row) {
                result.append(element);
            }
            result.append('\n');
        }
        return result.toString();
    }

    public int getSize() {
        return size;
    }
}
