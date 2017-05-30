package main.bookAP.Chapter2_ClassesAndObjects;

/**
 * Created by user1928 on 4/2/2015.
 */
public class IntObject {

    private int num;

    public IntObject(){
        num = 0;
    }

    public IntObject(int n){
        num = n;
    }

    public void increment(){
        num++;
    }

    public String toString(){
        return num + "";
    }
}
class IntObjectRunner {
    public static IntObject someMethod(IntObject obj){
        IntObject ans = obj;
        ans.increment();
        return ans;
    }

    public IntObject instanceSomeMethod(IntObject obj){
        IntObject ans = obj;
        ans.increment();
        return ans;
    }

    public IntObject someMethod1(IntObject ans){
        ans.increment();
        return ans;
    }



    public static void main(String[] args) {
        IntObject x = new IntObject(2);
        IntObject y = new IntObject(7);
        IntObject a = y;
        x = someMethod(y);
        a = someMethod(x);

        System.out.println("x = " + x + "\ny = " + y + "\na = " + a);



        //refresh
        IntObjectRunner o = new IntObjectRunner();

        x = new IntObject(2);
        y = new IntObject(7);
        a = y;
        x = o.instanceSomeMethod(y);
        a = o.instanceSomeMethod(x);

        System.out.println("x = " + x + "\ny = " + y + "\na = " + a);



        //refresh
        o = new IntObjectRunner();

        x = new IntObject(2);
        y = new IntObject(7);
        a = y;
        x = o.someMethod1(y);
        a = o.someMethod1(x);

        System.out.println("x = " + x + "\ny = " + y + "\na = " + a);
    }
}
