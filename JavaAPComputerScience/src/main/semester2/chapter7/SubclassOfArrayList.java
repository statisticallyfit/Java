package semester2.chapter7;

import java.util.ArrayList;

/**
 * Created by Nick on 10/03/2015.
 */
public class SubclassOfArrayList extends ArrayList<Object> {

    private ArrayList<Object> itsList = new ArrayList<Object>();

    /* Unit 6 test question 6 */
    public void addAll(ArrayList<Object> given){
        int givenIndex = 0;
        int limit = itsList.size() + given.size();

        for(int i = itsList.size(); i < limit; i++){
            itsList.add(i, given.get(givenIndex));
            givenIndex++;
        }
    }

    /* Unit 6 test question 7 */

    public boolean equals(ArrayList<Object> given){
        int limit = (itsList.size() >= given.size()) ? given.size() : itsList.size();

        for(int i = 0; i < limit; i++){
            if(!itsList.get(i).equals(given.get(i))){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        SubclassOfArrayList obj = new SubclassOfArrayList();


        ArrayList<Object> given = new ArrayList<Object>();
        given.add(0, 3);
        given.add(1, 2);
        given.add(2, 34);
        given.add(3, 56);

        System.out.println(obj.equals(given));
    }
}
