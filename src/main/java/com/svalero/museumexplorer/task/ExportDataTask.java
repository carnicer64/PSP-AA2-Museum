package com.svalero.museumexplorer.task;

import com.svalero.museumexplorer.util.ZipCompressor;
import javafx.concurrent.Task;

import java.io.*;
import java.util.List;
import com.svalero.museumexplorer.model.Record;


public class ExportDataTask extends Task<Integer> {

    private List<Record> recordList;
    private File file;
    private static final String CSV_SEPARATOR = ";";

    public ExportDataTask(List<Record> records, File file){
        recordList = records;
        this.file = file;
    }

    @Override
    protected Integer call() throws Exception {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            StringBuilder line = new StringBuilder();
            line.append("Title" + CSV_SEPARATOR + "Classiffication" + CSV_SEPARATOR + "Period" + CSV_SEPARATOR + "Dated" + CSV_SEPARATOR + "Provenance" + CSV_SEPARATOR + "Division" + CSV_SEPARATOR + "CreditLine");
            bufferedWriter.write(line.toString());
            bufferedWriter.newLine();
            for (Record record: recordList) {
                line.delete(0, line.length());

                if(record.getTitle() != null){
                    line.append(record.getTitle());
                    line.append(CSV_SEPARATOR);
                } else {
                    line.append("NO TITLE");
                    line.append(CSV_SEPARATOR);
                }

                if(record.getClassification() != null){
                    line.append(record.getClassification());
                    line.append(CSV_SEPARATOR);
                } else {
                    line.append("NO CLASSIFICATION");
                    line.append(CSV_SEPARATOR);
                }

                if(record.getPeriod() != null){
                    line.append(record.getPeriod());
                    line.append(CSV_SEPARATOR);
                } else {
                    line.append("NO PERIOD");
                    line.append(CSV_SEPARATOR);
                }

                if(record.getDated() != null){
                    line.append(record.getDated());
                    line.append(CSV_SEPARATOR);
                } else {
                    line.append("NO DATED");
                    line.append(CSV_SEPARATOR);
                }

                if(record.getProvenance() != null){
                    line.append(record.getProvenance());
                    line.append(CSV_SEPARATOR);
                } else {
                    line.append("NO PROVENANCE");
                    line.append(CSV_SEPARATOR);
                }

                if(record.getDivision() != null){
                    line.append(record.getDivision());
                    line.append(CSV_SEPARATOR);
                } else {
                    line.append("NO DIVISION");
                    line.append(CSV_SEPARATOR);
                }

                if(record.getCreditline() != null){
                    line.append(record.getCreditline());
                    line.append(CSV_SEPARATOR);
                } else {
                    line.append("NO CREDITLINE");
                    line.append(CSV_SEPARATOR);
                }

                bufferedWriter.write(line.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            bufferedWriter.close();

            ZipCompressor.createZip(file.getAbsolutePath());
        } catch (IOException ignored){

        }

        return 1;
    }
}
