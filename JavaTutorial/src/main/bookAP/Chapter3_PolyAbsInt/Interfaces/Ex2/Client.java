package main.bookAP.Chapter3_PolyAbsInt.Interfaces.Ex2;


public class Client {

    public static void main(String[] args) {


        //choice I
        Player p1 = new HumanPlayer();
        Player p2 = new ExpertPlayer();
        int x1 = p1.getMove();
        int x2 = p2.getMove();
        System.out.println("x1: " + x1 + "\nx2: " + x2);



        //choice II
        int x;
        Player c1 = new ExpertPlayer();
        Player c2 = new ExpertPlayer();

        if(((ExpertPlayer)c1).compareTo((ExpertPlayer)c2) < 0)
            x = c1.getMove();
        else
            x = c2.getMove();

        System.out.println(x);
    }
}
