package Chapter4_LoopsFiles;

/**
 *
 */
public class PostfixVsPrefix {

    public static void main(String[] args) {

        int number = 4;

        assert number == 4;
        assert (number++) == 4;
        assert number == 5;

        number--;
        assert number == 4;
        assert (++number) == 5;
        assert number == 5;

        /*System.out.println("BEFORE: " + number);
        System.out.println("Incrementing POSTFIX: " + number++);
        System.out.println("AFTER: " + number);

        number = 4;

        System.out.println("\nBEFORE: " + number);
        System.out.println("Incrementing PREFIX: " + ++number);
        System.out.println("AFTER: " + number);*/
    }
}
