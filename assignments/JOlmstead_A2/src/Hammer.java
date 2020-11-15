public class Hammer extends Tool{

    String function = "I hammer stuff";

    public Hammer(String name) {
        super(name);
        super.function = "I hammer stuff";
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFunction(){
        return function;
    }

    //toString():String = override the parent’s toString() method to return the tool’s name + function
    @Override
    public String toString() {
        return getName() + function;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}