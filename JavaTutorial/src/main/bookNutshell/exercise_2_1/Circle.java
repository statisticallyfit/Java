package main.bookNutshell.exercise_2_1;


class Point {
    private int xCoord;
    private int yCoord;

    public Point(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
    }

    public int xVal() { return xCoord; }
    public int yVal() { return yCoord; }

    public void move(int dX, int dY) {
        xCoord += dX;
        yCoord += dY;
    }

    public boolean isInside(Circle circ) {
        return(Math.sqrt((circ.getXCoord() - this.xVal())^2 +
                (circ.getYCoord() - this.yVal())^2) < circ.getRadius());
    }
}

public class Circle {

    private int radius;
    private Point centerPoint;

    public Circle(int r, Point point) {
        this.radius = r;
        this.centerPoint = point;
    }

    public int getRadius() { return radius; }

    public int getXCoord() {
        return centerPoint.xVal();
    }

    public int getYCoord() {
        return centerPoint.yVal();
    }

    public void move(int dX, int dY) {
        centerPoint.move(dX, dY);
    }

    /** Returns the smallest rectangle that could fit inside a Circle */
    public Rectangle boundingBox() {
        return new Rectangle(new Point(this.getXCoord() - this.getRadius(),
                    this.getYCoord() - this.getRadius()),
                new Point(this.getXCoord() + this.getRadius(),
                        this.getYCoord() + this.getRadius()));
    }

}


class Rectangle {

    private Point p1;
    private Point p2;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point firstPoint(){ return p1; }
    public Point secondPoint() { return p2; }

    public void move(int dX, int dY) {
        p1.move(dX, dY);
        p2.move(dX, dY);
    }

    /** Test whether the point is inside the rectangle **/
    public boolean isInside(Point aPoint){
        return((aPoint.xVal() >= p1.xVal()) && (aPoint.xVal() <= p2.xVal()) &&
                (aPoint.yVal() >= p1.yVal()) && (aPoint.yVal() <= p2.yVal()));
    }

    /** Test whether one rectangle is inside another one**/
    public boolean isInside(Rectangle rect){
        return ((this.firstPoint().xVal() >= rect.firstPoint().xVal()) &&
                (this.secondPoint().xVal() <= rect.secondPoint().xVal()) &&
                (this.firstPoint().yVal() >= rect.firstPoint().yVal()) &&
                (this.secondPoint().yVal() <= rect.secondPoint().yVal()));
    }

    /** Return the smallest rectangle that includes them both. */
    public Rectangle union(Rectangle rect){
        return new Rectangle(new Point((this.firstPoint().xVal() < rect.firstPoint().xVal()) ?
                        this.firstPoint().xVal() : rect.firstPoint().xVal(),
                (this.firstPoint().yVal() < rect.firstPoint().yVal()) ?
                        this.firstPoint().yVal() : rect.firstPoint().yVal()),
                new Point((this.secondPoint().xVal() > rect.secondPoint().xVal()) ?
                        this.secondPoint().xVal() : rect.secondPoint().xVal(),
                (this.secondPoint().yVal() > rect.secondPoint().yVal()) ?
                        this.secondPoint().yVal() : rect.secondPoint().yVal()));
    }

    /** Return the overlap **/
    public Rectangle intersection(Rectangle rect){
        if(this.secondPoint().xVal() < rect.firstPoint().xVal() || this.firstPoint().xVal() > rect.secondPoint().xVal())
            return null;
        return new Rectangle(new Point((this.firstPoint().xVal() > rect.firstPoint().xVal()) ? this.firstPoint().xVal() : rect.firstPoint().xVal(),
                (this.firstPoint().yVal() > rect.firstPoint().yVal()) ? this.firstPoint().yVal() : rect.firstPoint().yVal()),
                new Point((this.secondPoint().xVal() < rect.secondPoint().xVal()) ? this.secondPoint().xVal() : rect.secondPoint().xVal(),
                (this.secondPoint().yVal() < rect.secondPoint().yVal()) ? this.secondPoint().yVal() : rect.secondPoint().yVal()));
    }

    public String toString(){
        return "[" + this.firstPoint().xVal() + "," + this.firstPoint().yVal() + "; "
                + this.secondPoint().xVal() + "," + this.secondPoint().yVal() + "]";
    }

}
