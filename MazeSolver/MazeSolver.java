import java.util.Stack;

class MazeSolver {
    private int rows;
    private int columns;
    private int[][] map;

    private int startingRow;
    private int startingColumn;

    private boolean visited[][];

    private Stack<String> path;
    
    public MazeSolver(MapReader mapReader) {
        if(!mapReader.isRead()) {
            mapReader.read();
        }

        this.rows = mapReader.getRows();
        this.columns = mapReader.getColumns();

        this.startingRow = mapReader.getStartingRow();
        this.startingColumn = mapReader.getStartingColumn();

        this.map = mapReader.getMap();
        
        this.visited = new boolean[this.rows][this.columns];

        for(int i = 0; i < this.rows; i ++) {
            for(int j = 0; j < this.columns; j ++) {
                this.visited[i][j] = false;
            }
        }

        this.path = new Stack<>();
    }

    public void solve() {
        try {
            this.dfs(this.startingRow, this.startingColumn);
        } catch (RuntimeException ex) {
            System.out.println(ex);
        }
        
        for(String step : this.path) {
            System.out.print(step + " -> ");
        }
    }

    private void dfs(int rowIndex, int columnIndex) {
        if(rowIndex < 0 || rowIndex > this.rows - 1) {
            return;
        } else if (columnIndex < 0 || columnIndex > this.columns - 1) {
            return;
        } else if (this.map[rowIndex][columnIndex] == 1) {
            return;
        }else if (this.visited[rowIndex][columnIndex]) {
            return;
        }

        this.visited[rowIndex][columnIndex] = true;
        this.path.push("(" + rowIndex + ", " + columnIndex + ")");

        if(this.map[rowIndex][columnIndex] == 3) {
            throw new RuntimeException("Exit found: position " + rowIndex + ", " + columnIndex);
        } else {
            this.dfs(rowIndex + 1, columnIndex);
            this.dfs(rowIndex - 1, columnIndex);
            this.dfs(rowIndex, columnIndex + 1);
            this.dfs(rowIndex, columnIndex - 1);

            this.path.pop();
        }
    }
}