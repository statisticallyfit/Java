package main.Unit5.lesson4activity;


import java.io.IOException;

public class Vehicle {

    private int location;

    public Vehicle(){
        location = 0;
    }

    public Vehicle(int loc){
        if(loc >= -20 && loc <= 20) {
            location = loc;
        } else {
            location = 0;
        }
    }

    public void forward(){
        if(location + 1 <= 20){
            location += 1;
        }
    }

    public void backward(){
        if(location - 1 >= -20) {
            location -= 1;
        }
    }

    public int getLocation(){
        return location;
    }

    public String toString(){
        String moves = "";
        for(int blockOnRoad = 0; blockOnRoad < location; blockOnRoad++){
            moves += " ";
        }
        moves += "@"; //car symbol
        return moves;
    }
}

class VehicleTester {

    public static void main (String str[]) throws IOException {
        Vehicle v1 = new Vehicle (17);

        System.out.println(v1 + "    block = " + v1.getLocation());

        for (int i = 1; i < 5; i ++)
        {
            v1.forward();
            System.out.println(v1 + "    block = " + v1.getLocation());
        }
        System.out.println(v1.getLocation());

        for (int i = 1 ; i < 10; i ++)
        {
            int d = (int)(Math.random() *2);
            if (d ==0)
                v1.forward();
            else
                v1.backward();
            System.out.println(v1);


        }

        Vehicle v2 = new Vehicle (87);
        System.out.println(v2.getLocation());

        Vehicle v3 = new Vehicle(-18);
        System.out.println(v3);
        v3.backward();
        System.out.println(v3.getLocation());
        v3.backward();
        System.out.println(v3.getLocation());
        v3.backward();
        System.out.println(v3.getLocation());
        v3.backward();
        System.out.println(v3.getLocation());

    }

}
