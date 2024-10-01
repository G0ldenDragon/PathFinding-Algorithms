package src.cassetete;

import src.cassetete.jeux.Labyrinthe;
import src.cassetete.jeux.StatutBouton;

import java.util.ArrayList;
import java.util.List;

public class Case {
    private int x, y;
    private StatutBouton statut;

    public Case(int x, int y, StatutBouton statut) {
        this.x = x;
        this.y = y;
        this.statut = statut;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public StatutBouton getStatut() {
        return statut;
    }

    public void setStatut(StatutBouton statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Case aCase = (Case) obj;
        return x == aCase.x && y == aCase.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return "Case{" +
                "x=" + x +
                ", y=" + y +
                ", statut=" + statut +
                '}';
    }
}
