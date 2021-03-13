package aut.ir;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by mahdis on 1/20/2018.
 */
public class CreateFile {
    public CreateFile(ArrayList<Boolean> visited) throws IOException {
        File result = new File("result.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 1; i < visited.size(); i++) {
            try {
                if (visited.get(i))
                    bw.write("#" + (i + 1) + ":  A");
                else
                    bw.write("#" + (i + 1) + ":  B");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
