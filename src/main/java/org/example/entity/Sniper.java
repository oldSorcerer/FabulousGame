package org.example.entity;



public class Sniper extends AbstractShooters {

    public Sniper(String name, int x, int y) {
        super(name, 12, 100, 100, 300, 5, x, y);
    }

    @Override
    public String getType(){
        return "Sniper";
    }
}

