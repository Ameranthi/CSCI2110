public class SlowFlexible extends SlowPiece {
    public SlowFlexible(String name, String colour, Position position, Board board) {
        super(name, colour, position, board);
    }

    //can move up, down, left or right
    public void move(String direction, int n){
        if(direction.equals("left")){
            Position newPosition = new Position(getPosition().getX()-n, getPosition().getY()); //moves one to the left on the x axis
            if(getPosition().getX()-n > 8 || getPosition().getX()-n < 0){ // check if it will bring it off of the board
                return;
            } else if (board.hasPiece(newPosition)){// if there is a piece already in the destination
                return;
            } else {
                setPosition(newPosition);
            }
        } else if (direction.equals("right")){ // move th4e piece one to the right
            Position newPosition = new Position(getPosition().getX()+n, getPosition().getY()); //moves one to the right on the x axis
            if(getPosition().getX()+n > 8 || getPosition().getX()+n < 0){ // check if it will bring it off of the board
                return;
            }else if (board.hasPiece(newPosition)){// if there is a piece already in the destination
                return;
            } else {
                setPosition(newPosition);
            }

        } else if(direction.equals("up")){
            Position newPosition = new Position(getPosition().getX(), getPosition().getY()+n); //moves one to the right on the x axis
            if(getPosition().getY()+n > 8 || getPosition().getY()+n < 0){ // check if it will bring it off of the board
                return;
            }else if (board.hasPiece(newPosition)){// if there is a piece already in the destination
                return;
            } else {
                setPosition(newPosition);
            }

        } else if (direction.equals("down")){
            Position newPosition = new Position(getPosition().getX(), getPosition().getY()-n); //moves one to the right on the x axis
            if(getPosition().getY()-n > 8 || getPosition().getY()-n < 0){ // check if it will bring it off of the board
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
