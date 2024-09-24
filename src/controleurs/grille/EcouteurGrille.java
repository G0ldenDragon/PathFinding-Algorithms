package src.controleurs.grille;

import src.cassetete.jeux.Labyrinthe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class EcouteurGrille implements ActionListener {
    private Labyrinthe labyrinthe;

    public EcouteurGrille(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
