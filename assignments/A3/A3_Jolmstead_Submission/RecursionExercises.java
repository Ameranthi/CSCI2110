public class RecursionExercises {
    //Write a recursive method call squares which accepts a single positive integer
    // and calculates the sum of the squares of all the digits up to and including the integer. Use the following signature:
    public static void main(String[] args) {

        int n1 = 7;//for the squares method input
        System.out.println("The sum of the squares up to " + n1 + " is: " + squares(n1));
        int n2 = 8;//for the squares method input
        System.out.println("The sum of the squares up to " + n2 + " is: " + squares(n2));

        String word1 = "Mandalorian"; //for the reverse string method input
        int i1 = 1; // for the reverse string method inout
        System.out.println("Starting word is " + word1 + ", reversed from index [" + i1 + "] is " + reverseString(word1, i1));
        String word2 = "Star Wars"; //for the reverse string method input
        int i2 = 3; // for the reverse string method inout
        System.out.println("Starting word is " + word2 + ", reversed from index [" + i2 + "] is " + reverseString(word2, i2));
    }

    public static int squares(int n) {
        //check if the number = 0
        if (n == 0) {
            return 0;
        } //else continue with the code,
        //start with n and decrement until 0 to terminate the recursive method
        return squares(n - 1) + (n * n); //n*n = square. add the squares for each round of recursion
    }

    //• Write a recursive method called reverseString which accepts a string and an integer. The method returns the passed in string in reverse order starting from a specified index. Use the following header:
    public static String reverseString(String word, int i) {

        //check to see if the string is empty or not
        if (word.isEmpty()) {
            return word;
        } else if (i > 0) {// if index is greater than 0, keep iterating down with method
            return reverseString(word.substring(0, word.length() - 1), i - 1);
        } else { // if its less than 0 start getting the letters
            return word.charAt(word.length() - 1) + reverseString(word.substring(0, word.length() - 1), i - 1);
        }
    }
}


