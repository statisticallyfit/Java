package main.bookNutshell.exercise_2_1;


public class Rect {

    private int x1, x2, y1, y2;

    public Rect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rect(int width, int height){
        this(0, 0, width, height);
    }

    public Rect(){
        this(0, 0, 0, 0);
    }

    public void move(int deltaX, int deltaY){
        x1 += deltaX; x2 += deltaX;
        y1 += deltaY; y2 += deltaY;
    }

    /** Test whether the point is inside the rectangle **/
    public boolean isInside(int x, int y){
        return ((x >= x1) && (x <= x2) &&
                (y >= y1) && (y <= y2));
    }

    /** Test whether one rectangle is inside another one**/
    public boolean isInside(Rect r){
        return ((this.x1 >= r.x1) && (this.x2 <= r.x2) &&
                (this.y1 >= r.y1) && (this.y2 <= r.y2));
    }

    /** Return the smallest rectangle that includes them both. */
    public Rect union(Rect r){
        return new Rect((this.x1 < r.x1) ? this.x1 : r.x1,
                (this.y1 < r.y1) ? this.y1 : r.y1,
                (this.x2 > r.x2) ? this.x2 : r.x2,
                (this.y2 > r.y2) ? this.y2 : r.y2);
    }

    /** Return the overlap **/
    public Rect intersection(Rect r){
        if(this.x2 < r.x1 || this.x1 > r.x2)
            return null;
        return new Rect((this.x1 > r.x1) ? this.x1 : r.x1,
                (this.y1 > r.y1) ? this.y1 : r.y1,
                (this.x2 < r.x2) ? this.x2 : r.x2,
                (this.y2 < r.y2) ? this.y2 : r.y2);
    }

    public String toString(){
        return "[" + x1 + "," + y1 + "; " + x2 + "," + y2 + "]";
    }
}

class RectRunner {

    public static void main(String[] args) {
        // Test case 1: the smaller izs currently completely inside the bigger one
        Rect r1 = new Rect(2, 1, 5, 2); //the smaller one
        Rect r2 = new Rect(1,0, 7, 4); //the bigger one

        r1.move(1, 1);
        System.out.println(r1);

        testUnion(r1, r2);
        testInside(r1, r2);
        testIntersection(r1, r2);

        System.out.println("\n\n");



        // Test case 2: rectangles are currently separated
        r1 = new Rect(-5, -3, -1, -1); //the smaller one
        r2 = new Rect(0, -1, 3, 1); //the bigger one

        testUnion(r1, r2);
        testInside(r1, r2);
        testIntersection(r1, r2);

        System.out.println("\n\n");



        // Test case 3: rectangles are completely overlapped
        r1 = new Rect(2, 1, 5, 3);
        r2 = new Rect(2, 1, 5, 3);

        testUnion(r1, r2);
        testInside(r1, r2);
        testIntersection(r1, r2);

        System.out.println("\n\n");



        // Test case 4: rectangles are partially overlapped
        r1 = new Rect(2, 1, 7, 5);
        r2 = new Rect(3, 2, 11, 6);

        testUnion(r1, r2);
        testInside(r1, r2);
        testIntersection(r1, r2);
    }

    public static void testUnion(Rect r1, Rect r2){
        System.out.println(r1.union(r2));
        System.out.println(r2.union(r1));
    }

    public static void testInside(Rect r1, Rect r2) {
        System.out.println(r1.isInside(r2));
        System.out.println(r2.isInside(r1));
    }

    public static void testIntersection(Rect r1, Rect r2) {
        System.out.println(r1.intersection(r2));
        System.out.println(r2.intersection(r1));
    }
}