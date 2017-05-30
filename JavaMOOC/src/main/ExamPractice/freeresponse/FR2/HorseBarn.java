package main.ExamPractice.freeresponse.FR2;



class Horse{ //should be interface
    private String name;
    private double weight;

    public Horse(String horseName, double horseWeight){
        name = horseName;
        weight = horseWeight;
    }

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }
}


public class HorseBarn {

    private Horse[] spaces;

    public HorseBarn(Horse[] theSpaces){
        //spaces = new Horse[theSpaces.length];
        spaces = theSpaces;
    }

    /**
     * @todo CONSOLIDATE ALGORITHM
     * */
    public void consolidate() {
        /*for (int i = 0; i < spaces.length-1; i++) {
            if (spaces[i] == null) {
                for (int j = i+1; j < spaces.length; j++) {
                    if (spaces[j] != null) {
                        spaces[i] = spaces[j];
                        spaces[j] = null;
                        j = spaces.length;
                    }
                }
            }
        }*/

        int count = 0;
        for(int i = 0; i < spaces.length; i++){
            if(spaces[i] != null){
                spaces[count] = spaces[i];
                if(i != count)
                    spaces[i] = null;
                count++;
            }
        }
    }

    public String toString(){
        String s = "";
        for(Horse h : spaces){
            if(h == null){
                s += "null\n";
            } else{
                s += h.getName() + "\n";
            }
        }
        return s;
    }
}

class TestHorseBarn {

    public static void main(String[] args) {;

        Horse h0 = new Horse("Trigger", 1340);
        Horse h1 = null;
        Horse h2 = new Horse("Silver", 1210);
        Horse h3 = new Horse("Lady", 1450);
        Horse h4 = null;
        Horse h5 = new Horse("Patches", 1350);
        Horse h6 = new Horse("Duke", 1410);


        Horse[] horses = new Horse[]{h0, h1, h2, h3, h4, h5, h6};
        HorseBarn sweetHome = new HorseBarn(horses);
        System.out.println(sweetHome);
        sweetHome.consolidate();
        System.out.println(sweetHome);

    }
}
