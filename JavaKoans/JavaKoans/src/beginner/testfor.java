package beginner;

/**
 * Created by user1928 on 12/27/14.
 */
public class testfor {

    public void forLoop(){
        String s = "";
        for(int i = 0; i < 5; i++) {
            s += i + " ";
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        testfor obj = new testfor();
        obj.forLoop();
    }

}
