package org.example.entity;

import java.util.ArrayList;

public class Monk extends AbstractMagic {
    private int heal;
    public Monk(String name, int x, int y) {
        super(name, 9, 3, 100,100, 6,3, x, y);
        this.heal = -5;
    }
    public int getHeal() {
        return heal;
    }

    @Override
    public void step(ArrayList<Unit> units, ArrayList<Unit> team) {
        if (getState() == "alive") {
            if (getMana() > 0) {
                float min_XP = Integer.MAX_VALUE;
                int index = 0;
                for (int i = 0; i < team.size(); i++) {
                    if ((float) (team.get(i).getHp() / getMaxHp()) < min_XP && team.get(i).getState() == "alive") {
                        min_XP = (float) (team.get(i).getHp() / getMaxHp());
                        index = i;
                    }
                    team.get(index).HP_damage(getHeal());
                }
            }
        }
        else mana+=1;
    }
    @Override
    public String getType(){
        return "Monk";
    }
}
