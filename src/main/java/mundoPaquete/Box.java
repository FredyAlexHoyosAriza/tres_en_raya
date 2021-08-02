package mundoPaquete;

public class Box {

    // Attributes
    private int logicalValue;
    private String textualValue;
    private boolean available;
    private int row, column; // Cuando no se inicializan tipos de datos entero, por defecto, el sistema los pone en 0

    // Constructors
    public Box() {
        logicalValue = 0;
        textualValue = "_"; // Un tipo de dato char se especifica entre camillas sencillas
        available = true;
        row = -1;
        column = -1;        
    }

    public Box(int _row, int _column) {
        logicalValue = 0;
        textualValue = "_"; // Un tipo de dato char se especifica entre camillas sencillas
        available = true;
        row = _row;
        column = _column;        
    }

    public void fillBox(int _logicalValue) {        
        if(_logicalValue == 1) {
            logicalValue = _logicalValue;
            textualValue = "O";
            available = false;
        } else if(_logicalValue == 10) {
            logicalValue = _logicalValue;
            textualValue = "X";
            available = false;
        } else {
            System.out.println("** Warning: Invalid box assigment **");
        }
        
    }

    public void fillBox(int _logicalValue, String _textualValue) {
        if(_logicalValue == 1 || _logicalValue == 10) {
            logicalValue = _logicalValue;
            textualValue = _textualValue;
            available = false;
        } else {
            System.out.println("** Warning: Invalid box assigment **");
        }
        
    }

    // Methods
    // Here we overwrite a method that was inherited from the super class
    @Override
    public String toString() {

        String boxInfo = "\n--- BoxInfo ---\n";
        boxInfo += "Row: " + this.row + "\n";
        boxInfo += "Column: " + this.column + "\n";
        // String freeMessage = this.available ? "Yes" : "Not" ;
        boxInfo += "Free: " + (this.available ? "Yes" : "Not") + "\n";

        // The use of the method of the superior class and not the current one is specified
        // super.toString();
        return boxInfo;
    }

    // Getters
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean getAvailable() {
        return available;
    }

    public int getLogicalValue() {
        return logicalValue;
    }

    // Retorna el valor a inprimir en consola ('O', 'X' o '-'')
    public String getTextualValue() {
        return textualValue;
    }

    // Setters
    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }
    


    
}
