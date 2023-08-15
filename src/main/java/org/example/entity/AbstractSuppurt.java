package org.example.entity;

public abstract class AbstractSuppurt extends AbstractUnit {
    public AbstractSuppurt(String name, int damage, int moveDistance, int maxHp, int hp, int speed, int x, int y) {
        super(name, damage, moveDistance, maxHp, hp, speed, x, y);
    }

//    @Override
//    public void step(ArrayList<Unit> units, ArrayList<Unit> team) {
//        if (getState() == "dead") return;
//        if ((int) coordinates.countDistance(nearest(units).coordinates) <= attackRange) {
//            if (mana > 0) {
//                nearest(units).HP_damage(getDamage());
//                mana -= 1;
//                state = "Attack";
//            } else {
//                mana += 1;
//                state = "Busy";
//            }
//        } else {
//            move(nearest(units).coordinates, team);
//            state = "Moving";
//        }
//    }


}
