package com.example.fileupload;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
@SpringBootTest
public class CsvGenerator {
    /**
     * 测试csv文件生成
     */
    @Test
    public void test2() {
        String csvFilePath = "D:\\java\\apache-tomcat-8.5.35-windows-x64\\apache-tomcat-tempdir\\file.csv"; // 替换为实际路径

        try (FileWriter fileWriter = new FileWriter(csvFilePath);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT
                     .withHeader("Name", "Age", "Email"))) {

            // 写入数据
            List<List<String>> data = Arrays.asList(
                    Arrays.asList("John Doe", "29", "john.doe@example.com"),
                    Arrays.asList("Jane Smith", "34", "jane.smith@example.com"),
                    Arrays.asList("Emily Johnson", "45", "emily.johnson@example.com")
            );

            for (List<String> record : data) {
                csvPrinter.printRecord(record);
            }

            System.out.println("CSV file created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while creating CSV file.");
        }
    }
}
