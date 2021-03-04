package Practicum;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> games = new ArrayList<Game>();
    public Persoon(String nm, double bud){
        naam = nm;
        budget = bud;
    }
    public double getBudget(){
        return budget;
    }
    public boolean koop(Game g){
        for (Game game : games){
            if (g.getNaam().equals(game.getNaam())){
                return false;
            }
        }
        if (g.huidigeWaarde() > budget){
            return false;
        }
        else {
            this.budget -= g.huidigeWaarde();
            games.add(g);
            return true;
        }
    }
    public boolean verkoop(Game g, Persoon koper){
        boolean isEigenaar = false;
        for (Game game: games) {
            if (g.getNaam().equals(game.getNaam())){
                isEigenaar = true;
            }
        }
        if (!isEigenaar){
            return false;
        }
        for (Game game : koper.games){
            if (g.getNaam().equals(game.getNaam())){
                return false;
            }
        }
        if (g.huidigeWaarde() > koper.getBudget()){
            return false;
        }
        else {
            this.games.remove(g);
            koper.budget -= g.huidigeWaarde();
            koper.games.add(g);
            budget += g.huidigeWaarde();
            return true;
        }
    }
    public Game zoekGameOpNaam(String gameNaam){
        for (Game game : games){
            if (game.getNaam().equals(gameNaam)){
                return game;
            }
        }
        return null;
    }
    public String toString(){
        String res = "";
        res += naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:";
        for (Game game : games){
            res += "\n" + game.toString() ;
        }
        return res;
    }
}
