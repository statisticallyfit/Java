package semester1.chapter4.section_4_0_interlude;

/**
 * Created by user1928 on 11/14/14.
 */
public class ex6 {

    public void printSalute(){

        for(int i = -4; i <=5; i++)
            System.out.println("hi");

        System.out.println("NEXT one");

        for(int i = -2; i <8; i++)
            System.out.println("hi");

        System.out.println("NEXT one");

        for(int i = 3; i >=-6; i--)
            System.out.println("hi");
    }

    public static void main(String[] args){
        ex6 saluter = new ex6();

        saluter.printSalute();
    }
}
