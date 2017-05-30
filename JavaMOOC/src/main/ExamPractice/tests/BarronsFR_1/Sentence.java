package main.ExamPractice.tests.BarronsFR_1;


import java.util.ArrayList;
import java.util.List;

public class Sentence {

    private String sentence;

    public Sentence(String str){
        this.sentence = str;
    }

    /* Part a : correct implementation */

    public List<Integer> getBlankPositions(){
        List<Integer> posList = new ArrayList<Integer>();

        for(int pos = 0; pos < sentence.length(); pos++){
            if(sentence.substring(pos, pos + 1).equals(" ")){
                posList.add(pos);
            }
        }
        return posList;
    }

    /* Part b : correct implementation */

    public int countWords(){
        return getBlankPositions().size() + 1;
    }

    /* Part c : my implementation */

    public String[] getWords(){
        /*List<Integer> posList = getBlankPositions();
        int numWords = countWords();
        String[] words = new String[numWords];
        int first = 0;
        int last = 0;

        //get first word
        words[0] = sentence.substring(0, posList.get(0));
        if(numWords == 1){
            return words;
        }

        //get middle words
        for(int i = 0; i < posList.size() - 1; i++){
            first = posList.get(i) + 1;
            last = posList.get(i + 1);
            words[i + 1] = sentence.substring(first, last);
        }

        if(numWords == 2){
            return words;
        }

        //get last word
        words[words.length - 1] = sentence.substring(last + 1);

        return words;*/

        int counter = 0;
        int first = 0;
        List<Integer> posList = getBlankPositions();
        String[] words = new String[countWords()];

        while(counter < words.length - 1){
            words[counter] = sentence.substring(first, posList.get(counter));
            first = posList.get(counter) + 1;
            counter++;
        }
        words[counter] = sentence.substring(first);

        return words;
    }


    /* Part c: correct implementation */
    /*public String[] getWords(){
        List<Integer> posList = getBlankPositions();
        int numWords = countWords();
        String[] wordArr = new String[numWords];

        for(int i = 0; i < numWords; i++){
            if(i == 0){
                if(posList.size() != 0)
                    wordArr[i] = sentence.substring(0, posList.get(0));
                else
                    wordArr[i] = sentence;
            }
            else if(i == posList.size()){ // if we are at the last word
                wordArr[i] = sentence.substring(posList.get(i - 1) + 1);
            }
            else {
                wordArr[i] = sentence
                        .substring(
                                posList.get(i - 1) + 1,
                                posList.get(i));
            }
        }
        return wordArr;
    }*/

    public static void main(String[] args) {
        Sentence s = new Sentence("The butterfly flitted by the orchids.");
        String[] resultWords = s.getWords();

        for(String word : resultWords){
            System.out.println(word);
        }

    }

}
