package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {

    private WebDriver driver;

    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "s")
    private WebElement clickSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement clickSubmit;

    @FindBy(xpath = "//*[@id='js-product-list']/div[1]/article/div/a/img")
    private WebElement choseProduct;

    public void findProduct(String productName) {
        clickSearch.click();
        clickSearch.sendKeys(productName);
    }

    public void clicSearch() {
        clickSubmit.click();
    }

    public void addToCard() {

        choseProduct.click();
    }
}

