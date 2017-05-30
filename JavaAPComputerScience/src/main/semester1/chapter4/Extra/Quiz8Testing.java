package semester1.chapter4.Extra;
import javax.swing.JOptionPane;
/**
 * Created by user1928 on 12/23/14.
 */
public class Quiz8Testing {

    /*public static int read(){
        String xstr = JOptionPane.showInputDialog("get x here ");
        return Integer.parseInt(xstr);
    }*/

    public static void quiz(){
        int n = 0;
        for (int x = Integer.parseInt(JOptionPane.showInputDialog("Get now!"));  x != 0;
             x = Integer.parseInt(JOptionPane.showInputDialog("Get!"))){
            if (x > 20){
                n++;
            }
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        quiz();
    }
}
