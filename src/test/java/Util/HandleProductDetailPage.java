package Util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleProductDetailPage {
    public static void addProductToCart(WebDriver driver) throws InterruptedException {
        List<WebElement> addToCartButton = driver.findElements(By.xpath(
                "//div[contains(@class,\"productFullDetail-actionsMobile-386\")]//button[@aria-label=\"Add to cart\"]"));
        if (addToCartButton.size() > 0) {
            addToCartButton.getFirst().click();
            Thread.sleep(3000);
        }
    }

    public static void editQty(WebDriver driver, int quantity) throws InterruptedException {
        WebElement quantityInput = driver.findElement(By.xpath("//input[@aria-label=\"Item Quantity\"]"));
        quantityInput.click();
        quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE);
        Thread.sleep(1000);
        quantityInput.sendKeys(String.valueOf(quantity));
        Thread.sleep(1000);
    }

    public static void decreaseQtyButton(WebDriver driver) throws InterruptedException {
        WebElement decreaseQtyButton = driver.findElement(By.xpath("//button[@aria-label=\"Decrease Quantity\"]"));
        decreaseQtyButton.click();
        Thread.sleep(1000);
    }

    public static void increaseQtyButton(WebDriver driver) throws InterruptedException {
        WebElement increaseQtyButton = driver.findElement(By.xpath("//button[@aria-label=\"Increase Quantity\"]"));
        increaseQtyButton.click();
        Thread.sleep(1000);
    }

    public static void clickShoppingCartButton(WebDriver driver) {
        // Shopping Cart Button (Bottom)
        WebElement shoppingCartForMobile = driver.findElement(By.xpath(
                "//div[contains(@class,\"productFullDetail-actionsMobile\")]//button[contains(@aria-label,\"Toggle mini cart\")]"));
        shoppingCartForMobile.click();
    }
}
