package dockerTest;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DockerTest {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        URL url =new URL("http://localhost:4444/wd/hub");
  RemoteWebDriver driver =new RemoteWebDriver(url,capabilities);
  driver.get("http://www.google.com");
  System.out.println(driver.getTitle());
    }
}