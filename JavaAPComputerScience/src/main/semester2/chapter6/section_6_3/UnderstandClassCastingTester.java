package semester2.chapter6.section_6_3;

import semester1.chapter2.section_2_3.ex18_FourSequencesTakeSecondCD;

/**
 * Created by user1928 on 1/31/15.
 */


class First{
    public void go1(){
        System.out.println("first");
    }
}

class Second extends First{
    public void go2(){
        System.out.println("second");
    }
}

class Third{
    public void go3(){
        System.out.println("third");
    }
}


public class UnderstandClassCastingTester {

    public static void main(String[] args) {


        /*todo NOTE: ClassCastException thrown if casting to non-inherited class*/

        First[] firstArray = {new First(), new Second(), new First()};

        for(First first : firstArray){
            if(first instanceof Second){
                ((Second) first).go2();
            }
            //((Third)first).go3();
        }



        /* todo NOTE: "inconvertible types" if trying to cast objects with no inheritance relationship*/
        /*upcast OK*/
        Second secondObj = new Second();
        First firstObj = secondObj; //implicit upcast
        firstObj = (First)secondObj; //explicit upcast
        /*Interface variable = secondObj  |  also works todo example*/

        /*todo "inconvertible types error" */
        /*Third thirdObj = new Third();
        firstObj = (First)thirdObj;*/

    }
}
