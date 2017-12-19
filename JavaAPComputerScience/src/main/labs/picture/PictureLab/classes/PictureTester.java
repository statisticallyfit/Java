package labs.picture.PictureLab.classes;


/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

    /* To test Exercise 3 */
    public static void testKeepOnlyBlue(){
        Picture beach = new Picture("images/beach.jpg");
        beach.explore();
        beach.keepOnlyBlue();
        beach.explore();
    }


    /* To test exercise 4 */
    public static void testNegate(){
        Picture butterfly = new Picture("images/butterfly1.jpg");
        butterfly.explore();
        butterfly.negate();
        butterfly.explore();
    }


    /* To test Exercise 5 */
    public static void testGrayScale(){
        Picture redMotorcycle = new Picture("images/redMotorcycle.jpg");
        redMotorcycle.explore();
        redMotorcycle.grayScale();
        redMotorcycle.explore();
    }


    /* Test Exercise 6 */
    public static void testFixUnderwater(){
        Picture water = new Picture("images/water.jpg");
        water.explore();
        water.fixUnderwater();
        water.explore();
    }



  /** Method to test mirrorVerticalLeftToRight */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("images/seagull.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalLeftToRight();
    caterpillar.explore();
  }

    /* Test exercise 1 */
    public static void testMirrorVerticalRightToLeft(){
        Picture pic = new Picture("images/jean_cat_backwards2.jpg");
        pic.explore();
        pic.mirrorVerticalRightToLeft();
        pic.explore();
    }

    /* Test exercise 2 */
    public static void testMirrorHorizontal(){
        Picture pic = new Picture("images/redMotorcycle.jpg");
        pic.explore();
        pic.mirrorHorizontal();
        pic.explore();
    }

    /* Test exercise 3 */
    public static void testMirrorHorizontalBotToTop(){
        Picture pic = new Picture("redMotorcycle.jpg");
        pic.explore();
        pic.mirrorHorizontalBotToTop();
        pic.explore();
    }

    /* Test Exercise 4 */
    public static void testMirrorDiagonal(){
        Picture pic = new Picture("images/beach.jpg");
        pic.explore();
        pic.mirrorDiagonalLeftToRight();
        pic.explore();
    }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

    /* Test exercise 1 */
    public static void testMirrorArms(){
        Picture pic = new Picture("images/snowman.jpg");
        pic.explore();
        pic.mirrorArms();
        pic.explore();
    }

    public static void testMirrorGull(){
        Picture pic = new Picture("images/seagull.jpg");
        pic.explore();
        pic.mirrorGull();
        pic.explore();
    }

    public static void testCopy(){
        Picture pic = new Picture("images/seagull.jpg");
        pic.explore();
        pic.copy(new Picture("images/butterfly1.jpg"), 50, 30);
        pic.explore();
    }


    //Exercise 1 test
    public static void testCopy2(){
        Picture pic = new Picture("images/640x480.jpg");
        Picture fromPic = new Picture("images/jean_cat_backwards2.jpg");
        pic.explore();
        pic.copy2(fromPic, 0, 0,
                0, fromPic.getHeight(), fromPic.getWidth(), 0);
        pic.explore();
    }

    public static void testCopyCat(){
        Picture pic = new Picture("/images/640x480.jpg");
        Picture fromPic = new Picture("/images/jean_cat_backwards2.jpg");
        pic.explore();
        pic.copyCat(fromPic, 0, 0,
                0, fromPic.getHeight(), fromPic.getWidth(), 0);
        pic.explore();
    }

  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("images/640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

    //Exercise 2 activity 8
    public static void testMyCollage(){
        Picture canvas = new Picture("images/640x480.jpg");
        canvas.myCollage();
        canvas.explore();
    }

  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("images/swan.jpg");
    swan.explore();
    swan.edgeDetection2(10);
    swan.explore();
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayScale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
      //testMirrorHorizontal();
      //testMirrorHorizontalBotToTop();
      //testMirrorVerticalRightToLeft();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
      //testCopy2();
      testCopyCat();
      //testMyCollage();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}