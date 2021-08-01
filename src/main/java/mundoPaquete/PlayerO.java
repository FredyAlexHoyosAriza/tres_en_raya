package mundoPaquete;
import java.util.ArrayList;

public class PlayerO extends Player {
        // In Java it is only possible to inherit from the mother class,
    // not from grandparents or other relatives

    // Attributes -> inherited from player

    // Constructors

    PlayerO(String _playerName, int _logicalToken, String _consoleToken) {
        // A constructor of the superclass is consumed
        super(_playerName, _logicalToken, _consoleToken);
    }

    // Overloaded constructor -> A new constructor is established
    PlayerO(String _playerName, int _logicalToken) {
        // A constructor of the superclass is consumed
        super(_playerName, _logicalToken, "O");
    }

    // Local methods (Behavior)
    public Box chooseLowerRight(Board board) {
        // Box lowerRightBox = new Box();
        ArrayList<Box> emptyBoxes = board.getEmptyBoxes();
        // lowerRightBox = emptyBoxes.get(emptyBoxes.size()-1);
        return emptyBoxes.get(emptyBoxes.size()-1);
    }
    
    // Execute strategy
    // Implementation of the playSpecificStrategy abstract method
    public void playSpecificStrategy(Board board) {
        // Player X looks for the lowermost rightist empty corner
        super.play(this.chooseLowerRight(board), board);
    }
    
}
