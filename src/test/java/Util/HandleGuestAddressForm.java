package Util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleGuestAddressForm {
    public static void enterEmail(WebDriver driver, String emailAddress) {
        WebElement emailInput = driver
                .findElement(By.xpath("//div[contains(@class,\"shippingInformation\")]//input[@id=\"email\"]"));
        emailInput.click();
        emailInput.sendKeys(emailAddress);
    }

    public static void enterFullName(WebDriver driver, String fullName) {
        WebElement fullNameInput = driver
                .findElement(By.xpath("//div[contains(@class,\"shippingInformation\")]//input[@id=\"firstname\"]"));
        fullNameInput.click();
        fullNameInput.sendKeys(fullName);
    }

    public static void selectRegion(WebDriver driver, String region) throws InterruptedException {
        WebElement regionDropDownButton = driver.findElement(By.xpath("//div[@class=\"region-root-aGR\"]"));
        List<WebElement> regionDropDownOptions = driver
                .findElements(By.xpath("//div[@class=\"region-root-aGR\"]//div[@role=\"option\"]"));

        regionDropDownButton.click();
        Thread.sleep(1000);
        for (WebElement option : regionDropDownOptions) {
            if (option.getText().equals(region)) {
                option.click();
                break;
            }
        }
    }

    public static void selectDistrict(WebDriver driver, String district) throws InterruptedException {
        WebElement districtDropDownButton = driver.findElement(By.xpath("//div[@class=\"region-root-k7a\"]"));
        List<WebElement> districtDropDownOption = driver
                .findElements(By.xpath("//div[@class=\"region-root-k7a\"]//div[@role=\"option\"]"));

        districtDropDownButton.click();
        Thread.sleep(1000);
        for (WebElement option : districtDropDownOption) {
            if (option.getText().equals(district)) {
                option.click();
                break;
            }
        }
    }

    public static void enterStreetNumber(WebDriver driver, String streetNumber) {
        WebElement streetNumberInput = driver.findElement(By.xpath("//input[@id=\"street0\"]"));
        streetNumberInput.click();
        streetNumberInput.sendKeys(streetNumber);
    }

    public static void enterBuildingEstate(WebDriver driver, String buildingEstate) {
        WebElement buildingEstateInput = driver.findElement(By.xpath("//input[@id=\"street1\"]"));
        buildingEstateInput.click();
        buildingEstateInput.sendKeys(buildingEstate);
    }

    public static void enterUnitFloor(WebDriver driver, String unitFloor) {
        WebElement unitFloorInput = driver.findElement(By.xpath("//input[@id=\"street2\"]"));
        unitFloorInput.click();
        unitFloorInput.sendKeys(unitFloor);
    }

    public static void selectCountryCode(WebDriver driver, String countryCode) throws InterruptedException {
        WebElement countryCodeDropDownButton = driver
                .findElement(By.xpath("//div[contains(@class,\"guestForm-countryCode\")]"));
        List<WebElement> countryCodeDropDownOptions = driver
                .findElements(By.xpath("//div[contains(@class,\"guestForm-countryCode\")]//div[@role=\"option\"]"));

        countryCodeDropDownButton.click();
        Thread.sleep(3000);
        for (WebElement option : countryCodeDropDownOptions) {
            if (option.getText().contains(countryCode)) {
                option.click();
            }
        }
    }

    public static void enterMobileNumber(WebDriver driver, String mobileNumber) {
        WebElement mobileNumberInput = driver
                .findElement(By.xpath("//div[contains(@class,\"guestForm-telephone\")]//input"));
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public static void clickConfirmAddressButton(WebDriver driver) {
        WebElement confirmAddressButton = driver
                .findElement(By.xpath("//div[contains(@class,\"guestForm-buttons\")]/button[@type=\"submit\"]"));
        confirmAddressButton.click();
    }

    public static void clickConfirmDetailsButton(WebDriver driver) {
        WebElement confirmDetailsButton = driver
                .findElement(By.xpath("//div[contains(@class,\"checkoutPage-btnbox\")]/button[@type=\"submit\"]"));
        confirmDetailsButton.click();
    }
}
