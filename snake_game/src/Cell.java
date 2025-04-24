
public class Cell {
    Integer row, col;
    CellType cellType;

    public Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
        cellType = CellType.EMPTY;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }
}
