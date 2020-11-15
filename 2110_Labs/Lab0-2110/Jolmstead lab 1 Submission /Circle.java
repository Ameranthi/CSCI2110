/*
Julia Olmstead
B00780639
CSCI 2110
Fall 2020
Covid szn
*/
public class Circle {
    //Two double data fields named xpos and ypos that specify the center of the circle.
    double xpos;
    double ypos;
    double radius; //A double data field radius.

    final double pi = 3.14;

    //A constructor that creates a circle with the specified xpos, ypos and radius.
    public Circle(double xpos, double ypos, double radius){
        this.radius = radius;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    //getters and setters

    //Two Setter methods: one for setting the center and one for setting the radius
    public void setCentre(double xpos, double ypos){
        this.ypos = ypos;
        this.xpos = xpos;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }

    //Three Getter methods, one each for xpos, ypos and radius.
    public double getXpos(){
        return xpos;
    }
    public double getYpos(){
        return ypos;
    }
    public double getRadius(){
        return radius;
    }

    // A method getArea() that returns the area of the circle.
    //Area = pi*radius*radius
    public double getArea(){
        return pi*radius*radius;
    }

    //A method getCircumference() that returns the circumference of the circle.
    //Circumference = 2*pi*radius
    public double getCircum(){
        return 2*pi*radius;
    }


    //get Distance between the two centres of both circles
    public double getDistance(double x, double y){
        return Math.sqrt(Math.pow((x-xpos),2) + Math.pow((y-ypos),2));
    }

    //for contains methods:
    //The distance between two points p1=(x1, y1) and p2 = (x2,y2) is given by the square root of (x2-x1)^2 + (y2-y1)^2

    //A method contains(double x, double y)
    // returns true if the specified point (x,y) is inside this circle, false otherwise.
    public boolean contains(double x, double y){
        return (getDistance(x,y) < radius);
    }
    //A method contains(Circle c)
    //returns true if the specified circle is completely inside this circle
    //false otherwise.
    public boolean contains( Circle c ){
         double distanceBetweenCentres = getDistance(c.getXpos(),c.getYpos());

         return (distanceBetweenCentres + c.getRadius()< radius);
    }

    public boolean touches(double x, double y){
        return getDistance(x,y) == radius;
    }

    //A method touches(Circle c) that returns true if the specified circle touches this circle (similar to the case of the rectangle), false otherwise.

    public boolean touches (Circle c){
        double distanceBetweenCenters = getDistance(c.getXpos(), c.getYpos());
        return distanceBetweenCenters + c.getRadius() == radius ||
                distanceBetweenCenters - c.getRadius() == radius;
    }

    public String toString(){
        return "Circle's centre is "  + xpos + ", " + ypos + " \n"  +
                "It's Radius is: "
                + radius + "\n" + "Its Area is: " + getArea() +"\n";

    }
}
