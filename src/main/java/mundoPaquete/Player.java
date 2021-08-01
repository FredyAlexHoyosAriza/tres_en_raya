package mundoPaquete;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player {
    // The class is abstract by having at least one abstract method

    // Attributes
    protected String playerName;
    protected int logicalToken;
    protected String consoleToken;

    // Constructors
    Player(String _playerName, int _logicalToken, String _consoleToken) {    
        playerName = _playerName;
        logicalToken = _logicalToken;
        consoleToken = _consoleToken;
    }

    // Methods (Behavior)

    // Randomly choose the box of the board
    public Box chooseRandomBox(Board board) {
        // Consumption of an object of board class; the player object
        // does not host a board but it does receive it as a parameter
        // and consume it. This is a a use or denpendency relation.

        Box chosenBox = new Box();

        // Asks to the board object for the empty boxes
        ArrayList<Box> emptyBoxes = board.getEmptyBoxes();

        // Choose random box
        int min = 0;
        int max = emptyBoxes.size();
        // Math.random returns a pseudorandom double type number greater
        // than or equal to 0.0 and less than 1.0. Changing max and min
        // allows to change the upper and lower stops
        int chosenBoxIndex = min + (int)(Math.random() * (max-min));
        chosenBox = emptyBoxes.get(chosenBoxIndex);

        // Returns the chosen box
        return chosenBox;
    }

    // Makes the move based on the chosen box
    public void play(Board board) {//(Box chosenBox, Board board)
        // // aleatory selection
        // Box chosenBox = this.chooseRandomBox(board);
        // // Gets the chosen box informartion
        // int boxRow = chosenBox.getRow();
        // int boxColumn = chosenBox.getColumn();
        // // The player updates the board
        // // board.getBox(boxRow, boxColumn).fillBox(logicalToken);
        // board.getBox(boxRow, boxColumn).fillBox(logicalToken, consoleToken);

        // Randomly choose an available box
        this.play(this.chooseRandomBox(board), board);
    }

    public void play(Box chosenBox, Board board) {//(Board board)
        // Gets the chosen box informartion
        int boxRow = chosenBox.getRow();
        int boxColumn = chosenBox.getColumn();
        // The player updates the board
        // board.getBox(boxRow, boxColumn).fillBox(logicalToken);
        board.getBox(boxRow, boxColumn).fillBox(logicalToken, consoleToken);
    }

    public void play(int boxRow, int boxColumn, Board board) {
        // The player updates the board
        // board.getBox(boxRow, boxColumn).fillBox(logicalToken);
        board.getBox(boxRow, boxColumn).fillBox(logicalToken, consoleToken);
    }

    public void playManual(Board board) {
        // Request by console row number and column number
        Scanner sc = new Scanner(System.in);
        ArrayList<Box> emptyBoxes = board.getEmptyBoxes();
        int row, column;
        System.out.println("--> Player Turn: " + this.playerName + ", with simbol: " + this.consoleToken);
        boolean cycle = true;
        do {
            System.out.println("** Please, enter a valid (row, column) selection **");
            System.out.print("Enter the row: ");
            row = sc.nextInt();
            System.out.print("Enter the column: ");
            column = sc.nextInt();
            for (Box box : emptyBoxes) {
                if(box.getRow() == row && box.getColumn() == column) {
                    cycle = false;
                    break;
                }
            }

        } while(cycle);
        this.play(row, column, board);

    }

    // Execute strategy

    // Specification of an abstract method
    // abstract void playManual(Board board);
    abstract void playSpecificStrategy(Board board);
}
