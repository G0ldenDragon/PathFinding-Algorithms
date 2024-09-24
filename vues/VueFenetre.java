package vues;

import cassetete.jeux.Labyrinthe;
import com.sun.jdi.ShortType;

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
    
    public VueFenetre(String name, int widthSize, int heightSize)
    {
        this.setTitle(name);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(widthSize, heightSize);
        this.setLayout(new BorderLayout());

//        vueAffichage = new VueAffichage(this);
        vueGrille = new VueGrille(this, 10, 10);
        vueBoutons = new VueBoutons(this);
        
//        this.add(vueAffichage, BorderLayout.SOUTH);
        this.add(vueGrille, BorderLayout.CENTER);
        this.add(vueBoutons, BorderLayout.NORTH);

//        Affichage de la fenetre
        this.pack();
        this.setVisible(true);
        
    }
}
