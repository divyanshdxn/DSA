package com.dxn.algo;

import java.util.Arrays;

public class NQueen {
    public static void main(String[] args) {
        int n = 8;
        int[][] board = new int[n][n];
        if (nQueen(board, 0, n)) {
            for(int[] row:board) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    public static boolean nQueen(int[][] board, int row, int n) {
        if (row == n) {
            return true;
        } else {
            for (int col = 0; col < n; col++) {
                if (isSafe(board, row, col,n)) {
                    board[row][col] = 1;
                    if (nQueen(board, row + 1, n)) {
                        return true;
                    }
                    board[row][col] = 0;
                }
            }
            return false;
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        int r = row - 1;
        int c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 1) {
                return false;
            }
            r--;
            c--;
        }

        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < n) {
            if (board[r][c] == 1) {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}
