package semester2.DigDeepIn.Recursion;


public class Fibonacci {

    public int fibonacci(int n) {

        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public void getNextTen(int fromSpot){

        int startFib = fibonacci(fromSpot);
        System.out.println("Start fib is " + startFib);

        int prevFib = fibonacci(fromSpot - 1);

        int currentFib = startFib;
        for (int n = 1; n <= 10; n++) {
            int nextFib = currentFib + prevFib;
            prevFib = currentFib;
            currentFib = nextFib;

            System.out.println("Current fib is " + currentFib);
        }
        System.out.println("Last fib is " + currentFib);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        int fromSpot = Integer.parseInt(args[0]);
        fibonacci.getNextTen(fromSpot);
    }
}
