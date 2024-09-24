package src.vues;

import src.cassetete.jeux.Algo;
import src.cassetete.jeux.Labyrinthe;
import src.controleurs.algo.EcouteurAlgo;
import src.controleurs.boutons.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class VueBoutons extends JPanel implements Observer {

    public VueBoutons(Labyrinthe labyrinthe) 
    {
        // Boutons pour définir les types de cellules
        this.setLayout(new FlowLayout());
        
        // Texte non cliquable
        JLabel label = new JLabel("Composez votre labyrinthe");
        this.add(label);
        
        // Bouton Mur pour placer des Murs
        JButton murBouton = new JButton("Mur");
        murBouton.setBackground(Color.BLACK);
        murBouton.setForeground(Color.WHITE);
        murBouton.setOpaque(true);
        murBouton.setBorderPainted(false);
        murBouton.addActionListener(new EcouteurMur(labyrinthe));
        this.add(murBouton);

        // Bouton Départ pour placer le Départ
        JButton departBouton = new JButton("Départ");
        departBouton.setBackground(Color.GREEN);
        departBouton.setOpaque(true);
        departBouton.setBorderPainted(false);
        departBouton.addActionListener(new EcouteurDepart(labyrinthe));
        this.add(departBouton);

        // Bouton Départ pour placer le Départ
        JButton arriveeBouton = new JButton("Arrivée");
        arriveeBouton.setBackground(Color.RED);
        arriveeBouton.setOpaque(true);
        arriveeBouton.setBorderPainted(false);
        arriveeBouton.addActionListener(new EcouteurArrivee(labyrinthe));
        this.add(arriveeBouton);

        // Bouton Vide pour placer des cases Vide
        JButton videBouton = new JButton("Vide");
        videBouton.setBackground(Color.WHITE);
        videBouton.setOpaque(true);
        videBouton.setBorderPainted(false);
        videBouton.addActionListener(new EcouteurVide(labyrinthe));
        this.add(videBouton);

        // Crée un menu déroulant des différents algos
        JComboBox<Algo> menuDeroulant = new JComboBox<>(Algo.values());
        menuDeroulant.addActionListener(new EcouteurAlgo(menuDeroulant, labyrinthe));
        this.add(menuDeroulant);

        // Bouton "Démarrer"
        JButton boutonLancerAlgo = new JButton("Démarrer");
        boutonLancerAlgo.addActionListener(new EcouteurDemarrer(labyrinthe));
        this.add(boutonLancerAlgo);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Labyrinthe) {
            Labyrinthe labyrinthe = (Labyrinthe) o;
        }
    }
}