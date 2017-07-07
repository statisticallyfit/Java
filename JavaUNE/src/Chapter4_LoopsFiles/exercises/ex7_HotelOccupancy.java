package Chapter4_LoopsFiles.exercises;

import java.util.Scanner;

/**
 *
 */
public class ex7_HotelOccupancy {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int floors;
        int floorRoomsOccupied;
        int floorRoomsVacant;
        int floorRooms;
        int totalRooms = 0;
        int totalVacant = 0;
        int totalOccupied = 0;
        double occupancyRate = 0;

        //Getting num floors.
        do{
            System.out.print("# floors: ");
            floors = keyboard.nextInt();
        } while(floors < 1);

        // Iterating once per floor, rate.
        for(int f = 0; f < floors; f++){
            System.out.println("\nFloor " + (f + 1) + " ------------------------");

            //validate num rooms per floor.
            do {
                System.out.print("# rooms: ");
                floorRooms = keyboard.nextInt();
            } while(floorRooms < 10);

            do {
                System.out.print("# occupied: ");
                floorRoomsOccupied = keyboard.nextInt();
            } while(floorRoomsOccupied > floorRooms);

            floorRoomsVacant = floorRooms - floorRoomsOccupied;
            occupancyRate = 1.0 * floorRoomsOccupied / floorRooms;

            // Getting total hotel data.
            totalRooms += floorRooms;
            totalOccupied += floorRoomsOccupied;


            System.out.println("\nNumber of rooms: " + floorRooms);
            System.out.println("Number of occupied rooms: " + floorRoomsOccupied);
            System.out.println("Number of vacant rooms: " + floorRoomsVacant);
            System.out.println("Floor Occupancy Rate = " + occupancyRate);
            System.out.println("--------------------------------");
        }

        totalVacant = totalRooms - totalOccupied;
        occupancyRate = 1.0 * totalOccupied / totalRooms;

        System.out.println("\n\nTotal number of rooms: " + totalRooms);
        System.out.println("Total number of occupied rooms: " + totalOccupied);
        System.out.println("Total number of vacant rooms: " + totalVacant);
        System.out.println("Hotel Occupancy Rate = " + occupancyRate);
    }
}
