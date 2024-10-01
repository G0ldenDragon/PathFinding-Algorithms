package src.cassetete.jeux;
import src.cassetete.Case;

import java.util.Observable;

public class Labyrinthe extends Observable
{
    private int largeur;
    private int hauteur;
    private Case[][] grille;
    private StatutBouton statutMode = StatutBouton.VIDE;
    private Algo algorithmMode = Algo.Algo1;
    private Case depart = null;
    private Case arrivee = null;

    public Labyrinthe(int largeur, int hauteur)
    {
        this.largeur = largeur;
        this.hauteur = hauteur;
        grille = new Case[largeur][hauteur];

//        Initialisation de toutes les cases en VIDE
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                grille[x][y] = new Case(x, y, StatutBouton.VIDE);
            }
        }
    }

//    Getters
    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Case getCase(int x, int y)
    {
        return grille[x][y];
    }

    public Case[][] getGrille()
    {
        return grille;
    }

    public StatutBouton getStatutMode()
    {
        return statutMode;
    }

    public Algo getAlgorithmMode() {
        return algorithmMode;
    }

    public Case getDepart() {
        return depart;
    }

    public Case getArrivee() {
        return arrivee;
    }

    // Setters
    public void setCase(int x, int y)
    {
        grille[x][y].setStatut(statutMode);
        setChanged();
        notifyObservers();
    }

    public void setCase(int x, int y, StatutBouton statut)
    {
        grille[x][y].setStatut(statut);
        setChanged();
        notifyObservers();
    }

    public void setStatutMode (StatutBouton statut)
    {
        this.statutMode = statut;
    }

    public void setAlgorithmMode(Algo algorithmMode)
    {
        this.algorithmMode = algorithmMode;
    }

    public void setDepart(Case depart)
    {
        this.depart = depart;
    }

    public void setArrivee(Case arrivee)
    {
        this.arrivee = arrivee;
    }

    @Override
    public String toString()
    {
        String grilleToString = "Algorithme choisi : " + this.algorithmMode + "\n" +
                "Case Mode : " + this.statutMode + "\n" +
                "Case Départ : ";
        try
        {
            grilleToString += depart.toString();
        }
        catch (Exception e)
        {
            grilleToString += "NULL";
        }

        grilleToString += "\n" +
                "Case Arrivée : ";

        try
        {
            grilleToString += arrivee.toString();
        }
        catch (Exception e)
        {
            grilleToString += "NULL";
        }

        grilleToString += "\n";

        for (int x = 0; x < largeur; x++)
        {
            for (int y = 0; y < hauteur; y++)
            {
                grilleToString += (grille[x][y].toString() + "     ");
            }
            grilleToString += "\n";
        }
        return grilleToString;
    }
}
