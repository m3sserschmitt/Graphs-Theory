import java.util.ArrayList;
import java.util.List;

class App {
    public static void main(String[] args) {
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");

        A.addNeighbour(B, 1);
        A.addNeighbour(C, 7);

        B.addNeighbour(C, 9);
        B.addNeighbour(D, 2);
        B.addNeighbour(E, 1);

        C.addNeighbour(D, 1);

        D.addNeighbour(E, 5);
        D.addNeighbour(F, 1);

        E.addNeighbour(F, 1);

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(A);
        vertexList.add(B);
        vertexList.add(C);
        vertexList.add(D);
        vertexList.add(E);
        vertexList.add(F);

        PrimAlgorithm algorithm = new PrimAlgorithm(vertexList);
        algorithm.computeMST(A);
        System.out.println(algorithm.getMST());
    }
}