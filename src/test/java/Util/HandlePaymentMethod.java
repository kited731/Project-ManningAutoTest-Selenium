package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandlePaymentMethod {

    public static void selectPaymentMethod(WebDriver driver, int paymentOptions) throws InterruptedException {
        // paymentOptions
        // 1 = alipayHK
        // 2 = Visa
        // 3 = alipayCN
        // 4 = Payme
        // 5 = Octopus
        // 6 = WeChatpay
        switch (paymentOptions) {
            case 1:
                WebElement alipayHk = driver.findElement(By.xpath("//img[contains(@src,\"alihk\")]"));
                // scrollIntoViewIfNeeded(),selenium version
                // ((org.openqa.selenium.JavascriptExecutor)
                // driver).executeScript("arguments[0].scrollIntoView(true);", alipayHk);
                WebElement nextElement = driver
                        .findElement(By.xpath("//div[contains(@class,\"checkoutPage-payTips-bZi\")]/button"));
                new Actions(driver).moveToElement(nextElement).perform();
                Thread.sleep(500);

                alipayHk.click();
                Thread.sleep(3000);
                break;
            case 2:
                WebElement creditCard = driver.findElement(By.xpath("//img[contains(@src,\"visa\")]"));
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                        creditCard);
                creditCard.click();
                // FrameLocator frame1 = driver
                // .frameLocator("xpath=//div[@id=\"number-container\"]/iframe[@title=\"secure
                // payment field\"]");
                // Locator creditCardNumberInput =
                // frame1.locator("xpath=//form/input[@id=\"number\"]");
                // creditCardNumberInput.scrollIntoViewIfNeeded();
                // creditCardNumberInput.click();
                // creditCardNumberInput.fill("4242424242424242");
                // Locator cardExpiryMonthDropDown =
                // driver.locator("xpath=//select[@class=\"dateMonth\"]");
                // cardExpiryMonthDropDown.scrollIntoViewIfNeeded();
                // cardExpiryMonthDropDown.click();
                // cardExpiryMonthDropDown.selectOption(new SelectOption().setLabel("7"));
                // // Locator cardExpiryMonth = frame
                // // .locator("xpath=//div[@id=\"datePicker\"]/div[@class=\"dateMonth-box\"]");
                // // cardExpiryMonth.scrollIntoViewIfNeeded();
                // // cardExpiryMonth.selectOption(new SelectOption().setLabel("7"));
                // Locator cardExpiryYearDropDown =
                // driver.locator("xpath=//select[@class=\"dateYear\"]");
                // cardExpiryYearDropDown.scrollIntoViewIfNeeded();
                // cardExpiryYearDropDown.click();
                // cardExpiryYearDropDown.selectOption(new SelectOption().setLabel("27"));
                // // Locator cardExpiryYear =
                // //
                // frame.locator("xpath=//div[@id=\"datePicker\"]/div[@class=\"dateYear-box\"]");
                // // cardExpiryYear.scrollIntoViewIfNeeded();
                // // cardExpiryMonth.selectOption(new SelectOption().setLabel("2027"));
                // FrameLocator frame2 = driver.frameLocator(
                // "xpath=//div[@id=\"securityCode-container\"]/iframe[@title=\"secure payment
                // field\"]");
                // Locator cardSecurityCode =
                // frame2.locator("xpath=//input[@id=\"securityCode\"]");
                // cardSecurityCode.scrollIntoViewIfNeeded();
                // cardSecurityCode.fill("123");
                // cardSecurityCode.blur();
                break;
            case 3:
                WebElement alipayCn = driver.findElement(By.xpath("//img[contains(@src,\"zhifubao\")]"));
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                        alipayCn);
                alipayCn.click();
                Thread.sleep(1000);
                break;
            case 4:
                WebElement payMe = driver.findElement(By.xpath("//img[contains(@src,\"payme.svg\")]"));
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                        payMe);
                payMe.click();
                Thread.sleep(1000);
                break;
            case 5:
                WebElement octopus = driver.findElement(By.xpath("//img[contains(@src,\"octopus\")]"));
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                        octopus);
                octopus.click();
                Thread.sleep(1000);
                break;
            case 6:
                WebElement weChatPayHk = driver.findElement(By.xpath("//img[contains(@src,\"payment/wechat.svg\")]"));
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                        weChatPayHk);
                weChatPayHk.click();
                Thread.sleep(1000);
                break;
        }
    }

    public static void tncButton(WebDriver driver) throws InterruptedException {
        WebElement tncButton = driver
                .findElement(By.xpath("//div[contains(@class,\"checkoutPage-payTips-bZi\")]/button"));
        // ((org.openqa.selenium.JavascriptExecutor)
        // driver).executeScript("arguments[0].scrollIntoView(true);",
        // tncButton);
        WebElement nexElement = driver
                .findElement(By.xpath("//div[contains(@class,\"footer-subscriptionTextP\")]"));
        new Actions(driver).moveToElement(nexElement).perform();
        Thread.sleep(1000);
        new Actions(driver).click(tncButton).perform();
        Thread.sleep(3000);
    }

    public static void payNowButton(WebDriver driver) throws InterruptedException {
        WebElement payNow = driver.findElement(By.xpath("//button[contains(@class,\"checkout\")]"));
        // ((org.openqa.selenium.JavascriptExecutor)
        // driver).executeScript("arguments[0].scrollIntoView(true);", payNow);
        payNow.click();
        Thread.sleep(1000);
    }

    public static void payment(WebDriver driver, int paymentOptions) throws InterruptedException {
        // paymentOptions
        // 1 = alipayHK
        // 2 = Visa
        // 3 = alipayCN
        // 4 = Payme
        // 5 = Octopus
        // 6 = WeChatpay
        switch (paymentOptions) {
            case 1:
                WebElement alipayHk = driver.findElement(By.xpath("//span[@class='v2021-continue']"));
                alipayHk.click();
                Thread.sleep(1000);
                WebElement alipayHkInputPhone = driver.findElement(By.xpath("//input[@id='logon_phone']"));
                alipayHkInputPhone.click();
                Thread.sleep(1000);
                alipayHkInputPhone.sendKeys("61236123");
                Thread.sleep(1000);
                WebElement alipayHkSubmit = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
                alipayHkSubmit.click();
                Thread.sleep(3000);
                break;
            case 2:
                // As the credit card is fake, transaction will be declined after clicking Pay
                // Now button, therefore no payment will be tested for credit card.
                break;
            case 3:
                WebElement alipayCn = driver.findElement(By.xpath(
                        "//button[@class='adm-button adm-button-primary adm-button-block adm-button-fill-outline adm-button-large adm-button-shape-default h5RouteAppSenior__h5pay']"));
                alipayCn.click();
                Thread.sleep(1000);
                break;
            case 4:
                WebElement payMe = driver
                        .findElement(By.xpath("//img[@src=\"/venia-static-assets/images/payment/paymeIcon.svg\"]"));
                payMe.click();
                Thread.sleep(1000);
                break;
            case 5:
                // Show the QR code after clicking Pay Now button, therefore no test for octopus
                // here.
                break;
            case 6:
                WebElement weChatPayHk = driver
                        .findElement(By.xpath("//button[@class=\"weui-btn weui-btn_warn enText-btn\"]"));
                weChatPayHk.click();
                Thread.sleep(1000);
                break;
        }
    }
}
