package E2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeAnalyzerTester {

    public static void main(String[] args) throws FileNotFoundException {


        // initialize Scanner to capture user input
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = in.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> grades = new ArrayList<Integer>();

        //take in input
        while(inputFile.hasNextLine()) {

            //take in the string to create lists
            String inputLine = inputFile.nextLine();
            //System.out.println(inputLine); for testing

            if (!(inputLine.equals("-1"))) {

                try {
                    int grade = Integer.parseInt(inputLine);
                    grades.add(grade);
                } catch (NumberFormatException e) {
                    names.add(inputLine);
                }
            }
        }
       // System.out.println(names);
        //System.out.print(grades);

        ArrayList<Record> records = new ArrayList<Record>();
        for (int i =0; i <names.size(); i++){
            Record record = new Record(names.get(i),grades.get(i));
            records.add(record);
        }

        GradeAnalyzer analyzer = new GradeAnalyzer(records, grades);
        analyzer.printAllRecords();
        analyzer.printHistogram();
    }
}
