import java.lang.reflect.GenericSignatureFormatError;
import java.util.Scanner;

/**
 * Julia Olmstead
 * B00780639
 * Oct 3 2020
 *
 */

public class GenericStackTester {
    public static void main (String[] args){
        Scanner console = new Scanner (System.in); //take in colour and name
        // create two Stacks,
        GenericStack stackString = new GenericStack<String>();  // * one to hold Strings and
        GenericStack stackInt = new GenericStack<Integer>();   // * another to hold Integer Objects,

        //accept input from a user,  2 lines of input from a user.
        String inputLine1 = console.nextLine(); //An arbitrary number of Strings separated by whitespace
        // to be pushed to a Stack, with the final String ‘quit’ - signaling the end of input.
        String inputLine2 = console.nextLine();//An arbitrary number of integers separated by whitespace to be pushed
        // to a Stack, with the final int ‘-1’ signaling the end of input.

        String[] inputLine1Words = inputLine1.split(" ");//split by blank spaces
        String[] inputLine2Words = inputLine2.split(" ");//split by white space

        //push each item onto the Stack
        for (int i = 0; i < inputLine1Words.length; i++){
            if(!(inputLine1Words[i].equals("quit"))){//push the contents of the array onto the String stack - dont include the word quit
                stackString.push(inputLine1Words[i]);
            }
        }

        for(int i = 0; i < inputLine2Words.length; i++){
            int item = Integer.parseInt(inputLine2Words[i]); //parseInt the strings to ints
            if(item != -1){   //push contents of the array onto the Integer Stack - dont include the int -1
                stackInt.push(item);
            }
        }
        System.out.println("String Stack Contents");
        //System.out.println("stackString size: " + stackString.size()); for testing
        int sizeOfStringStack = stackString.size();
        // display the Stack String contents.
        for(int i = 0; i < sizeOfStringStack; i++){// for loop to pop everything off of the String stack
            System.out.println(stackString.pop());//print out each pop on a new line
        }

        System.out.println(); //after the string stack is done popping \n new line for formatting sake

        System.out.println("Integer Stack contents");
        int sizeOfIntStack = stackInt.size();
        for(int i = 0; i < sizeOfIntStack; i++){// for loop to pop everything off of the Int stack
            //int item = stackInt.size(); for testing
            //System.out.println(item); for tests
            System.out.println(stackInt.pop());//print out each pop on a new line
        }

    }
}
