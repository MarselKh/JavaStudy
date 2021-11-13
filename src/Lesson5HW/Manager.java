package Lesson5HW;

public class Manager {


    public static void main(String[] args) {
        Employee[] emplArr = new Employee[5];
        emplArr[0] = new Employee("Ivanov", "Ivan", "Ivanovich", "manager", "ivanov@mail.ru", 89061234587L, 70000, 45);
        emplArr[1] = new Employee("Sidorov", "Matvey", "Alexsandrovich", "economy", "sidorov@yn.ru", 89555621748L, 55000, 29);
        emplArr[2] = new Employee("Ignatova", "Irina", "Georgievna", "lawyer", "ignatova@gmailcom", 89631472532L, 45000, 25);
        emplArr[3] = new Employee("Usmanov", "Tagir", "Suleimanovich", "builder", "usmanov@mail.ru", +7478951L, 30000, 41);
        emplArr[4] = new Employee("Kravsova", "Inna", "Semenovna", "secretary", "kravsova@rambler.ru", +79524623578L, 15000, 19);
        for (int i = 0; i < emplArr.length; i++){
            if (emplArr[i].getAge() > 40) {
                System.out.println(emplArr[i].outInfoEmployee());
            }
        }

    }
    }