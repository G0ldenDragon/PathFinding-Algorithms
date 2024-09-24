package vues;

import cassetete.jeux.Labyrinthe;

import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class VueGrille extends JPanel implements Observer {

    public VueGrille(VueFenetre vueFenetre, int widthCellSize, int heightCellSize) {
        
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Labyrinthe) {
            Labyrinthe labyrinthe = (Labyrinthe) o;
        }
    }
}
