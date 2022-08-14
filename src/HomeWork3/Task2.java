package HomeWork3;

import java.util.Arrays;

public class Task2 {

    static int size = 5; // размер поля
    static int[][] steps = { // варианты ходов нашего коня
            {-2, -1},
            {-2, 1},
            {-1, -2},
            {-1, 2},
            {1, -2},
            {1, 2},
            {2, -1},
            {2, 1},
    };
    static int numberStep = 1; // номер хода внутри поля
    static int path = 0;

    public static void main(String[] args) {

        int[][] chessBoard = new int[size][size];
        int rowStart = 2;
        int colStart = 2;
        chessBoard[rowStart][colStart] = numberStep;

        solveHorse(chessBoard, rowStart, colStart);


    }

    public static boolean solveHorse(int[][] board, int row, int col) {

        if (numberStep == size * size) {
            System.out.println("Вариант пути № " + ++path);
            printBoard(board);
            return false;
        }

        for (int i = 0; i < steps.length; i++) {

            int newRow = row + steps[i][0];
            int newCol = col + steps[i][1];

            if (checkStep(board, newRow, newCol)) {
                board[newRow][newCol] = ++numberStep;
                if (solveHorse(board, newRow, newCol)) {
                    return true;
                } else {
                    board[newRow][newCol] = 0;
                    numberStep--;
                }
            }

        }

        return false;

    }

    public static boolean checkStep(int[][] board, int row, int col) {

        if (row >= size || row < 0) return false;
        if (col >= size || col < 0) return false;
        if (board[row][col] != 0) return false;

        return true;

    }

    public static void printBoard(int[][] arr) {

        for (int[] line : arr) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println();

    }


}
