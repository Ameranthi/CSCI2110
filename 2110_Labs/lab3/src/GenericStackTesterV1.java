import java.util.Scanner;

public class GenericStackTesterV1 {


    public static void main (String[] args) {
        Scanner in = new Scanner(System.in); //take in colour and name


        // create two Stacks,
        GenericStack stackString = new GenericStack<String>();  // * one to hold Strings and
        GenericStack stackInt = new GenericStack<Integer>();   // * another to hold Integer Objects,

        while(in.hasNext()){
            String element = in.next();
            if(!element.equals("quit")){
                stackString.push(element);
                System.out.print(stackString.peek());
            }
        }
    }

}


