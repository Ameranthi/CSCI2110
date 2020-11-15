/*
Piece class has the following fields:
• Name: A String (eg. ‘Jedi’, ‘Droid’, etc.)
• Colour: A String (eg. ‘Black’, ‘Red’, etc.)
• Position: A point described by a pair of integers (eg. [2, 4], [1, 1], etc.).
 */

public class Piece {

    String name;
    String colour;
    Position position; // position holds an int x and int y for the position
    Board board;

    //constructor
    public Piece(String name, String colour, Position position, Board board) {
        this.name = name;
        this.colour = colour;
        this.position = position;
        this.board = board;
    }


    //getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPosition(Position p) {

        this.position = p;

    }

    public String getName()
    {
        return name;
    }
    public String getColour(){
        return colour;
    }
    public Position getPosition(){
        return position;
    }

    public String toString () {
        return name + " " + colour + " is in position " + position;
    }

    public void move(String direction, int numberOfSpaces){
    }
}
