package src.cassetete;

import src.cassetete.jeux.StatutBouton;

import java.util.Objects;

public class Case 
{
    private int x, y;
    private StatutBouton statut;  // 0: VIDE, 1: MUR, 2: DEPART, 3: ARRIVEE

    public Case(int x, int y, StatutBouton statut) 
    {
        this.x = x;
        this.y = y;
        this.statut = statut;
    }

//    Getters
    public int getX() 
    { 
        return x; 
    }
    
    public int getY() 
    { 
        return y; 
    }
    
    public StatutBouton getStatut() 
    { 
        return statut; 
    }

//    Setters
    public void setStatut(StatutBouton statut) 
    {
        this.statut = statut;
    }

    @Override
    public String toString() 
    {
        return x + "-" + y + "_" + statut.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return x == aCase.x && y == aCase.y;
    }
}
