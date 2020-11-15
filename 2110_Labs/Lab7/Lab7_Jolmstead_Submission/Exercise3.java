import java.util.Scanner;

public class Exercise3 {
    public static void writeVertical(int number){

       /*
       Recursion Stacks:
       the first call will be saved to be executed first after it is able to go through all of the recursive calls
        */

        if(number <10){
            System.out.println(number); // will be the last digit in the integer, do not have to go through another recursive call
        } else {
            writeVertical(number/10);//divide the number by 10 to reduce the digit place
            System.out.println(number%10); //print the remainder
        }
    }
    public static void main (String[]args){
        System.out.println("Please input a number:");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        writeVertical(number);
    }

}
