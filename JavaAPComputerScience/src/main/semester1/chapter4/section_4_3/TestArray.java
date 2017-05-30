package semester1.chapter4.section_4_3;

/**
 * Created by user1928 on 11/21/14.
 */
public class TestArray {

    double [] myList = {1.9, 2.9, 3.4, 3.5};

    public void printMyList(){
        for(int i = 0; i < myList.length; i++){
            System.out.println("index " + i + "... " + myList[i]);
        }
    }

    public static void main(String[] args){
        TestArray testArray = new TestArray();

        testArray.printMyList();
    }
}
