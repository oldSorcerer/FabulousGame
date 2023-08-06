package org.example.entity;

import java.util.ArrayList;

public class Peasant extends AbstractSuppurt {

    public Peasant(String name, int x, int y) {
        super(name, 0, 1,50, 50, 1, x, y);
    }

    @Override
    public void step(ArrayList<Unit> units, ArrayList<Unit> team) {
        if (getState() == "dead") return;
        state = "standby";
    }

    public String getType(){
        return "Peasant";
    }
}
