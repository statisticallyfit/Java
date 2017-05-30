package semester1.chapter4.section_4_8;

/**
 * Created by user1928 on 12/14/14.
 */

/*
 * Assignment 4.37: the operations yield the same results for each combination!
 */
public class a37_RulesOfPrecedence {

    public void compare(){

        boolean b, c, d;

        System.out.println("Operation: !b && (c || !d) vs. operation: !(b || !c && d)");

        //first of eight
        b = true;
        c = true;
        d = true;
        System.out.println( (!b && (c || !d)) + " VS " + !(b || !c && d));

        //second of eight
        b = true;
        c = true;
        d = false;
        System.out.println((!b && (c || !d)) + " VS " + !(b || !c && d));

        //third of eight
        b = true;
        c = false;
        d = true;
        System.out.println((!b && (c || !d)) + " VS " + !(b || !c && d));

        //fourth of eight
        b = false;
        c = true;
        d = true;
        System.out.println((!b && (c || !d)) + " VS " + !(b || !c && d));

        //fifth of eight
        b = true;
        c = false;
        d = false;
        System.out.println((!b && (c || !d)) + " VS " + !(b || !c && d));

        //sixth of eight
        b = false;
        c = true;
        d = false;
        System.out.println((!b && (c || !d)) + " VS " + !(b || !c && d));

        //seventh of eight
        b = false;
        c = false;
        d = true;
        System.out.println((!b && (c || !d)) + " VS " + !(b || !c && d));

        //eight of eight
        b = false;
        c = false;
        d = false;
        System.out.println((!b && (c || !d)) + " VS " + !(b || !c && d));

    }


    public static void main(String[] args){
        a37_RulesOfPrecedence rules = new a37_RulesOfPrecedence();
        rules.compare();
    }
}
