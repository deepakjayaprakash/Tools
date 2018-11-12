package FileReaders;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepak.jayaprakash on 12/11/18.
 */
public class CSVReader {

    public static void readCSV() {
        String csvFile = "/Users/deepak.jayaprakash//cities.csv";
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";
        List<Row> data = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] csv = line.split(cvsSplitBy);
                for (int i = 0; i < csv.length; i++) {
                    Row row = new Row();
                    row.setFirst(csv[0]);
                    row.setSecond(csv[1]);
                    row.setThird(csv[2]);
                    data.add(row);
                }
            }

            for (Row row : data) {
                System.out.println(row);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        readCSV();
    }
}

@Data
class Row {
    String first;
    String second;
    String third;
}
