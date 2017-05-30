
package semester2.chapter6.section_6_4;



/*Exception class for Assignment 6.32*/

class ParIsNullException extends Exception {
    ParIsNullException(String message){
        super(message);
    }
}


public class StringInfo implements Comparable {

    private String itself;

    public StringInfo (String given){
        itself =   (given == null)  ?  ""  :  given;
    }

    public String toString(){
        return itself;
    }


    /** The standard Comparable method.
     *  Precondition: ob is a StringInfo object. */

    public int compareTo (Object ob){
        return itself.compareTo (((StringInfo) ob).itself);
    }


    /** Remove all characters before index n, plus any
     *  whitespace immediately following those characters.  */

    public void trimFront (int i){
        while (i < itself.length() && itself.charAt(i) <= ' '){
            i++;
        }
        itself = i > itself.length()  ?  "" : itself.substring(i);
    }


    /*Exercise 6.26*/

    public void trimRear() {
        int i = itself.length() - 1;
        while (i >= 0 && itself.charAt(i) <= ' ') {
            i--;
        }
        itself = itself.substring(0, i + 1);
    }


    /*Exercise 6.27*/

    public boolean hasWhite(){
        for(int i = 0; i < itself.length(); i++){
            if(itself.charAt(i) <= ' '){
                return true;
            }
        }
        return false;
    }


    /*Exercise 6.28*/

    public int indexOf(char par){
        for(int i = 0; i < itself.length(); i++){
            if(itself.charAt(i) == par){
                return i;
            }
        }
        return -1; // since the char is not in par
    }


    /*Exercise 6.29*/

    public String initDigits(){
        int iFromStart = 0;
        int iFromEnd = itself.length() - 1;
        int start = 0;
        int end = 0;

        while (itself.charAt(iFromStart) < '0' || itself.charAt(iFromStart) > '9'){
            iFromStart++;
        }
        start = iFromStart;

        while(itself.charAt(iFromEnd) < '0' || itself.charAt(iFromEnd) > '9'){
            iFromEnd--;
        }
        end = iFromEnd + 1;

        return itself.substring(start, end);
    }


    /** Return the first word of the String, down to but not
     *  including the first whitespace character.
     *  todo SEQUENTIAL SEARCH */

    public String firstWord(){
        for (int i = 0;  i < itself.length();  i++){
            if (itself.charAt (i) <= ' '){
                return itself.substring (0, i);
            }
        }
        return itself;  // since the string has no whitespace
    }


    /** Strip out all non-digits from the StringInfo object. Keep only numbers*/

    public void retainDigits(){
        String result = "";
        for (int i = 0;  i < itself.length();  i++){
            if (itself.charAt(i) >= '0' && itself.charAt(i) <= '9'){
                result += itself.charAt (i);
            }
        }
        itself = result;
        System.out.println(itself);
    }


    /** Return the numeric equivalent of itself.
     *  Ignore the first invalid character and anything after it.
     *  If the part of the string before the first invalid
     *  character is a numeral, return the double equivalent,
     *  otherwise return the value of badNumeral. */


    public double parseDouble (double badNumeral){
        if (itself.length() == 0){                              //1
            return badNumeral;
        }                                                       //2
        boolean hasNoDigit = true;  // until a digit is seen   //3
        int pos =  (itself.charAt (0) == '-' || itself.charAt (0) == '$')  ?  1  :  0;     //4  // if the inputted rate was negative, start analyzing past the sign
        for ( ;  hasDigitAt (pos);  pos++){                     //5
            hasNoDigit = false;
        }                                   //6
        if (pos < itself.length() && itself.charAt(pos) == '.'){ //checking: is the rate numbers or '.' all the way? to eliminate peculiarities...
            for (pos++;  hasDigitAt (pos);  pos++)  {            //8
                hasNoDigit = false;
            }                                                    //9
        }                                                      //10
        return hasNoDigit  ?  badNumeral                       //11
                :  Double.parseDouble (itself.substring (0, pos));  //cuts off any peculiarities after the last digit
    }

    private boolean hasDigitAt (int pos){
        return pos < itself.length() && itself.charAt(pos) >= '0'
            && itself.charAt(pos) <= '9';
    }


    //All-A-are-B looping action
    public boolean inRange(char low, char high){
        for(int i = 0; i < itself.length(); i++){
            if(itself.charAt(i) < low || itself.charAt(i) > high){
                return false;
            }
        }
        return true;
    }

    //Some-A-are-B looping action
    public boolean atLeastOneInRange(char low, char high){
        for(int i = 0; i < itself.length(); i++){
            if(itself.charAt(i) >= low && itself.charAt(i) <= high){
                return true;
            }
        }
        return false;
    }


    /*Exercise 6.24*/

    public int countRange(char low, char high){
        int count = 0;
        for(int i = 0; i < itself.length(); i++){
            if(itself.charAt(i) >= low && itself.charAt(i) <= high){
                count++;
            }
        }
        return count;
    }


    /*Exercise 6.25*/

    public char biggestChar(){
        char result = (char)0;

        for(int i = 0; i < itself.length(); i++){
            if(itself.charAt(i) > result){
                result = itself.charAt(i);
            }
        }
        return result;
    }


    /*Assignment 6.32 */

     public int lastBiggie(StringInfo par) {
        int lastPosSoFar = -1;

         try{
             if(par == null){
                 throw new ParIsNullException("par cannot be null!");
             }else{
                 int len = this.itself.length() >= par.itself.length() ? par.itself.length() : this.itself.length();

                 for(int i = 0; i < len; i++){
                     if(this.itself.charAt(i) > par.itself.charAt(i)){
                         lastPosSoFar = i;
                     }
                 }
             }
         }catch(ParIsNullException ex){
             System.out.println(ex.getMessage());
         }

        return lastPosSoFar; //default = -1 if no bigger char
    }


    /*Assignment 6.33*/

    public StringInfo reverse(){
        StringInfo reversedStr = new StringInfo("");
        int lastIndex = this.itself.length() - 1;

        for(int i = lastIndex; i >= 0; i--){
            reversedStr.itself += this.itself.substring(i, i + 1);
        }
        return reversedStr;
    }


    /*Assignment 6.34*/

    public void replace(char low, char high){
        itself.replace(low, high); //using the already-given String method replace()
    }


    /*Assignment 6.35*/

    public void numWords(){
        String[] splitWords = itself.split(" ");

        System.out.println("The number of words is: " + splitWords.length);
    }

    public int getElapsedTime(){
        long start = System.currentTimeMillis();
        reverse();
        return (int) (System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
        System.out.println(new StringInfo("the string").getElapsedTime());

        new StringInfo("trimrear    ").trimRear();
    }
}

