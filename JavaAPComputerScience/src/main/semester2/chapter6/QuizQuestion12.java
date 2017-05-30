package semester2.chapter6;


import java.util.ArrayList;
import java.util.List;

public class QuizQuestion12 {

    public static void main(String[] args) {

        /*List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i <= 10000; i++){
            list.add(i, (int)(1 + Math.random() *6));
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == 6){
                System.out.println("I was wrong...");
            }
        }*/



        //testing with 22 and 54 - print numbers between them, inclusive
        for(int i = 0; i < 1000000; i++){
            System.out.println((int)(1 + Math.random() * (54 - 22 + 1)));
        }
    }
}
