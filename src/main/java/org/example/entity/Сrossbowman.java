package org.example.entity;



public class Сrossbowman extends AbstractShooters {

    public Сrossbowman(String name, int x, int y) {
        super(name, 10, 100, 100, 8, 5, x, y);
    }

    @Override
    public String getType(){
        return "Crossbowman";
    }
}