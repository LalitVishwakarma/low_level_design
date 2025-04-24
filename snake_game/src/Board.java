public class Board {

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    Cell[][] cells;
    Integer ROWS;
    Integer COLS;

    Board(int rows, int cols) {
        this.ROWS = rows;
        this.COLS = cols;
        cells = new Cell[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell generateFood() {
        Cell cell;
        while(true) {
            int row = (int)(Math.random() * ROWS);
            int col = (int)(Math.random() * COLS);
            if(cells[row][col].getCellType().equals(CellType.EMPTY)){
                cell = cells[row][col];
                cell.setCellType(CellType.FOOD);
                break;
            }
        }
        return cell;
    }

    public boolean isValid(Cell next) {
        if (next != null)
            return next.getRow() >= 0 && next.getRow() < ROWS && next.getCol() >= 0 && next.getCol() < COLS;
        return false;
    }
}
