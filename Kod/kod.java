

import java.util.Arrays;

/** * Класс для проверки равенства среднего значения массива переданному значению. */
public class AverageChecker {

    /** * Метод для проверки равенства среднего значения массива переданному значению. * * @param array Массив целых чисел. * @param expectedAverage Ожидаемое среднее значение. * @return True, если среднее значение массива равно переданному значению, * False в противном случае. */
    public static boolean isAverageEqual(int[] array, double expectedAverage) {
        // Проверка на корректность массива
        if (array == null || array.length == 0) {
            return false; // Если массив пустой или null, возвращаем false
        }

        // Вычисляем сумму всех элементов массива
        int sum = 0;
        for (int element : array) {
            sum += element;
        }

        // Вычисляем среднее значение массива
        double actualAverage = (double) sum / array.length;

        // Сравниваем фактическое среднее значение с ожидаемым, учитывая возможную погрешность
        return Math.abs(actualAverage - expectedAverage) < 1e-9;
    }

    /** * Основной метод программы. * * @param args Аргументы командной строки (в данном примере не используются). */
    public static void main(String[] args) {
        // Создаем тестовый массив
        int[] testArray = {1, 2, 3, 4};

        // Задаем ожидаемое среднее значение
        double expectedValue = 2.5;

        // Вызов метода проверки среднего значения
        boolean result = isAverageEqual(testArray, expectedValue);

        // Выводим результат
        String message = result ?
                "Среднее значение массива равно переданному значению." :
                "Среднее значение массива не равно переданному значению.";
        System.out.println(message);
    }
}