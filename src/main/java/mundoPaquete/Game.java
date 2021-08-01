package mundoPaquete;

import java.util.Date;
// import java.util.GregorianCalendar;

public class Game {

    // Attributes
    private PlayerX playerX;
    private PlayerO playerO;
    private Board board;
    private boolean ticTacToe;
    private boolean tie;
    private int currentTurn; // logical value of the player who has the turn
    private Date startTime;
    private Date endingTime;    

    // Constructors
    public Game(String namePlayerX, String namePlayerO) {

        // This constructor is tied to two enumerations.
        // The enumerations provide greater security to constant or fixed data types in our project, and
        // also allow us to have them well located (modularized) in case we want to make any changes to them

        // Build players --> composition ratio
        // this.playerX = new PlayerX(namePlayerX, LogicalValues.PLAYER_X.getLogicalValue());
        // this.playerO = new PlayerO(namePlayerO, LogicalValues.PLAYER_O.getLogicalValue());
        this.playerX = new PlayerX(namePlayerX, LogicalValues.PLAYER_X.getLogicalValue(), ConsoleValues.PLAYER_X.getConsoleValue());
        this.playerO = new PlayerO(namePlayerO, LogicalValues.PLAYER_O.getLogicalValue(), ConsoleValues.PLAYER_O.getConsoleValue());

        // Build board
        this.board  = new Board();
    }

    // Methods (behavior)

    // Check if there is a winner

    // Set game turn

    // Checks if the board is full but there's no winner (tie)

    // Getters

    // Setters
    
    
}
