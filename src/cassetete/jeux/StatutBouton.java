package src.cassetete.jeux;

public enum StatutBouton {
    VIDE("WHITE"),
    MUR("BLACK"),
    DEPART("GREEN"),
    ARRIVEE("RED");

    private String mode;

    private StatutBouton(String mode) {
        this.mode = mode;
    }

    public String toString() {
        return this.mode;
    }
}