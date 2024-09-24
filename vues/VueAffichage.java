package vues;

import cassetete.jeux.Labyrinthe;

import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class VueAffichage extends JPanel implements Observer {

    public VueAffichage() {

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Labyrinthe) {
            Labyrinthe labyrinthe = (Labyrinthe) o;
        }
    }
}