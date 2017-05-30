package semester2.chapter6.section_6_3;


public class TimeTesterNew {

    public static void main(String[] args) {


        Time t1 = new Time(3, 31, 90);
        Time t2 = new Time(0, 3, 100);
        Time t5 = new Time(3, 31, 90);


        /*Testing compareTo()*/
        {
            if((t1.compareTo(t2) != 4) || (t2.compareTo(t1) != -4)){
                System.err.println("Test compareTo failed");
            }
        }


        /*Testing equals() */
        {
            if(!t1.equals(t5) || !t5.equals(t1)){
                System.err.println("Test equals of equal times failed");
            }
            if(t2.equals(t5) || t5.equals(t2)){
                System.err.println("Test equals of different times failed");
            }
        }

    }
}
