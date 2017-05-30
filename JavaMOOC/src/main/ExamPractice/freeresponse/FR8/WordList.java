package main.ExamPractice.freeresponse.FR8;

import java.util.ArrayList;


public class WordList {

    private ArrayList myList;

    public int numWordsOfLength(int len){
        int count = 0;

        for(int i = 0; i < myList.size(); i++){
            if(((String) myList.get(i)).length() == len)
                count++;
        }
        return count;
    }
}


