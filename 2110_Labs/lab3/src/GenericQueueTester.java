/**
 * Julia Olmstead
 * B00780639
 * Oct 4 2020
 */

import java.util.Scanner;
public class GenericQueueTester {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in); //take in colour and name
        // create two Stacks,
        GenericQueue queueString = new GenericQueue<String>();  // * one to hold Strings and
        GenericQueue queueInt = new GenericQueue<Integer>();   // * another to hold Integer Objects,

        //accept input from a user,  2 lines of input from a user.
        String inputLine1 = console.nextLine(); //An arbitrary number of Strings separated by whitespace
        // to be pushed to a queueu, with the final String ‘quit’ - signaling the end of input.
        String inputLine2 = console.nextLine();//An arbitrary number of integers separated by whitespace to be pushed
        // to a Stack, with the final int ‘-1’ signaling the end of input.

        String[] inputLine1Words = inputLine1.split(" ");//split by blank spaces
        String[] inputLine2Words = inputLine2.split(" ");//split by white space

        //push each item onto the Stack
        for (int i = 0; i < inputLine1Words.length; i++) {
            if (!(inputLine1Words[i].equals("quit"))) {//push the contents of the array onto the String queue - dont include the word quit
                queueString.enqueue(inputLine1Words[i]);
            }
        }

        for (int i = 0; i < inputLine2Words.length; i++) {
            int item = Integer.parseInt(inputLine2Words[i]); //parseInt the strings to ints
            if (item != -1) {   //push contents of the array onto the Integer Stack - dont include the int -1
                queueInt.enqueue(item);
            }
        }
        System.out.println("String Queue Contents");

        int sizeOfStringStack = queueString.size();

        for (int i = 0; i < sizeOfStringStack; i++) {// for loop to pop everything off of the String queue
            System.out.println(queueString.dequeue());//print out each pop on a new line
        }

        System.out.println(); //after the string queue is done popping \n new line for formatting sake

        System.out.println("Integer Queue contents");
        int sizeOfIntStack = queueInt.size();
        for (int i = 0; i < sizeOfIntStack; i++) {// for loop to pop everything off of the Int queue

            System.out.println(queueInt.dequeue());//print out each pop on a new line
        }

    }
}