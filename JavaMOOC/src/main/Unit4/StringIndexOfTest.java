package main.Unit4;

/**
 * From Lesson 31 : fast start : activity
 * */

 public class StringIndexOfTest {

    public static void main(String[] args) {
        String w = "potato";
        if (w.indexOf('e') == -1)
            w = w + "es";
        else
            w = w + "s";
        System.out.println(w);
    }
}
