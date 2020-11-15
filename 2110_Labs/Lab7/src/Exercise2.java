import java.util.Scanner;

public class Exercise2 {

    public static void countDown2(int n) { //n number
        //did n equal 0 or get reduced to below 0?
        if (n <= 0) { //if yes, then ... BLASTOFF!
            System.out.println("Blastoff!");
        } else {
            System.out.print(n + "! "); // exclamation marks and a space for dramatic effect
            countDown2(n - 2); //to make sure it is always odd or even just go down by two instead of 1
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an Integer:");
        int n = in.nextInt();

        System.out.print("Countdown Begins... ");
        countDown2(n);
    }

}
