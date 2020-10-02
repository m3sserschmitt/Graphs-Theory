class App {
    public static void main(String[] args) {
        MapReader mapReader = new MapReader("map", 20, 20);
        MazeSolver mazeSolver = new MazeSolver(mapReader);

        mazeSolver.solve();
    }
}