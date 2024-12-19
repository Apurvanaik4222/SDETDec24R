package dockerTest;

import java.io.File;

public class Filedelete {

    public static void main(String[] args) {

        String file = "output.txt";
        try {
            File f = new File(file);
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
