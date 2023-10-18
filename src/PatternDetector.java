public interface PatternDetector {
    abstract int detect(GenomeAnalyzer analyzer);
    abstract String labelString();
    abstract String additionalInfo();
}
