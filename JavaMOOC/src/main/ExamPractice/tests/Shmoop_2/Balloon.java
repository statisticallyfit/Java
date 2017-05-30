package main.ExamPractice.tests.Shmoop_2;



public class Balloon implements Comparable {

    private int height;
    private int number;
    private static int numCreated = 0;

    public Balloon(int balloonHeight){
        height = balloonHeight;
        number = numCreated + 1;
        numCreated++;
    }

    public int getHeight(){
        return height;
    }

    public int getNumber(){
        return number;
    }

    public static int getNumCreated(){
        return numCreated;
    }

    public int compareTo(Object other){
        return this.height - ((Balloon) other).getHeight();
    }
}
class TestBalloon {

    public static void main(String[] args) {
        Balloon b1 = new Balloon(30);
        Balloon b2 = new Balloon(40);
        Balloon b3 = new Balloon(1);
        Balloon b4 = new Balloon(1);
        Balloon b5 = new Balloon(1);
        Balloon b6 = new Balloon(1);

        System.out.println(Balloon.getNumCreated());
        System.out.println(b1.getNumber() + " should be 1");
    }
}
