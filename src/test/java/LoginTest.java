import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Util.*;

public class LoginTest {
    WebDriver driver;
    ChromeOptions options;
    Map<String, Object> mobileEmulation;
    int implicitlyTimeSeconds = 5;
    int recordTimeSeconds = 5;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyTimeSeconds));
    }

    // Your actual code here
    // Test your HandleXXX method here
    @Test
    public void startMemberLoginTest() throws InterruptedException {
        driver.get("https://www.mannings.com.hk/en/");
        HandlePopup.closeCookiesPopUp(driver);
        HandlePopup.closePromotionPopUp(driver);

        // Login Page
        HandleLogin.clickFixedBottomAccountIcon(driver);
        HandleLogin.inputEmailOrPhone(driver, LoginTestCaseData.VALID_EMAIL);
        HandleLogin.inputPassword(driver, LoginTestCaseData.VALID_PASSWORD);

        // Remember Me default is true
        // If you want to change it to false, you can set it to false
        HandleLogin.checkRememberMe(driver, true);
        
        // Handle Captcha
        Thread.sleep(30000);
        
        HandleLogin.clickLoginButton(driver);
        // Thread.sleep(3000);
        HandleOTP.inputOTPandVerify(driver);
        // We should be logged in

        // View my-account
        HandleLogin.clickFixedBottomAccountIcon(driver);
        Thread.sleep(recordTimeSeconds); // Wait for the account menu to appear and record the state
    }

    @AfterEach
    public void terminate() {
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
