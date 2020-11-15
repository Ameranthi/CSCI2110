//Demo class
public class Exercise0B {
    public static void main(String[] args) {
        Rectangle1 rect1 = new Rectangle1(10, 20, 300, 400);
        Rectangle1 rect2 = new Rectangle1(15, 25, 100, 100);
        System.out.println("Point (30,40) is contained in " + rect1 + "?\t" +
                            rect1.contains(30, 40));
        System.out.println("Point (10,20) is contained in " + rect1 + "?\t" +
                            rect1.contains(10, 20));
        System.out.println("Point (4,3) is contained in " + rect1 + "?\t" +
                            rect1.contains(4, 3));
        System.out.println("Rectangle " + rect2 + " is contained in " + rect1 + "?\t" +
                            rect1.contains(rect2));
        System.out.println("Rectangle " + rect1 + " is contained in " + rect2 + "?\t" +
                            rect2.contains(rect1));
    }
}