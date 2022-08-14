package HomeWork3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {

    // На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
    static int size = 9; // размер шахматной доски

    static int count = 0; // Счетчик удачных комбинаций

    static List<List<String>> answer = new ArrayList<>();  // Лист для ответов под литкод



    public static void main(String[] args) {

        int[][] chessBoard = new int[size][size];
        combQueen(chessBoard, 0);
        //System.out.println(answer);

    }

    public static boolean combQueen(int[][] board, int row) {

        if (row == size) {
            System.out.println("Итоговая доска № " + ++count);
            printBoard(board);
            //makeAnswer(board);   // Функция для конвертации ответа для литкода
            return false;  // если изменить значение на true то остановится на первом удачном варианте
        }

        for (int j = 0; j < size; j++) {


            if (checkPlace(board, row, j)) {

                board[row][j] = 1;
                if (combQueen(board, row + 1)) {
                    return true;
                }
                else {
                    board[row][j] = 0;
                }
            }

        }

        return false;
    }

    public static boolean checkPlace(int[][] board, int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) return false;
        }

        for (int i = row - 1 , j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < size; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    public static void printBoard(int[][] arr) {

        for (int[] line : arr) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println();
    }


    public static void makeAnswer(int[][] board) {

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int[] ints : board) {
            for (int i : ints) {
                if (i == 0) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            ans.add(sb.toString());
            sb.setLength(0);
        }
        answer.add(ans);
    }

}
