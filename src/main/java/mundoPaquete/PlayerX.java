package mundoPaquete;
import java.util.ArrayList;

public class PlayerX extends Player {
    // In Java it is only possible to inherit from the mother class,
    // not from grandparents or other relatives

    // Attributes -> inherited from player

    // Constructors

    PlayerX(String _playerName, int _logicalToken, String _consoleToken) {
        // A constructor of the superclass is consumed
        super(_playerName, _logicalToken, _consoleToken);
    }

    // Overloaded constructor -> A new constructor is established
    PlayerX(String _playerName, int _logicalToken) {
        // A constructor of the superclass is consumed
        super(_playerName, _logicalToken, "X");
    }

    // Local methods (Behavior)
    public Box chooseUpperLeft(Board board) {
        // Box upperLeftBox = new Box();
        // ArrayList<Box> emptyBoxes = board.getEmptyBoxes();
        // upperLeftBox = emptyBoxes.get(0);
        return board.getEmptyBoxes().get(0);
    }
    
    // Execute strategy
    // Implementation of the playSpecificStrategy abstract method
    public void playSpecificStrategy(Board board) {
        // Player X looks for the uppermost leftist empty corner
        // super.play(this.chooseUpperLeft(board), board);
        super.play(board.getEmptyBoxes().get(0), board);
    }



    // Getters

    // Setters
    
}
