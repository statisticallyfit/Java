package semester2.chapter13.ProjectSortSalon;


import java.util.Comparator;

public class HairSalon {

    private String itsService;
    private double itsPrice;
    private int itsTime;

    public HairSalon(String service, double price, int time){
        this.itsService = service;
        this.itsPrice = price;
        this.itsTime = time;
    }

    public String getService(){
        return this.itsService;
    }

    public double getPrice(){
        return this.itsPrice;
    }

    public int getTime(){
        return this.itsTime;
    }

    public String toString(){
        return "Service: " + this.itsService + ", Cost: $" +
                this.itsPrice + ", Length of Time: " + this.itsTime + " minutes";
    }



    /* Internal work horse */
    public int compareByPrice(HairSalon that) {
        return (this.itsPrice - that.getPrice() > 0) ? 1 : -1;
    }
    /* Internal work horse */
    public int compareByTime(HairSalon that) {
        return (this.itsTime - that.getTime()  > 0) ? 1 : -1;
    }



    public static Comparator<HairSalon> comparatorByService = new Comparator<HairSalon>() {
        public int compare(HairSalon h1, HairSalon h2) {
            return h1.getService().toUpperCase().compareTo(
                    h2.getService().toUpperCase()); //ascending order
        }
    };

    public static Comparator<HairSalon> comparatorByPrice = new Comparator<HairSalon>() {
        public int compare(HairSalon h1, HairSalon h2) {
            return h1.compareByPrice(h2); //ascending order
        }
    };

    public static Comparator<HairSalon> comparatorByTime = new Comparator<HairSalon>() {
        public int compare(HairSalon h1, HairSalon h2) {
            return h2.compareByTime(h1); //descending order
        }
    };
}
