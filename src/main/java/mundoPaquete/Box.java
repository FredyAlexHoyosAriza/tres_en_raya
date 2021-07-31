package mundoPaquete;

public class Box {

    // Attributes
    private int logicalValue;
    private String textualValue;
    private boolean boolValue;
    private int row, column; // Cuando no se inicializan tipos de datos entero, por defecto, el sistema los pone en 0

    // Constructors
    public Box() {
        logicalValue = 0;
        textualValue = "_"; // Un tipo de dato char se especifica entre camillas sencillas
        boolValue = true;
        row = -1;
        column = -1;        
    }

    public Box(int _row, int _column) {
        logicalValue = 0;
        textualValue = "_"; // Un tipo de dato char se especifica entre camillas sencillas
        boolValue = true;
        row = _row;
        column = _column;        
    }

    public void fillBox(int _logicalValue) {        
        if(_logicalValue == 1) {
            logicalValue = _logicalValue;
            textualValue = "O";
            boolValue = false;
        } else if(_logicalValue == 10) {
            logicalValue = _logicalValue;
            textualValue = "X";
            boolValue = false;
        } else {
            System.out.println("** Warning: Invalid box assigment **");
        }
        
    }

    public void fillBox(int _logicalValue, String _textualValue) {
        if(_logicalValue == 1 || _logicalValue == 10) {
            logicalValue = _logicalValue;
            textualValue = _textualValue;
            boolValue = false;
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
        // String freeMessage = this.boolValue ? "Yes" : "Not" ;
        boxInfo += "Free: " + (this.boolValue ? "Yes" : "Not") + "\n";

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

    public boolean getBoolValue() {
        return true;
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
