package com.github.perscholas;

public class ApplicationRunner implements Runnable {
    public void run() {
        animateMonster((Monster)new FireMonster());
        animateMonster((Monster)new WaterMonster());
        animateMonster((Monster)new StoneMonster());
    }

    private void animateMonster(Monster monster) {
        String monsterType = monster.getClass().getSimpleName();
        System.out.println(monsterType + " has been created!");

        String attackOutput = monster.attack();
        System.out.println("A " + monsterType + " has attacked.");
        System.out.println("The attack performed was " + attackOutput);
    }
}
