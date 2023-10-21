public class GastroDiseaseDetector implements PatternDetector{
    private StringBuilder sb;
    int idx = -1;
    @Override
    public int detect(GenomeAnalyzer analyzer) {
        boolean isStart = false;
        for(int i=0;i<analyzer.buffer.length();i++){
            char letter = analyzer.buffer.charAt(i);
            if(letter == 'G' && !isStart){
                sb = new StringBuilder("G");
                idx = i;
                isStart = true;
            }else if(letter == 'T' && isStart){
                sb.append('T');
            }else if(letter == 'G' && isStart){
                sb.append("G");
                if(sb.length()>=3){
                    return idx;
                }else{
                    sb = new StringBuilder("G");
                    idx = i;
                }
            }else if(letter == 'T' && !isStart){
                // Do nothing
            }
            else{
                idx = -1;
                isStart = false;
            }
        }
        sb = new StringBuilder();
        return -1;
    }

    @Override
    public String labelString() {
        return "GastroDisease";
    }

    @Override
    public String additionalInfo() {
        // Print out the detected pattern
        // GTTTTTTG  GTG

        return sb.isEmpty()? "" : sb.toString() + " is detected at pos " + idx;
    }

}
