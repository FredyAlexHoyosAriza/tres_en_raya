package mundoPaquete;
import java.util.ArrayList;
/**
 * El tablero puede verse como una matriz que en cada posicion tiene un objeto
 * tipo casilla
 * Cada casilla pude tener un valor textual, un valor logico y un valor booleano
 * 
 * Tablero textual consola
 * Tablero para mostrar en consola
 * _ X _
 * _ _ _
 * O _ O
 * 
 * Tablero logico
 * Aqui me permite saber quien gano
 * 0 10 0
 * 0 0 0
 * 1 0 1
 * 
 * Tablero booleano casillas libres
 * Casillas libres para jugar
 * true  false true
 * true  true  true
 * false true  false
**/
public class Board {

    // Attributes
    // Mas que para definir constantes las mayusculas sostenidas se usan para definir
    // las constantes del sistema, como por ejemplo las enumeraciones
    public static final int BOXES_NUM = 9;
    public static final int ROW_NUM = 3;
    public static final int COLUMN_NUM = 3;
    // Arreglo generico de tamaño definido menos flexible que ArrayList pero mas rapido
    private Box[][] boxes = new Box[ROW_NUM][COLUMN_NUM];

    // Constructors
    // Por omision los constructores son publicos para el mismo paquete, pero se debe
    // especificar que son publicos para poder crear instancias en otros paquetes y luego
    // de llamar el paquete con un import
    public Board() {
        // The entire matrix of squares is traversed
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COLUMN_NUM; j++) {
                // Builds a Box in each matrix position
                boxes[i][j] = new Box(i, j);
            }            
        }
    }

    // Methods
    // Boards returns a collection (ArrayList<Box>) with the empty boxes.
    // The number of empty boxes changes throughout the game.
    // The number of empty boxes is mutable that's why we use an ArrayList<Box>
    public ArrayList<Box> getEmptyBoxes() {
        // Al instanciar un objeto tipo ArrayList se instancian todos los objetos
        // contenidos en este, es decir, que no es necesario recorrer el ArrayList
        // con ciclos para instanciar cada uno de los objetos en el ArrayList.
        ArrayList<Box> emptyBoxes = new ArrayList<>();
        // The entire matrix of squares is traversed
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COLUMN_NUM; j++) {
                // Filter and collect the boxes that are free
                if(boxes[i][j].getBoolValue()) {
                    emptyBoxes.add(boxes[i][j]);
                }
            }            
        }
        // The emptyBoxes collection is returned
        return emptyBoxes;
    }

    // Indicate if the board is full or not. This method could be used by the player
    // or by the game. this method can serve as a criterion for stopping the game
    public boolean isFull() {
        if(getEmptyBoxes().isEmpty()) {
            // the board is full, since emptyBoxes has no elements
            return true;
        } else {
            // the board is not full, since emptyBoxes has elements
            return false;
        }
    }

    // Show board on console
    public void showBoard() {
        System.out.println();
        // The entire matrix of squares is traversed
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COLUMN_NUM; j++) {
                System.out.print(boxes[i][j].getTextualValue() + " ");
            }
            System.out.println();
        }
    }

    // Getters
    public Box getBox(int i, int j) {
        return boxes[i][j]; // equivalent: this.boxes[i][j]
    }
    
}
