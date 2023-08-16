package org.example.logic;

import org.example.entity.AbstractUnit;

import java.util.List;

public interface Interface {

    void step(List<AbstractUnit> units, List<AbstractUnit> team);

    String getInfo();
}