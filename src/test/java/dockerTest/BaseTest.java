package dockerTest;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class BaseTest {



    @BeforeTest
    public void setUp() throws IOException, InterruptedException {
        BaseTest.dockerOperation("dockerUp.bat","Started Selenium Hub 4.25.0");
        Thread.sleep(3000);
        BaseTest.dockerScale();
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown() throws IOException, InterruptedException {
        BaseTest.dockerOperation("dockerDown.bat","selenium-hub exited with code 0");
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        BaseTest.dockerOperation("dockerUp.bat","Started Selenium Hub 4.25.0");
        Thread.sleep(3000);
        BaseTest.dockerScale();
        Thread.sleep(5000);

        BaseTest.dockerOperation("dockerDown.bat","selenium-hub exited with code 0");

System.out.println("Test completed successfully");

    }

    public static void dockerOperation(String fileName,String expectedVal) throws IOException, InterruptedException {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 30);
        long stopTime = cal.getTimeInMillis();
        long startTime = System.currentTimeMillis();
        boolean flag = false;
        String file = "output.txt";
        try {
            File f = new File(file);
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start " + fileName);
        // runtime.exec("cmd /c start dockerUp.bat");
        Thread.sleep(3000);


            while (startTime < stopTime) {
                if (flag) {
                    break;
                }

                BufferedReader reader = new BufferedReader(new FileReader(file));

                String currentLine = reader.readLine();
                while (currentLine != null && !flag) {
                    if (currentLine.contains(expectedVal)) {
                        System.out.println("Found the text");
                        flag = true;
                        break;
                    }
                    currentLine = reader.readLine();

                }
                reader.close();

            }
            Assert.assertTrue(flag);
            System.out.println(fileName + ":Operation completed successfully");
        }


    public static void dockerScale(){
        Runtime runtime = Runtime.getRuntime();
        try{
            runtime.exec("cmd /c start dockerScale.bat");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
