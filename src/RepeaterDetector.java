import java.util.ArrayList;

public class RepeaterDetector implements PatternDetector{
    private char targetLetter;
    private int targetTimes;
    private StringBuilder sb = new StringBuilder();
    private int idx = -1;

    public RepeaterDetector(char letter, int times){
        this.targetLetter = letter;
        this.targetTimes = times;
    }

    @Override
    public int detect(GenomeAnalyzer analyzer) {
        boolean isRepeat = false;
        int count = 0;
        for(int i=0;i<analyzer.buffer.length();i++){
            char letter = analyzer.buffer.charAt(i);
            if(letter==this.targetLetter && !isRepeat){
                idx = i;
                isRepeat = true;
                count++;
                this.sb.append(this.targetLetter);
            }else if(letter==this.targetLetter && isRepeat){
                count++;
                this.sb.append(this.targetLetter);
            }else{
                isRepeat = false;
                count = 0;
                this.sb = new StringBuilder();
            }

            if(count == 5){
                return idx;
            }
        }
        return idx;
    }

    @Override
    public String labelString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<this.targetTimes;i++){
            sb.append(targetLetter);
        }
        return "Repeated letters is";
    }

    @Override
    public String additionalInfo() {
        return this.sb.toString() + " is detected at pos " + this.idx;
    }

    public void findSimpleSequence(){

    }
}
