import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MapReader {
    private String mapFile;

    private int rows;
    private int columns;

    private int startingRow;
    private int startingColumn;

    private int map[][];

    private boolean read;

    public MapReader(String mapFile, int rows, int columns) {
        this.mapFile = mapFile;
        this.rows = rows;
        this.columns = columns;
        this.map = new int[rows][columns];

        this.read = false;
    }

    public void read() {
        try {
            Scanner fileScanner = new Scanner(new File(this.mapFile));

            for(int i = 0; i < this.rows; i ++) {
                for(int j = 0; j < this.columns; j ++) {
                    this.map[i][j] = fileScanner.nextInt();

                    if(this.map[i][j] == 2) {
                        this.startingRow = i;
                        this.startingColumn = j;
                    }
                }
            }
            this.read = true;

        } catch (FileNotFoundException a) {
            System.out.println("File not found: " + this.mapFile);
        }
    }

    public boolean isRead() {
        return this.read;
    }

    public int[][] getMap() {
        return this.map;
    }

    public int getColumns() {
        return this.columns;
    }

    public int getRows() {
        return this.rows;
    }

    public int getStartingRow() {
        return this.startingRow;
    }

    public int getStartingColumn() {
        return this.startingColumn;
    }
}