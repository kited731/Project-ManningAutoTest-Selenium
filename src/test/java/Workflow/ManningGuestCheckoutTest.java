package Workflow;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Util.*;

public class ManningGuestCheckoutTest {
    WebDriver driver;
    ChromeOptions options;
    Map<String, Object> mobileEmulation;

    @Test
    public void start() throws InterruptedException {
        driver.get("https://www.mannings.com.hk/en");
        HandlePopup.closePromotionPopUp(driver);
        HandlePopup.closeCookiesPopUp(driver);

        HandleSearchQuery.search(driver, "lotion");
        Thread.sleep(3000);

        HandleSearchQuery.selectSearchAll(driver);
        Thread.sleep(3000);

        HandleSearchResult.findItem(driver, "Hada Labo AHA Lotion 170ml");
        Thread.sleep(500);

        HandleProductDetailPage.addProductToCart(driver);
        Thread.sleep(500);

        HandleProductDetailPage.editQty(driver, 3);
        Thread.sleep(500);

        HandleProductDetailPage.decreaseQtyButton(driver);
        Thread.sleep(500);

        HandleProductDetailPage.increaseQtyButton(driver);
        Thread.sleep(500);

        HandleProductDetailPage.clickShoppingCartButton(driver);
        Thread.sleep(5000);

    }

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

    @AfterEach
    public void terminate() {
        driver.quit();
    }

}
