import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.*;

public class KitTest {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // Your actual code here
    // Test your HandleXXX method here
    @Test
    public void start() throws InterruptedException {
        driver.get("https://www.mannings.com.hk/en/aronurish-toddler-formula-stage-3-750g/p/211896");
        HandlePopup.closePromotionPopUp(driver);
        HandlePopup.closeCookiesPopUp(driver);

        WebElement button = driver.findElement(By.xpath("//div[@class=\"react-tabs\"]"));
        new Actions(driver).moveToElement(button).perform();
        Thread.sleep(1500);
        new Actions(driver).moveToElement(button, 0, -30).perform();
        Thread.sleep(1500);
        new Actions(driver).moveToElement(button, 0, -60).perform();
        Thread.sleep(1500);
        new Actions(driver).moveToElement(button, 0, -90).perform();
        Thread.sleep(1500);
        new Actions(driver).moveToElement(button, 0, -120).perform();

        // HandleSearchQuery.search(driver, "lotion");
        // Thread.sleep(3000);
        // HandleSearchQuery.selectSearchAll(driver);
        // Thread.sleep(3000);
        // HandleSearchResult.findItem(driver, "Hada Labo AHA Lotion 170ml");

        // WebElement createAnAccountButton = driver
        // .findElement(By.xpath("//div[contains(@class,\"signIn-createAccount-O5F\")]/button"));
        // WebElement newLetterText =
        // driver.findElement(By.xpath("//div[@class=\"footer-subscriptionText-X1L\"]"));
        // new Actions(driver)
        // .moveToElement(newLetterText)
        // .perform();
        // Thread.sleep(1000);
        // createAnAccountButton.click();
        // Thread.sleep(1000);

    }

    @AfterEach
    public void terminate() {
        driver.quit();
    }
}
