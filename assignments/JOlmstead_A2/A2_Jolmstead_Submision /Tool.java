

/**
 * Basic tool class
 */
public class Tool{
    String function;
    private String name;


public Tool(String name){
    function = "I don't know what I do, but I try";
    this.name=name;
}

    public String getName(){return  name;}

public String toString(){
    return name;
}

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
