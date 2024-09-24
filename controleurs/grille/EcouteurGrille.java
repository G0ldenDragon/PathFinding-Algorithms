package controleurs.grille;

import cassetete.jeux.Labyrinthe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcouteurGrille extends MouseAdapter {
    private Labyrinthe labyrinthe;

    public EcouteurGrille(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Code pour gérer les clics sur la grille
    }
}
