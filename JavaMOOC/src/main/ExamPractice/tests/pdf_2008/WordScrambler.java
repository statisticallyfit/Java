package main.ExamPractice.tests.pdf_2008;



public class WordScrambler {

    private String[] scrambledWords;

    public WordScrambler(String[] wordArr){
        scrambledWords = mixedWords(wordArr);
    }

    private String recombine(String word1, String word2){
        return word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2);
    }

    private String[] mixedWords(String[] words){
        String[] result = new String[words.length];

        for(int i = 0; i < result.length; i += 2){
            result[i] = recombine(words[i], words[i + 1]);
            result[i + 1] = recombine(words[i + 1], words[i]);
        }
        return result;
    }

    public String toString(){
        String s = "";
        for(String word : scrambledWords)
            s += word + " ";
        return s;
    }
}

class TestWordScrambler {

    public static void main(String[] args) {
        String[] words = new String[] {"apple", "pear", "this", "cat"};
        WordScrambler scramble = new WordScrambler(words);
        System.out.println(scramble);

    }
}
