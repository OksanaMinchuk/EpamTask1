package by.epam.minchuk.task1.util;

import java.io.*;

public class DataReader {

    private static final String FILE_PATH = "InputData.txt";

    public DataReader() {
    }

    public String readFile() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            InputStreamReader ist = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(ist);
            String read;
            while ((read = br.readLine()) != null) {
                stringBuilder.append(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
