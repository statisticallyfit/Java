package main.bookAP.Chapter3_PolyAbsInt.Interfaces.Ex2;


public class HumanPlayer implements Player {

    private String name;

    //constructors

    public int getMove(){
        return 1;
    }

    public void updateDisplay(){
        System.out.println("Display updated");
    }

    public String getName(){
        return name;
    }
}


