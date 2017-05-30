package main.bookLiang;


import java.util.Date;

public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    public GeometricObject() {
        dateCreated = new Date();
    }

    public GeometricObject(String col, boolean fill) {
        dateCreated = new Date();
        this.color = col;
        this.filled = fill;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on: " + dateCreated + "\ncolor: " + color +
                "\nfilled: " + filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}

class Circle extends GeometricObject {
    private double radius;

    public Circle(double r) {
        this.radius = r;
    }

    public Circle(double r, String col, boolean fill) {
        this.radius = r;
        setColor(col);
        setFilled(fill);
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double r) {
        this.radius = r;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }
    public double getDiameter() {
        return 2 * radius;
    }
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }
}

class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    public Rectangle(double w, double h, String col, boolean fill) {
        this.width = w;
        this.height = h;
        setColor(col);
        setFilled(fill);
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public void setWidth(double w) {
        this.width = w;
    }
    public void setHeight(double h) {
        this.height = h;
    }
    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

class TestCircleRectangle {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println("A circle " + circle);
        System.out.println("The color is " + circle.getColor());
        System.out.println("The radius is " + circle.getRadius());
        System.out.println("The area is " + circle.getArea());
        System.out.println("The diameter is " + circle.getDiameter());

        Rectangle rectangle = new Rectangle(2, 4);
        System.out.println("\nA rectangle " + rectangle);
        System.out.println("The area is " + rectangle.getArea());
        System.out.println("The perimeter is " + rectangle.getPerimeter());
    }
}