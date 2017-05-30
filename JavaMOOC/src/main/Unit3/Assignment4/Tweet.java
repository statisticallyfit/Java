package main.Unit3.Assignment4;

import javax.swing.JOptionPane;

/**
 * Created by user1928 on 1/20/15.
 */
public class Tweet {

    private String itsTweetMessage = "";
    private char[] itsTweetChars = null;
    //private int itsNumChars = 0;
    private int itsNumOfAttrs = 0;
    private int itsNumOfHashtags = 0;
    private int itsNumOfLinks = 0;

    public void readTweet(){
        itsTweetMessage = JOptionPane.showInputDialog("Enter your tweet").toLowerCase();
    }

    public void splitTweet(){
        itsTweetChars = itsTweetMessage.toCharArray();
    }

    public boolean tweetIsValid(){

        return itsTweetChars.length <= 140;
    }

    //called if tweet is tweetIsValid() returns false
    public void printExcessCharacters(){
        System.out.println("Excess Characters: " + (itsTweetChars.length - 140));
    }

    //called if tweetIsValid() returns true
    public void analyzeTweet(){
        System.out.println("Length Correct");

        //count links
        while(itsTweetMessage.contains("http://")){
            itsTweetMessage = itsTweetMessage.replaceFirst("http://", "REPLACED");
            itsNumOfLinks++;
        }

        //count hashtags or @
        for (int i = 0; i < itsTweetChars.length; i++) {
            if(itsTweetChars[i] == '@'){
                itsNumOfAttrs++;

            }else if(itsTweetChars[i] == '#'){
                itsNumOfHashtags++;
            }
        }

        System.out.println("Number of Hashtags: " + itsNumOfHashtags);
        System.out.println("Number of Attributions: " + itsNumOfAttrs);
        System.out.println("Number of links: " + itsNumOfLinks);

    }

    public static void main(String[] args) {
        Tweet t = new Tweet();

        t.readTweet();
        t.splitTweet();
        if(t.tweetIsValid()){
            t.analyzeTweet();
        }else{
            t.printExcessCharacters();
        }

    }

}

