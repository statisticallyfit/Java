package main.bookNutshell.exercise_2_2;


public class MailingAddress {

    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;

    public MailingAddress(String aName, String aStreetAddress,
                          String aCity, String aState, int aZipCode) {
        this.name = aName;
        this.streetAddress = aStreetAddress;
        this.city = aCity;
        this.state = aState;
        this.zipCode = aZipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return " ~ Mailing Address ~ \n" +
                "Name: " + name + "\n" +
                "City: " + city + "\n" +
                "Street address: " + streetAddress + "\n" +
                "State: " + state + "\n" +
                "Zip code: " + zipCode;
    }
}

class MailingAddressRunner {

    public static void main(String[] args) {
        MailingAddress ma = new MailingAddress("Mary Carstworth", "32 Rosewood Lane",
                "Valewood", "Oregon", 213458);

        System.out.println(ma);
    }
}