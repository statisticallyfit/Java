package main.Unit5.lesson2activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program that allows a user to input words at the command line.  Your program should stop accepting words when the user enters "STOP".  Store the words in an ArrayList.  The word STOP should not be stored in the list.

 Next, your program should loop through the list and print out only the words that contain the letter "a".

 Sample Run:

 Please enter words, enter STOP to stop the loop.
 dog
 zebra
 cat
 fish
 STOP

 zebra
 cat
 */
public class ContainsLetter {

    public List<String> makeData(){
        List<String> list = new ArrayList<String>();
        /*Scanner scan = new Scanner(System.in);
        String word = scan.next();

        while(!word.toUpperCase().equals("STOP")){
            list.add(word);
            word = scan.next();
        }*/

        list.add("The Secret of the Old Clock");
        list.add("Mystery of Crocodile Island");
        list.add("The Hidden Staircase");
        list.add("The Haunted Showboat");
        list.add("The Bungalow Mystery");
        list.add("The Quest of the Missing Map");
        list.add("The Clue in the Crossword Cipher");

        return list;
    }

    public void printWordsThatContainA(List<String> list){

        for(String value : list){
            for(int i = 0; i < value.length(); i++){
                if(value.substring(i, i + 1).toLowerCase().equals("a")) {
                    System.out.println(value);
                    break;
                }
            }
        }
    }

    public void printList(List<String> list){
        for(String value : list)
            System.out.println(value);
    }

    /* Go backwards: won't skip removing elements that way, and no error */

    public void removeWordsWithUpperCaseC(List<String> list){
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i).indexOf("C") != -1){ //or list.get(i).contains("C")
                list.remove(i);
            }
        }
        printList(list);
    }
}

class Tester {


    public static void main(String[] args) {
        ContainsLetter cont = new ContainsLetter();

        List<String> list = cont.makeData();

        cont.printWordsThatContainA(list);

        System.out.println();

        cont.removeWordsWithUpperCaseC(list);
    }
}
