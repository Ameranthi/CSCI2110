import java.util.Scanner;

public class Exercise1 {

    //Exercise 1 A
    public static int factorial(int n) {
        //base case
        if (n == 0) //if n == 0, then factorial(n) = 1
            return 1;
        else //n > 0, then factorial(n) = n * factorial(n-1)
            return (n * factorial(n - 1));
    }

    //Exercise 1 B
    public static int exponential(int n, int x) {
        if (n == 0) { //if the number is 0 then retrun 0
            return 1;
        } else {
            //use Math.pow()
            return (int)Math.pow(n, x); //number to the x power (n^x)
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int factorial;
        int number = 1;//It is the number to calculate factorial
        System.out.println("Factorials:");

        for(int i = 0; i<10; i++ ){
            factorial = factorial(number);
            System.out.println(number + "! = " + factorial);
            number++;
        }

        System.out.println("Enter the base");
        int base = in.nextInt();
        System.out.println("Enter the exponent");
        int exponent = in.nextInt();
        int exponential = exponential(base, exponent);
        System.out.println(base +" to the power of " + exponent + " is " + exponential);


    }
}

