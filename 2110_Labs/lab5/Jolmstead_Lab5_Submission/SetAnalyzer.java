

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetAnalyzer<T> {

    //setAnalyzer(): empty constructor
    public SetAnalyzer() {

    }
    //Intersection:
// method which accepts two generic arraylists of type T, computes their intersection set, and returns a new arraylist.
    public ArrayList<T> intersection(ArrayList<T> list1, ArrayList<T> list2) {

        ArrayList<T> intersection = new ArrayList<T>();
        //practice for each loop, https://www.geeksforgeeks.org/for-each-loop-in-java/ (includes limitations documentation)
        for (T element : list1) { //for every element in list1
            //does list2 contain the current element?
            if(list2.contains(element)) {
                intersection.add(element); //if yes, then add it to the intersection set
            } //otherwise, don't do anything and proceed along with the loop
        }
        return intersection;
    }

    //union
// accepts two generic arraylists of type T, computes their union set, and returns a new arraylist containing the union.
    public ArrayList<T> union(ArrayList<T> list1, ArrayList<T> list2) {

        //initialize unionSet
        Set<T> unionSet = new HashSet<T>(); //sets only allow 1 of every element
        //addAll method adds all elements from list to the set
        unionSet.addAll(list1); //add all elements from list1 to set
        unionSet.addAll(list2);//add all elements from list2 to set - all duplicates wont be added, creating a union

        //create a new arraylist from the set
        ArrayList<T> union = new ArrayList<T>(unionSet);

        return union; //return union set
    }
}

