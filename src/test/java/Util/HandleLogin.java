package Util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandleLogin {
    static int moveTimeSeconds = 1;
    static int clickTimeSeconds = 4;
    static int inputTimeSeconds = 1;

    public static void clickFixedBottomAccountIcon(WebDriver driver) {
        WebElement accountIcon = driver.findElement(By.xpath("//div[@class='index-boxCenter--3x']"));

        new Actions(driver)
                .moveToElement(accountIcon)
                .click()
                .pause(Duration.ofSeconds(clickTimeSeconds)) // Wait for the account menu to appear
                .perform();
    }

    public static void inputEmailOrPhone(WebDriver driver, String emailOrPhone) {
        WebElement emailOrPhoneInput = driver.findElement(By.xpath("//input[@id='emailOrPhone']"));
        emailOrPhoneInput.clear();
        new Actions(driver)
                .moveToElement(emailOrPhoneInput)
                .click()
                .sendKeys(emailOrPhone)
                .pause(Duration.ofSeconds(inputTimeSeconds)) // Slow down the input for better visibility
                .perform();
    }

    public static void inputPassword(WebDriver driver, String password) {
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='Password']"));
        passwordInput.clear();
        new Actions(driver)
                .moveToElement(passwordInput)
                .click()
                .sendKeys(password)
                .pause(Duration.ofSeconds(inputTimeSeconds)) // Slow down the input for better visibility
                .perform();
    }

    public static void checkRememberMe(WebDriver driver, Boolean rememberMe) {
        if (rememberMe) {
            WebElement rememberMeCheckbox = driver.findElement(By.xpath("//input[@id='rememberMe']"));
            new Actions(driver)
                    .moveToElement(rememberMeCheckbox)
                    .click()
                    .pause(Duration.ofSeconds(inputTimeSeconds)) // Slow down for checkbox to be checked
                    .perform();
        }
    }

    public static void clickLoginButton(WebDriver driver) {
        WebElement createAccountText = driver.findElement(By.xpath("//span[normalize-space()='Create an account']"));
        new Actions(driver)
                .moveToElement(createAccountText)
                .perform();

        WebElement loginButton = driver.findElement(By.xpath("//span[normalize-space()='Login']"));
        new Actions(driver)
                .moveToElement(loginButton)
                .pause(Duration.ofSeconds(moveTimeSeconds)) // Wait for the button to be ready
                .click()
                .pause(Duration.ofSeconds(clickTimeSeconds)) // Wait for the login action to complete
                .perform();
    }
}
