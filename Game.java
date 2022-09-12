import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        boolean isXTurn = true ;
        Board newBoard = new Board () ;

        while (!newBoard.checkDraw()) {

            if (isXTurn) {
                System.out.println("X Turn") ;
            }

            else {
                System.out.println("O Turn") ;
            }

            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt() ;
            int col = scanner.nextInt() ;


            while (!check(row, col, newBoard)) {
                System.out.println("Invalid, Try again");
                row = scanner.nextInt() ;
                col = scanner.nextInt() ;
            }

            if (isXTurn) {
                newBoard.setBoard(row, col, new Cell (CellState.X));
                newBoard.print();
                if (newBoard.isEnd()) {
                    System.out.println("X Win");
                    break ;
                }
            }
            else {
                newBoard.setBoard(row, col, new Cell (CellState.O));
                newBoard.print();
                if (newBoard.isEnd()) {
                    System.out.println("O Win");
                    break ;
                }
            }

            isXTurn = !isXTurn ;
        }
        if (!newBoard.isEnd()) System.out.println("Draw");
    }


    static boolean check(int row, int col, Board newBoard) {
        if (row >= 3 || row < 0 || col >= 3 || col < 0) {
            return false ;
        }

        if (newBoard.board[row][col].getLilCell() != CellState.EMPTY ) {
            return false ;
        }

        return true ;
    }
}
