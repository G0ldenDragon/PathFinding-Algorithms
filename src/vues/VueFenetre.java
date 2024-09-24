package src.vues;

import src.cassetete.jeux.Labyrinthe;

import java.awt.*;
import javax.swing.*;

public class VueFenetre extends JFrame {
    private VueGrille vueGrille;
    private VueBoutons vueBoutons;
    private VueAffichage vueAffichage;
    private Labyrinthe labyrinthe;

    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }
    
    public VueFenetre(
            String name, 
            int widthSize, 
            int heightSize,
            int widthGridSize,
            int heightGridSize
    )
    {
        this.labyrinthe = new Labyrinthe(widthGridSize, heightGridSize);
        
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(widthSize, heightSize);
        this.setLayout(new BorderLayout());

//        vueAffichage = new VueAffichage(this);
        vueGrille = new VueGrille(labyrinthe);
        vueBoutons = new VueBoutons(labyrinthe);
        
//        this.add(vueAffichage, BorderLayout.SOUTH);
        this.add(vueGrille, BorderLayout.CENTER);
        this.add(vueBoutons, BorderLayout.NORTH);

//        Affichage de la fenetre
        this.setVisible(true);
        
    }
}
