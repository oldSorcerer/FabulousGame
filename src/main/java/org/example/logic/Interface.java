package org.example.logic;

import org.example.entity.AbstractUnit;

import java.util.ArrayList;

public interface Interface {

    void step(ArrayList<AbstractUnit> units, ArrayList<AbstractUnit> team);

    String getInfo();
}