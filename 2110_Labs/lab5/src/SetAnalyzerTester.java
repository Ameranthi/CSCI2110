import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SetAnalyzerTester {

    public static void main(String[] args) throws FileNotFoundException {

// Ask the user if they will be analyzing integers or Strings
        System.out.println("Will you be analyzing Integers or Strings? (case sensitive)");
        Scanner console = new Scanner(System.in);
        String type = console.nextLine();
        ArrayList list1;
        ArrayList list2;
        if (type.equals("Integers")) {
            list1 = new ArrayList<Integer>();
            list2 = new ArrayList<Integer>();
        } else {
            list1 = new ArrayList<String>();
            list2 = new ArrayList<String>();
        }

        // initialize Scanner to capture user input
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first filename to read from: ");//Asks the user to enter a file name
        String filename1 = in.nextLine();
        File file1 = new File(filename1);
        Scanner inputFile1 = new Scanner(file1);

        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the second filename to read from: ");//Asks the user to enter a 2nd file name
        String filename2 = kb.nextLine();
        File file2 = new File(filename2);
        Scanner inputFile2 = new Scanner(file2);

        //Populates the two ArrayLists with input data from the two files
        if (type.equals("Integers")) { //if its INTEGERS
            while (inputFile1.hasNextInt()) {
                int v = inputFile1.nextInt();// v is the whatever int that will be taken in
                list1.add(v);
            }
            while (inputFile2.hasNextInt()) {
                int v = inputFile2.nextInt();
                list2.add(v);
            }

        } else { //STRINGS
            while (inputFile1.hasNext()) {
                String v = inputFile1.next(); //v is the whatever string will be taken in
                list1.add(v);
            }
            while (inputFile2.hasNext()) {
                String v = inputFile2.next();
                list2.add(v);
            }
        }
            //Create a SetAnalyzer object
            SetAnalyzer setAnalyzer = new SetAnalyzer();

            //System.out.println(list1); //for testing purposes
            //System.out.println(list2); // for testing purposes
            System.out.println("Intersection between List1 and List2:\n" + setAnalyzer.intersection(list1, list2));
            System.out.println("Union between List1 and List2:\n" + setAnalyzer.union(list1, list2));

        }
    }
