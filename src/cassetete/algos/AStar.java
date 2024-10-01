package src.cassetete.algos;

import src.cassetete.Case;
import src.cassetete.jeux.Labyrinthe;
import src.cassetete.jeux.StatutBouton;

import java.util.*;

public class AStar {

    private final Labyrinthe labyrinthe;

    public AStar(Labyrinthe labyrinthe)
    {
        this.labyrinthe = labyrinthe;
    }

    // Fonction heuristique : distance de Manhattan
    private int heuristique(Case c1, Case c2) {
        return Math.abs(c1.getX() - c2.getX()) + Math.abs(c1.getY() - c2.getY());
    }

    // Renvoie les voisins valides d'une case
    private List<Case> voisins(Case c) {
        List<Case> voisins = new ArrayList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  // Droite, Gauche, Bas, Haut

        for (int[] direction : directions) {
            int nx = c.getX() + direction[0];
            int ny = c.getY() + direction[1];
            if (nx >= 0 && nx < labyrinthe.getHauteur() && ny >= 0 && ny < labyrinthe.getLargeur()) {
                Case voisin = labyrinthe.getGrille()[nx][ny];
                if (!voisin.getStatut().equals(StatutBouton.MUR)) {  // Corriger pour ajouter les voisins qui ne sont PAS des murs
                    voisins.add(voisin);
                }
            }
        }
        return voisins;
    }

    // A* pour trouver le chemin optimal
    public List<Case> trouverChemin() {
        // Initialiser gScore avec des valeurs infinies pour toutes les cases sauf le départ
        Map<Case, Integer> gScore = new HashMap<>();
        for (int i = 0; i < labyrinthe.getLargeur(); i++) {
            for (int j = 0; j < labyrinthe.getHauteur(); j++) {
                gScore.put(labyrinthe.getGrille()[i][j], Integer.MAX_VALUE);  // Score infini pour toutes les cases
            }
        }
        gScore.put(labyrinthe.getDepart(), 0);  // Le gScore du départ est 0

        // PriorityQueue pour l'openList, triée par fScore = gScore + heuristique
        PriorityQueue<Case> openList = new PriorityQueue<>(Comparator.comparingInt(c -> (gScore.get(c) + heuristique(c, labyrinthe.getArrivee()))));
        Set<Case> closedList = new HashSet<>();
        Map<Case, Case> cameFrom = new HashMap<>();

        openList.add(labyrinthe.getDepart());

        while (!openList.isEmpty()) {
            Case current = openList.poll();

            // Si on a atteint la case arrivée
            if (current.equals(labyrinthe.getArrivee())) {
                return reconstruireChemin(cameFrom, current);
            }

            closedList.add(current);

            for (Case voisin : voisins(current)) {
                if (closedList.contains(voisin)) {
                    continue;
                }

                int tentativeGScore = gScore.get(current) + 1;  // Toutes les distances entre les cases adjacentes valent 1

                // Si le nouveau chemin est plus court ou si le voisin n'a jamais été visité
                if (tentativeGScore < gScore.get(voisin)) {
                    cameFrom.put(voisin, current);
                    gScore.put(voisin, tentativeGScore);

                    if (!openList.contains(voisin)) {
                        openList.add(voisin);
                        if (voisin.getStatut().equals(StatutBouton.VIDE)) {
                            voisin.setStatut(StatutBouton.RECHERCHE);
                        }
                    }
                }
            }
        }
        return null;  // Aucun chemin trouvé
    }

    // Reconstruit le chemin à partir du Map cameFrom
    private List<Case> reconstruireChemin(Map<Case, Case> cameFrom, Case current) {
        List<Case> chemin = new ArrayList<>();
        while (cameFrom.containsKey(current)) {
            chemin.add(current);
            current = cameFrom.get(current);
        }
        Collections.reverse(chemin);
        for (Case c : chemin) {
            if (!c.getStatut().equals(StatutBouton.DEPART) && !c.getStatut().equals(StatutBouton.ARRIVEE)) {
                c.setStatut(StatutBouton.CHEMIN);
            }
        }
        return chemin;
    }

    // Décommenter pour tester
    /*
    public static void main(String[] args) {
        int rows = 5, cols = 5;
        Case[][] grille = new Case[rows][cols];

        // Initialiser la grille
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grille[i][j] = new Case(i, j, StatutBouton.VIDE);
            }
        }

        // Ajouter quelques murs
        grille[1][1].setStatut(StatutBouton.MUR);
        grille[1][2].setStatut(StatutBouton.MUR);
        grille[1][3].setStatut(StatutBouton.MUR);

        // Définir le départ et l'arrivée
        Case depart = grille[0][0];
        Case arrivee = grille[4][4];
        depart.setStatut(StatutBouton.DEPART);
        arrivee.setStatut(StatutBouton.ARRIVEE);

        // Exécuter l'algorithme A*
        AStar aStar = new AStar(grille, depart, arrivee);
        List<Case> chemin = aStar.trouverChemin();

        // Afficher la grille après l'exécution
        if (chemin != null) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(grille[i][j].getStatut().getColor() + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Aucun chemin trouvé.");
        }
    }
    */
}
