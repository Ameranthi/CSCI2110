public class Saw extends Tool {

    String function = "I saw stuff";
    public Saw(String name) {
        super(name);

    }

    //set function
    public void setFunction(String function) {
        this.function = function;
    }
    //get function
    public String getFunction() {
        return function;
    }

    @Override
    public String toString() {
        return getName() + function;
    }

    @Override
    public String getName() {
        return super.getName();
    }


}
