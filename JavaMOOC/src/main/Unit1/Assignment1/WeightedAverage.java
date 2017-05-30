package main.Unit1.Assignment1;

import java.util.Scanner;

public class WeightedAverage {


    public double getAScore(){
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }

    public double averageTheTests(double test1, double test2){
        return (test1 + test2)/2.0;
    }

    public double averageTheQuizzes(double quiz1, double quiz2, double quiz3){
        return (quiz1 + quiz2 + quiz3)/3.0;
    }

    public double weightTheFinalScore(double t, double q, double h){
        return (0.5*t + 0.3*q + 0.2*h);
    }
}

class Main{
    public static void main(String[] args) {
        WeightedAverage wav = new WeightedAverage();

        System.out.println("Please enter your test grades.");
        System.out.println("Test 1: ");
        double test1 = wav.getAScore();
        System.out.println("Test 2: ");
        double test2 = wav.getAScore();

        System.out.println("\nPlease enter your quiz grades.");
        System.out.println("Quiz 1: ");
        double quiz1 = wav.getAScore();
        System.out.println("Quiz 2: ");
        double quiz2 = wav.getAScore();
        System.out.println("Quiz 3: ");
        double quiz3 = wav.getAScore();
        
        System.out.println("\nPlease enter your homework average.");
        System.out.println("Homework: ");
        double homeworkAvg = wav.getAScore();

        /*Calculate and show averages*/
        double testAvg = wav.averageTheTests(test1, test2);
        double quizAvg = wav.averageTheQuizzes(quiz1, quiz2, quiz3);

        System.out.println("\nTest Average: " + testAvg);
        System.out.println("Quiz Average: " + quizAvg);
        System.out.println("Final Grade: " + wav.weightTheFinalScore(testAvg, quizAvg, homeworkAvg));
    }
}
