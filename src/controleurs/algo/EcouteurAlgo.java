package src.controleurs.algo;

import src.cassetete.jeux.Algo;
import src.cassetete.jeux.Labyrinthe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EcouteurAlgo implements ActionListener {
    
    private Labyrinthe labyrinthe;
    private JComboBox<Algo> algoComboBox;

    public EcouteurAlgo(JComboBox<Algo> algoComboBox, Labyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        this.algoComboBox = algoComboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Si des actions spécifiques doivent être réalisées lors de la sélection d'un algorithme, ajoutez-les ici.
        Algo selectedAlgo = (Algo) algoComboBox.getSelectedItem();
        labyrinthe.setAlgorithmMode(selectedAlgo);
    }
}