package semester1.chapter4.section_4_2;

import javax.swing.JOptionPane;

/**
 * Created by user1928 on 11/14/14.
 */
public class UsingShowConfirm extends ex1_EqualOrDifferentStrings_assignment {

    public void askIfUserWantsToRePlay(){
        while(JOptionPane.showConfirmDialog(null, "Again?") == JOptionPane.YES_OPTION){
            doStringComparison();
        }

    }

    public static void main(String[] args){
        UsingShowConfirm use = new UsingShowConfirm();

        use.askIfUserWantsToRePlay();
    }
}
