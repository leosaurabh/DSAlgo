import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PartitionParser {

    public static void main(String args[]) throws Exception{
        try {
            Map<Double, Double> tsToTimeTakenMap = new ConcurrentHashMap<Double, Double>();
            String reportFile = "/Users/ss030277/Desktop/files";
            File fileList = new File(reportFile);

            StringBuilder stringBuilder;
            if (fileList.isDirectory()) {
                for (File file:fileList.listFiles()) {
                    if (file.getName().equalsIgnoreCase(".ds_store")) {
                        continue;
                    }

                    //                    stringBuilder = new StringBuilder();
                    //                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    //                    String line;
                    //                    while((line = bufferedReader.readLine()) != null) {
                    //                        stringBuilder.append(line);
                    //                    }
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(file);

                    doc.getDocumentElement().normalize();

                    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                    NodeList nList = doc.getElementsByTagName("prx:measurementRecord");

                    System.out.println("----------------------------");

                    for (int temp = 0; temp < nList.getLength(); temp++) {

                        Node nNode = nList.item(temp);

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element eElement = (Element) nNode;

                            String apiName = eElement.getElementsByTagName("prx:name").item(0).getTextContent();
                            if (apiName.indexOf("acadia:loadMedsByEncounter") > 0) {
                                String createTime =  eElement.getElementsByTagName("prx:createTime").item(0).getTextContent();
                                String startTime = eElement.getElementsByTagName("prx:startTime").item(0).getTextContent();
                                String stopTime = eElement.getElementsByTagName("prx:stopTime").item(0).getTextContent();
                                double ts = getSecs(createTime);
                                double timeTaken = convertToAge(startTime, stopTime);
                                tsToTimeTakenMap.put(ts, timeTaken);
                            }
                        }
                    }
                }
            }
            System.out.println(tsToTimeTakenMap.keySet());
            System.out.println(tsToTimeTakenMap.values());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double convertToAge(String startTime, String stopTime) {
        DateTime startDtTm = convertToDateTime(startTime, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateTime endDtTm = convertToDateTime(stopTime, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return ((double) endDtTm.getMillis() - (double) startDtTm.getMillis())/1000.00;
    }

    private static double getSecs(String time) {
        DateTime startDtTm = convertToDateTime(time, "yyyy-MM-dd'T'HH:mm'Z'");
        return ((double) startDtTm.getMillis())/1000.00;
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
