package semester2.chapter6.section_6_2.NestedClassExample;



//@todo: what effect does access modifier on method of static nested class have?


public class Class {

    private String toMentionInStaticInner;

    private void methodOuter(){
        System.out.println("coming from class");
    }


    public static class InsideClass{

        public void methodInner(){
            System.out.println("coming from public method of static nested class");
        }
    }

    private static class StaticInsideClass{
        private void methodInner(){
            System.out.println("coming from private method of static nested class");
        }
    }

    public static void main(String[] args) {
        new Class().methodOuter();

        new InsideClass().methodInner();

        new StaticInsideClass().methodInner();
    }
}



/*A non-static nested class in Java contains an implicit
reference to an instance of the parent class.
Thus to instantiate a NestOfBroom, you would need to also have an
instance of TopClass. In a static context (the main method),
there is no instance of TopClass to refer to. Thus the compiler
 indicates it can not construct a NestOfBroom.

If you make NestOfBroom a static class (or regular outer class),
then it will not need a reference to TopLevel and can be
 instantiated directly in the static main method.

 Source: http://stackoverflow.com/questions/13373779/non-static-class-cannot-be-referenced-from-a-static-context
 */