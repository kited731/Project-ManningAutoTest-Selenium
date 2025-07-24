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

import Util.HandleCheckout;
import Util.HandleGuestAddressForm;
import Util.HandlePaymentMethod;
import Util.HandlePopup;
import Util.HandleProductDetailPage;
import Util.HandleSearchQuery;
import Util.HandleSearchResult;

public class ManningGuestCheckoutTest {
    WebDriver driver;
    ChromeOptions options;
    Map<String, Object> mobileEmulation;
    // Setup
    String searchKeyword = "lotion";
    String productFullName = "CeraVe Moisturising Lotion 1L";
    int oldQuantity = 2;
    int newQuantity = 5;
    // Home Delivery Address form information
    String emailAddress = "scharlo3@fudier.com";
    String fullName = "Deadline Fighter";
    String region = "Kowloon";
    String district = "Cheung Sha Wan";
    String address_1 = "Wing Hong Street 108";
    String address_2 = "Oriental Building";
    String address_3 = "15/F 1503";
    String countryCode = "+852";
    String mobileNumber = "61235123";
    // Payment Settings
    // 1 = alipayHK
    // 2 = Visa
    // 3 = alipayCN
    // 4 = Payme
    // 5 = Octopus
    // 6 = WeChatpay
    int paymentMethod = 1;

    @Test
    public void start() throws InterruptedException {
        driver.get("https://www.mannings.com.hk/en");
        HandlePopup.closePromotionPopUp(driver);
        HandlePopup.closeCookiesPopUp(driver);

        // Searching the product
        HandleSearchQuery.search(driver, searchKeyword);
        Thread.sleep(3000);
        HandleSearchQuery.selectSearchAll(driver);
        Thread.sleep(3000);
        HandleSearchResult.findItem(driver, productFullName);
        Thread.sleep(500);
        // Product Detail Page
        HandleProductDetailPage.addProductToCart(driver);
        Thread.sleep(500);
        HandleProductDetailPage.editQty(driver, oldQuantity);
        Thread.sleep(500);
        // HandleProductDetailPage.decreaseQtyButton(driver);
        // Thread.sleep(500);
        // HandleProductDetailPage.increaseQtyButton(driver);
        // Thread.sleep(500);
        HandleProductDetailPage.clickShoppingCartButton(driver);
        Thread.sleep(5000);
        // Shopping cart / checkout page
        HandleCheckout.selectHomeDelivery(driver);
        HandleCheckout.updateQty(driver, newQuantity);
        HandleCheckout.clickChecoutSecurelyButton(driver);
        HandleCheckout.clickGuestCheckoutButton(driver);
        // Input guest adderss form
        HandleGuestAddressForm.enterEmail(driver, emailAddress);
        HandleGuestAddressForm.enterFullName(driver, fullName);
        HandleGuestAddressForm.selectRegion(driver, region);
        HandleGuestAddressForm.selectDistrict(driver, district);
        HandleGuestAddressForm.enterStreetNumber(driver, address_1);
        HandleGuestAddressForm.enterBuildingEstate(driver, address_2);
        HandleGuestAddressForm.enterUnitFloor(driver, address_3);
        HandleGuestAddressForm.selectCountryCode(driver, countryCode);
        HandleGuestAddressForm.enterMobileNumber(driver, mobileNumber);
        HandleGuestAddressForm.clickConfirmAddressButton(driver);
        HandleGuestAddressForm.clickConfirmDetailsButton(driver);
        Thread.sleep(3000);
        // Payment
        HandlePaymentMethod.selectPaymentMethod(driver, paymentMethod);

        HandlePaymentMethod.tncButton(driver);
        HandlePaymentMethod.payNowButton(driver);
        Thread.sleep(10000);
        HandlePaymentMethod.payment(driver, paymentMethod);
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
