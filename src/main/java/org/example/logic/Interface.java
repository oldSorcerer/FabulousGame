package org.example.logic;

import org.example.entity.Unit;

import java.util.ArrayList;

public interface Interface {

    void step(ArrayList<Unit> units, ArrayList<Unit> team);

    String getInfo();
}