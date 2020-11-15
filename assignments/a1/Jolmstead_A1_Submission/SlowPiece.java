//SP - A Piece that moves left or right exactly one step per move. Y
// our SlowPiece should extend the Piece class, implementing a constructor and
// redefining the inherited toString method via overriding.

public class SlowPiece extends Piece {

    public SlowPiece(String name, String colour, Position position, Board board) {
        super(name, colour, position, board);

        final int maxNumberOfMoves = 1; // A Piece that moves left or right exactly one step per move.

    }

    //redefining the inherited toString method via overriding.
    public String toString(){
        return name + " " + colour + " " + position;
    }

    /*
            move (String direction):
            A method to move the piece left or right by one space.
            This method will accept a direction parameter.
            If a move is requested that would take the Piece off the edge of the board,
            simply return without doing anything.
     */
    public void move(String direction, int n){

        //if the move is to go to the left, move the piece one to the left
        if(direction.equals("left")){
            Position newPosition = new Position(getPosition().getX()-n, getPosition().getY()); //moves one to the left on the x axis
            if(getPosition().getX()-n > 8 || getPosition().getX()-n < 0){ // check if it will bring it off of the board
                return;
            } else if (board.hasPiece(newPosition)){// if there is a piece already in the destination
                return;
            } else {
                setPosition(newPosition);
            }

        } else if(direction.equals("right")){ // move the piece one to the right
            Position newPosition = new Position(getPosition().getX()+n, getPosition().getY()); //moves one to the right on the x axis

            if(getPosition().getX()+n > 8 || getPosition().getX()+n < 0){ // check if it will bring it off of the board
                return;
            }else if (board.hasPiece(newPosition)){ // if there is a piece already in the destination
                return;
            } else {
                setPosition(newPosition);
            }
        } else {
            return;
        }
    }

}
