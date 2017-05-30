package main.ExamPractice.tests.BePrepared_1;


public class TestMC {

    //question 30

    public static void printSomething(String s){
        int n = s.length();
        if(n < 1)
            return;
        String s1 = s.substring(1, n);
        printSomething(s1);
        System.out.println(s);
        printSomething(s1);
    }

    public static void assignmentArrays(){
        String[] xy = {"X", "Y"};
        String[] yx = xy;
        yx[0] = xy[1];
        yx[1] = xy[0];
        System.out.println(xy[0] + xy[1] + yx[0] + yx[1]);
    }






    public static void main(String[] args) {
        String text = "wordingfunnereveryday";
        String sub = "cat";
        int i = 7;
        System.out.println(text.substring(0, 7) + sub + text.substring(i+3));
    }
}

