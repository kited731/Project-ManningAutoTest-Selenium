import Util.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class JackTest {
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
        HandlePopup.closeCookiesPopUp(driver);
        driver.findElement(By.xpath("//div[@class=\"index-box-tGb \"][4]")).click();
        Thread.sleep(5000);
        WebElement createAnAccountButton = driver
                .findElement(By.xpath("//div[contains(@class,\"signIn-createAccount-O5F\")]/button"));
        WebElement newLetterText = driver.findElement(By.xpath("//div[@class=\"footer-subscriptionText-X1L\"]"));
        new Actions(driver).moveToElement(newLetterText).perform();
        Thread.sleep(1000);
        createAnAccountButton.click();
        Thread.sleep(1000);
        driver.findElement(By.id("title")).click();
        driver.findElement(By.xpath("//div[@role='option'][1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("firstName")).sendKeys("Jacky");
        Thread.sleep(1000);
        driver.findElement(By.id("lastName")).sendKeys("Chan");
        Thread.sleep(1000);
        driver.findElement(By.id("Email")).sendKeys("clinicfirstjacky@gmail.com");
        driver.findElement(By.id("countryCode")).click();
        driver.findElement(By.id("react-select-3-option-0")).click();
        driver.findElement(By.id("telephone")).sendKeys("96751234");
        Thread.sleep(5000);
        driver.findElement(By.id("Password")).sendKeys("123456a");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456a");
        WebElement consentCheckbox = driver.findElement(By.id("subscribe"));
        consentCheckbox.click();
        driver.findElement(By.xpath("//span[text()='Terms & Conditions']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='popup-popupClose-TDK']//*[name()='svg']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Direct Marketing purposes']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='popup-popupClose-TDK']//*[name()='svg']")).click();
        // Captcha
        WebElement nextElement = driver
                .findElement(By.xpath("//div[contains(@class,\"footer-subscriptionText-X1L\")]"));
        new Actions(driver).moveToElement(nextElement).perform();
        Thread.sleep(20000);
        // Click Create Account
        driver.findElement(By.xpath("//button[contains(@class,\"createAccount-submitButton\")]")).click();
        Thread.sleep(5000);
        driver.quit();
    }

    @AfterEach
    public void terminate() {
        driver.quit();
    }
}
