package org.example.entity;


public class Spearman extends AbstractInfantry {


    public Spearman(String name, int x, int y) {
        super(name, 7, 2,100, 100, 10,1,1, x, y);
    }


//    }
    @Override
    public String getType(){
        return "Spearman";
    }
}
