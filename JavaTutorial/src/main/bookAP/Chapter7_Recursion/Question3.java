package main.bookAP.Chapter7_Recursion;


public class Question3 {

    public static void stringRecur(String s){
        if(s.length() < 15){
            System.out.println(s);
        }
        stringRecur(s + "*");
    }

    public static void main(String[] args) {
        stringRecur("string");
    }
}
