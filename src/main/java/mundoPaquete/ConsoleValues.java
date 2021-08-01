package mundoPaquete;

public enum ConsoleValues {

    PLAYER_X("X"), PLAYER_O("O");

    // Assciation Attribute
    private String consoleValue;

    ConsoleValues(String _consoleValue) {
        this.consoleValue = _consoleValue;
    }

    // Get the value with which the symbolic constant is associated
    public String getConsoleValue() {
        return consoleValue;
    }
    
}
