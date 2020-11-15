/*
Next define a Board class –
The Board class will hold the 8 X 8 game board.
Each position of the board either contains a Piece or is empty.
Since the pieces move around on the game board, any location may contain any type of Piece.
Consider what data structure you wish to use to represent the board.
 */

public class Board {

    //set the board size
    //final int size = 8;
    final int height = 8;
    final int width = 8;

    //create and 8x8 array
    //fill the array with - hyphens and then change the hyphens to the pieces
    Piece[][] board = new Piece[height][width];


    public Board() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = null;
            }
        }
    }

    public String addPiece(Position position, Piece piece) {
        //check if piece can be added to that spot. if the spot is occupied than it cannot be added

        if (hasPiece(position)){
            return "there is a piece in the destination position, cannot add piece";
        } else {
            //if the piece can be added add it to that position
            board[position.getX()][position.getY()] = piece;
            return piece.getName() + piece.getColour() + piece.getClass() + " piece has been added";


        }
    }

    public String movePiece(Piece piece, String direction, int numberOfSpaces) {
        //for assessment purposes
        Position oldPosition = piece.getPosition();

        piece.move(direction, numberOfSpaces);

        //did the piece move?
        if(oldPosition.equals(piece.getPosition())){
            return "piece has not been moved";
        }else{//it did move

            //old x and y
            //get the current x and y coordinates of the piece
            int XPos = oldPosition.getX();
            int YPos = oldPosition.getY();
            Piece temp = board[XPos][YPos];
            board[XPos][YPos] = null;

            //get the new position
            XPos = piece.getPosition().getX();
            YPos = piece.getPosition().getY();
            board[XPos][YPos] = piece;

            return "piece has been moved";
        }


    }
    //checks to see if position on the board has a piece
    public boolean hasPiece(Position position){

        int YPos = position.getY();
        int XPos = position.getX();

        //if the position in the board has no piece then return false
        if(board[XPos][YPos] == null){
            return false;
        }
        //otherwise, return true as there is a piece there
        return true;
    }


    //showing the name, color and type of each Piece on the game board at its current location.
    // simple text-based display to show the board and the Pieces on it.
    public String displayTheBoard() {

        String displayedBoard = ""; //simple string to show the board

        //loops to put items into the string
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                displayedBoard += " ";
                if(board[x][y] == null){
                    displayedBoard += " - ";
                } else {
                    Piece piece = board[x][y];
                    displayedBoard += piece.getName() + piece.getColour() + piece.getClass();
                }
                if (x == board[y].length - 1) {
                    displayedBoard += "\n";
                }
            }
        }
        return displayedBoard;
    }

    public Piece getPiece(Position position){
       int x = position.getX();
       int y = position.getY();
        return board[x][y];
    }
}
