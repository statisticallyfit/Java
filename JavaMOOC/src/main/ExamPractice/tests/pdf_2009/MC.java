package main.ExamPractice.tests.pdf_2009;




public class MC {


    public static String goAgain(String str, int index){
        if(index >= str.length())
            return str;

        return str + goAgain(str.substring(index), index + 1);
    }


    public void changeIt(int[] list, int num){
        //making a new array out of the copy does not change it when array comes out of changeIt() call
        list = new int[5];
        num = 0;

        for(int x = 0; x < list.length; x++)
            list[x] = 0;
    }

    public void start(){
        int[] nums = {1, 2, 3, 4, 5};
        int value = 6;

        changeIt(nums, value);

        for(int k = 0; k < nums.length; k++)
            System.out.print(nums[k] + " ");

        System.out.print(value);
    }

    public static void main(String[] args) {
        System.out.println(goAgain("today", 1));
    }
}
