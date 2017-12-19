

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

    /* Exercise 3 */
    public void keepOnlyBlue(){
        Pixel[][] pixels = this.getPixels2D();

        for(Pixel[] rowArray : pixels){
            for(Pixel pixelObj : rowArray){
                if(!pixelObj.getColor().equals(Color.blue)){
                    pixelObj.setRed(0);
                    pixelObj.setGreen(0);
                }
            }
        }
    }


    /* Exercise 4 */
    public void negate(){
        Pixel[][] pixels = this.getPixels2D();

        for(Pixel[] rowArray : pixels){
            for(Pixel pixelObj : rowArray){
                //negate each pixel
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }


    /* Exercise 5 */
    public void grayScale(){
        Pixel[][] pixels = this.getPixels2D();

        for(Pixel[] rowArray : pixels){
            for(Pixel pixelObj : rowArray){
                int avgColor = (pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3;
                pixelObj.setRed(avgColor);
                pixelObj.setGreen(avgColor);
                pixelObj.setBlue(avgColor);
            }
        }
    }


    /* Challenge Bonus: Exercise 6 */
    public void fixUnderwater(){
        Pixel[][] pixels = this.getPixels2D();

        for(int r = 0; r < pixels.length; r++){
            for(int c = 0; c < pixels[0].length; c++){
                Pixel pixelObj = pixels[r][c];
                pixelObj.setRed(pixelObj.getRed() * 4);
            }
        }

    }

  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVerticalLeftToRight()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

    /* Exercise 1 */
    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length / 2; col++){
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][pixels[0].length - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /* Exercise 2 */
    public void mirrorHorizontal(){
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;

        for (int row = 0; row < pixels.length / 2; row++) {
            for (int col = 0; col < pixels[0].length; col++){
                topPixel = pixels[row][col];
                bottomPixel = pixels[pixels.length - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }


    /* Exercise 3 */
    public void mirrorHorizontalBotToTop(){
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;

        for (int row = 0; row < pixels.length / 2; row++) {
            for (int col = 0; col < pixels[0].length; col++){
                topPixel = pixels[row][col];
                bottomPixel = pixels[pixels.length - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }


    /* Exercise 4 */
    public void mirrorDiagonalLeftToRight(){
        Pixel[][] pixels = this.getPixels2D();
        Pixel topWingPixel = null;
        Pixel acrossWingPixel = null;

        for(int row = 0; row < pixels.length; row++){
            for(int col = 0; col < pixels.length; col++){
                topWingPixel = pixels[row][col];
                acrossWingPixel = pixels[col][row];
                topWingPixel.setColor(acrossWingPixel.getColor());
            }
        }
    }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
{
    int numTimesLoopExecutes = 0;
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
        // loop from 13 to just before the mirror point
        for (int col = 13; col < mirrorPoint; col++)
        {
            numTimesLoopExecutes++;
            leftPixel = pixels[row][col];
            rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
            rightPixel.setColor(leftPixel.getColor());
        }
    }
    System.out.println(numTimesLoopExecutes);
}


    /* Exercise 3 */
    public void mirrorGull(){

        int mirrorPoint = 211;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();


        for (int row = 231; row < 329; row++) {
            for (int col = 345; col >= mirrorPoint; col--){
                rightPixel = pixels[row][col];
                leftPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }


    /* Exercise 1 from Mirroring snowman arms */
    public void mirrorArms(){
        int mirrorPoint = 193;
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;

        //do the left arm
        for(int row = 158; row < mirrorPoint; row++){
            for(int col = 101; col < 172; col++){
                topPixel = pixels[row][col];
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }

        //do right arm
        mirrorPoint = 197;
        for(int row = 170; row < mirrorPoint; row++){
            for(int col = 238; col < 295; col++){
                topPixel = pixels[row][col];
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, int startRow, int startCol) {

    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();

    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length && toRow < toPixels.length;
         fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

    //Exercise 1 from activity 8
    public void copy2(Picture fromPic, int startToRow, int startToCol,
                      int startFromRow, int endFromRow, int startFromCol, int endFromCol) {

        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();

        for (int fromRow = startFromRow, toRow = startToRow;
             fromRow < endFromRow && toRow < toPixels.length;
             fromRow++, toRow++)
        {
            for (int fromCol = startFromCol, toCol = startToCol;
                 fromCol < endFromCol && toCol < toPixels[0].length;
                 fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }


    public void copyCat(Picture fromPic, int startToRow, int startToCol,
                      int startFromRow, int endFromRow, int startFromCol, int endFromCol) {

        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();

        for (int fromRow = startFromRow, toRow = startToRow;
             fromRow < endFromRow && toRow < toPixels.length;
             fromRow++, toRow++)
        {
            for (int fromCol = startFromCol, toCol = startToCol;
                 fromCol > endFromCol && toCol < toPixels[0].length;
                 fromCol--, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVerticalLeftToRight();
    this.write("collage.jpg");
  }

    //Exercise 2 activity 8
    public void myCollage(){
        //create cat picture and flower pic
        Picture cat = new Picture("mine_halfcat.jpg");
        Picture blueFlower = new Picture("mine_forgetnot.jpg");
        Picture pinkFlower = new Picture("mine_rose.jpg");

        //first flower
        for(int rowLevel = 0; rowLevel <= this.getHeight(); rowLevel += blueFlower.getHeight()){
            this.copy(blueFlower, rowLevel, 0);
        }
        //second flower
        for(int colLevel = 0; colLevel <= this.getWidth(); colLevel += pinkFlower.getWidth()) {
            this.copy(pinkFlower, this.getHeight() - pinkFlower.getHeight(), colLevel);
        }

        this.mirrorDiagonalLeftToRight(); //manipulation 3
        cat.mirrorVerticalRightToLeft(); //manipulation 1
        this.copy(cat, 134, 100); //manipulation 2
    }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */

  public void edgeDetection(int edgeDist) {
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel bottomPixel = null;
      Pixel topPixel = null;

      Pixel[][] pixels = this.getPixels2D();
      Color rightColor = null;
      Color bottomColor = null;

      for (int row = 0; row < pixels.length - 1; row++) {
          for (int col = 0; col < pixels[0].length - 1; col++) {

              leftPixel = pixels[row][col];
              rightPixel = pixels[row][col + 1];
              rightColor = rightPixel.getColor();
              if (leftPixel.colorDistance(rightColor) > edgeDist)
                  leftPixel.setColor(Color.BLACK);
              else
                  leftPixel.setColor(Color.WHITE);
          }
      }
  }

    public void edgeDetection2(int edgeDist)
    {
        Picture copy = new Picture(this);
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        // compare a pixel with one to the right of it
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length-1; col++) {

                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist) {
                    leftPixel.setColor(Color.BLACK);
                }
                else {
                    leftPixel.setColor(Color.WHITE);
                }
            }
        }
        // now compare a pixel with the one below it
        Pixel[][] copyPixels = copy.getPixels2D();
        Pixel topPixel = null;
        Pixel botPixel = null;
        Color botColor = null;
        for (int row = 0; row < copyPixels.length-1; row++) {
            for (int col = 0; col < copyPixels[0].length; col++) {
                topPixel = copyPixels[row][col];
                botPixel = copyPixels[row+1][col];
                botColor = botPixel.getColor();
                if (topPixel.colorDistance(botColor) > edgeDist)
                {
                    pixels[row][col].setColor(Color.BLACK);
                }
            }
        }
    }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture pic = new Picture("snowman.jpg");
    pic.explore();
    //pic.mirrorTemple();
    //pic.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
