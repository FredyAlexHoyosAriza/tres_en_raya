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
        // // board.boxes[0][1].fillBox(10,"X");
        // // board.boxes[2][0].fillBox(1,"O");
        // // board.boxes[2][2].fillBox(1,"O");
        // board.getBox(0,1).fillBox(10);
        // board.getBox(2,0).fillBox(1);
        // board.getBox(2,2).fillBox(1);

        // // Checking the board after forcing plays
        // System.out.println("After filling boxes of the board");
        // board.showBoard();

        // Todas las clases creadas en java, heredan de una clase madre implicita;
        // clase base mas generica de java, y de esta heredan algunos metodos
        // genericos, que por supuesto pueden sobreescribirse en las clases hijas

        // // for overwriting
        // System.out.print("Inherited generic method call: ");
        // // Returns the reference to the Board object in a string
        // System.out.println(board.toString());

        // // for overwriting
        // System.out.print("Overwritten inherited generic method call: ");
        // // Returns the reference to the Box object in a string
        // System.out.println(board.getBox(0,0).toString());
        // System.out.println(board.getBox(0,1).toString());

        // // test the automatic version of the playerX
        // // PlayerX playerX = new PlayerX("Carlos Ariza", 10, "X");
        // PlayerX playerX = new PlayerX("Carlos Ariza", 10);
        // // playerX executes a random strategy from the super class Player.
        // // The play method of the super class Player, uses the board object as a parameter
        // playerX.play(board); // the board object is sent by reference to the play method
        // playerX.playSpecificStrategy(board);

        // // test the automatic version of the playerO
        // // PlayerO playerO = new PlayerO("Carlos Ariza", 1, "O");
        // PlayerO playerO = new PlayerO("Carlos Ariza", 1);
        // // playerO executes a random strategy from the super class Player.
        // // The play method of the super class Player, uses the board object as a parameter
        // playerO.play(board); // the board object is sent by reference to the play method
        // playerO.playSpecificStrategy(board);

        // Force alternate turns with players assisted by the machine
        PlayerX playerX = new PlayerX("Carlos Ariza", 10);
        PlayerO playerO = new PlayerO("Carlos Ariza", 1);
        playerX.playSpecificStrategy(board);
        board.showBoard();
        playerO.playSpecificStrategy(board);
        board.showBoard();
        playerX.playManual(board);
        board.showBoard();
        playerO.playManual(board);
        board.showBoard();
        playerX.play(board);
        board.showBoard();
        playerO.play(board);

        // Checking the board after automatic moves of playerX
        System.out.println("After filling boxes of the board");
        board.showBoard();
    }

}
