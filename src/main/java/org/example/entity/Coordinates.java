package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Coordinates extends ArrayList<Integer> {
    int x;
    int y;
    ArrayList<Integer> xy = new ArrayList<>();

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
        xy.add(0, x);
        xy.add(1, y);
    }

    public double countDistance(Coordinates coordinates) {
        int dx = coordinates.x - x;
        int dy = coordinates.y - y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public Coordinates newPosition(Coordinates targetPosition, List<AbstractUnit> team) {
        Coordinates currentPos = new Coordinates(x, y);

        if (Math.abs(targetPosition.x - x) >= Math.abs(targetPosition.y - y)) {
            if (targetPosition.x - x > 0) currentPos.x += 1;
            else currentPos.x -= 1;
        }

        if (Math.abs(targetPosition.x - x) < Math.abs(targetPosition.y - y)) {
            if (targetPosition.y - y > 0) currentPos.y += 1;
            else currentPos.y -= 1;
        }
        return currentPos;
    }

    public boolean containsByPos(Coordinates nextPosition, List<AbstractUnit> team) {
        for (AbstractUnit avengers: team) {
            if (avengers.coordinates == nextPosition) return true;
        }
        return false;
    }
}