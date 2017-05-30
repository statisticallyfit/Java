package main.Unit2.Assignment3;


import java.util.Scanner;

public class Horoscope {


    private String itsMonthAsWord;
    private String itsDayAsWord;
    private String itsStarSign;
    private String itsHoroscope;
    private int normalizedBirthDate;

    public Horoscope(int month, int day){
        this.itsMonthAsWord = monthToString(month);
        this.itsDayAsWord = dayToString(day);
        this.normalizedBirthDate = 31 * month + day;
    }

    public int getInputsAsInts(){
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }


    public String monthToString(int month){
        String[] monthAsWord = {"", "January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December"};

        return monthAsWord[month];
    }


    public String dayToString(int day){

        String[] unit = {"", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth"};
        String[] tens = {"", "tenth", "twenty", "thirty"};
        String[] fancyTens = {"", "", "twentieth", "thirtieth"};
        int t = day/10;
        int u = Integer.parseInt(Integer.toString(day).substring(1, 2));

        if(u == 0){
            return fancyTens[t];
        }
        //else
        return tens[t] + unit[u];
    }


    public void getStarsign(){
        int upper = 0; //upper bound month
        int lower = 0; //lower bound month
        int[] ranges = {
                19, 20, 80, 81, 113, 114, 143, 144,
                175, 176, 206, 207, 239, 240, 270, 271,
                301, 302, 332, 333, 362, 363, 393, 394};

        for(int i = 0; i < ranges.length; i++){
            if(normalizedBirthDate >= ranges[i] && normalizedBirthDate <= ranges[i + 1]){
                upper = ranges[i];
                lower = ranges[i+1];
            }
        }

    }

    public static void main(String[] args) {
        Horoscope h = new Horoscope(3, 23);

    }
}
