import java.util.Objects;

public class Board {
    Cell[][] board = new Cell[3][3] ;

    public Board() {
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                board[i][j] = new Cell(CellState.EMPTY) ;
            }
        }
    }

    public void setBoard(int rowPos, int colPos, Cell boardState) {
        board[rowPos][colPos].setLilCell(boardState);
    }


    public void print() {
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                if (board[i][j].getLilCell() == CellState.EMPTY) {
                    System.out.print("[ ]") ;
                }
                else if(board[i][j].getLilCell() == CellState.X){
                    System.out.print("[X]") ;
                }
                else if(board[i][j].getLilCell() == CellState.O){
                    System.out.print("[O]") ;
                }
            }

            System.out.print('\n') ;
        }

    }

    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getLilCell() == CellState.EMPTY )
                    return false;
            }
        }
        return true;
    }

    public boolean isEnd() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getLilCell() == board[i][1].getLilCell() && board[i][1].getLilCell() == board[i][2].getLilCell() && board[i][0].getLilCell() != CellState.EMPTY) {
                return true;
            }
            if (board[0][i].getLilCell() == board[1][i].getLilCell() && board[1][i].getLilCell() == board[2][i].getLilCell() && board[0][i].getLilCell() != CellState.EMPTY) {
                return true;
            }
        }
        if ((board[0][0].getLilCell() == board[1][1].getLilCell() && board[1][1].getLilCell() == board[2][2].getLilCell() && board[0][0].getLilCell() != CellState.EMPTY)
                || (board[0][2].getLilCell() == board[1][1].getLilCell() && board[1][1].getLilCell() == board[2][0].getLilCell() && board[1][1].getLilCell() != CellState.EMPTY)) {
            return true;
        }
        return false;
    }

}
