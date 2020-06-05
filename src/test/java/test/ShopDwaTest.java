package test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AboutProductPage;
import pages.BuyingProcessPage;
import pages.LogInToShopPage;
import pages.ShoppingPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ShopDwaTest {

    private static WebDriver driver;


    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl");
    }

    @Test
    public void logInTest() {
        LogInToShopPage logIn = new LogInToShopPage(this.driver);
        ShoppingPage shoping = new ShoppingPage(this.driver);
        AboutProductPage product = new AboutProductPage(this.driver);
        BuyingProcessPage buyProcess = new BuyingProcessPage(this.driver);


        logIn.signIn();
        logIn.logInData("rafal.szostakowski@gmail.com", "pas123");
        logIn.correctSignIn();

        shoping.findProduct("sweater");
        shoping.clicSearch();
        shoping.addToCard();

        product.productSize("M");
        product.productQuantity("5");
        product.addToCard();
        product.setProceedToCheckout();
        product.setProceedCheckout();

        buyProcess.checkAddress("Srodziemiedzin");
        buyProcess.clickButton();
        buyProcess.shippingMethod();
        buyProcess.payByCheck();
        buyProcess.clickAgree();
        buyProcess.clickObligationPay();

    }


    @After
    public void printScreen() {
        File screenshotConfirmated = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotConfirmated, new File("/home/rafal/Obrazy/seenshot.png"));
        } catch (Exception e) {
            System.out.println("Błąd zapisu pliku!");
        }
    }


}


