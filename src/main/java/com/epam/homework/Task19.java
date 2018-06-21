package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task19 {

    /**
     * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     * Гарантируется что после уплотнения в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * 2  0  0 -1
     * 0  0  0  0
     * 0  0  0  3
     * -3  0  0  1
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 2 -1
     * 0  3
     * -3  1
     */
    public static void main(String[] args) {
        // TODO реализация
        Matrix matrix = new Matrix();
        matrix.readMatrix();
        matrix.printMatrix();
    }

}

class Matrix {

    private int[][] matrix;
    private Set<Integer> indexOfRow = new HashSet<>();
    private Set<Integer> indexOfColumn = new HashSet<>();

    Matrix() { }

    void readMatrix() {
        try (Scanner scanner = new Scanner(System.in)) {
            int dimension = scanner.nextInt();
            matrix = new int[dimension][dimension];
            for (int row = 0; row < dimension; ++row) {
                for (int col = 0; col < dimension; ++col) {
                    matrix[row][col] = scanner.nextInt();
                    checkOnZero(row, col);
                }
            }
        }
    }

    private void checkOnZero(int row, int col) {
        if (matrix[row][col] != 0) {
            indexOfRow.add(row);
            indexOfColumn.add(col);
        }
    }

    void printMatrix() {
        System.out.println(indexOfRow.size());
        System.out.println(indexOfColumn.size());
        for (int row : indexOfRow) {
            for (int col : indexOfColumn) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
