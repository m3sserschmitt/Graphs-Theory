import java.util.ArrayList;
import java.util.List;

class App {
    public static void main(String[] args) {
        Vertex S = new Vertex("S");

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");

        Vertex T = new Vertex("T");

        S.addNeighbour(A, 4);
        S.addNeighbour(B, 5);

        A.addNeighbour(T, 7);
        
        B.addNeighbour(A, 4);
        B.addNeighbour(T, 1);

        List<Vertex> vertices = new ArrayList<>();
        vertices.add(S);
        vertices.add(A);
        vertices.add(B);
        vertices.add(T);

        FlowNetwork flowNetwork = new FlowNetwork(vertices, S, T);
        FordFulkersonAlgorithm algorithm = new FordFulkersonAlgorithm(flowNetwork);

        algorithm.computeMaxFlow();

        System.out.println("Maximum flow: " + algorithm.getMaxFlow());
        System.out.println(algorithm.getEdges());
    }
}