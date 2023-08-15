package org.example.entity;

import org.example.logic.Interface;
import org.example.logic.Names;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractUnit implements Interface {

    protected boolean standby;
    private String name;
    private int damage;
    private int maxHp;
    private int hp;
    private int speed;
    public int moveDistance;
    public String state;

    Coordinates coordinates;

    public AbstractUnit(String name, int damage, int moveDistance, int maxHp, int hp, int speed, int x, int y) {
        this.name = name;
        this.damage = damage;
        this.maxHp = maxHp;
        this.hp = hp;
        this.speed = speed;
        coordinates = new Coordinates(x, y);
        this.moveDistance = moveDistance;
        this.state = "Standby";
    }

    public ArrayList<Integer> getCoords() {
        return coordinates.xy;
    }

    public void move(Coordinates targetPosition, ArrayList<AbstractUnit> team) {
        if (!coordinates.containsByPos(coordinates.newPosition(targetPosition, team), team)) {
            for (int i = 0; i < moveDistance; i++) {
                coordinates = coordinates.newPosition(targetPosition, team);
            }
        }
    }

    @Override
    public String getInfo() {
        return String.format("%s %s hp:%d", getType(), name, hp);
    }

    public AbstractUnit nearest(ArrayList<AbstractUnit> units) {
        double nearestDistance = Double.MAX_VALUE;
        AbstractUnit nearestEnemy = null;
        for (int i = 0; i < units.size(); i++) {
            if (coordinates.countDistance(units.get(i).coordinates) < nearestDistance) {
                if (units.get(i).getState() == "alive") {
                    nearestEnemy = units.get(i);
                    nearestDistance = coordinates.countDistance(units.get(i).coordinates);
                }
            }
        }
        return nearestEnemy;
    }

    public int getHp() {
        return hp;
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

    public int getMaxHp() {
        return maxHp;
    }

    public String getState() {
        if (getHp() > 1) return "alive";
        else return "dead";
    }

    public void HP_damage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
        if (hp > maxHp) hp = maxHp;
    }

    public int damage() {
        return damage;
    }
}
