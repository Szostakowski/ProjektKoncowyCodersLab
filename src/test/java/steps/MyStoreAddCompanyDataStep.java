package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataFiles.UsersLogIn;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyStoreAddCompanyDataPage;

import java.util.concurrent.TimeUnit;

public class MyStoreAddCompanyDataStep {

    private WebDriver driver;
    private String alias;
    private String address;

// użycie metody Gherkin

    @Given("open browser with (.*)")
    public void openBrowserOnWebsite(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Then("click Sign in")
    public void signIn() {
        MyStoreAddCompanyDataPage logInSite = new MyStoreAddCompanyDataPage(this.driver);
        logInSite.signIn();
    }

    @And("log in to customer account")
    public void logIn() {
        MyStoreAddCompanyDataPage inputLogInData = new MyStoreAddCompanyDataPage(this.driver);
        inputLogInData.logInData(UsersLogIn.getUserLog(), "pas123"); // prawidlowe 123
    }

    @And("check if Sign in is correct")
    public void ckg() {
        MyStoreAddCompanyDataPage checkLogIn = new MyStoreAddCompanyDataPage(this.driver);
        try {
            checkLogIn.correctSignIn();
        } catch (Exception e) {
            System.out.println("Błąd logowania");
        }
    }

    @And("go to \"add first address\"")
    public void clickAddAddress() {
        MyStoreAddCompanyDataPage goToAddAddress = new MyStoreAddCompanyDataPage(this.driver);
        goToAddAddress.goToAdd();
    }

    @And("add data to form get (.*), (.*), (.*), (.*), (.*), (.*)")
    public void addDataToForm(String alias, String address, String city, String zipCode, String country, String phone) {
        MyStoreAddCompanyDataPage addComapnyData = new MyStoreAddCompanyDataPage(this.driver);

        addComapnyData.addAlias(alias);
        this.alias = alias;

        addComapnyData.addAddress(address);
        this.address = address;

        addComapnyData.addCity(city);
        addComapnyData.addZipCode(zipCode);
        addComapnyData.addCountry(country);
        addComapnyData.addPhone(phone);
    }

    @And("check that every thing is okay")
    public void checkLastBlock() {
        MyStoreAddCompanyDataPage checking = new MyStoreAddCompanyDataPage(this.driver);
        checking.findLastBlock();
        String acctualText = checking.getLastaddressTxt();

        Assert.assertTrue(acctualText.contains(this.alias));
        System.out.println(this.alias+": dodano poprawnie");

        Assert.assertTrue(acctualText.contains(this.address));
        System.out.println(this.address+": dodano poprawnie");
    }

}





