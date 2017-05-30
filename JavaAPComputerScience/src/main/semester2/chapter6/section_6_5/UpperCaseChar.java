package semester2.chapter6.section_6_5;


/*Exercise 6.36*/

public class UpperCaseChar {

    public static char toUpperCase(char par){

        /*char upperCaseChar = String.valueOf(par).toUpperCase().charAt(0);
        return par != upperCaseChar ? upperCaseChar : par;*/

        return (par < 'a' || par > 'z') ? par : (char)(par - 'a' + 'A');
    }

    public static void main(String[] args) {
        System.out.println(toUpperCase('h'));
        System.out.println(toUpperCase('A'));
    }
}
