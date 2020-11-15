import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class GameDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//regular line commands
        Scanner console = new Scanner (System.in); //take in colour and name

        Board board = new Board(); //create a new board - automatically 8x8

        System.out.println("Enter a command (type help for details):");

        while (in.hasNextLine()) {
            String inputLine = in.nextLine();

            //parse the input line and take the first word out of it

            String[] commandWords = inputLine.split(" ");//split buy blank spaces

            String command = commandWords[0];//first word will be the command word

            if (command.equals("help")) { //check if it matches help - if so then print help menu
                System.out.println("Possible command are as follows:\n" +
                        "create location [fast][flexible]: Creates a new piece. \n" +
                        "move location direction [spaces]: Moves a piece \n" +
                        "print: Displays the board. \n" +
                        "help: Displays help. \n" +
                        "exit: Exits the program. \n \n" +
                        "please enter a command");
            } else if (command.equals("print")) { //print the board to the screen
                System.out.println(board.displayTheBoard());
                System.out.println("Enter a command (type help for details):");


            } else if (command.contains("create")) { //create a piece and put it on the board
                //declaration of piece
                Piece piece;

                //break up the command string line
                //take the x and y position
                int x = Integer.parseInt(commandWords[1]);
                int y = Integer.parseInt(commandWords[2]);
                Position position = new Position(x, y); //create the new position for the piece

                System.out.println("enter a name for the new piece: ");
                //enter a name for the new piece
                String name =console.next();

                System.out.println("Input a colour for the new piece: ");
                //Input a colour for the new piece:
                String colour = console.next();

                //evaluate the command Words and create a piece type depending on what was given in the line

                //example: ‘create 1 1’→would create a slow nonflexible Piece at location [1, 1]
                //slow piece
                if (commandWords.length < 4) {
                    piece = new SlowPiece(name, colour, position, board);

                    //• ‘create 1 1 fast’→would create a fast nonflexible Piece at location [1,1]
                    //fast piece
                } else if (commandWords[3].equals("fast") && commandWords.length < 5) {
                    piece = new FastPiece(name, colour, position, board);

                    //• ‘create 1 1 flexible’→would create a slow flexible Piece at location [1, 1]
                    //slow flexible
                } else if (commandWords[3].equals("flexible") && commandWords.length < 5) {
                    piece = new SlowFlexible(name, colour, position, board);

                    //• ‘create 1 1 fast flexible’→would create a fast flexible Piece at location [1, 1]
                    //fast flexible
                } else {
                    piece = new FastFlexible(name, colour, position, board);
                }

                //add piece to board
                System.out.println(board.addPiece(position, piece)); //print status and add piece to board
                System.out.println("Enter a command (type help for details):");


            } else if (command.contains("move")) { //check if command is move - if it is move the piece
                //moves whatever piece at the location by the direction and amount of spaces

                int spaces = 0;
                //if it is less than for long then it is will only be moving by 1 space by default
                if (commandWords.length < 5) { //piece is not fast and can only move 1 at a time
                    spaces = 1;
                } else {
                    spaces = Integer.parseInt(commandWords[4]); // number of spaces to move
                }

                int x = Integer.parseInt(commandWords[1]); //get x coordinate
                int y = Integer.parseInt(commandWords[2]); // get y coordinate

                Position currentPosition = new Position(x, y); //create the current position
                Piece piece = board.getPiece(currentPosition);

                String direction = commandWords[3]; //left, right, up,  down

                System.out.println(board.movePiece(piece, direction, spaces)); //execute method and print out result
                System.out.println("Enter a command (type help for details):");


            } else if (command.equals("exit")){
                System.out.print("game over");
                break; //yeet out of the program
            } else { //because people can't type and you need to assist them
                System.out.print("invalid command, try again");
            }
        }
    }
}
