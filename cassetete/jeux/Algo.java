package cassetete.jeux;

public enum Algo
{
    Algo1 ("Dijkstra"),
    Algo2 ("A*"),
    Algo3 ("Greedy Best First"),
    Algo4 ("Largeur d’abord"),
    Algo5 ("Profondeur d’abord"),
    Algo6 ("IDA*");

    private String algorithm;
    
    private Algo(String algorithm) 
    {
        this.algorithm = algorithm;
    }

    public String toString()
    {
        return this.algorithm;
    }
}
