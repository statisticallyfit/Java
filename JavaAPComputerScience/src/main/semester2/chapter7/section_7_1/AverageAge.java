package semester2.chapter7.section_7_1;

/*Assignment 7.5: Read information from three workers and print their average age. */

public class AverageAge {

    public double getAverageAge(Worker first, Worker second, Worker third){
        return (first.getBirthYear() + second.getBirthYear() + third.getBirthYear())/3.0;
    }

    public static void main(String[] args) {
        System.out.println("Reading in three workers and printing average of their ages.");

        Buffin file = new Buffin("C:\\D\\tmp\\workers.txt");

        Worker first = new Worker(file.readLine());
        Worker second = new Worker(file.readLine());
        Worker third = new Worker(file.readLine());

        System.out.println("The average age is: " + new AverageAge().getAverageAge(first, second, third));
    }
}
