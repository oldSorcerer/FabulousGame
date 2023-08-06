package org.example.entity;

import java.util.ArrayList;

public abstract class AbstractInfantry extends Unit {

    protected int attacksAmount;
    protected int attackRange;

    public AbstractInfantry(String name, int damage, int moveDistance, int maxHp, int hp, int speed, int attacksAmount, int attackRange, int x, int y) {
        super(name, damage,moveDistance, maxHp, hp, speed, x, y);
        this.attacksAmount = attacksAmount;
        this.attackRange = attackRange;

    }

    @Override
    public void step(ArrayList<Unit> units, ArrayList<Unit> team) {
        if (getState() == "dead") return;

        if (coordinates.countDistance(nearest(units).coordinates) <= attackRange) {
            for (int i = 0; i < attacksAmount; i++) {
                nearest(units).HP_damage(getDamage());
            }
            state = "Attack";
        } else {
            move(nearest(units).coordinates, team);
            state = "Moving";
        }
    }
}



