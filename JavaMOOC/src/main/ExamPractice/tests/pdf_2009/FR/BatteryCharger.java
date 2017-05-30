package main.ExamPractice.tests.pdf_2009.FR;



public class BatteryCharger {

    private int[] rateTable;

    public BatteryCharger(int[] rates){
        rateTable = rates;
    }

    public int getChargingCost(int startHour, int chargeTime){
        //int hoursLeft = startHour + chargeTime;
        int i = startHour;
        int cost = 0;

        while(chargeTime >= 1){
            if(i > 23)
                i = 0;
            cost += rateTable[i];
            chargeTime--;
            i++;
        }
        return cost;
    }

    public int getChargeStartTime(int chargeTime){
        int minCost = getChargingCost(0, chargeTime);
        int startIndex = 0;

        for(int i = 1; i < 24; i++){
            if(getChargingCost(i, chargeTime) < minCost){
                minCost = getChargingCost(i, chargeTime);
                startIndex = i;
            }
        }
        return startIndex;
    }
}
class TestBatteryCharger{

    public static void main(String[] args) {
        int[] ratesTable = new int[]{
                50, 60, 160, 60, 80, 100, 100, 120,
                150, 150, 150, 200, 40, 240, 220, 220,
                200, 200, 180, 180, 140, 100, 80, 60
        };

        BatteryCharger bat = new BatteryCharger(ratesTable);

        {
            if(bat.getChargingCost(12, 1) != 40)
                System.err.println("Test 1 failed");
            if(bat.getChargingCost(0, 2) != 110)
                System.err.println("Test 2 failed");
            if(bat.getChargingCost(22, 7) != 550)
                System.err.println("Test 3 failed");
            if(bat.getChargingCost(22, 30) != 3710)
                System.err.println("Test 4 failed");
        }

    }
}