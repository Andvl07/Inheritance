package Studentaspir;

// Базовый класс Student
class Student {
    String name; // инициализация поля имени студента
    String faculty; // инициализация поля факультета
    int yearOfEnrollment; // инициализация переменной для хранения года поступления студента
    int rating; // инициализация интовой переменной для хранения рейтинга

    public Student(String name, String faculty, int yearOfEnrollment, int rating) { // конструктор
        this.name = name;
        this.faculty = faculty;
        this.yearOfEnrollment = yearOfEnrollment;
        this.rating = rating;
    }

    public String getFullInfo() {// инициалзация метода для вывода полной информации о студенте
        return "Имя: " + name + ", Факультет: " + faculty + ", Год поступления: " + yearOfEnrollment +
                ", Рейтинг: " + rating;
    }

    @Override // оператор
    public String toString() {
        return getFullInfo();
    }
}

// Класс Postgraduate наследуется от Student
class Postgraduate extends Student {
    String supervisor;
    String specialityCode;

    public Postgraduate(String name, String faculty, int yearOfEnrollment, int rating, String supervisor,
            String specialityCode) {
        super(name, faculty, yearOfEnrollment, rating);
        this.supervisor = supervisor;
        this.specialityCode = specialityCode;
    }

    @Override
    public String getFullInfo() {
        return super.getFullInfo() + ", Руководитель: " + supervisor + ", Код специальности: " + specialityCode;
    }

    public boolean isGraduatingThisYear(int currentYear) {
        // Предполагаем, что аспирантура - 3 года
        return yearOfEnrollment + 3 == currentYear;
    }

    @Override
    public String toString() {
        return getFullInfo();
    }
}