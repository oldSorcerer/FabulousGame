package org.example;

import org.example.entity.*;
import org.example.logic.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Unit> team1 = new ArrayList<>();
    public static ArrayList<Unit> team2 = new ArrayList<>();
    public static ArrayList<Unit> allTeam = new ArrayList<>();
    public static void main(String[] args) {


        for (int i = 0; i < 11; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case 0 -> team1.add(new Mag(Unit.setName(),1, i));
                case 1 -> team1.add(new Monk(Unit.setName(),1, i));
                case 2 -> team1.add(new Peasant(Unit.setName(),1, i));
                case 3 -> team1.add(new Robber(Unit.setName(),1, i));
                case 4 -> team1.add(new Sniper(Unit.setName(),1, i));
                case 5 -> team1.add(new Spearman(Unit.setName(),1, i));
                case 6 -> team1.add(new Сrossbowman(Unit.setName(),1, i));
            }
        }

        for (int i = 0; i < 11; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case 0 -> team2.add(new Mag(Unit.setName(),10, i));
                case 1 -> team2.add(new Monk(Unit.setName(),10, i));
                case 2 -> team2.add(new Peasant(Unit.setName(),10, i));
                case 3 -> team2.add(new Robber(Unit.setName(),10, i));
                case 4 -> team2.add(new Sniper(Unit.setName(),10, i));
                case 5 -> team2.add(new Spearman(Unit.setName(),10, i));
                case 6 -> team2.add(new Сrossbowman(Unit.setName(),10, i));
            }
        }

        System.out.println("Team1: ");
        team1.forEach(n-> System.out.println(n.getInfo()));
        System.out.println("\nTeam2: ");
        team2.forEach(n-> System.out.println(n.getInfo()));


        allTeam.addAll(team1);
        allTeam.addAll(team2);
        allTeam.sort(Comparator.comparing(Unit::getSpeed));
        Collections.reverse(allTeam);
        team1.sort(Comparator.comparing(Unit::getSpeed));
        Collections.reverse(team1);
        team2.sort(Comparator.comparing(Unit::getSpeed));
        Collections.reverse(team2);


        Scanner in = new Scanner(System.in);
//        while (true) {
//            in.nextLine();
//            team1.forEach(n -> n.step(team2, team1));
//            team2.forEach(n -> n.step(team1, team2));
//            System.out.println("\nTeam1 урон: ");
//            team1.forEach(n-> System.out.println(n.getInfo()));
//
//            System.out.println("\nTeam2 урон: ");
//            team2.forEach(n-> System.out.println(n.getInfo()));
//
//        }
        while(true) {
            View.view();
            in.nextLine();
            for (Unit hero : allTeam) {
                if (team2.contains(hero)) hero.step(team1, team2);
                else hero.step(team2, team1);
            }
            if (isTeamDie(team1)) {
                System.out.println("Team 2 (Blue) win");
                break;
            }
            if (isTeamDie(team2)) {
                System.out.println(("Team 1 (Green) win"));
                break;
            }
        }
    }
    static boolean isTeamDie(ArrayList<Unit> team) {
        for (Unit hero: team) {
            if (hero.getState()=="alive") return false;
        }
        return true;
    }

}

