public class E1Rectangle {
    //Rectangle class that defines a Rectangle object with xpos, ypos, width and height
    // Has two contains methods
    //instance variables
    private double xpos, ypos, width, height;

    //constructor
    public E1Rectangle(double xpos, double ypos, double width, double height) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    //setters and getters
    public void setX(double xpos) {
        this.xpos = xpos;
    }

    public void setY(double ypos) {
        this.ypos = ypos;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return xpos;
    }

    public double getY() {
        return ypos;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    //other methods: moveTo changes xpos and ypos and resize changes

    //width and height

    public void moveTo(double xpos, double ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public void resize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //toString method
    public String toString() {
        return "top corner is: [xpos= " + xpos + "," + "ypos= " + ypos + "] \n " +
                "It's width is: " +
                width + "\n"
                +
                "It's height is: " + height + "\n";
    }

    //contains method: returns true if a point (px, py) is contained within this rectangle
    //contains DOESNT returns true if the point touches the rectangle
    public boolean contains(double px, double py) {
        return (px > xpos && px < (xpos + width) &&
                py > ypos && py < (ypos + height));
    }
    // touches returns true if the point touches the rectangle
    public boolean touches(double px, double py) {
        return ((px == xpos || px == (xpos + width))) && (py >= ypos && py <= (ypos + height)) ||
                ((py == ypos || py == (ypos + height)) && (px >= xpos && px <= (xpos + width)));
    }

    // contains method: returns true if another rectangle r is contained within this rectangle
    // it uses the point contains method
    public boolean contains(E1Rectangle r) {
        return (this.contains(r.getX(), r.getY()) &&
                this.contains(r.getX() + r.getWidth(), r.getY() + r.getHeight()));
    }
    //returns true if the rectangle touches the boundaries
    //it uses the point touches method
    public boolean touches(E1Rectangle r){
        return (this.touches(r.getX(), r.getY()) ||
                this.touches(r.getX() + r.getWidth(),r.getY() + r.getHeight()) ||
                this.touches(r.getX(),r.getY() + r.getHeight()) ||
                this.touches(r.getX() + r.getWidth(),r.getY()));
    }
}

