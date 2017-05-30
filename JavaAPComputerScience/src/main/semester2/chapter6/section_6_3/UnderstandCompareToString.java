package semester2.chapter6.section_6_3;


public class UnderstandCompareToString {

    public static void main(String[] args) {
        System.out.println("b".compareTo("e")); //output: -3   (e is at the third spot after b)
        System.out.println("r".compareTo("g")); //output: 11   (g is at eleventh spot after r)
        System.out.println("a".compareTo("a")); //output: 0
        System.out.println("a".compareTo("b")); //output: -1   (b is one after a)
        System.out.println("d".compareTo("c")); //output: 1    (c is one ahead of d)
        System.out.println("i".compareTo("o")); //output: -6

        System.out.println("aardvark".compareTo("alpha")); //output: -11 (l is at eleventh position after a)
        System.out.println("bid".compareTo("bob")); //output: -6
    }
}