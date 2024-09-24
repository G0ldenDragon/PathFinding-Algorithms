package cassetete.jeux;

import cassetete.Case;
import java.util.Observable;

public class Labyrinthe extends Observable {
    private Case[][] grille;
    private int largeur;
    private int hauteur;

    public Labyrinthe(int largeur, int hauteur) {
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

    // Méthode pour modifier une case donnée
    public void setCase(int x, int y, StatutBouton statut) 
    {
        grille[x][y].setStatut(statut);
        setChanged();
        notifyObservers();
    }

    public Case[][] getGrille() 
    {
        return grille;
    }
}
