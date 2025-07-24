package Util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandleOTP {
    static int otpTimeSeconds = 20;
    static int clickTimeSeconds = 4;
    public static void inputOTPandVerify(WebDriver driver) throws InterruptedException {
        // OTP must input
        WebElement otp = driver.findElement(By.xpath("//input[@id='otp']"));
        new Actions(driver)
                .moveToElement(otp)
                .click()
                .pause(Duration.ofSeconds(otpTimeSeconds)) // Wait for user to input OTP manually
                .perform();

        // Click Verify Account button
        WebElement verifyButton = driver
                .findElement(By.xpath("//span[@class='button-content-krs'][normalize-space()='Verify Account']"));
        new Actions(driver)
                .moveToElement(verifyButton)
                .click()
                .pause(Duration.ofSeconds(clickTimeSeconds)) // Wait for action to complete
                .perform();
    }
}