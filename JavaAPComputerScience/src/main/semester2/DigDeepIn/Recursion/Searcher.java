package semester2.DigDeepIn.Recursion;

public class Searcher{

    /** Recursively search array for key.
     * @param a the array of String objects
     * @param key a String object
     * @return true if a[k] equals key for 0 <= k < a.length;
     * false otherwise
     */

    public boolean search(String[] a, String key){
        return recurSearch(a, 0, key);
    }

    /** THIS IS A PRIVATE HELPER METHOD
     * Recursively search array a for key, starting at startIndex.
     * Precondition:
     * - a contains at least one element.
     * - 0 <= startIndex <= a.length
     * @return true if a[k] equals key for 0 <= k < a.length;
     * false otherwise
     * */

    private boolean recurSearch(String[] a, int startIndex, String key){
        if(startIndex == a.length){ //base case. key was not found
            return false;
        } else if(a[startIndex].compareTo(key) == 0){ //base case key was found
            return true;
        } else{
            return recurSearch(a, startIndex + 1, key);
        }
    }


    public static void main(String[] args) {
        String[] list = {"Mary", "Joe", "Lee", "Jake"};
        Searcher s = new Searcher();
        System.out.println("Enter key: Mary, Joe, Lee or Jake");
        String key = IO.readString();
        boolean result = s.search(list, key);
        if(!result)
            System.out.println(key + " was not found.");
        else
            System.out.println(key + " was found.");
    }
}
