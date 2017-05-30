package semester1.chapter4.Extra;

/**
 * Created by user1928 on 12/23/14.
 */


class A {
    A() {
        System.out.println("A constructor");
    }
}

class B extends A {

    int x = initX();

    int initX() {
        System.out.println("B initX");
        return 1;
    }

    B() {
        super();
        System.out.println("B constructor");
    }

}

public class OrderOfInitialization {

    public static void main(String[] args) {
        B a = new B();
    }
}