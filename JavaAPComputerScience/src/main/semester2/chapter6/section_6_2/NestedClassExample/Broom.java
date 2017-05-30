package semester2.chapter6.section_6_2.NestedClassExample;


/*Kathy Sierra example, page 681*/


/*The "static" class is not really static - just means it is a static member of the outer class,
so it can be accessed without instance of outer class */


class BigOuter{
    static class Nest{
        public void go(){
            System.out.println("hi");
        }
    }
}
public class Broom{
    static class NestOfBroom {
        public void go2(){
            System.out.println("hi 2");
        }
    }
}
class BroomTester{
    public static void main(String[] args) {
        BigOuter.Nest nest = new BigOuter.Nest();
        nest.go(); //hi
        Broom.NestOfBroom broomNest = new Broom.NestOfBroom();
        broomNest.go2(); // hi 2
    }
}