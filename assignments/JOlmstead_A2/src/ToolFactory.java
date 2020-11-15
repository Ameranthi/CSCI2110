public class ToolFactory {
    public static Tool ToolFactory(String itemName) {

        Tool tool = null;

        //for me:
        //Make a case for each valid tool type
        //Don't forget to put a "break;" after each case
        switch (itemName) {
            case "hammer": //if it is a hammer
                tool = new Hammer(itemName);
                break;
            case "level": // if it is a level
                tool = new Level(itemName);
                break;
            case "saw": //if it is a saw
                tool = new Saw(itemName);//rest of initialize statement
                break;

            default:
                // Not a valid tool; print error message
                System.err.print("\nNot a valid tool, we only have 3 tool types in this house \n\n");
        }
        return tool;
    }
}


