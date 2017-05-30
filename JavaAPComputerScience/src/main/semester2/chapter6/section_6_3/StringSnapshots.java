package semester2.chapter6.section_6_3;



/*Exercise 18*/
public class StringSnapshots {

    /*Precondition: neither of string values are null */

    public static int indexOf(String big, String little){

        if(big == null || little == null){
            return -1; //no success
        }else{
            int littleLen = little.length();
            int lastToLookAt = big.length() - littleLen; //to avoid StringIndexOutOfBoundsException

            for(int i = 0; i <= lastToLookAt; i++){
                if(big.substring(i, i + littleLen).equals(little)){
                    return i; //return the index of big
                }
            }
            return -1; //no success
        }
    }

    public static void main(String[] args) {

        {
            if(indexOf("horsemerrygoround", "merry") != 5){
                System.err.println("Test 1 failed");
            }
            if(indexOf("wellhowdedonow", "de") != 7){
                System.err.println("Test 2 failed");
            }
            if(indexOf("interesting", "rest") != 4){
                System.err.println("Look here");
            }
        }
    }
}
