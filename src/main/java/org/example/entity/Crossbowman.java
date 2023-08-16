package org.example.entity;

public class Crossbowman extends AbstractShooters {

    public Crossbowman(String name, int x, int y) {
        super(name, 10, 100, 100, 8, 5, x, y);
    }

    @Override
    public String getType(){
        return "Crossbowman";
    }
}