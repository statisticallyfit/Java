package semester2.DigDeepIn.Recursion;


public class RecursiveMethods {


   /* In recursive methods, execution is stacked (first is
    * currently at bottom of stack, and next call produces
    * item that is stacked on top */


    public static int factorial(int n){
        if(n == 1){
            return 1;
        } else {
            int result = n * factorial(n - 1);
            System.out.println("n: " + n + "\nresult: " + result);
            return result;
        }
    }

    public static int triangle(int n)
    {
        System.out.println("Entering: n = " + n);
        if(n == 1)
        {
            System.out.println("Returning 1");
            return 1;
        }
        else
        {
            int temp = n + triangle(n - 1);
            System.out.println("Returning " + temp);
            return temp;
        }
    }

    /* Recursive quick sort */

    private static void quickSort(char[] items, int left, int right){
        int i, j;
        char x, y;

        i = left; j = right;
        x = items[(left + right) / 2];

        do{
            while(items[i] < x && i < right)
                i++;
            while(x < items[j] && j > left)
                j--;

            if(i <= j){
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++; j--;
            }
        }while(i <= j);

        if(left < j)
            quickSort(items, left, j);
        if(i < right)
            quickSort(items, i, right);

    }

    public static int[] reverseTailWay(int[] digits, int first, int last){
        int indexDiff = (digits.length % 2 == 0) ? 1 : 2;

        if(digits.length == 1){
            return digits; //ordered
        } else {
            digits = swap(digits, first, last);
            if(last - first == indexDiff)
                return digits;
            last--;
            first++;
            reverseTailWay(digits, first, last);

            return digits;
        }
    }

    /* used in reverseTailWay method */

    public static int[] swap(int[] digits, int first, int last){
        int temp = digits[last];
        digits[last] = digits[first];
        digits[first] = temp;
        return digits;
    }

    public static void reverseWord(int index){
        String wordToReverse = "This is a test";

        if(index != wordToReverse.length() - 1){
            reverseWord(index + 1);
        }
        System.out.print(wordToReverse.charAt(index));
    }

    /* from beginnersbook.com */

    public static void reverseWithModuloOp(int number) {
        if (number < 10) {
            System.out.println(number);
            return;
        }
        else {
            System.out.print(number % 10);
            reverseWithModuloOp(number / 10);
        }
    }

    /* Method from BluePelican Java*/

    public static int adder(int n){
        if(n <= 0){
            return 30;
        }else{
            int result = n + adder(n - 2);
            System.out.println("\nn: " + n + "\nresult: " + result);
            return result;
        }
    }

    /* from BluePelican */

    public static int nrd(int n){
        if(n > 6) {
            System.out.println("\nn = " + n + "\nn - 3 = " + (n - 3));
            return n - 3;
        } else {
            int result = n + nrd(n + 1);
            System.out.println("\nn: " + n + "\nresult: " + result);
            return result;
        }
    }

    /* from BluePelican */

    public static int festus(int n){
        if(n > 6){
            return n - 3;
        } else {
            n *= 2;
            System.out.println("n: " + n);
            int result = n + festus(n + 1);
            System.out.println("\nback to n: " + n + "\nresult: " + result);
            return result;
        }
    }

    /* from BluePelican */

    public static void homer(int n){
        if(n <= 1){
            System.out.print("n: " + n);
        } else {
            homer(n/2);
            System.out.print(", " + n);
        }
    }

    /* from Blue Pelican */

    public static int pls(int n){
        if(n == 0)
            return 5;
        else if(n == 1)
            return 11;
        else
            return pls(n - 1) + 2 * pls(n - 2);
    }

    public static int sumByThrees(int n){
        if(n == 0){
            return 0;
        } else {
            return n + sumByThrees(n - 3);
        }
    }

    public static int sumByFives(int n){
        if(n == 0)
            return 0;
        else
            return n + sumByFives(n - 5);
    }

    /* from Blue Pelican (method1) */

    public static void generateOddsOrEvensUntil(int n){
        if(n <= 1){
            System.out.print("n: " + n);
        } else {
            generateOddsOrEvensUntil(n - 2);
            System.out.print(", " + n);
        }
    }


    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static int power(int base, int exp){
        if(exp == 1){
            return base;
        } else if(exp >= 1){
            exp--;
            return base * power(base, exp);
        }
        return 0; //just to keep errors away
    }

    public static double powerPosOrNeg(double x, int n) {
        if (n > 1)
            return x * powerPosOrNeg(x, n - 1); // Recursive call
        else if (n < 0)
            return 1.0 / powerPosOrNeg(x, -n); // Negative powerPosOrNeg of x
        else
            return x;
    }

    public static boolean isPalindrome(String word) {
        if(word.length() == 0 || word.length() == 1){
            return true;
        } else if(word.charAt(0) == word.charAt(word.length() - 1)){ //continue to check
            isPalindrome(word.substring(1, word.length() - 1));
        }
        return false;
    }

    /* Write a recursive method RevDigs that outputs its integer
    parameter with the digits reversed.  For example RevDigs(147)
    outputs 741, RevDigs(4) outputs 4.  You will have to use your
    modulus operator (%) and integer division.*/

    public static void revDigs(int n){
        System.out.print(n % 10); //rightmost digit

        if(n / 10 != 0){
            revDigs(n / 10);
        }
    }

    /* From barrons AP book */

    public static void stackWords(){
        String word = IO.readString();

        if(word.equals(".")){
            System.out.println(); //space
        } else {
            stackWords();
        }
        System.out.println(word);
    }

    /* from AP Barrons book */

    public static void drawLine(int n){
        if(n == 0){
            System.out.println("That's all, folks!");
        } else {
            for(int i = 1; i <= n; i++){
                System.out.print("*");
            }
            System.out.println();
            drawLine(n - 1);
        }
    }

    /* From AP Barrons book, number 14 on multiple choice */

   /* public static int mystery(int n){
        if(n < 0){
            return 2;
        } else{
            int part1 = mystery(n - 1);

            int part2 = mystery(n - 3);

            return part1 + part2;
        }
    }*/

    /* from BluePelican */

    public static void f(int n){
        if(n == 0){
            System.out.print("x");
        }else{
            System.out.print("{");
            f(n - 1);
            System.out.print("}");
        }
    }

    /* from BluePelican */

    public static void g(int x, int y){
        if(x/y != 0)
            g(x/y, y);
        System.out.print(x / y + 1);
    }

    /* from BluePelican */

    public static int rig(int n){
        if(n == 0)
            return 5;
        else if(n == 1)
            return 8;
        else
            return rig(n - 1) - rig(n - 2);
    }

    public static int mm(int n){
        if(n <= 0)
            return 10;
        else
            return n + mm(n - 1);
    }

    public static int zing(int n){
        if(n > 10){
            return n - 2;
        } else {
            n *= 3;
            return n + zing(n + 2);
        }
    }

    public static void crch(int n){
        if(n <= 0){
            System.out.print(n);
        } else {
            crch(n / 3);
            System.out.print(", " + n);
        }
    }
}
