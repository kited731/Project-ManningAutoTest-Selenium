package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleCheckout {
    public static void selectClickAndCollect(WebDriver driver) { // > $50?
        WebElement clickAndCollectOption = driver.findElement(
                By.xpath("//div[contains(@class,\"deliveryMethod-root\")]//span[text()=\"click and collect\"]"));
        clickAndCollectOption.click();

    }

    public static void selectHomeDelivery(WebDriver driver) {
        WebElement homeDeliveryOption = driver.findElement(
                By.xpath("//div[contains(@class,\"deliveryMethod-root\")]//span[text()=\"home delivery\"]"));
        homeDeliveryOption.click();
    }

    public static void updateQty(WebDriver driver, int quantity) throws InterruptedException {
        WebElement quantityInput = driver.findElement(By.xpath("//input[@aria-label=\"Item Quantity\"]"));
        quantityInput.click();
        Thread.sleep(500);
        quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE);
        Thread.sleep(3000);
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public static void clickChecoutSecurelyButton(WebDriver driver) {
        WebElement checkoutSecurelyButton = driver.findElement(
                By.xpath("//button[contains(@class,\"stickyCheckoutBtn\")]/span[text()=\"Checkout securely\"]"));
        checkoutSecurelyButton.click();
    }

    public static void clickGuestCheckoutButton(WebDriver driver) {
        WebElement guestCheckoutButton = driver.findElement(By.xpath("//button/input[text()=\"Guest checkout\"]"));
        guestCheckoutButton.click();
    }

}
