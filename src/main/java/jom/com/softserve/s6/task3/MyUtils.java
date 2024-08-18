package jom.com.softserve.s6.task3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyUtils {

    public static void writeFile(String filename, String text)  {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            for (char c : text.toCharArray()) {
                fos.write(String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0').getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
