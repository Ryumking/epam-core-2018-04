package com.epam.homework;


import java.util.*;

public class Task17 {

    /**
     * Вычислить определитель матрицы
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Целое число, соответствующее определителю матрицы.
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     3
     -2  1  2
     0 -1  0
     1 -2  3
     *
     * Выходные данные:
     * 8
     *
     *
     * Входные данные:
     4
     6 4 0 1
     8 7 0 3
     1 3 0 9
     7 5 1 2
     *
     * Выходные данные:
     * -65
     */
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            double[][] matrix = getMatrix(reader);
            System.out.println(Math.round(gaussMethodDeterminant(matrix)));
        }
    }


    private static double[][] getMatrix(Scanner reader) {
        int n = reader.nextInt();
        double[][] matrix  = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }
        return matrix;
    }

    private static double gaussMethodDeterminant(double[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        for (int k = 0; k < matrix.length; k++){
            for (int i = k + 1; i < matrix.length; i++) {
                if (matrix[k][k] == 0) {
                    continue;
                }
                double n = - matrix[i][k] / matrix[k][k];
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] +=  matrix[k][j] * n;
                }
            }
        }
        return determinantCount(matrix);
    }

    private static double determinantCount(double[][] matrix) {
        boolean sign = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    if (i != j) {
                        swapLines(matrix, i, j);
                        sign = !sign;
                    }
                }
            }
        }
        double determinant = 1;
        for (int j = 0; j < matrix.length; j++) {
            determinant *= matrix[j][j];
        }
        return determinant * (sign ? 1 : -1);
    }

    private static void swapLines(double[][] matrix, int i, int j) {
        double[] temp = matrix[j];
        matrix[j] = matrix[i];
        matrix[i] = temp;
    }
}


