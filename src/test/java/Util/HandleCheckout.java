package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandleCheckout {
    public static void selectClickAndCollect(WebDriver driver) { // > $50?
        WebElement clickAndCollectOption = driver.findElement(
                By.xpath("//div[contains(@class,\"deliveryMethod-content\")]/div[1]"));
        clickAndCollectOption.click();

    }

    public static void selectHomeDelivery(WebDriver driver) throws InterruptedException {
        WebElement scrollToTarget = driver.findElement(By.xpath("//div[@class=\"deliveryMethod-notice_wrapper-XxA\"]"));
        WebElement homeDeliveryOption = driver.findElement(
                By.xpath("//div[contains(@class,\"deliveryMethod-content\")]/div[2]"));
        Thread.sleep(1000);
        new Actions(driver).moveToElement(scrollToTarget).perform();
        Thread.sleep(5000);
        new Actions(driver).click(homeDeliveryOption).perform();
        Thread.sleep(5000);

    }

    public static void updateQty(WebDriver driver, int quantity) throws InterruptedException {
        WebElement scrollToTarget = driver
                .findElement(By.xpath("//div[@class=\"linkYuuBox-root-wxY rounded-lg md_rounded-xl\"]"));
        new Actions(driver).moveToElement(scrollToTarget).perform();
        Thread.sleep(1000);
        WebElement quantityInput = driver.findElement(By.xpath("//input[@aria-label=\"Item Quantity\"]"));
        quantityInput.click();
        Thread.sleep(1000);
        quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE);
        Thread.sleep(3000);
        quantityInput.sendKeys(String.valueOf(quantity), Keys.TAB);
        Thread.sleep(300);
    }

    public static void clickChecoutSecurelyButton(WebDriver driver) throws InterruptedException {
        WebElement checkoutSecurelyButton = driver.findElement(
                By.xpath("//button[contains(@class,\"stickyCheckoutBtn\")]/span[text()=\"Checkout securely\"]"));
        checkoutSecurelyButton.click();
        Thread.sleep(5000);
    }

    public static void clickGuestCheckoutButton(WebDriver driver) throws InterruptedException {
        WebElement scrollToTarget = driver.findElement(By.xpath("//div[contains(@class,\"footer-subscription-6sK\")]"));
        Thread.sleep(1000);
        new Actions(driver).moveToElement(scrollToTarget).perform();
        Thread.sleep(1000);
        WebElement guestCheckoutButton = driver.findElement(By.xpath("//button/span[text()=\"Guest checkout\"]"));
        guestCheckoutButton.click();
    }

}
