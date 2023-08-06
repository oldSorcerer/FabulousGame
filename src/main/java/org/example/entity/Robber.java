package org.example.entity;


public class Robber extends AbstractInfantry {
    public Robber(String name, int x, int y) {
        super(name, 12, 3,80, 80, 9,1,1, x, y);
    }


    @Override
    public String getType(){
        return "Robber";
    }
}