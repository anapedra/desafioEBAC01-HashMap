package org.anasantana.service.util;

import java.io.FileWriter;
import java.io.IOException;

public class CsvExporter {

    private final StringBuilder sb = new StringBuilder();
    private final String filePath;

    public CsvExporter(String filePath) {
        this.filePath = filePath;
        sb.append("method,scale,time_ms\n"); // CSV Header
    }

    public void addRecord(String method, int scale, long timeInMs) {
        sb.append(method)
          .append(",")
          .append(scale)
          .append(",")
          .append(timeInMs)
          .append("\n");
    }

    public void export() {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(sb.toString());
            System.out.println("CSV exported to: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }
}
