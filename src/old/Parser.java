import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import nu.xom.Nodes;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Parser {

    Map<Long, Double> tsToTimeTakenMap = new TreeMap<Long, Double>();
    Map<Long, String> tsToApiName = new TreeMap<Long, String>();

    /**
     * @param args
     */
    public static void main(String[] args) throws ValidityException, ParsingException, IOException {
        Parser p = new Parser();

        String reportFile = "/Users/ss030277/Desktop/Encounter_10_100/xmls";
        File fileList = new File(reportFile);

        if (fileList.isDirectory()) {
            for (File file : fileList.listFiles()) {
                if (file.getName().equalsIgnoreCase(".ds_store")) {
                    continue;
                }
                System.out.println(file.getName());
                Builder builder = new Builder();
                InputStream ins = new FileInputStream(file);
                Document doc = builder.build(ins);
                p.traverse(doc);
            }
        }
        System.out.println(p.tsToTimeTakenMap.keySet());
        System.out.println(p.tsToTimeTakenMap.values());
        System.out.println(p.tsToApiName);
//        Map<Long, Double> tsTimeMap = modifyMap(p.tsToTimeTakenMap);
//        System.out.println(tsTimeMap.keySet());
//        System.out.println(tsTimeMap.values());
//        System.out.println(tsTimeMap.size());
    }


    public void traverse(Document doc) {
        Element root = doc.getRootElement();

        // Get children
        Elements students = root.getChildElements();
        Element nameChild = null;
        for (int i = 0; i < students.size(); i++) {
            Element element = students.get(i);
            nameChild = element.getFirstChildElement("name");

            if (nameChild != null && nameChild.getValue() != null
                    && nameChild.getValue().indexOf("acadia:") > 0) {
                String name = nameChild.getValue();
                String startTime = "";
                String stopTime = "";

//                nameChild = element.getFirstChildElement("createTime");
//                if (nameChild != null) {
//                    createTime = nameChild.getValue();
//                }

                nameChild = element.getFirstChildElement("startTime");
                if (nameChild != null) {
                    startTime = nameChild.getValue();
                }

                nameChild = element.getFirstChildElement("stopTime");
                if (nameChild != null) {
                    stopTime = nameChild.getValue();
                }

                long ts = getSecs(stopTime);
                double timeTaken = convertToAge(startTime, stopTime);

                this.tsToTimeTakenMap.put(ts, timeTaken);
                this.tsToApiName.put(ts, name);
            }
        }
    }

    private void applyXpath(Document doc) {
        Element root = doc.getRootElement();
        Nodes result = root.query("/students/student[name[@rel=\"second\"]]/@href");
        System.out.println(result.get(0).getValue());
    }

    private static Map<Long, Double> modifyMap(Map<Long, Double> tsToTimeTakenMap) {
        Map<Long, Double> tsTimeMap = new TreeMap<Long, Double>();
        long lastTime = 0;

        for (Map.Entry<Long, Double> tsEntry: tsToTimeTakenMap.entrySet()) {
            long ts = tsEntry.getKey();
            double timeTaken = tsEntry.getValue();

            if (tsTimeMap.isEmpty()) {
                tsTimeMap.put(lastTime, timeTaken);
            } else {
                tsTimeMap.put(ts - lastTime, timeTaken);
            }
            lastTime = ts;
        }
        return tsTimeMap;
    }

    private static double convertToAge(String startTime, String stopTime) {
        DateTime startDtTm = convertToDateTime(startTime, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateTime endDtTm = convertToDateTime(stopTime, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return ((double) endDtTm.getMillis() - (double) startDtTm.getMillis())/1000.00;
    }

    private static long getSecs(String time) {
        DateTime startDtTm = convertToDateTime(time, "yyyy-MM-dd'T'HH:mm'Z'");
        return startDtTm.getMillis();
    }

    private static DateTime convertToDateTime(String date, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format);
        DateTime returnDateTime;
        try {
            returnDateTime = DateTime.parse(date, dateTimeFormatter);
        } catch (Exception excp) {
            returnDateTime = new DateTime(Instant.now());
        }
        return returnDateTime;
    }

}