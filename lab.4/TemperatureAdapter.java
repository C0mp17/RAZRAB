
import  java.util.Arrays;

/** * Класс для работы с температурой, позволяющий конвертировать градусы Цельсия в градусы Фаренгейта и обратно, * а также отслеживать изменения температуры за последние N дней. */
public class TemperatureAdapter {

    // Константы
    private static final String DEFAULT_TEMPERATURE_TYPE = "Celsius";  // Тип температуры по умолчанию
    private static final int DEFAULT_DAYS_COUNT = 7;                  // Количество дней по умолчанию

    // Поля
    private String temperatureType;      // Тип температуры (Celsius/Fahrenheit)
    private double temperature;          // Текущая температура
    private int daysCount;               // Количество дней для отслеживания изменений
    private double[] changesOverDays;    // Массив изменений температуры

    /** * Конструктор по умолчанию. * Инициализирует объект с типом температуры Celsius, нулевой температурой и отслеживанием за 7 дней. */
    public TemperatureAdapter() {
        this(DEFAULT_TEMPERATURE_TYPE, 0.0, DEFAULT_DAYS_COUNT);
    }

    /** * Конструктор с параметрами. * * @param temperatureType тип температуры (Celsius/Fahrenheit) * @param temperature начальная температура * @param daysCount количество дней для отслеживания изменений */
    public TemperatureAdapter(String temperatureType, double temperature, int daysCount) {
        this.temperatureType = temperatureType;
        this.temperature = temperature;
        this.daysCount = daysCount;
        this.changesOverDays = new double[daysCount];
    }

    // Геттеры и Сеттеры

    /** * Возвращает текущий тип температуры. * * @return тип температуры (Celsius/Fahrenheit) */
    public String getTemperatureType() {
        return temperatureType;
    }

    /** * Устанавливает новый тип температуры. * * @param temperatureType новый тип температуры */
    public void setTemperatureType(String temperatureType) {
        this.temperatureType = temperatureType;
    }

    /** * Возвращает текущую температуру. * * @return текущая температура */
    public double getTemperature() {
        return temperature;
    }

    /** * Устанавливает новую температуру. * * @param temperature новая температура */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /** * Возвращает количество дней для отслеживания изменений температуры. * * @return количество дней */
    public int getDaysCount() {
        return daysCount;
    }

    /** * Устанавливает новое количество дней для отслеживания изменений температуры. * * @param daysCount новое количество дней * @throws IllegalArgumentException если daysCount меньше или равен нулю */
    public void setDaysCount(int daysCount) throws IllegalArgumentException {
        if (daysCount <= 0) {
            throw new IllegalArgumentException("Количество дней должно быть больше нуля.");
        }
        this.daysCount = daysCount;
        this.changesOverDays = new double[daysCount];  // Обновление массива при изменении количества дней
    }

    /** * Возвращает массив изменений температуры за последние дни. * * @return массив изменений температуры */
    public double[] getChangesOverDays() {
        return Arrays.copyOf(this.changesOverDays, this.daysCount);
    }

    /** * Устанавливает новые данные об изменениях температуры. * * @param changesOverDays массив новых изменений температуры * @throws IllegalArgumentException если размер массива не соответствует количеству дней */
    public void setChangesOverDays(double[] changesOverDays) throws IllegalArgumentException {
        if (changesOverDays.length != this.daysCount) {
            throw new IllegalArgumentException("Размер массива должен соответствовать количеству дней.");
        }
        System.arraycopy(changesOverDays, 0, this.changesOverDays, 0, this.daysCount);
    }

    // Методы для преобразования температуры

    /** * Преобразует градусы Цельсия в градусы Фаренгейта. * * @param tempInCelsius температура в градусах Цельсия * @return температура в градусах Фаренгейта */
    public double celsiusToFahrenheit(double tempInCelsius) {
        return tempInCelsius * 9 / 5 + 32;
    }

    /** * Преобразует градусы Фаренгейта в градусы Цельсия. * * @param tempInFahrenheit температура в градусах Фаренгейта * @return температура в градусах Цельсия */
    public double fahrenheitToCelsius(double tempInFahrenheit) {
        return (tempInFahrenheit - 32) * 5 / 9;
    }

    /** * Основной метод для тестирования работы класса. * * @param args аргументы командной строки (не используются) */
    public static void main(String[] args) {
        // Создание объекта TemperatureAdapter
        TemperatureAdapter adapter = new TemperatureAdapter();

        // Установка начальных данных
        adapter.setTemperatureType("Celsius");
        adapter.setTemperature(25.0);
        adapter.setDaysCount(10);  // Устанавливаем количество дней для отслеживания изменений

        // Пример использования методов преобразования
        double tempInFahrenheit = adapter.celsiusToFahrenheit(adapter.getTemperature());
        System.out.println("Температура в градусах Фаренгейта: " + tempInFahrenheit);

        // Пример изменения температуры
        adapter.setTemperature(tempInFahrenheit);
        adapter.setTemperatureType("Fahrenheit");

        double tempInCelsius = adapter.fahrenheitToCelsius(adapter.getTemperature());
        System.out.println("Температура в градусах Цельсия: " + tempInCelsius);
    }
}