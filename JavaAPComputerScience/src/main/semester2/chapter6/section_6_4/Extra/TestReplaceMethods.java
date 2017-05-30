package semester2.chapter6.section_6_4.Extra;



public class TestReplaceMethods {

    public static void main(String[] args) {
        String word = "this is a word to replace word stuff";

        System.out.println(word.replace("word", "penguin"));
        System.out.println(word.replaceAll("word", "penguin"));
    }
}
