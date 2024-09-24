package src.controleurs.boutons;

import src.cassetete.jeux.Labyrinthe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurDemarrer implements ActionListener {

    private Labyrinthe labyrinthe;

    public EcouteurDemarrer(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Labyrinthe.selectedColor = java.awt.Color.RED;
    }
}
