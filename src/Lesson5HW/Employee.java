package Lesson5HW;


public  class Employee {
    private String surname;
    private String name;
    private String middleName;
    private String position;
    private String email;
    private long phone;
    private int salary;
    private int age;

    public Employee(String surname, String name, String middleName, String position, String email, long phone, int salary, int age) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String outInfoEmployee() {
        return (surname + " " + name + " " + middleName + " " + position + " " + email + " " + phone + " " + salary + " " + age);
    }
    public int getAge() {
        return age;
    }
}

