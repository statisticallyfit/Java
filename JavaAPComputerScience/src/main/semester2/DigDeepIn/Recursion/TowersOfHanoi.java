package semester2.DigDeepIn.Recursion;

import java.util.Scanner;

/* Example from Daniel Liang book, page 752 */
public class TowersOfHanoi {


    /** The method for finding the solution to move n disks
     17 from fromTower to toTower with auxTower */

    public static void moveDisks(int n, char fromTower, char toTower, char auxTower){
        if(n == 1){ //base case (n = number of disks)
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        } else {
            
            //step 1: move them to auxiliary tower
            moveDisks(n - 1, fromTower, auxTower, toTower);

            //step 2: move the last biggest disk from fromTower to toTower
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);

            //step 3: move the disks from auxiliary to destination toTower
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }


    public static void main(String[] args){

        System.out.println("Enter number of disks to move: ");

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        System.out.println("The moves are: ");
        moveDisks(n, 'A', 'B', 'C');
    }
}
