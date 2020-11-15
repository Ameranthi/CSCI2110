

import java.util.ArrayList;

/**
 * A class which stores items with unique identifiers
 *
 * @param <T>
 * @param <U>
 **/
public class StorageBin<T, U> {
    //Two generic ArrayLists to store generic items - low key so mad that the instructions say this and I cant use a hashmap
    private ArrayList<T> itemsStored; //values
    private ArrayList<U> itemIDs; //unique keys

    /**
     * Setting up the lists
     * A constructor to set up the ArrayLists
     */
    public StorageBin() {
        itemsStored = new ArrayList<T>();
        itemIDs = new ArrayList<U>();
    }

    //sizeofBin():int method which returns the number of items stored
    public int sizeOfBin() {
        return itemsStored.size();
    }

    //addItem(T item, U id):void method which adds an item and its unique ID to the arrays.
    public void addItem(T item, U id) {

        //This method prints an error if an item is added with an already existing ID
        if (itemIDs.contains(id)) {
            //print error

        } else {
            itemsStored.add(item);
            itemIDs.add(id);
        }
    }

    //method remove the item with the given ID from the bin and returns it to the caller.
    public T removeItem(U id) {
        int indexOfItem = itemIDs.indexOf(id);
        T itemTemp = itemsStored.get(indexOfItem);
        itemsStored.remove(indexOfItem);// remove from item list
        itemIDs.remove(indexOfItem);//remove from id list
        return itemTemp;
    }

    //method prints the contents of the storage bin in the format Name and ID
    public String displayItems() {

        String display = "";
        int counter = 0;
        for (T item : itemsStored) {
            //"Item " + name + ": " + item.getFunction() + " ID: " + id
            display += "item: " + item + ": "+  " ID: " + itemIDs.get(counter) + "\n";
            counter++;
        }
        return display;
    }

    public T getItemStored(int i) {
        return itemsStored.get(i);
    }

    public U getItemIDs(int i) {
        return itemIDs.get(i);
    }

    public boolean isEmpty() {
        if (itemsStored.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(Tool tool, int id) {
        String itemName = tool.getName();
        if (!isEmpty()) { //if the list is not empty then there is a possibility it contains the item with same id
            for (int i = 0; i < itemsStored.size(); i++) {
                if (itemsStored.get(i).equals(itemName) && itemIDs.get(i).equals(id)) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }
    public boolean containsID(int id){
        if (!isEmpty()) { //if the list is not empty then there is a possibility it contains the item with same id
            for (int i = 0; i < itemsStored.size(); i++) {
                if (itemIDs.get(i).equals(id)){
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public int getIDIndex(int id){
        if(containsID(id)==true){
            return itemIDs.indexOf(id);
        }
        return -1;
    }
}
