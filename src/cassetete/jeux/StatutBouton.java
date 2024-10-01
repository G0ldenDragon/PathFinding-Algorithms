package src.cassetete.jeux;

import src.cassetete.Case;

import java.awt.*;
import java.lang.reflect.Field;

public enum StatutBouton {
    VIDE("WHITE"),
    MUR("BLACK"),
    DEPART("GREEN"),
    ARRIVEE("RED"),
    CHEMIN("CYAN"),
    RECHERCHE("YELLOW");

    private String mode;

    private StatutBouton(String mode) {
        this.mode = mode;
    }

    public String toString() {
        return this.mode;
    }

    public static Color setBackgroundColor(String color)
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