class App {
    public static void main(String[] args) {
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");

        A.addNeighbour(new Edge(B, 1));
        A.addNeighbour(new Edge(E, 7));
        
        B.addNeighbour(new Edge(D, 1));
        B.addNeighbour(new Edge(C, 5));

        C.addNeighbour(new Edge(F, 4));

        D.addNeighbour(new Edge(G, 2));

        E.addNeighbour(new Edge(C, 6));
        E.addNeighbour(new Edge(I, 1));

        F.addNeighbour(new Edge(H, 1));

        G.addNeighbour(new Edge(F, 15));
        G.addNeighbour(new Edge(H, 25));
        
        I.addNeighbour(new Edge(F, 1));

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        
        algorithm.computeDistances(A);
        System.out.println(algorithm.getRoute(H));
    }
}