package Lesson7HW.models;

public class Enemy {
    private int health;
    private int attackPoint;
    private int x;
    private int y;

    private int enemyValueMin = 20;
    private int enemyValueMax = 20;

    private int countEnemies;

    public Enemy(int countEnemies) {
        this.health = Tools.myRandom(enemyValueMin, enemyValueMax);
        this.attackPoint = Tools.myRandom(enemyValueMin, enemyValueMax);
        this.countEnemies = countEnemies;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void decreaseHP(int value) {
        this.health -= value;
    }

    public int getCountEnemies() {
        return countEnemies;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public void killEnemy () {
        --countEnemies;
    }
}
