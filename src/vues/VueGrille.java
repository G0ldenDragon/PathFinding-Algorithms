package src.vues;

import src.cassetete.jeux.Labyrinthe;
import src.controleurs.grille.EcouteurGrille;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class VueGrille extends JPanel implements Observer {

    public VueGrille(VueFenetre vueFenetre, Labyrinthe labyrinthe) {
        this.setLayout(new GridLayout(labyrinthe.getLargeur(), labyrinthe.getHauteur()));
        
        // Initialisation du tableau de Case et création des boutons
        for (int i = 0; i < labyrinthe.getLargeur(); i++) {
            for (int j = 0; j < labyrinthe.getHauteur(); j++) {
                
                // Créer un bouton pour chaque case
                JButton button = new JButton("(" + i + "," + j + ")");
                button.setBackground(Color.WHITE);
                button.setOpaque(true);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                button.addActionListener(new EcouteurGrille(labyrinthe));
                this.add(button);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Labyrinthe) {
            Labyrinthe labyrinthe = (Labyrinthe) o;
        }
    }
}
