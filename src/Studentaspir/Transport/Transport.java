package Studentaspir.Transport;

class Transport { //инициализация класса транспорт (базовый класс)
    protected double power; //поля класса: мощность, стоимость, номер, марка
    protected double cost;
    protected String number;
    protected String stamp;

    public Transport(double power, double cost, String number, String stamp) {//конструктор
        this.power = power;
        this.cost = cost;
        this.number = number;
        this.stamp = stamp;
    }

    public void info() { // метод для получения информации
        System.out.println("Марка: " + stamp + ", Номер: " + number + ", Мощность: " + power + ", Стоимость: " + cost);
    }

    public double getCost() { //метод вывода стоимости
        return cost;
    }

}

class Airplane extends Transport { //инициализация класса самолет(производный класс)
    private double maximumHeight;

    public Airplane(double power, double cost, String number, String stamp, double maximumHeight) {
        super(power, cost, number, stamp);
        this.maximumHeight = maximumHeight; // конструктор для самолёта
    }

    public void info() { 
        super.info();
        System.out.println("Максимальная высота полета: " + maximumHeight); //метод вывода максимальной высоты полёта
    }

    public double getMaxPower() {
        return power; //метод вывода мощности
    }

    public double getMaxHeight() {
        return maximumHeight; // метода вывода максмальной высоты полёта
    }
}

class Car extends Transport { //инициализация класса автомобиль(производный класс)
    private double mileage;
    private boolean isTechnicalInspection;

    public Car(double power, double cost, String number, String stamp, double mileage, boolean isTechnicalInspection) {
        super(power, cost, number, stamp);
        this.mileage = mileage;
        this.isTechnicalInspection = isTechnicalInspection(); //конструктор класса автомобиль
    }

    public void info() {
        super.info();
        System.out.println("Пробег: " + mileage + ", Прошел техосмотр: " + isTechnicalInspection);  // метод вывода пробег и прохождения техосмотра
    }

    public double getMileage() {
        return mileage; // метод ввода пробега
    }

    public double getMaxPower() {
        return power; // метод ввода мощности
    }

    public boolean isTechnicalInspection() {
        return isTechnicalInspection;  // метод ввода пробега и прохождения техосмотра
    }
}
