package vues;

import cassetete.jeux.Algo;
import cassetete.jeux.Labyrinthe;
import controleurs.algo.EcouteurAlgo;
import controleurs.boutons.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class VueBoutons extends JPanel implements Observer {

    public VueBoutons(VueFenetre vueFenetre) 
    {
        // Boutons pour définir les types de cellules

        // Texte non cliquable
        JLabel label = new JLabel("Composez votre labyrinthe");
        this.add(label);
        
        // Bouton Mur pour placer des Murs
        JButton murBouton = new JButton("Mur");
        murBouton.setBackground(Color.BLACK);
        murBouton.setForeground(Color.WHITE);
        murBouton.setOpaque(true);
        murBouton.setBorderPainted(false);
        murBouton.addActionListener(new EcouteurMur(vueFenetre.getLabyrinthe()));
        this.add(murBouton);

        // Bouton Départ pour placer le Départ
        JButton departBouton = new JButton("Départ");
        departBouton.setBackground(Color.GREEN);
        departBouton.setOpaque(true);
        departBouton.setBorderPainted(false);
        departBouton.addActionListener(new EcouteurDepart(vueFenetre.getLabyrinthe()));
        this.add(departBouton);

        // Bouton Départ pour placer le Départ
        JButton arriveeBouton = new JButton("Arrivée");
        arriveeBouton.setBackground(Color.RED);
        arriveeBouton.setOpaque(true);
        arriveeBouton.setBorderPainted(false);
        arriveeBouton.addActionListener(new EcouteurArrivee(vueFenetre.getLabyrinthe()));
        this.add(arriveeBouton);

        // Bouton Vide pour placer des cases Vide
        JButton videBouton = new JButton("Vide");
        videBouton.setBackground(Color.WHITE);
        videBouton.setOpaque(true);
        videBouton.setBorderPainted(false);
        videBouton.addActionListener(new EcouteurVide(vueFenetre.getLabyrinthe()));
        this.add(videBouton);

        // Crée un menu déroulant des différents algos
        JComboBox<Algo> menuDeroulant = new JComboBox<>(Algo.values());
        menuDeroulant.addActionListener(new EcouteurAlgo(menuDeroulant, vueFenetre.getLabyrinthe()));
        this.add(menuDeroulant);

        // Bouton "Démarrer"
        JButton boutonLancerAlgo = new JButton("Démarrer");
        boutonLancerAlgo.addActionListener(new EcouteurDemarrer(vueFenetre.getLabyrinthe()));
        this.add(boutonLancerAlgo);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Labyrinthe) {
            Labyrinthe labyrinthe = (Labyrinthe) o;
        }
    }
}