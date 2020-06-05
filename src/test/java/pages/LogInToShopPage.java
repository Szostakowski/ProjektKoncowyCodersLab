package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInToShopPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    private WebElement toSignIn;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement clickLogIn;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement user;

    @FindBy(xpath = "//*[@id='_desktop_logo']")
    private WebElement clickToMyStore;


    public LogInToShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void signIn() {
        toSignIn.click();
    }


    public void logInData(String user, String password) {
        emailInput.clear();
        emailInput.sendKeys(user);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        clickLogIn.click();
    }

    public String getLoggedUser() {
        return user.getText();
    }

    public void correctSignIn() {
        Assert.assertEquals("Rafal Szostakowski", getLoggedUser());
        System.out.println("Logowanie poprawne");
    }

    public void myStoreButton(){
        clickToMyStore.click();
    }



}





//    @FindBy(xpath = "//div[@class='regular-price']/span")
//    private WebElement regularPrice;
//
//
//    static String regularPriceString;
//    static double regularPriceDouble;
//
//    public double getRegularPrice() {
//        regularPriceString = regularPrice.getAttribute("content");
//        regularPriceDouble = Double.parseDouble(regularPriceString);
//        return regularPriceDouble;
//    }
//
//
//    @FindBy(xpath = "//div[@class='discount discount-percentage']/span")
//    private WebElement discount;
//
//
//    static String discountString;
//    static double discountDouble;
//
//    public double getDiscount() {
//        discountString = discount.getAttribute("content");
//        discountDouble = Double.parseDouble(discountString);
//        return discountDouble;
//    }
//
//
//    @FindBy(xpath = "//div[@class='current-price']/span")
//    private WebElement priceAfterDiscount;
//
//
//    static String priceAfterDiscString;
//    static double priceAfterDiscDouble;
//
//    public double getPriceAfterDiscount() {
//        priceAfterDiscString = priceAfterDiscount.getAttribute("content");
//        priceAfterDiscDouble = Double.parseDouble(priceAfterDiscString);
//        return priceAfterDiscDouble;
//    }




