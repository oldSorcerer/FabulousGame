package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShooters extends AbstractUnit {

    private int shoots;

    public AbstractShooters(String name, int damage, int maxHp, int hp, int speed, int shoots, int x, int y) {
        super(name, damage, 0, maxHp, hp, speed, x, y);
        this.shoots = shoots;
    }

    public int doShootDamage() {
        return getDamage();
    }

    @Override
    public void step(List<AbstractUnit> units, List<AbstractUnit> team) {
        if (getState() == "dead" || this.shoots == 0) return;
        for (AbstractUnit unit : team) {
            if (unit.getType().equals("Peasant") && unit.getState() == "alive" && unit.standby) {
                if (unit.getHp() > 0) {
                    shoots++;
                    unit.state = "busy";
                    break;
                }
            }
        }
        nearest(units).HP_damage(doShootDamage());
        shoots -= 1;
        return;
    }

    @Override
    public String getInfo() {
        return String.format("%s %s hp:%d shoots:%d", getType(), getName(), getHp(), shoots);
    }
}

