package main.bookAP.Chapter1_Intro;


import java.util.Scanner;

public class DanglingElseTrap {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        if(n > 0)
            if(n % 2 == 0)
                System.out.println(n);
        else
                System.out.println(n + " is not positive");
    }
}
