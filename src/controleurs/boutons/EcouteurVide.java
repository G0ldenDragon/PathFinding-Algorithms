package src.controleurs.boutons;

import src.cassetete.jeux.Labyrinthe;
import src.cassetete.jeux.StatutBouton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurVide implements ActionListener {

    private Labyrinthe labyrinthe;

    public EcouteurVide(Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
//        System.out.println("Case \"Vide\" séléctionnée.");
        labyrinthe.setStatutMode(StatutBouton.VIDE);
    }
}
