package src.cassetete.jeux;
import src.cassetete.Case;

import java.util.Observable;

public class Labyrinthe extends Observable 
{
    private Case[][] grille;
    private int largeur;
    private int hauteur;

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

    public Case[][] getGrille()
    {
        return grille;
    }

    // Setters
    public void setCase(int x, int y, StatutBouton statut) 
    {
        grille[x][y].setStatut(statut);
        setChanged();
        notifyObservers();
    }
}
