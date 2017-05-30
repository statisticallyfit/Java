package main.bookAP.Chapter1_Intro;


public class NestedForLoops {

    public static void main(String[] args) {
        for(int i = 1; i <= 6; i++){

            for(int j = 1; j <= i; j++)
                System.out.print("@");

            for(int j = 1; j <= 6 - i; j++)
                System.out.print("*");

            System.out.println();
        }
    }
}
