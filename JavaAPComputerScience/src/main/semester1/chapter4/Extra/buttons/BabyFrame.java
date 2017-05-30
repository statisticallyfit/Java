package semester1.chapter4.Extra.buttons;

/**
 * Created by user1928 on 12/13/14.
 */
// This class is not to be studied until after you study Chapter 9.
// Simply compile it before compiling any class that uses it.

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** 1. How do you make an inner class? Just put it inside another class;
 its heading can begin with either "public class" or "private class".
 2. What do you lose? You cannot have class methods or class
 variables in the inner class.
 3. What do you gain? The inner class can access private variables
 and methods of the outer class. */

public class BabyFrame extends JFrame
{
    private boolean isMainFrame;

    /** Create a JFrame with the given title; use FlowLayout.  */

    public BabyFrame (String title)
    {    super (title);
        getContentPane().setLayout (new java.awt.FlowLayout());  // ##
        isMainFrame = true;
        addWindowListener (new Closer());
        setVisible (true);
    }

     /* Note:  An instructor may wish to modify this class to allow students
       to create applets in the same vein.  Do the following and recompile:
       1. Replace "JFrame" by "javax.swing.JApplet" in the class heading.
       2. Delete the BabyFrame constructor above, and the one at the end.
       3. Tell students their subclasses should use init(), not constructors.
          Their first init() statement should be the one marked ## above. */

    public java.awt.Component add (java.awt.Component given)
    {    this.getContentPane().add (given);
        return given;
    }

    private class Closer extends java.awt.event.WindowAdapter
    {
        public void windowClosing (java.awt.event.WindowEvent e)
        {    if (isMainFrame)
            System.exit (0);
        else
            setVisible (false);
        }
    }

    /** Create a JScrollPane containing a JTextArea.  It will display
     a given showUpdatedStatus on a line by itself. */

    public class BabyTextArea extends JScrollPane
    {
        private JTextArea itsArea;

        public BabyTextArea (int rows, int columns)
        {    super();
            itsArea = new JTextArea (rows, columns);
            // the following is required because we cannot
            // create the area and then say super(itsArea)
            this.setViewportView (itsArea);
        }

        /** Show the showUpdatedStatus in the scrolled text area. */

        public void say (String message)
        {    itsArea.append (message + "\n");
        }    //======================
    }

    /** Create a JButton with the given title.  It is its own listener.
     It will call the void buttonAction_N method when clicked. */

    public class BabyButton_1 extends JButton implements ActionListener
    {
        public BabyButton_1 (String title)
        {    super (title);  // sets the label on the button
            this.addActionListener (this);  // connects to
            // the following actionPerformed method
        }

        public void actionPerformed (ActionEvent ev)
        {    buttonAction_1();
        }
    }

    public void buttonAction_1()  // to be overridden
    {  }

    /** Create a JTextField with the given width (in characters, roughly).
     It is its own listener.  It will call the void fieldAction_N
     method when ENTER is pressed, passing itself as a parameter. */

    public class BabyField_1 extends JTextField implements ActionListener
    {
        public BabyField_1 (int textSize)
        {    super (textSize);  // sets the text in the textfield
            this.addActionListener (this);  // connects to
            // the following actionPerformed method
        }

        public void actionPerformed (ActionEvent ev)
        {    fieldAction_1 ((BabyField_1) ev.getSource());
        }
    }

    public void fieldAction_1 (BabyField_1 source)  // to be overridden
    {  }


    public class BabyButton_2 extends JButton implements ActionListener
    {
        public BabyButton_2 (String title)
        {    super (title);  // sets the label on the button
            this.addActionListener (this);  // connects to
            // the following actionPerformed method
        }

        public void actionPerformed (ActionEvent ev)
        {    buttonAction_2();
        }
    }

    public void buttonAction_2()  // to be overridden
    {  }



    public class BabyField_2 extends JTextField implements ActionListener
    {
        public BabyField_2 (int textSize)
        {    super (textSize);  // sets the text in the textfield
            this.addActionListener (this);  // connects to
            // the following actionPerformed method
        }

        public void actionPerformed (ActionEvent ev)
        {    fieldAction_2 ((BabyField_2) ev.getSource());
        }
    }

    public void fieldAction_2 (BabyField_2 source)  // to be overridden
    {  }



    public class BabyButton_3 extends JButton implements ActionListener
    {
        public BabyButton_3 (String title)
        {    super (title);  // sets the label on the button
            this.addActionListener (this);  // connects to
            // the following actionPerformed method
        }


        public void actionPerformed (ActionEvent ev)
        {    buttonAction_3();
        }
    }

    public void buttonAction_3()  // to be overridden
    {  }




    public class BabyField_3 extends JTextField implements ActionListener
    {
        public BabyField_3 (int textSize)
        {    super (textSize);  // sets the text in the textfield
            this.addActionListener (this);  // connects to
            // the following actionPerformed method
        }

        public void actionPerformed (ActionEvent ev)
        {    fieldAction_3 ((BabyField_3) ev.getSource());
        }
    }


    public void fieldAction_3 (BabyField_3 source)  // to be overridden
    {  }



    public class BabyButton_4 extends JButton implements ActionListener
    {
        public BabyButton_4 (String title)
        {    super (title);  // sets the label on the button
            this.addActionListener (this);  // connects to
            // the following actionPerformed method
        }

        public void actionPerformed (ActionEvent ev)
        {    buttonAction_4();
        }
    }

    public void buttonAction_4()  // to be overridden
    {  }



    public class BabyField_4 extends JTextField implements ActionListener
    {
        public BabyField_4 (int textSize)
        {    super (textSize);  // sets the text in the textfield
            this.addActionListener (this);  // connects to
            // the following actionPerformed method
        }

        public void actionPerformed (ActionEvent ev)
        {    fieldAction_4 ((BabyField_4) ev.getSource());
        }
    }

    public void fieldAction_4 (BabyField_4 source)  // to be overridden
    {  }





    public class BabyButton_5 extends JButton implements ActionListener
    {
        public BabyButton_5 (String title)
        {    super (title);  // sets the label on the button
            this.addActionListener (this);  // connects to
            // the following actionPerformed method
        }

        public void actionPerformed (ActionEvent ev)
        {    buttonAction_5();
        }
    }

    public void buttonAction_5()  // to be overridden
    {  }



    public class BabyButton_6 extends JButton implements ActionListener
    {
        public BabyButton_6 (String title)
        {    super (title);  // sets the label on the button
            this.addActionListener (this);  // connects to
            // the following actionPerformed method
        }

        public void actionPerformed (ActionEvent ev)
        {    buttonAction_6();
        }
    }

    public void buttonAction_6()  // to be overridden
    {  }



    /** Create a JFrame with the given title; use FlowLayout.
     The second parameter should be true if this is the main frame of
     the application; it should be false if it is a "sub-frame." */

    public BabyFrame (String title, boolean isMain)
    {    super (title);
        getContentPane().setLayout (new java.awt.FlowLayout());  // ##
        isMainFrame = isMain;
        addWindowListener (new Closer());
        setVisible (true);
    }


    public JButton newButton (String label, ActionListener alis)
    {    JButton but = new JButton (label);
        but.addActionListener (alis);
        return but;
    }
}
