package Util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandlePopup {
    public static void closePromotionPopUp(WebDriver driver) {

        List<WebElement> closeButton = driver
                .findElements(By.xpath("//div[@role=\"presentation\"]/button[text()=\"X\"]"));
        if (closeButton.size() > 0) {
            // new Actions(driver).scrollToElement(closeButton);
            closeButton.get(0).click();
        }
    }

    public static void closeCookiesPopUp(WebDriver driver) {
        List<WebElement> understandButton = driver
                .findElements(By.xpath("//div[contains(@class,\"CookiePopup\")]/button"));
        if (understandButton.size() > 0) {
            // new Actions(driver).scrollToElement(understandButton);
            understandButton.get(0).click();
        }
    }
}
