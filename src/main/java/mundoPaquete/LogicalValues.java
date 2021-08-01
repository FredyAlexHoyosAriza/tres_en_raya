package mundoPaquete;

public enum LogicalValues {
    // Enums logical values of a game

    // Logical values of playerX
    PLAYER_X(10), TICTACTOE_X(30), // Se asigna 10 a PLAYER_X y 30 a TICTACTOE_X
    // PLAYER_X, TICTACTOE_X, // De esta forma se asignaria: 0 a PLAYER_X y 1 a TICTACTOE_X

    // Logical values of playerO
    PLAYER_O(1), TICTACTOE_O(3),

    //Tie situations
    TIE_STARTS_X(54), TIE_STARTS_O(45),

    // Indicate match tie
    TIED_GAME(1),

    // Board partially full without a winner
    NO_WINNER_YET(0);

    // Assciation Attribute
    private int logicalValue;

    LogicalValues(int _logicalValue) {
        this.logicalValue = _logicalValue;
    }

    // Get the value with which the symbolic constant is associated
    public int getLogicalValue() {
        return logicalValue;
    }
}
