public class Level extends Tool{

    String function = "I make sure everything is even";
    public Level(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    @Override
    public String toString() {
        return getName() + function;
    }
}
