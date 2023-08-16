package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Mag extends AbstractMagic {

    public Mag(String name, int x, int y) {
        super(name, 10, 1,100, 100, 3,3, x,y);
    }

    @Override
    public void step(List<AbstractUnit> units, List<AbstractUnit> team) {
        if (getState() == "alive") {
            if(getMana()>0){
                nearest(units).HP_damage(damage());
                mana -= 1;
            }
            else mana+=1;
        }
    }

    @Override
    public String getType(){
        return "Mag";
    }
}

