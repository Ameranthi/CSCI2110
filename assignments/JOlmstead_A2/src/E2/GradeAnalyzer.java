package E2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Basic record keeping class
 * Complete the GradeAnalyzer.java class
 */
public class GradeAnalyzer {

    //setting up a list for Records and for storing summary data on grades
    private List<Record> gradeList;
    private ArrayList<Integer> gradeSummary;

    //hash map has unique keys and individual values.
    HashMap<Record, Integer> hashMapOfRecordsAndGrades;


    public GradeAnalyzer(ArrayList<Record> records, ArrayList<Integer> gradesinputted) {
        gradeList = records;
        gradeSummary = gradesinputted;

        hashMapOfRecordsAndGrades = new HashMap<Record, Integer>();
        //add records and their grades to hashmap
        for (int i = 0; i < gradeList.size(); i++) {
            hashMapOfRecordsAndGrades.put(gradeList.get(i), gradeSummary.get(i));
        }

    }

    //•addRecord(Record r): void method to add a record to the list
    public void addRecord(Record r) {
        gradeList.add(r);
    }

    //•removeRecord(Record r): void to remove a record from the list
    public void removeRecord(Record r) {
        gradeList.remove(r);
    }

    //clearAllRecords(): void clears the record list
    public void clearAllRecords() {
        gradeList.clear();
    }

    //•printAllRecords(): void prints the records
    public void printAllRecords() {
        for (Record r : hashMapOfRecordsAndGrades.keySet()) {
            String key = r.getNameofStudent();
            String value = hashMapOfRecordsAndGrades.get(r).toString();
            System.out.println(key + ", " + value + "\n");
        }
        //interesting code from stack overflow from java8 and I would like to understand the syntax more:
        // grades.entrySet().forEach(grade-> System.out.println(grade.getKey() + " " + grade.getValue() + "\n"));
    }


    /* •printHistogram():void prints a histogram of the grade data with interval size 9
0-10|**
10-20|***
20-30|
30-40|
40-50|**
50-60|****
60-70|*********
70-80|********
80-90|***************
90-100|*********
*/
    public void printHistogram() {
        HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();

        for (int j = 0; j <= 10; j++) {
            //set up histogram
            histogram.put(j, 0);

        }

        for (int i = 0; i < gradeSummary.size(); i++) {
            int grade = gradeSummary.get(i);
            int place = grade / 10;
            //System.out.println(place); //for testing
            int value = histogram.get(place);
            value++;
            //put the correct amount of data per bucket
            histogram.replace(place, value);
        }
        int modifier = 0;
        for (int i = 0; i<10; i++) {

            String range = modifier + " - " + (modifier+10);
            String asterisks = "";
            modifier+=10;
            for( int j = 0; j< histogram.get(i);j++) {
                asterisks += "*";
            }
            System.out.println(range + "|" + asterisks);

        }

    }
}
