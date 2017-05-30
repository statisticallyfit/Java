package semester2.chapter6.section_6_4.Extra;




class WrongInputException extends Exception {
    WrongInputException(String s) {
        super(s);
    }
}
public class Input {
    void method() throws WrongInputException {
        throw new WrongInputException("Wrong input");
    }
}
class TestInput {
    public static void main(String[] args){
        try {
            new Input().method();
        }
        catch(WrongInputException wie) {
            System.out.println(wie.getMessage());
        }
    }
}