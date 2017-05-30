package main.bookAP.Chapter3_PolyAbsInt.Interfaces.Ex2;



public class ExpertPlayer extends HumanPlayer {

    private int rating;

    //constructors
    public int compareTo(ExpertPlayer expert){
        return 0;
    }

    //delete after...
    public int getMove(){
        //System.out.println(super.getMove());
        //System.out.println("Now this is ExpertPlayer's getMove: ");
        return 10;
    }
}
