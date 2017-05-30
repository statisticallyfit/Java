package main.Unit7.Assignment7_InsertNames;


import java.util.ArrayList;
import java.util.Scanner;

public class InsertNames {

    private static ArrayList<String> addInOrder(ArrayList<String> list, String s){
        if(list.size() == 0){
            list.add(s);
        } else {
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).compareTo(s) >= 0){
                    list.add(i, s);
                    return list;
                }
            }
            list.add(s); //if gone through whole list and didn't in between pair, then add at end
        }
        return list;
    }

    public static String titleCase(String s){
        String lowerCase = s.toLowerCase();
        return lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1);
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<String>();

        String word = scan.nextLine();
        while (!word.toLowerCase().equals("stop")) {
            word = titleCase(word);
            names = addInOrder(names, word);
            word = scan.nextLine();
        }

        System.out.println(names.toString());
    }
}
