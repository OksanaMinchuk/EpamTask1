package by.epam.minchuk.task1.view;

import java.io.*;

public class FilePrinter implements Printable {

    private File fbyte = new File("outputDataByte.data");
    private File fsymb = new File("outputDataSymbol.data");

    private FileOutputStream fileOutputStream = null;
    private FileWriter fileWriter = null;

    @Override
    public void print(Object ob) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fbyte);
             FileWriter fileWriter = new FileWriter(fsymb)) {
            fileOutputStream.write(ob.toString().getBytes());
            fileWriter.write(ob.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
