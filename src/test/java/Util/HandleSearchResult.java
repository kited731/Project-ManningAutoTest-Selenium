package Util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandleSearchResult {
    public static void findItem(WebDriver driver, String productName) throws InterruptedException {
        // Load more Button
        List<WebElement> loadMoreProductsButton = driver
                .findElements(By.xpath("//div[@class=\"liveSearchPLP-loadmore-IXn\"]"));
        // newsLetter for scolling use
        WebElement newsLetter = driver
                .findElement(By.xpath("//div[contains(@class,\"footer-subscriptionTextP-lSJ\")]"));
        List<WebElement> searchResultItems;
        boolean isFound = false;

        do {
            searchResultItems = driver
                    .findElements(By.xpath("//div[contains(@class,\"item-name\")]"));
            loadMoreProductsButton = driver
                    .findElements(By.xpath("//div[@class=\"liveSearchPLP-loadmore-IXn\"]"));
            // search for item
            for (WebElement result : searchResultItems) {
                System.out.println("Current item name: " + result.getText());
                if (result.getText().equals(productName)) {
                    isFound = true;
                    new Actions(driver).moveToElement(result).perform();
                    Thread.sleep(3000);
                    System.out.println("Matched");
                    result.click();
                    Thread.sleep(3000);
                    break;
                }
            }
            if (isFound) {
                break;
            } else {
                if (loadMoreProductsButton.size() > 0) {
                    new Actions(driver).moveToElement(newsLetter).perform();
                    Thread.sleep(500);
                    loadMoreProductsButton.get(0).click();
                    Thread.sleep(5000);
                }
            }
        } while (loadMoreProductsButton.size() > 0 && !isFound);
    }

}
