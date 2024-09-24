package controleurs.boutons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cassetete.jeux.Labyrinthe;

public class EcouteurArrivee implements ActionListener {

    private Labyrinthe labyrinthe;

    public EcouteurArrivee(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Labyrinthe.selectedColor = java.awt.Color.RED;
    }
}
