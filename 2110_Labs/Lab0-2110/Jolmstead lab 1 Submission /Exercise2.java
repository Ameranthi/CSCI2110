import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //take in the number of cases to test
        int numberOfCases = in.nextInt();
        double xpos;
        double ypos;
        double radius;


        //array lists to put the circles in
        ArrayList<Circle> c1 = new ArrayList<Circle>();
        ArrayList<Circle> c2 = new ArrayList<Circle>();


        //take in the information for the rectangles and put them into an arraylist for usage later
        for (int i = 0; i < numberOfCases * 2; i++) {

            //each line will have 3 doubles to take in that will represent: x,y,r
            //centre of circle = x and y position
            //radius of the circle
            xpos = in.nextDouble();
            ypos = in.nextDouble();
            radius = in.nextDouble();

            Circle circle = new Circle(xpos, ypos, radius);

            if (i % 2 == 0) {
                c1.add(circle);
            } else { // if the circle is the second one in the pair add it the the second rectangles list
                c2.add(circle);
            }

        }

        //compare the first and second pairs of rectangles
        //to string the info of the rectangles
        //check contains and check touches
        for (int i = 0; i < numberOfCases; i++) {
            System.out.println("Case #: " + (i + 1));
            System.out.print("The First ");
            System.out.print(c1.get(i).toString());

            System.out.print("The Second ");
            System.out.print(c2.get(i).toString());

            System.out.print("The Contains Method Returns: ");
            System.out.print(c1.get(i).contains(c2.get(i)));
            System.out.println(); // for formatting's sake
            System.out.print("The Touches Method Returns: ");
            System.out.print((c1.get(i).touches(c2.get(i))));
            System.out.println(); // for formatting's sake
        }


    }
}
