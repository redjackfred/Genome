public class GeniusDetector implements PatternDetector{
    private int idx = -1;
    @Override
    public int detect(GenomeAnalyzer analyzer) {
        // Find exact pattern in analyzer.buffer
        this.idx = analyzer.buffer.indexOf("GAGA");
        return this.idx;
    }

    @Override
    public String labelString() {
        return "Genius is";
    }

    @Override
    public String additionalInfo() {
        return this.idx!=-1 ? "GAGA is detected at pos " + this.idx : "";
    }
}
