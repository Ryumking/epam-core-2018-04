package com.epam.homework;

import java.util.*;

public class Task7 {

    /**
     * Ввести N слов с консоли.
     * Найти слова, состоящие только из различных символов английского алфавита.
     * Символы верхнего и нижнего регистра считать одинаковыми.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов (состоящих только из букв английского языка), разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена строка, содержащая найденные слова, разделенные пробелами.
     * Порядок слов должен совпадать с порядком их появления во входной последовательности.
     * В случае, если не найдено ни одного слова, удовлетворяющего условию - в поток должно быть выведено "NOT FOUND".
     *
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 11
     * The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
     *
     * Выходные данные:
     * The is a
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        Set<String> wordsWithUniqueLetters = new HashSet<>();

        for (int i = 0; i < N; i++) {
            Set<Character> uniqueCharArray = new HashSet<>();

            String currWord = in.next().toLowerCase();

            for (int j = 0; j < currWord.length(); j++) {
                uniqueCharArray.add(currWord.charAt(j));
            }

            if (uniqueCharArray.size() == currWord.length()) {
                wordsWithUniqueLetters.add(currWord);
            }
        }

        if (wordsWithUniqueLetters.isEmpty()) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println(String.join(" ", wordsWithUniqueLetters));
        }
    }
}
