package cassetete.algos;

import java.util.PriorityQueue;
import java.util.Comparator;
import cassetete.jeux.Labyrinthe;

public class AStar {
    private int[][] grid;
    private int rows = 10;
    private int cols = 10;

    public AStar(int[][] grid) {
        this.grid = grid;
    }

    public boolean rechercherChemin() {
        // Exécuter l'algorithme A* pour trouver un chemin
        // Implémentation simplifiée

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        boolean[][] closedList = new boolean[rows][cols];

        // Trouver le point de départ et le point d'arrivée
        Node start = null, goal = null;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) { // Départ
                    start = new Node(i, j, null, 0, heuristique(i, j, 3, 3));
                }
                if (grid[i][j] == 3) { // Arrivée
                    goal = new Node(i, j, null, 0, 0);
                }
            }
        }

        if (start == null || goal == null) return false;

        openList.add(start);

        while (!openList.isEmpty()) {
            Node current = openList.poll();

            if (current.equals(goal)) {
                // Chemin trouvé
                return true;
            }

            closedList[current.x][current.y] = true;

            // Explorer les voisins
            for (int[] direction : directions()) {
                int nx = current.x + direction[0];
                int ny = current.y + direction[1];

                if (isValid(nx, ny) && !closedList[nx][ny] && grid[nx][ny] != 1) { // 1 est un mur
                    int gNew = current.g + 1;
                    int hNew = heuristique(nx, ny, goal.x, goal.y);
                    openList.add(new Node(nx, ny, current, gNew, gNew + hNew));
                }
            }
        }

        return false; // Aucun chemin trouvé
    }

    private int heuristique(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2); // Heuristique de Manhattan
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }

    private int[][] directions() {
        return new int[][] {
                {0, 1}, {1, 0}, {0, -1}, {-1, 0} // Droite, Bas, Gauche, Haut
        };
    }

    class Node {
        int x, y;
        Node parent;
        int g, f;

        Node(int x, int y, Node parent, int g, int f) {
            this.x = x;
            this.y = y;
            this.parent = parent;
            this.g = g;
            this.f = f;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return x == node.x && y == node.y;
        }
    }
}
