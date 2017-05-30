package semester1.chapter4.section_4_8;

/**
 * Created by user1928 on 12/14/14.
 */
public class ex36_RulesOfPrecedence {

    public void compare(){

        boolean b, c, d;

        System.out.println("Operation: (b || c) && d     vs.    operation: b || (c && d)");

        //first of eight
        b = true;
        c = true;
        d = true;
        print(b, c, d);

        //second of eight
        b = true;
        c = true;
        d = false;
        print(b, c, d);

        //third of eight
        b = true;
        c = false;
        d = true;
        print(b, c, d);

        //fourth of eight
        b = false;
        c = true;
        d = true;
        print(b, c, d);

        //fifth of eight
        b = true;
        c = false;
        d = false;
        print(b, c, d);

        //sixth of eight
        b = false;
        c = true;
        d = false;
        print(b, c, d);

        //seventh of eight
        b = false;
        c = false;
        d = true;
        print(b, c, d);

        //eight of eight
        b = false;
        c = false;
        d = false;
        print(b, c, d);

    }

    public void print(boolean b, boolean c, boolean d){
        System.out.println(((b || c) && d) + " VS " + (b || (c && d)));
    }


    public static void main(String[] args){
        ex36_RulesOfPrecedence rules = new ex36_RulesOfPrecedence();
        rules.compare();
    }
}
