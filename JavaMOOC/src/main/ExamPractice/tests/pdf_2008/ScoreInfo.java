package main.ExamPractice.tests.pdf_2008;


import java.util.ArrayList;
import java.util.List;

public class ScoreInfo {

    private int score;
    private int numStudentsWithThisScore;

    public ScoreInfo(int aScore){
        score = aScore;
        numStudentsWithThisScore = 1;
    }

    public void increment(){
        numStudentsWithThisScore++;
    }

    public int getScore(){
        return score;
    }

    public int getFrequency(){
        return numStudentsWithThisScore;
    }
}

class Stats {
    private List<ScoreInfo> scoreList;

    public Stats(List<ScoreInfo> list){
        scoreList = list;
    }

    public boolean record(int score){
        boolean newObjWasAdded = false;
        ScoreInfo info = new ScoreInfo(score);

        if(scoreList.size() == 0){
            scoreList.add(info);
            newObjWasAdded = true;
        } else if(scoreList.size() == 1){

            int currScore = scoreList.get(0).getScore();
            if(currScore == score){
                scoreList.get(0).increment();
            } else if(currScore > score){
                scoreList.add(0, info);
                newObjWasAdded = true;
            } else {
                scoreList.add(info);
                newObjWasAdded = true;
            }
        } else {

            for(int i = 0; i < scoreList.size(); i++){
                int currScore = scoreList.get(i).getScore();

                if(currScore == score){
                    scoreList.get(i).increment();
                    break;
                } else if(currScore > score){
                    scoreList.add(i, info);
                    newObjWasAdded = true;
                    break;
                }
            }
        }
        return newObjWasAdded;
    }

    public void recordScores(int[] stuScores){
        for(int i = 0; i < stuScores.length; i++)
            record(stuScores[i]);
    }

    public String toString(){
        String s = "";
        for(ScoreInfo sInfo : scoreList)
            s += "score =  " + sInfo.getScore() + "      freq =  " + sInfo.getFrequency() + "\n";
        return s;
    }
}

class TestStats {

    public static void main(String[] args) {
        List<ScoreInfo> list = new ArrayList<ScoreInfo>();
        list.add(new ScoreInfo(1));
        list.add(new ScoreInfo(4));
        list.add(new ScoreInfo(5));
        list.add(new ScoreInfo(8));
        list.add(new ScoreInfo(9));
        list.add(new ScoreInfo(10));


        int[] stuScores = new int[]{2, 3, 6, 7, 10, 10, 10, 1, 1, 1, 4, 4};

        Stats stat = new Stats(list);
        System.out.println(stat);

        stat.recordScores(stuScores);
        System.out.println(stat);

    }
}