package com.epam.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
     * Количество различных вхождений одной буквы в слове учитывается.
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 5
     * Язык программирования Java is widespread
     *
     * Выходные данные:
     * 2
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        int countWords = 0;

        for (int i = 0; i < N; i++) {
            String currWord = in.next();
            if (checkWord(currWord)) {
                countWords++;
            }
        }
        System.out.println(countWords);
    }

    private static boolean checkWord(String str) {

        if (str.matches("[a-zA-Z]+")) {
            char[] charArray = str.toCharArray();
            Character[] vowelsArray = {'a','A','e','E','i','I','o','O','u','U','y','Y'};

            int vowelsCounter = 0;
            int consonantCounter = 0;

            for (Character ch: charArray) {
                if (Arrays.asList(vowelsArray).contains(ch)) {
                    vowelsCounter++;
                } else {
                    consonantCounter++;
                }
            }
            return vowelsCounter == consonantCounter;
        }
        return false;
    }
}
