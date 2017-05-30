package main.Practice;


import java.util.ArrayList;


public class StudentAnswerSheet {

    // List of a particular student's answers
    private ArrayList<String> answers;
    private String name;

    public StudentAnswerSheet(String name, ArrayList<String> theAnswers){
        this.name = name;
        this.answers = theAnswers;
    }

    /**
     * @param key the list of correct answers, as strings of length one
     *            Precondition: key.size() equals number of answers in answers
     * @return this student's test score
     */
    public double getScore(ArrayList<String> key) {

        int numCorrect = 0;
        int numPartiallyCorrect = 0;

        for(int i = 0; i < answers.size(); i++){
            String a = answers.get(i);
            String k = key.get(i);
            if(a.equals(k))
                numCorrect++;
            else
                numPartiallyCorrect++;
        }
        return (numCorrect - numPartiallyCorrect * 0.25);
    }

    public String getName(){
        return name;
    }
}


class TestResults {

    private ArrayList<StudentAnswerSheet> sheets;

    public String highestScoringStudent(ArrayList<String> key){
        StudentAnswerSheet highest = sheets.get(0);

        for(StudentAnswerSheet sheet : sheets){
            if(sheet.getScore(key) > highest.getScore(key)){
                highest = sheet;
            }
        }
        return highest.getName();
    }
}