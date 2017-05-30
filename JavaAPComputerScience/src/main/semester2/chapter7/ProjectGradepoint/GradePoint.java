package semester2.chapter7.ProjectGradepoint;

import java.util.Scanner;


public class GradePoint {

    public static final int NUM_OF_STUDENTS = 10;
    public static final int NUM_OF_GRADES_PER_STUDENT = 5;
    private String[] itsGradesList = {"F", "D", "C", "B", "A"};


    public boolean inputIsCorrect(String input){
        /* if the input equals either one of the letters
        in the list, it is in the range of A to F, excluding E */
        for(int i = 0; i < itsGradesList.length; i++){
            if(input.equals(itsGradesList[i]))
                return true;
        }
        return false;
    }

    /* Calculate the overall student GPA */

    public double getGPA(String[] inputList){
        int[] listOfGPAs = matcher(inputList, itsGradesList);
        return average(listOfGPAs);
    }

    /* Returns the array of indexes at which two string arrays
    * are equal */

     public static int[] matcher(String[] base, String[] iterator){
        int[] indexValues = new int[NUM_OF_GRADES_PER_STUDENT];
        int g = 0;

        for(int b = 0; b < base.length; b++){
            for(int i = 0; i < iterator.length; i++){
                if(base[b].equals(iterator[i])){
                    indexValues[g++] = i;
                    break;//to go back to outer loop
                }
            }
        }
        return indexValues;
    }

    /* Calculates the average of an array */

    public static double average(int[] values){
        double sum = 0.0;
        for(int i = 0; i < values.length; i++)
            sum += values[i];
        return sum / values.length;
    }

    /* Prints the values of a list */

    public static void displayOutput(double[] list){
        System.out.println("\nThe GPAs for each student are: ");
        for(int i = 0; i < list.length; i++)
            System.out.println("Student " + (i + 1) + " : " + list[i]);
    }

    /* Displays GradePoint-specific error message */

    private static void displayErrorMessage() {
        System.out.println("Only A, B, C, D, or F are valid inputs");
    }

    public static void main(String[] args) {

        /* Enter input */

        GradePoint administrator = new GradePoint();
        Scanner in = new Scanner(System.in);

        int studentID = 0;
        double[] studentGPAs = new double[NUM_OF_STUDENTS];

        while(studentID < NUM_OF_STUDENTS){

            int l = 0;
            int g = 0;
            String[] listOfInputs = new String[NUM_OF_GRADES_PER_STUDENT];
            String input;

            System.out.println("\nEnter five letter grades for student " + (studentID + 1) + ": ");

            while(l < NUM_OF_GRADES_PER_STUDENT){

                System.out.println("grade " + ++g + ": ");
                input = in.next();
                while(!administrator.inputIsCorrect(input)){
                    displayErrorMessage();
                    input = in.next();
                }
                listOfInputs[l] = input;
                l++;
            }

            /* Calculate gpa for the student */
            studentGPAs[studentID] = administrator.getGPA(listOfInputs);

            studentID++;
        }

        /* Display the students and their gpa list */
        displayOutput(studentGPAs);
    }
}
