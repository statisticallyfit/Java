package main.bookAP.Chapter8_SortingSearching;

public class Print {

    public static void array(Comparable[] array)
    {
        for(int i = 0; i < array.length - 1; i++)
            System.out.print(array[i] + ", ");
        //now print last term
        System.out.print(array[array.length - 1] + "\n");
    }

    public static String array(int[] array)
    {
        String s = "";
        for(int i = 0; i < array.length - 1; i++)
            s += array[i] + ", ";
        //now print last term
        s += array[array.length - 1] + "\n";
        return s;
    }
}