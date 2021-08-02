package mundoPaquete;

import java.util.Date;
import java.util.ArrayList;
// import java.util.GregorianCalendar;

public class Game {
    // By convention, the names of classes and enumerations must be singular

    // Attributes
    private PlayerX playerX; // Composition relation
    private PlayerO playerO; // Composition relation
    private Board board; // Composition relation
    private boolean ticTacToe;
    private boolean tie;
    private LogicalValue currentTurn; // logical value of the player who has the turn
    private LogicalValue winnerValue; // Winner logical value
    private Date startTime;
    private Date endingTime;

    // Constructors
    public Game(String namePlayerX, String namePlayerO) {

        // Control parameters should ideally be constant
        // This constructor is tied to two enumerations.
        // The enumerations provide greater security to constant or fixed data types in our project, and
        // also allow us to have them well located (modularized) in case we want to make any changes to them

        // Build players --> composition ratio
        // this.playerX = new PlayerX(namePlayerX, LogicalValue.PLAYER_X.getLogicalValue());
        // this.playerO = new PlayerO(namePlayerO, LogicalValue.PLAYER_O.getLogicalValue());
        this.playerX = new PlayerX(namePlayerX, LogicalValue.PLAYER_X.getLogicalValue(), ConsoleValue.PLAYER_X.getConsoleValue());
        this.playerO = new PlayerO(namePlayerO, LogicalValue.PLAYER_O.getLogicalValue(), ConsoleValue.PLAYER_O.getConsoleValue());

        // Build board
        this.board  = new Board();

        // Game control attributes (initial stage)
        this.tie = false;
        this.ticTacToe = false;
        // Randomly choose who starts the game
        if(Math.random() > 0.5) {
            this.currentTurn = LogicalValue.PLAYER_X;
        } else {
            this.currentTurn = LogicalValue.PLAYER_O;
        }

        // Start time
        startTime = new Date();
    }

    // Extracts a row, a column or a diagonal

    // Estracts row
    public ArrayList<Box> getRow(int rowNumber){
        ArrayList<Box> boardRow = new ArrayList<Box>();
        for (int j = 0; j < Board.COLUMN_NUM; j++) {
            boardRow.add(this.board.getBox(rowNumber, j));
        }
        return boardRow;
    }

    // Estracts column
    public ArrayList<Box> getColumn(int columnNumber){
        ArrayList<Box> boardColumn = new ArrayList<Box>();
        for (int i = 0; i < Board.ROW_NUM; i++) {
            boardColumn.add(this.board.getBox(i, columnNumber));
        }
        return boardColumn;
    }

    // Estracts diagonal
    public ArrayList<Box> getDiagonal(){
        ArrayList<Box> boardDiagonal = new ArrayList<Box>();
        for (int i = 0; i < Board.ROW_NUM; i++) { // On the diagonal i = j
            boardDiagonal.add(this.board.getBox(i, i));
        }
        return boardDiagonal;
    }

    
    // Methods (behavior)

    // Estracts diagonal
    public ArrayList<Box> getReverseDiagonal(){
        ArrayList<Box> invertedBoardDiagonal = new ArrayList<Box>();
        // A diagonal only makes sense in a square matrix --> ROW_NUM = COLUMN_NUM
        for (int i = 0, j = Board.ROW_NUM-1; i < Board.ROW_NUM; i++, j--) {
            invertedBoardDiagonal.add(this.board.getBox(i, j));
        }
        return invertedBoardDiagonal;
    }

    // Sums any of the previous arrays (collection)
    public int sumBoxesArray(ArrayList<Box> boxesArray) {
        int boxesSum = 0;
        for (Box box : boxesArray) { // In java all objects work by reference
            boxesSum += box.getLogicalValue();
        }
        return boxesSum;
    }

    // Sum of the whole board
    public int sumWholeBoard() {
        int wholeBoardSum = 0;
        for (int i = 0; i < Board.ROW_NUM; i++) {
            for (int j = 0; j < Board.COLUMN_NUM; j++) {
                wholeBoardSum += this.board.getBox(i, j).getLogicalValue();
            }            
        }
        return wholeBoardSum;
    }

    // Gives the game capacity to review (check) the board and determine its status
    public LogicalValue checkBoard() {
        // Get the summ of the rows
        ArrayList<Integer> rowsSum = new ArrayList<Integer>();
        // ArrayList<Box> rowsArray = new ArrayList<Box>();
        // int boxesSum;
        // for (int i = 0; i < Board.ROW_NUM; i++) {
        //     rowsArray = getRow(i);
        //     boxesSum = 0;
        //     for (Box box : rowsArray) {
        //         boxesSum += box.getLogicalValue();                
        //     }
        //     rowsSum.add(boxesSum);
        // }
        for (int i = 0; i < Board.ROW_NUM; i++) {
            rowsSum.add(this.sumBoxesArray(this.getRow(i)));
        }

        // Get the sum of the columns
        ArrayList<Integer> columnsSum = new ArrayList<Integer>();
        for (int j = 0; j < Board.COLUMN_NUM; j++) {
            columnsSum.add(this.sumBoxesArray(this.getColumn(j)));
        }

        // Get the sum of the diagonal
        int diagonalSum = this.sumBoxesArray(this.getDiagonal());

        // Get the sum of the inverse diagonal
        int reverseDiagonalSum = this.sumBoxesArray(this.getReverseDiagonal());

        // Get the sum of the whole board
        int totalBoardSum = this.sumWholeBoard();

        // Check if there is a winner

        // check if the playerO won
        
        // int TICTACTOE = LogicalValue.TICTACTOE_O.getLogicalValue();
        // if (rowsSum.contains(TICTACTOE) || columnsSum.contains(TICTACTOE) || 
        //     diagonalSum == TICTACTOE || reverseDiagonalSum == TICTACTOE) {
        //         return LogicalValue.TICTACTOE_O; // LogicalValue instantiates itself
        // }
        if (rowsSum.contains(LogicalValue.TICTACTOE_O.getLogicalValue()) ||
            columnsSum.contains(LogicalValue.TICTACTOE_O.getLogicalValue()) ||
            diagonalSum == LogicalValue.TICTACTOE_O.getLogicalValue() ||
            reverseDiagonalSum == LogicalValue.TICTACTOE_O.getLogicalValue()) {
            return LogicalValue.TICTACTOE_O;
        }

        // check if the playerX won
        if (rowsSum.contains(LogicalValue.TICTACTOE_X.getLogicalValue()) ||
        columnsSum.contains(LogicalValue.TICTACTOE_X.getLogicalValue()) ||
        diagonalSum == LogicalValue.TICTACTOE_X.getLogicalValue() ||
        reverseDiagonalSum == LogicalValue.TICTACTOE_X.getLogicalValue()) {
                return LogicalValue.TICTACTOE_X; // LogicalValue instantiates itself
        }

        // Check for a tie
        if(totalBoardSum == LogicalValue.TIE_STARTS_X.getLogicalValue() ||
           totalBoardSum == LogicalValue.TIE_STARTS_O.getLogicalValue()) {
            return LogicalValue.TIED_GAME;
        }

        // There is still no winner or tie
        return LogicalValue.NO_WINNER_YET;
    }

    // Start autonomous players simulation
    public void playGame() {

        // Game mainloop
        LogicalValue check;
        while(true) { // Tautology

            // Whoever has the turn plays
            if(this.currentTurn == LogicalValue.PLAYER_X) {
                this.playerX.play(board);
            } else {
                this.playerO.play(board);
            }

            // Visualization and it's not behavior
            this.board.showBoard();

            // Here is the review
            check = checkBoard();
            if(check == LogicalValue.TICTACTOE_X) {
                this.tie = false;
                this.ticTacToe = true;
                this.winnerValue = LogicalValue.PLAYER_X;
                this.endingTime = new Date();
                System.out.println("*** " + this.playerX.playerName + " (PlayerX) has won the game ***");
                break;
            } else if(check == LogicalValue.TICTACTOE_O) {
                this.tie = false;
                this.ticTacToe = true;
                this.winnerValue = LogicalValue.PLAYER_O;
                this.endingTime = new Date();
                System.out.println("*** " + this.playerO.playerName + " (PlayerO) has won the game ***");
                break;
            } else if(check == LogicalValue.TIED_GAME) {
                this.tie = true;
                this.ticTacToe = false;
                this.winnerValue = LogicalValue.TIED_GAME;
                this.endingTime = new Date();
                System.out.println("********** Tied game **********");
                break;
            } else if(check == LogicalValue.NO_WINNER_YET) {
                this.tie = false;
                this.ticTacToe = false;
                this.winnerValue = LogicalValue.NO_WINNER_YET;
                System.out.println("******** No winner Yet ********");
            }

            // Change turn
            if(this.currentTurn == LogicalValue.PLAYER_X) {
                this.currentTurn = LogicalValue.PLAYER_O;
            } else{
                this.currentTurn = LogicalValue.PLAYER_X;
            }
        }
        
    }

    // Getters
    public boolean isTie() {
        return tie;
    }

    public boolean isTicTacToe() {
        return ticTacToe;
    }    

    // Setters
    
    
}
