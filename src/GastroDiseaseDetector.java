public class GastroDiseaseDetector implements PatternDetector{
    private StringBuilder sb = new StringBuilder("G");
    int idx = -1;
    @Override
    public int detect(GenomeAnalyzer analyzer) {
        boolean isStart = false;
        for(int i=0;i<analyzer.buffer.length();i++){
            char letter = analyzer.buffer.charAt(i);
            if(letter == 'G' && !isStart){
                idx = i;
                isStart = true;
            }else if(letter == 'T' && isStart){
                sb.append('T');
                continue;
            }else if(letter == 'G' && isStart){
                sb.append("G");
                if(sb.length()>=3){
                    return idx;
                }else{
                    sb = new StringBuilder("G");
                    idx = i;
                }
            }else{
                sb = new StringBuilder("G");
                idx = -1;
                isStart = false;
            }
        }
        return idx;
    }

    @Override
    public String labelString() {
        return "GastroDisease";
    }

    @Override
    public String additionalInfo() {
        // Print out the detected pattern
        // GTTTTTTG  GTG

        return sb.toString() + " is detected at pos: " + idx;
    }

}
