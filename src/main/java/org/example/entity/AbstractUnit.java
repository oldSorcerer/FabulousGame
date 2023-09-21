package org.example.entity;

import org.example.logic.Interface;
import org.example.logic.Names;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public abstract class AbstractUnit implements Interface {

    protected boolean standby; // поддержка ?

    private final String name;
    private final int damage;
    private final int maxHealthPoint;
    private int healthPoint;
    private final int speed;

    public int moveDistance;
    public String state; // состояние

    Coordinates coordinates;

    // имя урон длина шага ?
    public AbstractUnit(String name, int damage, int moveDistance, int maxHealthPoint, int healthPoint, int speed, int x, int y) {
        this.name = name;
        this.damage = damage;
        this.moveDistance = moveDistance;
        this.maxHealthPoint = maxHealthPoint;
        this.healthPoint = healthPoint;
        this.speed = speed;

        coordinates = new Coordinates(x, y);

        state = "Standby";
    }

    public List<Integer> getCoords() {
        return coordinates.xy;
    }

    public void move(Coordinates targetPosition, List<AbstractUnit> team) {
        Coordinates integers = coordinates.newPosition(targetPosition, team);
        if (!coordinates.containsByPos(integers, team)) {
            for (int i = 0; i < moveDistance; i++) {// ??
                coordinates = coordinates.newPosition(targetPosition, team);
            }
        }
    }

    @Override
    public String getInfo() {
        return String.format("%s %s hp:%d", getType(), name, healthPoint);
    }

    public AbstractUnit nearest(List<AbstractUnit> units) {
        double nearestDistance = Double.MAX_VALUE;
        AbstractUnit nearestEnemy = null; // ближайший враг
        for (AbstractUnit unit : units) {
            if (coordinates.countDistance(unit.coordinates) < nearestDistance) {
                if (Objects.equals(unit.getState(), "alive")) {
                    nearestEnemy = unit;
                    nearestDistance = coordinates.countDistance(unit.coordinates);
                }
            }
        }
        return nearestEnemy;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getDamage() {
        return damage;
    }

    public static String setName() {
        return (Names.values()[new Random().nextInt(Names.values().length)].toString());
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return "";
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public String getState() {
        return getHealthPoint() > 1 ? "alive" : "dead";
    }

    public void HP_damage(int damage) {
        healthPoint -= damage;
        if (healthPoint < 0) {
            healthPoint = 0;
        }
        if (healthPoint > maxHealthPoint) healthPoint = maxHealthPoint;
    }

    public int damage() {
        return damage;
    }
}
