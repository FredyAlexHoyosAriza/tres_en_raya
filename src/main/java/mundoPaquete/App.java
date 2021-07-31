package mundoPaquete;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Tres en raya" );

        // Test the board construction
        Board board = new Board();
        System.out.println("Before filling boxes of the board");
        board.showBoard();

        // Force some plays to test the behavior of the boxes on the board.
        // board.boxes[0][1].fillBox(10,"X");
        // board.boxes[2][0].fillBox(1,"O");
        // board.boxes[2][2].fillBox(1,"O");
        board.getBox(0,1).fillBox(10);
        board.getBox(2,0).fillBox(1);
        board.getBox(2,2).fillBox(1);

        // Checking the board after forcing plays
        System.out.println("After filling boxes of the board");
        board.showBoard();

        // Todas las clases creadas en java, heredan de una clase madre implicita;
        // clase base mas generica de java, y de esta heredan algunos metodos
        // genericos, que por supuesto pueden sobreescribirse en las clases hijas

        // for overwriting
        System.out.print("Inherited generic method call: ");
        // Returns the reference to the Board object in a string
        System.out.println(board.toString());

        // for overwriting
        System.out.print("Overwritten inherited generic method call: ");
        // Returns the reference to the Box object in a string
        System.out.println(board.getBox(0,0).toString());
        System.out.println(board.getBox(0,1).toString());
    }

}
