package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Peasant extends AbstractSuppurt {

    public Peasant(String name, int x, int y) {
        super(name, 0, 1,50, 50, 1, x, y);
    }

    @Override
    public void step(List<AbstractUnit> units, List<AbstractUnit> team) {
        if (getState() == "dead") return;
        state = "standby";
    }

    public String getType(){
        return "Peasant";
    }
}
