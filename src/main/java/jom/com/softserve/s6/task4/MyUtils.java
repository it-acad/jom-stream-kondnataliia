package jom.com.softserve.s6.task4;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;

public class MyUtils {

    public static String readFile(String filename) {
        StringBuilder readableString = new StringBuilder();

        try (FileReader fileReader = new FileReader(filename)) {
            StringBuilder binaryString = new StringBuilder();
            int c = 0;

            while ((c = fileReader.read()) != -1) {
                binaryString.append((char) c);

                if (binaryString.length() == 7) {
                    int charCode = Integer.parseInt(binaryString.toString(), 2);
                    readableString.append((char) charCode);
                    binaryString.setLength(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readableString.toString();
    }
}
