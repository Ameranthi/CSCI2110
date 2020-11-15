import java.util.Scanner;
public class Exercise2 {

    public static void countDown(int n){ //n number
        if (n == 0) { // if passed 1 and reached 0, then print Blast off
            System.out.println("Blastoff!");
        } else {
            System.out.print(n + "! "); // exclamation marks and a space for dramatic effect
            countDown(n - 1);
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an Integer");
        int n = in.nextInt();

        System.out.print("Countdown Begins... ");
        countDown(n);


    }

}
