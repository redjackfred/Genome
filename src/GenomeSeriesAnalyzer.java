import java.util.ArrayList;

public class GenomeSeriesAnalyzer extends GenomeAnalyzer {
    ArrayList<PatternDetector> list = new ArrayList<>();

    /**
     * just get the input
     *
     * @param fileName
     */
    public GenomeSeriesAnalyzer(String fileName) {
        super(fileName);

    }

    public void addDetector() {
        list.add(new GeniusDetector());
        list.add(new GastroDiseaseDetector());
        list.add(new RepeaterDetector('G',5));
    }

    public void run() {
        addDetector();
        for (PatternDetector detector : list) {
            int pos = detector.detect(this);
            if (pos != -1) {
                System.out.println(detector.labelString() + " detected at " + pos);
            } else {
                System.out.println(detector.labelString() + " not detected!");
            }
            System.out.println(detector.additionalInfo());
        }
    }

}
