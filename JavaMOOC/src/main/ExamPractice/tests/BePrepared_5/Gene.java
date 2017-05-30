package main.ExamPractice.tests.BePrepared_5;


public class Gene {


    public static boolean isValidDNA(String str){

        for(int i = 0; i < str.length(); i++){
            String letter = str.substring(i, i + 1);
            if(!(letter.equals("A") || letter.equals("G") || letter.equals("C") || letter.equals("T")))
                return false;
        }
        return true;
    }

    public static int matchGenes(String dnaString, String[] genes){
        /*int sumOfGaps = 0;
        int[] indexPairs = new int[genes.length * 2];
        int iPair = 0;

        for(int i = 0; i < genes.length; i++){
            indexPairs[iPair] = dnaString.indexOf(genes[i]);
            indexPairs[iPair + 1] = indexPairs[iPair] + genes[i].length() - 1;
            iPair += 2;
        }

        for(int i = 0; i < indexPairs.length; i++){
            if(indexPairs[i] == -1)
                return -1;
        }

        for(int i = 0; i < indexPairs.length - 1; i++)
            if(i % 2 == 1)
                sumOfGaps += indexPairs[i + 1] - indexPairs[i] - 1;

        for(int i = 0; i <= indexPairs.length - 4; i += 2){
            if(!(indexPairs[i] < indexPairs[i + 2] && indexPairs[i + 1] < indexPairs[i + 2]))
                return -1;
        }
        return sumOfGaps;*/

        int sumOfGaps = 0;
        int startGapPos = 0;
        for(String gene : genes){
            int pos = dnaString.indexOf(gene);
            if(pos < startGapPos)
                return -1;
            if(startGapPos > 0)
                sumOfGaps += pos - startGapPos;
            startGapPos = pos + gene.length();
        }
        return sumOfGaps;
    }

    public static int encode(String dnaSegment){
        /*String binaryStr = "";

        for(int i = 0; i < dnaSegment.length(); i++){
            String letter = dnaSegment.substring(i, i + 1);
            if(letter.equals("A"))
                binaryStr += "00";
            else if(letter.equals("C"))
                binaryStr += "01";
            else if(letter.equals("G"))
                binaryStr += "10";
            else
                binaryStr += "11";
        }
        int j = 0;
        int code = 0;
        for(int exp = binaryStr.length() - 1; exp >= 0; exp--){
            if(binaryStr.substring(j, j + 1).equals("1"))
                code += (int)(Math.pow(2, exp));
            j++;
        }
        return code;*/

        int code = 0;
        for(int i = 0; i < dnaSegment.length(); i++){
            int k = "ACGT".indexOf(dnaSegment.substring(i, i + 1));
            code = 4 * code + k;
        }
        return code;
    }
}

class TestGenes{

    public static void main(String[] args) {

        if(Gene.matchGenes("GTACGTAATGACAGT", new String[] {"ACG", "AA", "ACA"}) != 3)
            System.err.println("Test 1 failed");
        if(Gene.matchGenes("GTACGTAATAAGACAGTAA", new String[] {"ACG", "AA", "ACA"}) != 5)
            System.err.println("Test 2 failed");
        if(Gene.matchGenes("GTACGAATAAGACAGTAA", new String[] {"ACG", "AA", "ACA"}) != 4)
            System.err.println("Test 3 failed");
        if(Gene.matchGenes("GTACGAAACAGTAA", new String[] {"ACG", "AA", "ACA"}) != 0)
            System.err.println("Test 4 failed");
        if(Gene.matchGenes("AATACGTAATGACAGT", new String[] {"ACG", "AA", "ACA"}) != -1)
            System.err.println("Test 5 failed");
        if(Gene.matchGenes("GTACGTAGGAACAGT", new String[] {"ACG", "AA", "ACA"}) != -1)
            System.err.println("Test 6 failed");
        if(Gene.matchGenes("GTACGTATTGACAGT", new String[] {"ACG", "AA", "ACA"}) != -1)
            System.err.println("Test 7 failed");

        //Testing encode
        {
            if(Gene.encode("GATCCGTA") != 36204)
                System.err.println("Test 1 failed");
        }
    }
}
