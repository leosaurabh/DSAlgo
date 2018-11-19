import org.joda.time.Instant;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class PerformanceTest {

    public static long startTime;

    public static void main(String args[]) {

        try {
            String fileName = "/Users/ss030277/Documents/workspace/MillenniumPlus/Apache-Bench/logs/logs";

            File logFile = new File(fileName + ".txt");

            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(logFile, true));

            startTime = System.currentTimeMillis();
            buffWrite.write("\nStart Time>>" + new Instant(startTime).toString() + "\n");

            LogData logData = new LogData();
            long threadCount = 10l;
            logData.constantToCount.put(999, 0l);

            for (int threadId = 0; threadId < threadCount; threadId++) {
                long tempCount = logData.constantToCount.get(999);
                logData.constantToCount.put(999, ++tempCount);
                if (logFile.length() > 100000000l) {
                    logFile = new File(fileName + threadId + ".txt");
                    buffWrite = new BufferedWriter(new FileWriter(logFile));
                }
//                int sleepTime = getRandomSleep(random);
                Thread.sleep(threadCount - threadId);
                new PerformanceThread(threadId, buffWrite, logData).start();
            }
            buffWrite.write("\nEnd Time>>" + new Instant(System.currentTimeMillis()).toString() +
                    " Total elapse time:" + ((double) (System.currentTimeMillis() - startTime)) / 1000.00 + "\n\n");
            buffWrite.flush();

            while (true) {
                if (logData.constantToCount.get(999) == 0) {
                    System.out.println("X->" + logData.timeElapsedToTimeTakenMap.keySet());
                    System.out.println("Y->" + logData.timeElapsedToTimeTakenMap.values());
                    break;
                }
            }
            buffWrite.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    private static long getSessionId() throws Exception{
//        Process proc = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST",
//                "-d",
//                "{\"sessionId\":0,"
//                        + "\"encounterId\":1911990,\"personId\":2100035,\"anchorDateTime\":\"2015-03-31T00:00:00Z\",\"lookForwardHours\":2}\n"
//                , "-u", "sj9511@deveng:redwings",
//                "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/medication/retrieval/encounter")
//                .start();
//
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//
//        //        long startTime = System.currentTimeMillis();
//        String line;
//        StringBuilder stringBuilder = new StringBuilder();
//        while((line = bufferedReader.readLine()) != null) {
//            stringBuilder.append(line);
//        }
//
//        return getSessionId(stringBuilder.toString());
//    }
//
//    private static long getSessionId(String str) throws Exception {
//        Object session = getObject(str, "sessionId");
//        if (session == null) {
//            return -1;
//        }
//        return (Long) session;
//    }
//
//    private static Object getObject(String output, String key){
//        Object obj;
//        try {
//            JSONParser parser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) parser.parse(output);
//            obj = jsonObject.get(key);
//        } catch(Exception ex) {
//            obj = null;
//        }
//        return obj;
//    }
}
