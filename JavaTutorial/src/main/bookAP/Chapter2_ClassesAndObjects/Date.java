package main.bookAP.Chapter2_ClassesAndObjects;



public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int mo, int da, int yr){
        this.month = mo;
        this.day = da;
        this.year = yr;
    }

    public int month(){
        return month;
    }
    public int day(){
        return day;
    }
    public int year(){
        return year;
    }

    public void addYears(int n){
        year += n;
    }

    public String toString(){
        return month + "/" + day + "/" + year;
    }
}
class DateRunner{

    public static void addCentury(Date recent, Date old){
        old.addYears(100);
        recent = old;

        System.out.println("\nInside addCentury(): ");
        System.out.println("Recent date: " + recent);
        System.out.println("Old date: " + old);
    }

    public static void main(String[] args) {
        Date oldDate = new Date(1, 13, 1900);
        Date recentDate = null;

        System.out.println("Before addCentury(): " );
        System.out.println("Recent date: " + recentDate);
        System.out.println("Old date: " + oldDate);


        addCentury(recentDate, oldDate);

        System.out.println("\nAfter exiting addCentury(): ");
        System.out.println("Recent date: " + recentDate);
        System.out.println("Old date: " + oldDate);
    }
}

