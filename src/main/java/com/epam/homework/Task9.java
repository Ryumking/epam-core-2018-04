package com.epam.homework;

import java.text.DecimalFormat;
import java.util.Scanner;
import static java.lang.Math.*;

public class Task9 {

    /**
     * С консоли вводятся три целых числа A, B, C.
     * Числа являются коэффициентами, задающими квадратное уравнение в общем виде: A*x^2 + B*x + C = 0
     * Необходимо найти корни этого уравнения.
     * <p>
     * Формат входных данных:
     * Строка, содержащая 3 целых числа, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате решения уравнения может быть получено три варианта ответа:
     * <p>
     * NO ROOTS
     * корень уравнения
     * первый корень уравнения, второй корень уравнения
     * <p>
     * В результате выполнения в выходной поток посылается строка, соответствующая найденному решению.
     * Значения корней округляются до 2 знаков после запятой.
     * В качестве десятичного разделителя используется точка.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 2 7 0
     * <p>
     * Выходные данные:
     * -3.50, 0.00
     * <p>
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 4 4 1
     * <p>
     * Выходные данные:
     * -0.50
     * <p>
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 7 0 35
     * <p>
     * Выходные данные:
     * NO ROOTS
     */
    private static final double EPSILON = 0.00000001;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        double discriminant = pow(b, 2) - 4 * a * c;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        if (discriminant > 0) {
            double root1 = (-b - sqrt(discriminant)) / (2 * a);
            double root2 = (-b + sqrt(discriminant)) / (2 * a);
            System.out.println(decimalFormat.format(root1) + ", " + decimalFormat.format(root2));
        } else if (abs(discriminant - 0) < EPSILON) {
            double root = -b / (2 * a);
            System.out.println(decimalFormat.format(root));
        } else {
            System.out.println("NO ROOTS");
        }

    }
}
