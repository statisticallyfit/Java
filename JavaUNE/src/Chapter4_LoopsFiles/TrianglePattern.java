package Chapter4_LoopsFiles;

/**
 *
 */
public class TrianglePattern {

    public static void main(String[] args){
        final int BASE_SIZE = 8;

        for(int r = 0; r < BASE_SIZE; r++){
            for(int c = 0; c < (r+1); c++){ //when r = 7, c goes up to c < 8 so prints 0..7 (8 stars) then r exits.
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
