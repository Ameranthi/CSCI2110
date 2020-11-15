

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * Creates a storage bin and a toolbelt. Adds items to the bin, then to the tool belt if requested.
 */
public class StorageBinTester {


    public static void main(String[] args) {

        StorageBin<Tool, Integer> bin = new StorageBin<Tool, Integer>();
        ArrayList<Tool> workbelt = new ArrayList<Tool>();

        ToolFactory toolFactory = new ToolFactory();
        //Notification notification = notificationFactory.createNotification("SMS");

        Scanner in = new Scanner(System.in);
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter tools to be stored in the format ItemName ID\n" +
                "Enter quit to end the list of tools");


        //take in input
        while(in.hasNextLine()) {

            //take in the string to create lists
            String inputLine = in.nextLine();

            if (!(inputLine.equals("quit"))) {
                //first word in the line is the item Name, second word in the item list is the ID
                String[] itemsAndIDs = inputLine.split(" ");//split buy blank spaces
                String itemName = itemsAndIDs[0];
                String IDs = itemsAndIDs[1];
                int id = parseInt(IDs);

                //create the appropriate type tool with Factory Method
                Tool tool = ToolFactory.ToolFactory(itemName);
                //check to see if tool with same id is already in list
                    if (!(bin.containsID(id))) { // beware: you used to be a totalogy to be or not to be, p or ~p
                        //add tool to list if it doesn't exist already
                        bin.addItem(tool, id);
                        System.out.println("Item added");
                    } else {
                        System.out.println("There is already a tool with that item ID.");
                    }

            } else if (inputLine.equals("quit")) {
                break;
            }
        }

        System.out.println("Items in storage:");
        //After entering the tools, print the items in storage in the following format:
        // Name Function ID
        for (int i = 0; i < bin.sizeOfBin() ; i++){
            String name = bin.getItemStored(i).getName();
            String function = bin.getItemStored(i).getFunction();
            Tool item = bin.getItemStored(i);
            int id = bin.getItemIDs(i);
            //System.out.println(function); //test purposes
            System.out.println("Item " + name + ": " + item.getFunction() + " ID: " + id);
        }

        System.out.println(); //for formatting sake
        //Prompt the user to retrieve tools from the bin and add them to the workbelt
        System.out.println("Would you like to retrieve a tool and add it to the workbelt? yes/no");

        while (kb.hasNextLine()){

            String workbeltAnswer = kb.nextLine();

            if (workbeltAnswer.equals("yes")) { //if yes, add specific tool to the work belt and remove specific tool from bin

                //The user will enter the unique tool ID to search the storage bin
                System.out.println("Please enter the unique tool ID of the tool you would like to put into your workbelt");
                int id = kb.nextInt();

                //If the tool is in the bin, add it to the workbelt, otherwise print an error
                if (bin.containsID(id)==true){
                    int indexOfToolInBin = bin.getIDIndex(id); //the index of the id will be the same index as the item
                    Tool tempTool = bin.getItemStored(indexOfToolInBin);
                    workbelt.add(tempTool);
                    System.out.println(bin.removeItem(id));
                    System.out.println("Item removed from bin and placed on workbelt");
                    System.out.println("Would you like to retrieve a tool and add it to the workbelt? yes/no");
                } else {
                    System.err.println("Tool was not found in the bin, unable to add to workbelt");
                    System.out.println("Would you like to retrieve a tool and add it to the workbelt? yes/no");
                }
            } else if (workbeltAnswer.equals("no")){//Entering “no” stops adding tools to the workbelt.
                System.out.print("Okay, Have a nice day!");
                break;//if no, then dont add any tools to the work belt n break
            }
        }

        //Print the contents of the storage bin and the workbelt
        System.out.println("\nItems in storage:");
        //After entering the tools, print the items in storage in the following format:
        // Name Function ID
        for (int i = 0; i < bin.sizeOfBin() ; i++){
            String name = bin.getItemStored(i).getName();
            String function = bin.getItemStored(i).getFunction();
            Tool item = bin.getItemStored(i);
            int id = bin.getItemIDs(i);
            //System.out.println(function); //test purposes
            System.out.println("Item " + name + ": " + item.getFunction() + " ID: " + id);
        }

        System.out.println("\nItems on workbelt:");
        for (int i = 0; i < workbelt.size() ; i++){
            String name = workbelt.get(i).getName();
            String function = workbelt.get(i).getFunction();
            Tool item = workbelt.get(i);

            System.out.println("Item " + name + ": " + item.getFunction());
        }

    }
}
