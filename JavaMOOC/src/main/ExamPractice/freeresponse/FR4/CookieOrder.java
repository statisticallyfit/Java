package main.ExamPractice.freeresponse.FR4;


import java.util.ArrayList;
import java.util.List;

public class CookieOrder {

    private String variety;
    private int numBoxes;

    public CookieOrder(String cookieVariety, int cookieNumBoxes){
        variety = cookieVariety;
        numBoxes = cookieNumBoxes;
    }

    public String getVariety(){
        return variety;
    }

    public int getNumBoxes(){
        return numBoxes;
    }
}

class MasterOrder {
    private List<CookieOrder> orders;

    public MasterOrder(){
        orders = new ArrayList<CookieOrder>();
    }

    public void addOrder(CookieOrder theOrder){
        orders.add(theOrder);
    }

    /* Part a */
    public int getTotalBoxes(){
        int sum = 0;
        for(int i = 0; i < orders.size(); i++)
            sum += orders.get(i).getNumBoxes();
        return sum;
    }

    /* part b */
    public int removeVariety(String cookieVar){
        int sumBoxesRemoved = 0;

        for(int i = orders.size() - 1; i >= 0; i--){
            CookieOrder currentOrder = orders.get(i);

            if(currentOrder.getVariety().equals(cookieVar)){
                sumBoxesRemoved += currentOrder.getNumBoxes();
                orders.remove(i);
            }
        }

        for(CookieOrder c : orders)
            System.out.println(c.getVariety());
        return sumBoxesRemoved;
    }
}

class Q1Tester {
    public static void main(String[] args) {
        MasterOrder goodies = new MasterOrder();
        goodies.addOrder(new CookieOrder("Chocolate Chip", 1));
        goodies.addOrder(new CookieOrder("Shortbread", 5));
        goodies.addOrder(new CookieOrder("Macaroon", 2));
        goodies.addOrder(new CookieOrder("Chocolate Chip", 3));
        goodies.addOrder(new CookieOrder("Chocolate Chip", 5));
        goodies.addOrder(new CookieOrder("Strawberry Shortcake", 10));
        goodies.addOrder(new CookieOrder("Chocolate Chip", 1));
        goodies.addOrder(new CookieOrder("Brownie", 1));

        goodies.removeVariety("Brownie");
        goodies.removeVariety("Chocolate Chip");

    }
}
