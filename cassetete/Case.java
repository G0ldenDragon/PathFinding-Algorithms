package cassetete;

import cassetete.jeux.StatutBouton;

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

    public void setStatut(StatutBouton statut) 
    {
        this.statut = statut;
    }
}
