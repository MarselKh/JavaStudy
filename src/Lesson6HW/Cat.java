package Lesson6HW;

public class Cat extends Animal {

    private int countCat = 0;

    public Cat(String name, String color, float run, float swim) {
        super(name, color, run, swim);
    }

    public countCats () ;
        countCat = countCat++;
    }


    @Override
    public String run (int dictanceRun) {
        int maxDictance = 200;
        if ( dictanceRun > maxDictance) {
            return "Кот " + name + " Не может пробежать более 200 м";
        } else {
            return "Кот " + name + " пробежал " + dictanceRun + " м.";
        }

    }
    @Override
    public String swim (int dictanceSwim) {
        int maxDictance = 0;
        if (dictanceSwim >= maxDictance) {
            return "Кот " + name + "  не умеет плавать";
        } else {
            return "Ошибка";
        }
    }

}
