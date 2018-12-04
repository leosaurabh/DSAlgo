import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogData {

    public Map<Integer, Double> threadIdToTimeTaken;
    public Map<Double, Double> timeElapsedToTimeTakenMap;
    public Map<Integer, Long> constantToCount;

    public LogData() {
        this.threadIdToTimeTaken = new ConcurrentHashMap<Integer, Double>();
        this.constantToCount = new ConcurrentHashMap<Integer, Long>();
        this.timeElapsedToTimeTakenMap = Collections.synchronizedMap(new LinkedHashMap<Double, Double>());
    }
}
