package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataFiles.UsersLogIn;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyStoreAddCompanyDataPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyStoreAddCompanyDataStep {

    private WebDriver driver;

// użycie metody Gherkin

    @Given("open browser with (.*)")
    public void openBrowserOnWebsite(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Then("click Sign in")
    public void signIn() {
        MyStoreAddCompanyDataPage logInSite = new MyStoreAddCompanyDataPage(this.driver);
        logInSite.signIn();
    }

    @And("log in to customer account")
    public void logIn(){
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
        goToAddAddress.goToAddressData();
    }
//        URL url = new URL("https://prod-kurs.coderslab.pl/index.php?controller=address");
//        Assert.assertEquals("https://prod-kurs.coderslab.pl/index.php?controller=address", url.getProtocol());


    @And("add data to form get (.*), (.*), (.*), (.*), (.*), (.*)")
    public void addDataToForm(String alias, String address, String city, String zipCode, String country, String phone) {
        MyStoreAddCompanyDataPage addComapnyData = new MyStoreAddCompanyDataPage(this.driver);

        addComapnyData.addAlias(alias);
        addComapnyData.addAddress(address);
        addComapnyData.addCity(city);
        addComapnyData.addZipCode(zipCode);
        addComapnyData.addCountry(country);
        addComapnyData.addPhone(phone);


    }

//
//        WebElement clickS = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
//        clickS.click();




 }

