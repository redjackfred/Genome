import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * GenomeAnalyzer provides basics of analyzing a string of DNA
 */
public class GenomeAnalyzer {

    static final String genCodeLetters ="GTAC";
    protected String buffer;

    protected String getBuffer() {
        return buffer;
    }

    /**
     * just get the input
     * @param fileName
     */
    public GenomeAnalyzer(String fileName){

        getInput(fileName);
    }

    /**
     * Reads given file into the data member buffer
     *
     * @param fileName name of file to parse
     */
    private void getInput(String fileName)  {
        try {
            Path filePath = Paths.get(fileName);
            byte[] allBytes = Files.readAllBytes(filePath);
            buffer = new String (allBytes);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    /**
     * check that all letters in buffer are valid (GTAC)
     * @return true if valid
     */
    private boolean validCode(){
        for (int i=0;i<buffer.length();i++){
            char c = buffer.charAt(i);
            if (genCodeLetters.indexOf(c)== -1)
                return false;
        }
        return true;
    }

    /**
     * Given any string, see if it is in buffer
     * @param seq the string we're looking for
     * @return the index of seq, or -1 if not found
     */
    protected int findSimpleSequence(String seq){
        return (buffer.indexOf(seq));

    }

    /**
     * Here is a sample use of findSimpleSequence
     * @return the index of GAC, or -1 if not found
     */
    public int findGACSequence(){

        return findSimpleSequence("GAC");
    }

    /**
     * test code for the methods
     * @param args
     */
    public static void main(String args[]){
        GenomeAnalyzer gSequencer= new GenomeAnalyzer("test.txt");
        if (gSequencer.validCode()){
            System.out.println("valid DNA");
        } else {
            System.out.println("code not valid DNA");
        }

        int pos=gSequencer.findGACSequence();
        if (pos!=-1){
            System.out.println("GAC at:"+pos);
        }
        else {
            System.out.println("GAC not found");
        }

    }

}