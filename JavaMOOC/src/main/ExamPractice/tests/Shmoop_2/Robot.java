package main.ExamPractice.tests.Shmoop_2;



public class Robot {

    private int[] hall;
    private int pos;
    private boolean facingRight;

    public Robot(int[] aHall, int aPos, boolean right){
        hall = aHall;
        pos = aPos;
        facingRight = right;
    }

    public boolean forwardMoveBlocked(){
        return (facingRight && pos == hall.length - 1) ||
                (!facingRight && pos == 0);
    }

    public void move(){
        if(hall[pos] > 0)
            hall[pos]--;
        if(hall[pos] == 0){
            if(!forwardMoveBlocked()) {

                if(facingRight)
                    pos++;
                else
                    pos--;

            } else {
                facingRight = !facingRight;
            }
        }
    }

    public boolean hallIsClear(){
        for(int tile = 0; tile < hall.length; tile++)
            if(hall[tile] != 0)
                return false;
        return true;
    }

    public int clearHall(){
        int numMoves = 0;
        while(!hallIsClear()){
            move();
            numMoves++;
        }
        return numMoves;
    }

    public static String scrambleWord(String word){
        int i = 0;

        while(i < word.length() - 1){
            if(word.substring(i, i + 1).equals("A")
                    && !word.substring(i + 1, i + 2).equals("A")){
                word = word.substring(0, i) +
                        word.substring(i + 1, i + 2) +
                        "A" +
                        word.substring(i + 2);
                i += 2;
            } else {
                i++;
            }
        }
        return word;
    }
}

class TestRobot {

    public static void main(String[] args) {
        Robot bot = new Robot(new int[]{1, 1, 2, 2}, 1, true);
        //assert(bot.clearHall() == 9);
        if(bot.clearHall() != 9)
            System.err.println("Test 1 failed");
    }
}