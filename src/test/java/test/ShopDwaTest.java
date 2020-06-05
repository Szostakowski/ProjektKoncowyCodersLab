package test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ShopDwaTest {

    private static WebDriver driver;

    // podaj adres strony
    private String web = "https://prod-kurs.coderslab.pl";

    // wpisz dane do logowania:
    private String userLogin = "rafal.szostakowski@gmail.com";
    private String userPassword = "pas123";

    //podaj nazwę zamawianego produktu
    private String productName = "sweater";

    // podaj ilość zamawianych produktów
    private String quantityString = "5";

    // podaj rozmiar zamawianego produktu
    private String sizeString = "M";

    //// wpisz którą część adresu chcesz sprawdzić
    private String whatToCheck = "Srodziemiedzin";

    // gdzie zapisać plik potwierdzający zamówienie
    private String fileToScreenshot = "/home/rafal/Obrazy/zamowienia_shop/zamowienie.png";



    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(web);
    }

    @Test
    public void logInTest() {
        LogInToShopPage logIn = new LogInToShopPage(this.driver);
        ShoppingPage shoping = new ShoppingPage(this.driver);
        AboutProductPage product = new AboutProductPage(this.driver);
        BuyingProcessPage buyProcess = new BuyingProcessPage(this.driver);
        PriceCheckPage price = new PriceCheckPage(this.driver);


        logIn.signIn();
        logIn.logInData(userLogin, userPassword);
        logIn.correctSignIn();


        shoping.findProduct(productName);
        shoping.clicSearch();
        shoping.addToCard();


//        price.priceForOne();
        product.productSize(sizeString);


        product.productQuantity(quantityString);
        product.addToCard();
        product.setProceedToCheckout();
        product.setProceedCheckout();


        buyProcess.checkAddress(whatToCheck);
        buyProcess.clickButton();
        buyProcess.shippingMethod();
        buyProcess.payByCheck();
        buyProcess.clickAgree();
        buyProcess.clickObligationPay();
//        price.checkTotalPrice();


    }


    @After
    public void printScreen() {
        File screenshotConfirmated = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotConfirmated, new File(fileToScreenshot));
        } catch (Exception e) {
            System.out.println("Błąd zapisu pliku!");
        }
    }

}


