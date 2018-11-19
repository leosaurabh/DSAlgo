import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PerformanceThread extends Thread {

    private int threadId;
    private BufferedWriter buffWrite;
    private long sessionId;
    private LogData logData;

    public PerformanceThread(int threadId, BufferedWriter buffWrite, LogData logdata) {
        this.threadId = threadId;
        this.buffWrite = buffWrite;
        this.logData = logdata;
    }

    public void run(){
        try {
            for (int x = 0; x < 100; x ++) {
                Process process;
                process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST",
                        "-d",
                        "{\"sessionId\":0,"
                                + "\"encounterId\":1911990,\"personId\":2100035,\"anchorDateTime\":\"2015-03-31T00:00:00Z\",\"lookForwardHours\":2}\n"
                        , "-u", "sj9511@deveng:redwings",
                        "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/medication/retrieval/encounter")
                        .start();
                printOutput(process, "tasks_by_encounter", x);
                process.destroy();

//                if (this.sessionId > 0) {
//                    process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST", "-d",
//                            "{\"sessionId\":" + this.sessionId +
//                                    ",\"encounterId\":1911990,\"taskIdList\":[\"67979849\",\"67971195\",\"67971197\",\"67971199\",\"70099607\", \"70099611\"]} "
//                            , "-u", "sj9511@deveng:redwings",
//                            "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/medication/retrieval/task")
//                            .start();
//                    printOutput(process, "task_load_session", x);
//                    process.destroy();
//
//                    process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST", "-d",
//                            "{\"sessionId\":\"" + this.sessionId +
//                                    "\",\"warningProcessFlags\" : {\"nurseReview\": false,\"medInterval\" : false,"
//                                    + "\"late\" : true,\"needPharmacyVerification\" : false,\"staleCheck\" : false}}"
//                            , "-u", "sj9511@deveng:redwings",
//                            "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/scratchpad/task-state/warning")
//                            .start();
//                    printOutput(process, "task_state_warnings", x);
//                    process.destroy();
//
//                    process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST", "-d",
//                            "{\"sessionId\":\"" + this.sessionId +
//                                    "\",\"personId\":\"2100035\",\"taskIdList\":[67979849,67971195,67971197,67971199,70099607, 70099611],"
//                                    + "\"warningProcessFlags\" : {\"nurseReview\": false,\"medInterval\" : false,"
//                                    + "\"late\" : true,\"needPharmacyVerification\" : false,\"staleCheck\" : false}}"
//                            , "-u", "sj9511@deveng:redwings",
//                            "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/scratchpad/task-state/warning")
//                            .start();
//                    printOutput(process, "task_state_warnings_from_list", x);
//                    process.destroy();





//                    process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST", "-d",
//                            "{\"sessionId\":" + this.sessionId +
//                                    ",\"activationStates\" : [{\"taskId\": 67971197,\"activateTask\" : true,\"keepPreppedData\" : true}]}"
//                            , "-u", "sj9511@deveng:redwings",
//                            "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/scratchpad/task-state/activation")
//                            .start();
//                    printOutput(process, "task_activation_67971197", x);
//
//                    process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST", "-d",
//                            "{\"sessionId\":" + this.sessionId +
//                                    ",\"activationStates\" : [{\"taskId\": 67971195,\"activateTask\" : true,\"keepPreppedData\" : true}]}"
//                            , "-u", "sj9511@deveng:redwings",
//                            "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/scratchpad/task-state/activation")
//                            .start();
//                    printOutput(process, "task_activation_67971195", x);
//
//                    process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST", "-d",
//                            "{\"sessionId\":" + this.sessionId +
//                                    ",\"activationStates\" : [{\"taskId\": 67979849,\"activateTask\" : true,\"keepPreppedData\" : true}]}"
//                            , "-u", "sj9511@deveng:redwings",
//                            "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/scratchpad/task-state/activation")
//                            .start();
//                    printOutput(process, "task_activation_67979849", x);
//
//                    process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST", "-d",
//                            "{\"sessionId\":" + this.sessionId +
//                                    ",\"activationStates\" : [{\"taskId\": 67971199,\"activateTask\" : true,\"keepPreppedData\" : true}]}"
//                            , "-u", "sj9511@deveng:redwings",
//                            "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/scratchpad/task-state/activation")
//                            .start();
//                    printOutput(process, "task_activation_67971199", x);
//
//                    process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST", "-d",
//                            "{\"sessionId\":" + this.sessionId +
//                                    ",\"activationStates\" : [{\"taskId\": 70099607,\"activateTask\" : true,\"keepPreppedData\" : true}]}"
//                            , "-u", "sj9511@deveng:redwings",
//                            "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/scratchpad/task-state/activation")
//                            .start();
//                    printOutput(process, "task_activation_70099607", x);

//                    process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST", "-d",
//                            "{\"organizationId\" : 589723,"
//                                    + "\"barcodeData\" : \"55390002701\",\"allowedBarcodeTypes\" : {\"medication\" : true},\"medCriteria\" : {\"encounterId\" : 1911990,\"sessionId\":"
//                                    + this.sessionId + "}}"
//                            , "-u", "sj9511@deveng:redwings",
//                            "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/workflow/barcode/process")
//                            .start();
//                    printOutput(process, "proces_barcode", x);

//                    process = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST", "-d",
//                            "{\"sessionId\":" + this.sessionId + "}"
//                            , "-u", "sj9511@deveng:redwings",
//                            "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/scratchpad/clear/all")
//                            .start();
//                    printOutput(process, "clear_state", x);
//                    process.destroy();
//                }
//                double actualTime = this.executionTime ;
//                double elapsedTime = ((double) (System.currentTimeMillis() - beginTime))/1000.00;
//                this.logData.timeElapsedToTimeTakenMap.put(elapsedTime, actualTime);
                this.buffWrite.write("\nThread Id: " + this.threadId + " Iteration: " + x + "\n" +
                        "\nThreadCount: " + this.logData.constantToCount.get(999) + "time:" +
                        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) + "\n");
                this.buffWrite.flush();
            }
            long tempCount = this.logData.constantToCount.get(999);
            this.logData.constantToCount.put(999, --tempCount);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void printOutput(Process proc, String name, int iter) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        if (name.equalsIgnoreCase("tasks_by_encounter")) {
            this.sessionId = getSessionId(stringBuilder.toString(), iter, name);
        } else if (name.equalsIgnoreCase("task_load_session")) {
            checkSessionId(stringBuilder.toString(), iter, name);
        } else if (name.contains("task_activation") || name.equalsIgnoreCase("clear_state") ||
                name.equalsIgnoreCase("task_state_warnings") || name.equalsIgnoreCase("task_state_warnings_from_list")) {
            checkSuccess(stringBuilder.toString(), iter, name);
        } else if (name.equalsIgnoreCase("proces_barcode")) {
            checkBarcodeType(stringBuilder.toString(), iter, name);
        }
    }

    private long getSessionId(String str, int iter, String name) throws Exception {
        Object session = getObject(str, "sessionId");
        if (session == null) {
            this.buffWrite.write("\nNo session id obtained for " + name + " thread " + this.threadId + " and iteration " + iter + "\n" + str + "\n");
            return -1;
        }
        return (Long) session;
    }

    private void checkSessionId(String str, int iter, String name) throws Exception {
        Object session = getObject(str, "sessionId");
        if (session == null) {
            this.buffWrite.write("\nNo session id obtained for " + name + " thread " + this.threadId + " and iteration " + iter + "\n");
//            this.sessionId = getSessionId();
        }
    }

    private void checkSuccess(String str, int iter, String name) throws Exception {
        Object status = getObject(str, "success");
        if (status == null || !((Boolean) status)) {
            this.buffWrite.write("\nCall did not succeed for " + name + " thread " + this.threadId + " and iteration " + iter + "\n");
        }
    }

    private void checkBarcodeType(String str, int iter, String name) throws Exception {
        Object type = getObject(str, "barcodeType");
        if (type == null) {
            this.buffWrite.write("\nUnable to retrieve barcodeType for " + name + " thread " + this.threadId + " and iteration " + iter + "\n");
        }
    }

    private Object getObject(String output, String key){
        Object obj;
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(output);
            obj = jsonObject.get(key);
        } catch(Exception ex) {
            try {
                this.buffWrite.write("\nERRRRRORRR Thread Id: " + this.threadId + "\n" +
                        "X-> " + this.logData.timeElapsedToTimeTakenMap.keySet() + "\nY-> "
                        + this.logData.timeElapsedToTimeTakenMap.values() + "\nThreadCount: " + this.logData.constantToCount.get(999) + "\n");
                obj = null;
            } catch (Exception exInternal) {
                exInternal.printStackTrace();
                obj = null;
            }
        }
        return obj;
    }

    private static long getSessionId() throws Exception{
        Process proc = new ProcessBuilder("curl", "-H", "Content-Type: application/json", "-X", "POST",
                "-d",
                "{\"sessionId\":0,"
                        + "\"encounterId\":1911990,\"personId\":2100035,\"anchorDateTime\":\"2015-03-31T00:00:00Z\",\"lookForwardHours\":2}\n"
                , "-u", "sj9511@deveng:redwings",
                "http://cerncnmappd07:8080/rest-med-admin/deveng.northamerica.cerner.net/service/medication/retrieval/encounter")
                .start();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        //        long startTime = System.currentTimeMillis();
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return getSessionId(stringBuilder.toString());
    }

    private static long getSessionId(String str) throws Exception {
        Object session = getObject(str, "sessionId", 1);
        if (session == null) {
            return -1;
        }
        return (Long) session;
    }

    private static Object getObject(String output, String key, int x){
        Object obj;
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(output);
            obj = jsonObject.get(key);
        } catch(Exception ex) {
            obj = null;
        }
        return obj;
    }
}
