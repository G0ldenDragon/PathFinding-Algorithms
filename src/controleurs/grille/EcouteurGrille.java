package src.controleurs.grille;

import src.cassetete.Case;
import src.cassetete.jeux.Labyrinthe;
import src.cassetete.jeux.StatutBouton;
import src.vues.VueGrille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class EcouteurGrille implements ActionListener 
{
    private Labyrinthe labyrinthe;
    private int positionX;
    private int positionY;
    private VueGrille vueGrille;

    public EcouteurGrille(Labyrinthe labyrinthe, int positionX, int positionY, VueGrille vueGrille) 
    {
        this.labyrinthe = labyrinthe;
        this.positionX = positionX;
        this.positionY = positionY;
        this.vueGrille = vueGrille;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
//        Obtention du bouton source
        JButton sourceButton = (JButton) e.getSource();
        
//        Cas d'un ajout d'un Départ
        if (labyrinthe.getStatutMode() == StatutBouton.DEPART)
        {

//            Si Départ à été initialisé
            if (labyrinthe.getDepart() != null)
            {
                labyrinthe.setCase(
                        labyrinthe.getDepart().getX(),
                        labyrinthe.getDepart().getY(),
                        StatutBouton.VIDE
                );
                
                vueGrille.setButtonBackGroundColor(
                        labyrinthe.getDepart().getX(), 
                        labyrinthe.getDepart().getY(), 
                        setBackgroundColor(
                                StatutBouton.VIDE.toString()
                        )
                );
            }

            labyrinthe.setDepart(new Case(positionX, positionY, StatutBouton.DEPART));
        }

//        Cas d'un ajout d'une Arrivée
        else if (labyrinthe.getStatutMode() == StatutBouton.ARRIVEE)
        {
            
//            Si Arrivée à été initialisé
            if (labyrinthe.getArrivee() != null)
            {
                labyrinthe.setCase(
                        labyrinthe.getArrivee().getX(),
                        labyrinthe.getArrivee().getY(),
                        StatutBouton.VIDE
                );
                
                vueGrille.setButtonBackGroundColor(
                        labyrinthe.getArrivee().getX(), 
                        labyrinthe.getArrivee().getY(), 
                        setBackgroundColor(
                                StatutBouton.VIDE.toString()
                        )
                );
            }
            
            labyrinthe.setArrivee(new Case(positionX, positionY, StatutBouton.ARRIVEE));
        }
        
//        Tous les autres cas
        else
        {
//            Si modification de l'Arrivée ou du Départ, remise à NULL
            if (labyrinthe.getCase(positionX, positionY).equals(labyrinthe.getDepart()))
            {
                labyrinthe.setDepart(null);
            }
            if (labyrinthe.getCase(positionX, positionY).equals(labyrinthe.getArrivee()))
            {
                labyrinthe.setArrivee(null);
            }
        }
        
//        Modification du tableau back-end
        labyrinthe.setCase(positionX, positionY);
//        Modification de la couleur front-end
        sourceButton.setBackground(setBackgroundColor(labyrinthe.getStatutMode().toString()));
        
//        Affichage du tableau du labyrinthe
        System.out.println(labyrinthe.toString());
    }
    
    private Color setBackgroundColor(String color)
    {
        try {
            Field field = Color.class.getField(color);
            Color backgroundColor = (Color) field.get(null);
            return backgroundColor;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
