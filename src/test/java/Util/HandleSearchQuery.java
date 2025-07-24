package Util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleSearchQuery {

    public static void search(WebDriver driver, String keyword) throws InterruptedException {
        WebElement headerSearchBar = driver
                .findElement(By.xpath("//div[contains(@class,\"searchBar-container-qV3\")]"));
        headerSearchBar.click();
        Thread.sleep(3000);
        WebElement popupSearchBar = driver
                .findElement(By.xpath("//div[contains(@class,\"contentMobile\")]//input[@name=\"search_query\"]"));
        popupSearchBar.click();
        popupSearchBar.sendKeys(keyword);
    }

    public static void selectSuggestionCategories(WebDriver driver) {
        List<WebElement> searchSuggestionCategories = driver
                .findElements(By.xpath("//div[@class=\"popover-CategoryItem--MT\"]"));
        searchSuggestionCategories.getFirst().click();
    }

    public static void selectSuggestionItems(WebDriver driver) {
        List<WebElement> searchSuggestionItems = driver.findElements(
                By.xpath("//div[@class=\"popover-Products-Qr9\"]//div[@class=\"popover-ProductItem-1UB\"]"));
        searchSuggestionItems.get(0).click();

    }

    public static void selectSearchAll(WebDriver driver) {
        WebElement searchAllButton = driver.findElement(By.xpath("//div[@class=\"popover-ViewAllBtn-w0D\"]"));
        searchAllButton.click();
    }
}
