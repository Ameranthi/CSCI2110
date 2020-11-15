import java.util.Scanner;

public class Exercise3 {
    public static void multiples(int n, int m) {
        if (m == 0) {
            System.out.print("end");
        } else{
            System.out.print(n * m + ", ");
            multiples(n, m-1);
        }

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an value");
        int number = in.nextInt(); //number to get multiples of
        System.out.println("How many multiples do you want?");
        int amountOfMultiples = in.nextInt(); //amount of multiples to find

        System.out.println("The first " + amountOfMultiples + " multiples of " + number + " are: ");
        multiples(number, amountOfMultiples);
    }
}

