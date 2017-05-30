package main.bookAP.Chapter1_Intro;

/**
 * Created by user1928 on 1/17/15.
 */
public class EnhancedForLoopTest {

    public static void main(String args[]){
        extendedForLoopBreak();
    }

    public static void extendedForLoop(){
        int [] numbers = {10, 20, 30, 40, 50};

        for(int i : numbers ){
            System.out.print( i );
            System.out.print(", ");
        }
        System.out.print("\n");
        String [] names ={"James", "Larry", "Tom", "Lacy"};
        for( String name : names ) {
            System.out.print( name );
            System.out.print(", ");
        }



        int[] is = {1,2,3,4};
        String s = "-";
        for(int j : is) {
            s += "." + j;
            System.out.println(s);
        }
        System.out.println(s);
    }

    public static void extendedForLoopBreak() {
        String[] sa = {"Dog", "Cat", "Tiger"};
        int count = 0;
        for(String current : sa) {
            if("Cat".equals(current)) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
