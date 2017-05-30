package main.ExamPractice.freeresponse.FR2;

import com.sun.org.apache.bcel.internal.generic.InstructionConstants;

import java.util.ArrayList;
import java.util.List;

class ClimbInfo{
    private String name;
    private int time;

    public ClimbInfo(String peakName, int climbTime){
        name = peakName;
        time = climbTime;
    }

    public String getName(){
        return name;
    }
    public int getTime(){
        return time;
    }
}


public class ClimbingClub {

    private List<ClimbInfo> climbList;

    public ClimbingClub(){
        climbList = new ArrayList<ClimbInfo>();
    }

    /* part b -- ordered add */
    public void addClimb(String peakName, int climbTime){
        /*ClimbInfo info = new ClimbInfo(peakName, climbTime);

        if(climbList.size() == 0){
            climbList.add(info);
        } else if(climbList.size() == 1) {
            if(climbList.get(0).getName().compareTo(peakName) < 0)
                climbList.add(info);
            else
                climbList.add(0, info);
        } else {
            for(int i = 0; i < climbList.size(); i++){
                if(climbList.get(i).getName().compareTo(peakName) > 0) {
                    climbList.add(i, info);
                    return;
                }
            }
        }*/

        /**
         * @todo INSERT IN ORDER ALGORITHM
         */
        ClimbInfo info = new ClimbInfo(peakName, climbTime);

        for (int i = 0; i < climbList.size(); i++) {
            if (climbList.get(i).getName().compareTo(peakName) > 0) {
                climbList.add(i, info);
                return;
            }
        }
        climbList.add(info);
    }

    public String toString(){
        String s = "";
        for(ClimbInfo info : climbList)
            s += info.getName() + "\n";
        return s;
    }
}

class TestClimb{

    public static void main(String[] args) {
        ClimbingClub club = new ClimbingClub();
        club.addClimb("Monadnock", 274);
        club.addClimb("Whiteface", 301);
        club.addClimb("Algonquin", 225);
        club.addClimb("Monadnock", 344);
        club.addClimb("Royale", 300);

        System.out.println(club.toString());
    }
}
