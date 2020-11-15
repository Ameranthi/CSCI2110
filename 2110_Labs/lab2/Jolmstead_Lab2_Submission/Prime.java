/*
Julia Olmstead
CSCI 2110
Lab 2 September 26th 2020
Prime Solution
*/
/**
 * This class tests the code for Lab2: Exercise1. It calls a method to
 * calculate the nth prime and prints information about running time.
 * It expands upon a framework provided by Srini.
 */

import java.util.*;

public class Prime {
    public static void main(String[] args) {
        //timer begins
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();

        Scanner in = new Scanner(System.in);
        long n;
        //array to but the numbers in
        ArrayList<Long> numbers = new ArrayList<>();

        //take in the nth primes to look for
        while (in.hasNextLong()) {
            //System.out.println(in.hasNextInt()); // for debugging purposes
            n = in.nextLong(); //the nth prime that we want to find
            if (n == 0) {
                break;
            }
            numbers.add(n);
            //System.out.println(n); //for debugging purposes
            // System.out.println(in.hasNextInt()); //for debugging purposes
        }
        //print out the nth prime it is
        for (int i = 0; i <= numbers.size() - 1; i++) {

            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            System.out.println("the #" + numbers.get(i) + " prime is " + nthPrime(numbers.get(i))
                    + " and took " + executionTime + " millis");


            System.out.println("Elapsed time: " + executionTime);
        }
    }

    public static long nthPrime(long n) {
        ArrayList<Long> primeNumbers = new ArrayList<Long>(); //to put only the prime numbers in

        for (int i = 2; primeNumbers.size() <= n; i++) { //go until the prime number list size reaches the inputted number
            if (checkPrime(i)) { //check if it is prime
                primeNumbers.add((long)i); // if it is add it to the list
            }
        }
        return primeNumbers.get(((int)n-1)); //return the number
    }

    public static boolean checkPrime(long n) {
        int i = 2; //0 and 1 are not prime numbers start at 2
        while (i < n-1) { //check each number in between as prime is only itself and 1
            if (n % i == 0) { //check the remainders
                return false;
            }
            i++;
        }
        return true;
    }
}