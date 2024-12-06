package Studentaspir;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Programm {
    public static void main(String[] args) {
        // Создаем списки (List) студентов и аспирантов
        List<Student> students = new ArrayList<>();
        List<Postgraduate> postgraduates = new ArrayList<>();

        // Добавляем студентов
        students.add(new Student("Иван Иванов", "Экономический", 2023, 95));
        students.add(new Student("Петр Петров", "Экономический", 2023, 88));
        students.add(new Student("Сидоров Сидор", "Экономический", 2023, 92));
        students.add(new Student("Анна Абрамова", "Юридический", 2022, 85));
        students.add(new Student("Мария Миронова", "Экономический", 2023, 98));

        // Добавляем аспирантов
        postgraduates.add(new Postgraduate("Дмитрий Дмитриев", "Физический", 2021, 90, "Профессор X", "01.03.02"));
        postgraduates.add(new Postgraduate("Елена Еленова", "Математический", 2022, 85, "Профессор Y", "05.13.11"));
        postgraduates.add(new Postgraduate("Сергей Сергеев", "Экономический", 2022, 92, "Профессор Z", "08.00.05"));
        postgraduates.add(new Postgraduate("Ольга Олегова", "Математический", 2020, 78, "Профессор Y", "05.13.11"));


        // Получаем информацию о трех лучших студентах первого курса экономического факультета
        getHighRatingStudents(students);

        // Выясняем, кто из аспирантов специальности 05.13.11 заканчивает обучение в текущем году
        int currentYear = Year.now().getValue();
        getGraduatingPostgraduates(postgraduates, currentYear, "05.13.11");

        // Выводим полную информацию обо всех студентах и аспирантах
        System.out.println("\n\nВсе студенты:");
        students.forEach(System.out::println);
        System.out.println("\n\nВсе аспиранты:");
        postgraduates.forEach(System.out::println);
    }

    // Метод для получения информации о лучших студентах
    static void getHighRatingStudents(List<Student> students) {
        List<Student> economicStudentsFirstYear = new ArrayList<>();
        int currentYear = Year.now().getValue();
        for (Student student : students) {
            if (student.faculty.equals("Экономический") && student.yearOfEnrollment == currentYear) {
                economicStudentsFirstYear.add(student);
            }
        }

        // Сортируем по рейтингу по убыванию
        Collections.sort(economicStudentsFirstYear, Comparator.comparingInt(s -> -s.rating));

        System.out.println("\nТри лучших студента первого курса экономического факультета:");
        for (int i = 0; i < Math.min(3, economicStudentsFirstYear.size()); i++) {
            System.out.println(economicStudentsFirstYear.get(i));
        }
    }

    // Метод для получения информации об аспирантах, заканчивающих обучение
    static void getGraduatingPostgraduates(List<Postgraduate> postgraduates, int currentYear, String specialityCode) {
        System.out.println("\nАспиранты специальности " + specialityCode + " которые заканчивают обучение в " + currentYear + " году:");
        for (Postgraduate postgraduate : postgraduates) {
            if (postgraduate.specialityCode.equals(specialityCode) && postgraduate.isGraduatingThisYear(currentYear)) {
                System.out.println(postgraduate);
            }
        }
    }
}
