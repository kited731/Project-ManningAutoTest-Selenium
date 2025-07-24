package Util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandleGuestAddressForm {
    public static void enterEmail(WebDriver driver, String emailAddress) throws InterruptedException {
        WebElement emailInput = driver
                .findElement(By.xpath("//div[contains(@class,\"shippingInformation\")]//input[@id=\"email\"]"));
        WebElement nextElement = driver
                .findElement(By.xpath("//div[contains(@class,\"shippingInformation\")]//input[@id=\"firstname\"]"));
        moveToNextElement(driver, nextElement);
        emailInput.click();
        emailInput.sendKeys(emailAddress);
        Thread.sleep(1000);
    }

    public static void enterFullName(WebDriver driver, String fullName) throws InterruptedException {
        WebElement fullNameInput = driver
                .findElement(By.xpath("//div[contains(@class,\"shippingInformation\")]//input[@id=\"firstname\"]"));

        WebElement nextElement = driver.findElement(By.xpath("//div[@class=\"region-root-aGR\"]"));
        moveToNextElement(driver, nextElement);

        fullNameInput.click();
        fullNameInput.sendKeys(fullName);
        Thread.sleep(1000);
    }

    public static void selectRegion(WebDriver driver, String region) throws InterruptedException {
        WebElement regionDropDownButton = driver.findElement(By.xpath("//div[@class=\"region-root-aGR\"]"));
        WebElement nextElement = driver.findElement(By.xpath("//input[@id=\"street2\"]"));
        moveToNextElement(driver, nextElement);
        Thread.sleep(1000);
        regionDropDownButton.click();
        Thread.sleep(1000);
        WebElement hongkong = driver.findElement(By.xpath("//div[contains(@class,\"css-10wo9uf-option\")][1]"));
        WebElement kowloon = driver.findElement(By.xpath("//div[contains(@class,\"css-10wo9uf-option\")][2]"));
        WebElement newTerritories = driver.findElement(By.xpath("//div[contains(@class,\"css-10wo9uf-option\")][3]"));
        if (region.equals("Hong Kong Island")) {
            hongkong.click();
        } else if (region.equals("Kowloon")) {
            kowloon.click();
        } else {
            newTerritories.click();
        }

        Thread.sleep(1000);
    }

    public static void selectDistrict(WebDriver driver, String district) throws InterruptedException {
        WebElement districtDropDownButton = driver.findElement(By.xpath("//div[@class=\"region-root-k7a\"]"));
        districtDropDownButton.click();
        Thread.sleep(1000);

        List<WebElement> districtDropDownOption = driver
                .findElements(By.xpath("//div[@id=\"react-select-5-listbox\"]/div"));
        WebElement nextElement = driver
                .findElement(By.xpath("//div[contains(@class,\"guestForm-telephone\")]//input"));
        moveToNextElement(driver, nextElement);
        Thread.sleep(1000);

        for (WebElement option : districtDropDownOption) {
            System.out.println(option.getText());
            if (option.getText().equals(district)) {
                new Actions(driver).click(option).perform();
                break;
            }
        }
        Thread.sleep(1000);
    }

    public static void enterStreetNumber(WebDriver driver, String streetNumber) throws InterruptedException {
        WebElement streetNumberInput = driver.findElement(By.xpath("//input[@id=\"street0\"]"));

        WebElement nextElement = driver.findElement(By.xpath("//input[@id=\"street1\"]"));
        moveToNextElement(driver, nextElement);
        Thread.sleep(1000);
        streetNumberInput.click();
        Thread.sleep(1000);
        streetNumberInput.sendKeys(streetNumber, Keys.TAB);
        Thread.sleep(1000);
    }

    public static void enterBuildingEstate(WebDriver driver, String buildingEstate) throws InterruptedException {
        WebElement buildingEstateInput = driver.findElement(By.xpath("//input[@id=\"street1\"]"));

        WebElement nextElement = driver.findElement(By.xpath("//input[@id=\"street2\"]"));
        moveToNextElement(driver, nextElement);
        Thread.sleep(1000);

        buildingEstateInput.click();
        Thread.sleep(1000);
        buildingEstateInput.sendKeys(buildingEstate);
        Thread.sleep(1000);
    }

    public static void enterUnitFloor(WebDriver driver, String unitFloor) throws InterruptedException {
        WebElement unitFloorInput = driver.findElement(By.xpath("//input[@id=\"street2\"]"));

        WebElement nextElement = driver
                .findElement(By.xpath("//div[contains(@class,\"guestForm-countryCode\")]"));
        moveToNextElement(driver, nextElement);
        Thread.sleep(1000);

        unitFloorInput.click();
        Thread.sleep(1000);
        unitFloorInput.sendKeys(unitFloor);
        Thread.sleep(1000);
    }

    public static void selectCountryCode(WebDriver driver, String countryCode) throws InterruptedException {
        WebElement countryCodeDropDownButton = driver
                .findElement(By.xpath("//div[contains(@class,\"guestForm-countryCode\")]"));

        WebElement nextElement = driver.findElement(By.xpath("//div[@class=\"checkoutPage-shipping_reamrks-fTT\"]"));
        moveToNextElement(driver, nextElement);
        Thread.sleep(1000);

        countryCodeDropDownButton.click();
        Thread.sleep(1000);
        WebElement hkCode = driver
                .findElement(By.xpath("//div[contains(@class,\"react-select__option\")][1]"));
        WebElement mcCode = driver
                .findElement(By.xpath("//div[contains(@class,\"react-select__option\")][2]"));
        WebElement cnCode = driver
                .findElement(By.xpath("//div[contains(@class,\"react-select__option\")][3]"));
        if (countryCode.equals("+852")) {
            hkCode.click();
        } else if (countryCode.equals("+853")) {
            mcCode.click();
        } else {
            cnCode.click();
        }

    }

    public static void enterMobileNumber(WebDriver driver, String mobileNumber) throws InterruptedException {
        WebElement mobileNumberInput = driver
                .findElement(By.xpath("//div[contains(@class,\"guestForm-telephone\")]//input"));

        WebElement nextElement = driver
                .findElement(By.xpath("//div[contains(@class,\"guestForm-buttons\")]/button[@type=\"submit\"]"));
        moveToNextElement(driver, nextElement);
        Thread.sleep(1000);

        mobileNumberInput.sendKeys(mobileNumber);
        Thread.sleep(1000);
    }

    public static void clickConfirmAddressButton(WebDriver driver) throws InterruptedException {
        WebElement confirmAddressButton = driver
                .findElement(By.xpath("//div[contains(@class,\"guestForm-buttons\")]/button[@type=\"submit\"]"));

        WebElement nextElement = driver.findElement(By.xpath("//div[@class=\"checkoutPage-shipping_reamrks-fTT\"]"));
        moveToNextElement(driver, nextElement);
        Thread.sleep(1000);

        confirmAddressButton.click();
        Thread.sleep(3000);
    }

    public static void clickConfirmDetailsButton(WebDriver driver) throws InterruptedException {
        WebElement confirmDetailsButton = driver
                .findElement(By.xpath("//div[contains(@class,\"checkoutPage-btnbox\")]/button[@type=\"submit\"]"));
        Thread.sleep(1000);
        confirmDetailsButton.click();
        Thread.sleep(3000);
    }

    private static void moveToNextElement(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
}
