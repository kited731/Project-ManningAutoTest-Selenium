import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JasonTest {
    WebDriver driver;
    ChromeOptions options;
    Map<String, Object> mobileEmulation;

    @BeforeEach
    public void initialze() {
        // Set up ChromeOptions for mobile emulation
        options = new ChromeOptions();
        mobileEmulation = new HashMap<>();
        // Specify the device name (e.g., "iPhone SE") or custom device settings
        mobileEmulation.put("deviceName", "iPhone SE");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(375, 800));

    }

    // Your actual code here
    // Test your HandleXXX method here
    @Test
    public void start() throws InterruptedException {
        driver.get("https://www.mannings.com.hk/en/");
        Thread.sleep(5000);
    }

    @AfterEach
    public void terminate() {
        driver.quit();
    }
}
