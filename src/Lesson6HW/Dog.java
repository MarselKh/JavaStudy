package Lesson6HW;

public class Dog extends Animal {

    public Dog(String name, String color, float run, float swim) {
        super(name, color, run, swim);
    }

    @Override
    public String run (int dictanceRun) {
        int maxDictance = 500;
        if ( dictanceRun > maxDictance) {
            return "Собака " + name + " Не может пробежать более 200 м";
        } else {
            return "Собака " + name + " пробежала " + dictanceRun + " м.";
        }

    }
    @Override
    public String swim (int dictanceSwim) {
        int maxDictance = 10;
        if (dictanceSwim <= maxDictance && dictanceSwim >= 0) {
            return "Собака " + name + "  проплыла " + dictanceSwim + " м.";
        } else if (dictanceSwim > maxDictance) {
            return "Собака " + name + " Не может проплыть более 10 м";
        } else {
            return "Ошибка";
        }
    }
}
