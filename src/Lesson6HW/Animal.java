package Lesson6HW;

public class Animal {
    protected String name;
    protected String color;
    protected float run;
    protected float swim;

    public Animal(String name, String color, float run, float swim) {
        this.name = name;
        this.color = color;
        this.run = run;
        this.swim = swim;
    }

    public void info () {
        System.out.println(name + " ");
    }

    public String run(int dictanceRun) {
        return name + " пробежал " + dictanceRun + " м.";
    }

    public String swim(int dictanceSwim) {
        return name + " проплыл " + dictanceSwim + " м.";
    }
}
