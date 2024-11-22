public class TemperatureAdapter {
    // Атрибуты
    private String type;  // Тип температуры (Celsius/Fahrenheit)
    private double temperature;
    private int daysCount;   // Количество дней для отслеживания изменений
    private double[] changesOverDays;  // Массив изменений температуры

    // Конструктор по умолчанию
    public TemperatureAdapter() {
        this.type = "Celsius";
        this.temperature = 0.0;
        this.daysCount = 7;
        this.changesOverDays = new double[this.daysCount];
    }

    // Конструктор с параметрами
    public TemperatureAdapter(String type, double temperature, int daysCount) {
        this.type = type;
        this.temperature = temperature;
        this.daysCount = daysCount;
        this.changesOverDays = new double[this.daysCount];
    }

    // Геттеры и Сеттры
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(int daysCount) {
        if (daysCount > 0) {
            this.daysCount = daysCount;
            this.changesOverDays = new double[this.daysCount];  // Обновляем массив при изменении количества дней
        } else {
            throw new IllegalArgumentException("Количество дней должно быть положительным числом.");
        }
    }

    public double[] getChangesOverDays() {
        return changesOverDays;
    }

    public void setChangesOverDays(double[] changesOverDays) {
        if (changesOverDays.length == this.daysCount) {
            System.arraycopy(changesOverDays, 0, this.changesOverDays, 0, this.daysCount);
        } else {
            throw new IllegalArgumentException("Размер массива должен соответствовать количеству дней.");
        }
    }

    // Методы для преобразования температуры
    
    public double celsiusToFahrenheit(double tempInCelsius) {
        return tempInCelsius * 9 / 5 + 32;
    }

    public double fahrenheitToCelsius(double tempInFahrenheit) {
        return (tempInFahrenheit - 32) * 5 / 9;
    }

    // Метод main для запуска программы
    public static void main(String[] args) {
        // Создание объекта TemperatureAdapter
        TemperatureAdapter adapter = new TemperatureAdapter();
        
        // Установка начальных данных
        adapter.setType("Celsius");
        adapter.setTemperature(25.0);
        adapter.setDaysCount(10);  // Устанавливаем количество дней для отслеживания изменений
        
        // Пример использования методов преобразования
        double tempInFahrenheit = adapter.celsiusToFahrenheit(adapter.getTemperature());
        System.out.println("Температура в градусах Фаренгейта: " + tempInFahrenheit);
        
        // Пример изменения температуры
        adapter.setTemperature(tempInFahrenheit);
        adapter.setType("Fahrenheit");
        
        double tempInCelsius = adapter.fahrenheitToCelsius(adapter.getTemperature());
        System.out.println("Температура в градусах Цельсия: " + tempInCelsius);
    }
} 