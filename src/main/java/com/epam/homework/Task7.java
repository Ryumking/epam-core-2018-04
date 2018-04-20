package com.epam.homework;

import java.util.ArrayList;
import java.util.Scanner;

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
        try (Scanner in = new Scanner(System.in)) {

            int wordCount = Integer.valueOf(in.next());
            ArrayList<String> result = new ArrayList<>();

            for (int i = 0; i < wordCount; i++) {

                String word = in.next();
                if (word.toLowerCase().chars().distinct().count() == word.chars().count()) {
                    if (!result.contains(word)) {
                        result.add(word);
                    }
                }
            }

            if (result.isEmpty()) {
                System.out.println("NOT FOUND");
            } else {
                StringBuilder sb = new StringBuilder();
                for (String word : result) {
                    sb.append(word).append(' ');
                }
                System.out.println(sb);
            }
        }
    }
}
