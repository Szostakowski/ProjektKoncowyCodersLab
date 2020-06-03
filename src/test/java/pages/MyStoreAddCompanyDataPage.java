package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class MyStoreAddCompanyDataPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    private WebElement toSignIn;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"submit-login\"]")
    private WebElement clickLogIn;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement user;

    @FindBy(xpath = "//*[@id=\"address-link\"]/span")
    private WebElement toAddress;

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement zipcodeInput;

    @FindBy(name = "id_country")
    private WebElement countrySelect;

    @FindBy(name = "phone")
    private WebElement phoneInput;


    public MyStoreAddCompanyDataPage(WebDriver driver) {
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

    public void goToAddressData() {
        toAddress.click();
    }


    public void addAlias(String alias) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void addAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void addCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void addZipCode(String zipCode) {
        zipcodeInput.clear();
        zipcodeInput.sendKeys(zipCode);
    }

    public void addCountry(String country) {
        Select CountryDrop = new Select(countrySelect);
        CountryDrop.selectByVisibleText(country);
    }

    public void addPhone(String phone) {
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        phoneInput.submit();
    }
}


