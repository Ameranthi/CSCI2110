import java.util.ArrayList;

public class GenericQueue<T> {

    ArrayList<T> queue = new ArrayList<T>();
    int size = queue.size();

    public GenericQueue() {
        this.size = queue.size();
        this.queue = new ArrayList<T>();
    }

    public int size() {
        return queue.size();
    }

    public T peek() {
        return queue.get(0);
    }

    public T dequeue() {
        T item = queue.get(0); //save the reference
        queue.remove(0); //emulate popping action by removing it from the list
        return item; //return the reference
    }

    public void enqueue(T element) {
        queue.add(element);
    }

    public boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    public void clear() {
        while (!(isEmpty())) {
            dequeue();
        }
    }

    //additional methods to be implemented
    //int positionOf(T item): Return the position of the specified item and -1 if not found.
    public int positionOf(T item){
        int position = -1;
        if(!(isEmpty())){
            for(int i = 0; i < size(); i++){
                if(queue.get(i).equals(item)){
                    position =i;
                    return position;
                } else{
                    position =-1;
                    return position;
                }
            }
        } else {
            return -1;
        }
        return position;
    }

    //void remove(T item): Remove the first occurrence (from front) of specified item
    public void remove(T item){

            for(int i = 0; i < size(); i++){
                if(queue.get(i).equals(item)){
                    queue.remove(i);
                }
            }
    }
    //T first(): Return the first item in the Queue(front), null if Queue is empty
    public T first(){
        T element;
        if(!(isEmpty())){
            element = queue.get(0);
            return element;
        } else {
            return null;
        }
    }
    //T next(): Return the next item in the Queue relative to the previous call to first or next.
    // Return null if end of Queue is reached.
    public T next(){
        T next;
        T current = queue.get(0);
        if(current != null){
            next = queue.get(1);
            return next;
        }
        return null;
    }

}
