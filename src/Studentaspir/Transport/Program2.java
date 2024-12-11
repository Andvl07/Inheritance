package Studentaspir.Transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        // Коллекция автомобилей
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(150, 1000000, "A123BC45", "Toyota", 100000, true)); //коллекция автомобилей
        cars.add(new Car(200, 1500000, "B456CD78", "BMW", 50000, false));
        cars.add(new Car(180, 1200000, "C789DE10", "Audi", 80000, true));

        // Коллекция самолетов
        List<Airplane> airplanes = new ArrayList<>();
        airplanes.add(new Airplane(5000, 10000000, "RA12345", "Boeing", 12000)); //коллекция самолётов
        airplanes.add(new Airplane(4000, 8000000, "RA67890", "Airbus", 10000));
        airplanes.add(new Airplane(6000, 15000000, "RA13579", "Embraer", 11000));


        // Найти стоимость и пробег заданного автомобиля
        String carToFind = "B456CD78";
        for (Car car : cars) {
            if (car.number.equals(carToFind)) {
                System.out.println("Стоимость автомобиля " + carToFind + ": " + car.getCost() + ", Пробег: " + car.getMileage());
                break;
            }
        }

        // Налог на регистрацию автомобилей
        double totalCarTax = cars.stream().mapToDouble(Car::getCost).sum() * 0.05;
        System.out.println("Налог на регистрацию всех автомобилей: " + totalCarTax);

        // Техосмотр самой дорогой машины
        Car mostExpensiveCar = Collections.max(cars, Comparator.comparingDouble(Transport::getCost));
        System.out.println("Самая дорогая машина прошла техосмотр: " + mostExpensiveCar.isTechnicalInspection());

        // Нахождение мощность и максимальную высоту полета заданного самолета
        String airplaneToFind = "RA67890";
        for (Airplane airplane : airplanes) {
            if (airplane.number.equals(airplaneToFind)) {
                System.out.println("Мощность самолета " + airplaneToFind + ": " + airplane.getMaxPower() + ", Максимальная высота: " + airplane.getMaxHeight());
                break;
            }
        }

        // Налог на регистрацию самолетов
        double totalAirplaneTax = airplanes.stream().mapToDouble(Transport::getCost).sum() * 0.03;
        System.out.println("Налог на регистрацию всех самолетов: " + totalAirplaneTax);

        // Самый дорогой самолет
        Airplane mostExpensiveAirplane = Collections.max(airplanes, Comparator.comparingDouble(Transport::getCost));
        System.out.println("Самый дорогой самолет: Мощность - " + mostExpensiveAirplane.getMaxPower() + ", Стоимость - " + mostExpensiveAirplane.getCost() + ", Марка - " + mostExpensiveAirplane.stamp);

        // Информация обо всех автомобилях и самолетах
        System.out.println("\nИнформация об автомобилях:");
        cars.forEach(Car::info);

        System.out.println("\nИнформация о самолетах:");
        airplanes.forEach(Airplane::info);
    }
}
