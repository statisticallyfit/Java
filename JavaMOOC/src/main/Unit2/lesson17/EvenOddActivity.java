package main.Unit2.lesson17;

import java.util.Scanner;


public class EvenOddActivity {

    public static void main(String[] args)
    {
        System.out.println("Enter two numbers:");
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int last = scan.nextInt();

        if(last < first){
            int temp = last;
            last = first;
            first = temp;
        }

        if(first % 2 == 0 && last % 2 == 0){
            while(first <= last){
                System.out.print(first + " ");
                first += 2;
            }
        } else if(first % 2 != 0 && last % 2 != 0){
            first++;
            last--;
            while(first <= last){
                System.out.print(first + " ");
                first += 2;
            }
        } else if(first % 2 == 0 && last % 2 != 0) {
            last--;
            while(first <= last){
                System.out.print(first + " ");
                first += 2;
            }
        } else if(first % 2 != 0 && last % 2 == 0) {
            first++;
            while(first <= last){
                System.out.print(first + " ");
                first += 2;
            }
        }
    }
}
