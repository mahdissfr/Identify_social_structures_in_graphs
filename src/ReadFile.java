package aut.ir;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class ReadFile {
    private static final String FILENAME = "test2.txt";
    Matrix matrix;
    LinkedList linkedList;
    String readingTime;

    public ReadFile(int selector) {
        Instant start = Instant.now();
        BufferedReader br = null;
        FileReader fr = null;
        String[] tmp;


        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;
            if (selector == 1) {
                matrix = new Matrix();
                while ((sCurrentLine = br.readLine()) != null) {
                    tmp = sCurrentLine.split(",");
                    matrix.add(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));

                }
            }
            if (selector == 2) {
                linkedList = new LinkedList();
                while ((sCurrentLine = br.readLine()) != null) {
                    tmp = sCurrentLine.split(",");
                    linkedList.add(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));

                }
            }
//            while ((sCurrentLine = br.readLine()) != null) {
//                tmp = sCurrentLine.split(" ");
//                if (selector == 1)
//                    matrix.add(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
//                if (selector == 2)
//                    linkedList.add(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
//
//            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Instant end = Instant.now();
        readingTime= Duration.between(start, end)+"";
        System.out.println("reading from file last: "+readingTime);
    }
}