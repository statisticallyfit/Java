package semester2.chapter13.ProjectSortSalon;



import java.util.Scanner;

enum Category {
    SERVICE, PRICE, TIME
}

public class SortSalon {

    public static final int MAX_APPOINTMENTS = 6;

    /* Method 1: sorting manually by insertion */

    public HairSalon[] serviceSort(HairSalon[] elements){
        for (int j = 1; j < elements.length; j++)
        {
            HairSalon temp = elements[j];
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.getService().toLowerCase().compareTo(elements[possibleIndex - 1].getService().toLowerCase()) < 0)
            {
                elements[possibleIndex] = elements[possibleIndex - 1];
                possibleIndex--;
            }
            elements[possibleIndex] = temp;
        }
        return elements;
    }

    public HairSalon[] priceSort(HairSalon[] elements){
        for (int j = 1; j < elements.length; j++)
        {
            HairSalon temp = elements[j];
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.getPrice() < elements[possibleIndex - 1].getPrice())
            {
                elements[possibleIndex] = elements[possibleIndex - 1];
                possibleIndex--;
            }
            elements[possibleIndex] = temp;
        }
        return elements;
    }

    public HairSalon[] timeSort(HairSalon[] elements){
        for (int j = 1; j < elements.length; j++)
        {
            HairSalon temp = elements[j];
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.getTime() > elements[possibleIndex - 1].getTime())
            {
                elements[possibleIndex] = elements[possibleIndex - 1];
                possibleIndex--;
            }
            elements[possibleIndex] = temp;
        }
        return elements;
    }

    /* Method 2: sorting with comparator */

    /*public HairSalon[] sortUpByService(HairSalon[] list){
        Arrays.sort(list, HairSalon.comparatorByService);
        return list;
    }

    public HairSalon[] sortUpByPrice(HairSalon[] list){
        Arrays.sort(list, HairSalon.comparatorByPrice);
        return list;
    }

    public HairSalon[] sortDownByTime(HairSalon[] list){
        Arrays.sort(list, HairSalon.comparatorByTime);
        return list;
    }*/

    public HairSalon makeAppointment(){
        Scanner scan = new Scanner(System.in);
        String service = "";
        double price = 0;
        int time = 0;

        System.out.print("\n\tService description: ");
        service = scan.next();
        System.out.print("\tEnter a price: ");
        price = scan.nextDouble();
        System.out.print("\tEnter length of time in minutes: ");
        time = scan.nextInt();

        return new HairSalon(service, price, time);
    }

    public boolean checkToMake(int numOfAppointments){
        Scanner scan = new Scanner(System.in);
        if(numOfAppointments == MAX_APPOINTMENTS - 1)
            System.out.println("\nThis is the last appointment you can make! Make it? (yes or no)");
        else if(numOfAppointments == MAX_APPOINTMENTS)
            return false;
        else
            System.out.println("\nSchedule an appointment? (enter yes or no)");
        return scan.next().toLowerCase().equals("yes");
    }

    public static void printData(HairSalon[] list){
        for (HairSalon aSalon : list) {
            System.out.println("\t" + aSalon.toString());
        }
    }

    public static HairSalon[] makeData(){
        HairSalon[] salon = new HairSalon[MAX_APPOINTMENTS];

        salon[0] = new HairSalon("Facewash", 34.00, 30);
        salon[1] = new HairSalon("Mudmask", 20.00, 25);
        salon[2] = new HairSalon("Shampoo", 10.00, 60);
        salon[3] = new HairSalon("Cut", 12.45, 15);
        salon[4] = new HairSalon("makeUp", 100, 100);
        salon[5] = new HairSalon("Acnecleanse", 1300, 140);

        return salon;
    }

    private void askHowToSort() {
        System.out.println("\n\nHow do you want to sort the descriptions?\n" +
                "\tby service,\n" +
                "\tby price,\n" +
                "\tor by time?\n");
    }


    public static void main(String[] args) {

        SortSalon sortSalon = new SortSalon();
        HairSalon[] salon = new HairSalon[MAX_APPOINTMENTS];
        boolean messageWasUnclear = false;
        boolean make = false;
        int numOfAppointments = 0;


        /* Get input to fill array*/
        System.out.println("Enter your appointments: ");

        do {
            salon[numOfAppointments] = sortSalon.makeAppointment();
            numOfAppointments++; //just made another appointment
            make = sortSalon.checkToMake(numOfAppointments);
        } while(make);


        /* Give sorting choices */
        sortSalon.askHowToSort();

        do {
            Scanner scan = new Scanner(System.in);
            String category = scan.next();

            if(Category.SERVICE.toString().equals(category.toUpperCase())){
                System.out.println("\nSort by service, ascending");
                salon = sortSalon.serviceSort(salon);
                printData(salon);

            } else if(Category.PRICE.toString().equals(category.toUpperCase())){
                //salon = sortSalon.makeData();
                System.out.println("\nSort by price, ascending");
                salon = sortSalon.priceSort(salon);
                printData(salon);

            } else if(Category.TIME.toString().equals(category.toUpperCase())) {
                //salon = sortSalon.makeData();
                System.out.println("\nSort by time, descending");
                salon = sortSalon.timeSort(salon);
                printData(salon);
            } else {
                messageWasUnclear = true;
                System.out.println("Could not read that... Try again");
            }
        } while(messageWasUnclear);
    }
}
