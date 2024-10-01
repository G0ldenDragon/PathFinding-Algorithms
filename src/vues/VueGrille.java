package src.vues;

import src.cassetete.jeux.Labyrinthe;
import src.controleurs.grille.EcouteurGrille;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class VueGrille extends JPanel implements Observer {

    private JButton[][] buttons;
    
    public VueGrille(Labyrinthe labyrinthe) {
        this.setLayout(new GridLayout(labyrinthe.getLargeur(), labyrinthe.getHauteur()));
        
        // Initialisation du tableau de Boutons
        this.buttons = new JButton[labyrinthe.getLargeur()][labyrinthe.getHauteur()];

        // Initialisation du tableau de Case et création des boutons
        for (int x = 0; x < labyrinthe.getLargeur(); x++) {
            for (int y = 0; y < labyrinthe.getHauteur(); y++) {
                
                // Créer un bouton pour chaque case
                JButton button = new JButton("(" + x + "," + y + ")");
                button.setBackground(Color.WHITE);
                button.setOpaque(true);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                button.addActionListener(new EcouteurGrille(labyrinthe, x, y, this));
                
                buttons[x][y] = button;
                this.add(button);
            }
        }
    }
    
    public void setButtonBackGroundColor (int x, int y, Color color)
    {
        buttons[x][y].setBackground(color);
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Labyrinthe) {
            Labyrinthe labyrinthe = (Labyrinthe) o;
        }
    }
}
