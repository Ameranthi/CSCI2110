
//Demo class


public class Exercise0A {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(10, 20, 300, 400);
        System.out.println("Created one rectangle object:\n" + rect1);
        rect1.moveTo(30, 40);
        System.out.println("Moved to new position: \n" + rect1);
        rect1.resize(350, 450);
        System.out.println("Resized to new dimensions: \n" + rect1);
    }
}