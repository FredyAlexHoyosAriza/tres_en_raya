package mundoPaquete;

public enum ConsoleValue {
    
    // ConsoleValue hosts constant console control parameters

    // All fields in an enumeration are public and static, therefore they don't require instances

    PLAYER_X("X"), PLAYER_O("O");

    // Assciation Attribute
    private String consoleValue;

    ConsoleValue(String _consoleValue) {
        this.consoleValue = _consoleValue;
    }

    // Get the value with which the symbolic constant is associated
    public String getConsoleValue() {
        return consoleValue;
    }
    
}
