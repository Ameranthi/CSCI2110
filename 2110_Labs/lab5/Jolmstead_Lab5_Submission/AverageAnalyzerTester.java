import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageAnalyzerTester {

    public static void main (String[]args) throws FileNotFoundException {

        // initialize Scanner to capture user input
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = in.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        ArrayList values = new ArrayList<Integer>();

        //Populate an ArrayList of Integers with the file data
        while(inputFile.hasNext()) {
            int v = inputFile.nextInt();
            values.add(v);
        }
        //Create an AverageAnalyzer object
        AverageAnalyzer averageAnalyzer = new AverageAnalyzer(values);//Pass list of data from file
        System.out.println("the mean is : " + averageAnalyzer.mean());
        System.out.println("the mode is: " + averageAnalyzer.mode());
    }

    /*
    public String printList(ArrayList list){
        for(int i = 0; i<list.size(); i++){

        }
    }
*/



}
