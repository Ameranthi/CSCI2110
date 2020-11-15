import java.util.ArrayList;

public class AverageAnalyzer {

    private ArrayList<Integer> values;

    // AverageAnalyzer(ArrayList<Integer> values): constructor which sets up the values list.
    public AverageAnalyzer(ArrayList<Integer> values) {
        this.values = values;
    }

    // mean():double method, which calculates the mean from the list of values
    public double mean() {
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }
        final double average = sum / values.size(); //a mean is the average of the numbers
        return average;
    }

    //mode(): int method, which calculates the mode from the list of values
    //o You are guaranteed that the list of values will have a mode and will be in the range of [0,100]
    public int mode() {
        int mode = 0;
        int finalCount = 0;
        for (int i = 0; i < values.size(); i++) {

            int firstOccurrence = values.get(i);//get the number from this position
            int tempCount = 1; //add a count to it

            for (int j =0 ; j < values.size(); j++) {
                int y = values.get(j); //create variable to check if the first occurrence of the int appears again.

                //does the first occurrence equals y?
                if (firstOccurrence == y) //yes, then...
                    tempCount++; //if it is the same then increase temp count by one

                //is the temp count greater than final count?
                if (tempCount > finalCount) { //if yes, temp count is higher than the final count,
                    // make the count = tempcount
                    finalCount = tempCount;
                    mode = firstOccurrence; //mode will be the the number that has the highest count
                }
            }

        }
        return mode;
    }
}


