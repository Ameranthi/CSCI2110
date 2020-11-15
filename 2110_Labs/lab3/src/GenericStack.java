import java.util.ArrayList;

public class GenericStack<T> {

    ArrayList<T> stack = new ArrayList<T>();
    int size = stack.size();

    public GenericStack(){
        this.size = stack.size();
        this.stack = new ArrayList<T>();

    }

    public int size(){
        return stack.size();
    }

    public T pop(){
        T item = stack.get(size()-1); //save the reference
        stack.remove(stack.get(size()-1)); //emulate popping action by removing it from the list
        return item; //return the reference
    }

    public T peek(){
        return stack.get(size()); //just return element without getting rid of it
    }

    public void push(T element){
        stack.add(element);//will be added to the next index of the list
    }
    public boolean isEmpty(){
        if(stack.size() == 0){
            return true;
        } else {
            return false;
        }
    }
}
