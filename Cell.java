public class Cell {
    CellState LilCell = CellState.EMPTY;

    public Cell () {}
    public Cell(CellState lilCell) {
        LilCell = lilCell;
    }

    public CellState getLilCell() {
        return LilCell;
    }

    public void setLilCell(Cell lilCell) {
        this.LilCell = lilCell.getLilCell();
    }

    public void setLilCell(CellState lilCell) {
        this.LilCell = lilCell;
    }
}
