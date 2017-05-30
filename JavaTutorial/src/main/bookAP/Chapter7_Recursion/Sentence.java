package main.bookAP.Chapter7_Recursion;


public class Sentence {

    private String sentence;
    private int numWords;

    public Sentence(String str){
        this.sentence = str;

        int k = str.indexOf(" ");

        while(k != -1){
            numWords++;
            str = str.substring(k + 1);
            k = str.indexOf(" ");
        }
        if(str.length() > 0){
            numWords++;
            System.out.println(sentence + " : numWords = " + numWords);
        }
    }

    public boolean isPalindrome(){
        return isPalindrome(sentence, 0, sentence.length() - 1);
    }

    public boolean isPalindrome(String s, int start, int end){
        if(start >= end){
            return true;
        } else {
            String first = s.substring(start, start + 1);
            String last = s.substring(end, end + 1);
            if(first.equals(last))
                return isPalindrome(s, start + 1, end - 1);
            return false;
        }
    }

    public static void main(String[] args) {
        Sentence s1 = new Sentence("This is not a palindrome");
        System.out.println(s1.isPalindrome());

        Sentence s2 = new Sentence("evacanistabbatsinacave");
        System.out.println(s2.isPalindrome());

        Sentence s3 = new Sentence("racecar");
        System.out.println(s3.isPalindrome());
    }
}
