import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Accepts in the following format:
// Line 1 will be an integer: the number of tests to expect
// All following lines will consist of doubles separated by whitespace.
// Each line represents a Rectangle.

public class Exercise1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //take in the number of cases to test
        int numberOfCases = in.nextInt();
        double xpos;
        double ypos;
        double width;
        double height;

        //array Lists to put the rectangles in
        ArrayList<E1Rectangle> rectanglesFirst = new ArrayList<E1Rectangle>();
        ArrayList<E1Rectangle> rectanglesSecond = new ArrayList<E1Rectangle>();


        //take in the information for the rectangles and put them into an arraylist for usage later
        for (int i = 0; i < numberOfCases * 2; i++) {

            //each line will have 4 doubles to take in that will represent: x,y,w,h
            //top corner x and y position
            //width and height w,h
            xpos = in.nextDouble();
            ypos = in.nextDouble();
            width = in.nextDouble();
            height = in.nextDouble();

            E1Rectangle rectangle = new E1Rectangle(xpos, ypos, width, height);
            //System.out.print(rectangle.toString()); //test to see if the rectangle was read correctly

            //if the rectangles pair is the first one in the pair, add it to the First Rectangles list
            if (i % 2 == 0) {
                rectanglesFirst.add(rectangle);
                //System.out.print(rectangle.toString()); //test to see if the rectangle was read correctly
            } else { // if the rectangle is the second one in the pair add it the the second rectangles list
                rectanglesSecond.add(rectangle);
            }

        }

        //compare the first and second pairs of rectangles
        //to string the info of the rectangles
        //check contains and check touches
        for (int i = 0; i < numberOfCases; i++) {
            System.out.println("Case #: " + (i + 1));
            System.out.print("The First Rectangle's ");
            System.out.print(rectanglesFirst.get(i).toString());

            System.out.print("The Second Rectangle's ");
            System.out.print(rectanglesSecond.get(i).toString());

            System.out.print("The Contains Method Returns: ");
            System.out.print(rectanglesFirst.get(i).contains(rectanglesSecond.get(i)));
            System.out.println(); // for formatting's sake
            System.out.print("The Touches Method Returns: ");
            System.out.print((rectanglesFirst.get(i).touches(rectanglesSecond.get(i))));
            System.out.println(); // for formatting's sake
        }
    }
}
