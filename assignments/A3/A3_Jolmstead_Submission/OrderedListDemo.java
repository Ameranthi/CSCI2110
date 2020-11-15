import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class OrderedListDemo {
    public static void main (String []args) throws FileNotFoundException {

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

        //instantiate two ordered lists to hold the names of each list
        OrderedList<String> names1 = new OrderedList<String>();
        OrderedList<String> names2 = new OrderedList<String>();

        //instantiate two arraylists to hold the names of each list
        ArrayList<String> arrayListNames1 = new ArrayList<String>();
        ArrayList<String> arrayListNames2 = new ArrayList<String>();

        //In the main method, read in the values from list1.txt and list2.txt
        //accept input from a user (specifying the names of two input files) and read files

        //LIST ONE
        //read a list of names from a file and add them to orderedlist names1
        while(inputFile1.hasNextLine()){
            String name = inputFile1.nextLine();
            arrayListNames1.add(name);
        }
        //LIST TWO
        //read a list of names from a file and add them to orderedlist names2
        while(inputFile2.hasNextLine()){
            String name = inputFile2.nextLine();
            arrayListNames2.add(name);
        }
        //make the 2 ORDERED lists
        Collections.sort(arrayListNames1);
        Collections.sort(arrayListNames2);

        Set mergedSet = new HashSet(); //sets only allow 1 of every element
        //addAll method adds all elements from list to the set
        mergedSet.addAll(arrayListNames1); //add all elements from list1 to set
        mergedSet.addAll(arrayListNames2);//add all elements from list2 to set - all duplicates wont be added, creating a union
        //create a new arraylist from the set
        ArrayList merged = new ArrayList(mergedSet);
        //alphabetize it
        Collections.sort(merged);

        //FOR Testing purposes, keep
//        System.out.println("Ordered first list: " + arrayListNames1);
//        System.out.println("Ordered second List: " + arrayListNames2);
//        System.out.println("Merged List" + Arrays.toString(merged.toArray()));

        //resource: https://www.w3schools.com/java/java_files_create.asp
        //use try catch block to ensure it is being written to file
        try {
            //file writer object, can write and open files
            FileWriter textEditor = new FileWriter("merged.txt"); //create new object to write to merged.txt and open file
            //write() method will write to the textEditors opened file and if there is something already in the file it will write over it
            textEditor.write("The Ordered Lists contain the following entries:\n" +
                    "1) Ordered first list: " + arrayListNames1+ "\n" +
                    "2) Ordered second List: " + arrayListNames2 + "\n" +
                    "3) Merged List: " + Arrays.toString(merged.toArray())); //write the lists to the file
            textEditor.close(); //close the open file - similar to php, don't keep it open to reduce load
            //System.out.println("Successfully wrote to the file."); //print success statement for testing

        } catch (IOException e) { //use catch statement to check if could not be written
            System.err.println("An error occurred.");
        }
    }
}
