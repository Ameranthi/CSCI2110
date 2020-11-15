import java.util.Scanner;

public class Exercise1 {
    //fibonacci - pineapple

    public static int fib(int n) { //fib = fibonacci
        if (n == 0) {//if n==0, then fib(n) = 0 //base case
            return 0;
        } else if (n == 1 || n == 2) { //if n==1 or n==2 then fib(n) = 1 //base case, this will print 1 twice
            return 1;
        } else {//if n>1, then fib(n) = fib(n-1) + fib(n-2)
            return (fib(n - 1) + fib(n - 2));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Fibonacci:");
        //print each fibonacci number at place i up till the 20th place
        for (int i = 0; i < 20; i++) {
            System.out.print(fib(i) + ", ");//print a comma after each fibonacci for formatting
        }
    }
}
