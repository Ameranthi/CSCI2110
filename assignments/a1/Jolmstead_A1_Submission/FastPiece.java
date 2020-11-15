/*
Define a FastPiece class –
A Piece that moves left or right a specified,
arbitrary number of steps per move.
Your FastPiece should extend the Piece class, implementing a constructor and redefining
the inherited toString method via overriding.
 */

public class FastPiece extends Piece {

    public FastPiece(String name, String colour, Position position, Board board) {
        super(name, colour, position, board);
    }


    /*
    In addition, implement the following method:
    move (String direction, int n): A method to move the piece left or right by
    a specified number of spaces. This method will accept a direction parameter and a number of spaces.
    If a move is requested that would take the Piece off the edge of the board, simply return without doing anything.
     */

    public void move(String direction, int n){
        //if the move is to go to the left, move the piece one to the left
        if(direction.equals("left")){
            Position newPosition = new Position(getPosition().getX()-n, getPosition().getY()); //moves n spaces to the left on the x axis
            if(getPosition().getX()-n > 8 || getPosition().getX()-n < 0){ //check if it will bring it off of the board
                return;
            }else if (board.hasPiece(newPosition)){// if there is a piece already in the destination
                return;
            } else {
                setPosition(newPosition);
            }

        } else if (direction.equals("right")){ // move th4e piece one to the right
            Position newPosition = new Position(getPosition().getX()+n, getPosition().getY()); //moves n spaces to the right on the x axis
            if(getPosition().getX()+n > 8 || getPosition().getX()+n < 0){ // check if it will bring it off of the board
                return;
            }else if (board.hasPiece(newPosition)){// if there is a piece already in the destination
                return;
            } else {
                setPosition(newPosition);
            }
        } else {
            return;
        }
    }
}
