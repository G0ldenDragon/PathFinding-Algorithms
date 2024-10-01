package src.controleurs.boutons;

import src.cassetete.Case;
import src.cassetete.algos.AStar;
import src.cassetete.jeux.Algo;
import src.cassetete.jeux.Labyrinthe;
import src.cassetete.jeux.StatutBouton;
import src.vues.VueGrille;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EcouteurDemarrer implements ActionListener
{
    private Labyrinthe labyrinthe;
    private VueGrille vueGrille;
    private List<Case> dernierAlgo;

    public EcouteurDemarrer(Labyrinthe labyrinthe, VueGrille vueGrille)
    {
        this.labyrinthe = labyrinthe;
        this.vueGrille = vueGrille;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Remise à 0 des recherches
        if (dernierAlgo != null)
        {
            for (Case caseX : dernierAlgo)
            {
                if (caseX.getStatut().equals(StatutBouton.RECHERCHE) || caseX.getStatut().equals(StatutBouton.CHEMIN))
                {
                    caseX.setStatut(StatutBouton.VIDE);
                }
            }
        }

        if (labyrinthe.getAlgorithmMode() == Algo.Algo1)
        {

        }
        if (labyrinthe.getAlgorithmMode() == Algo.Algo2)
        {
            AStar aStar = new AStar(labyrinthe);
            List<Case> listeChemin = aStar.trouverChemin();
            this.dernierAlgo = listeChemin;
            for (Case caseX : listeChemin)
            {
//                if (caseX.getStatut().equals(StatutBouton.VIDE))
//                {
                    vueGrille.setButtonBackGroundColor(
                            caseX.getX(),
                            caseX.getY(),
                            StatutBouton.setBackgroundColor(
                                    StatutBouton.CHEMIN.toString()
                            )
                    );
//                }
            }

//            List<Case> listeTrouve = aStar.getCheminsNonRetenus();
//            for (Case caseX : listeTrouve)
//            {
//                vueGrille.setButtonBackGroundColor(
//                        caseX.getX(),
//                        caseX.getY(),
//                        StatutBouton.setBackgroundColor(
//                                StatutBouton.RECHERCHE.toString()
//                        )
//                );
//            }
            System.out.println(listeChemin);
        }
        if (labyrinthe.getAlgorithmMode() == Algo.Algo3)
        {

        }
        if (labyrinthe.getAlgorithmMode() == Algo.Algo4)
        {

        }
        if (labyrinthe.getAlgorithmMode() == Algo.Algo5)
        {

        }
        if (labyrinthe.getAlgorithmMode() == Algo.Algo6)
        {

        }

    }
}
