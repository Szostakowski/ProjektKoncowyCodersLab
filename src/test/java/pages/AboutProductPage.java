package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutProductPage {

    private WebDriver driver;

    public AboutProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "group_1")
    private WebElement sizeOfProduct;

    @FindBy(id = "quantity_wanted")
    private WebElement productQuantity;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedToCheckout;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedCheckout;



    public void productSize(String size) {
        sizeOfProduct.click();
        sizeOfProduct.sendKeys(size);
        System.out.println("Wybrano rozmiar: "+size);
    }



    public void productQuantity(String quantity) {
        productQuantity.clear();
        productQuantity.sendKeys(quantity);
        System.out.println("Wybrano: "+quantity+" sztuk");
    }

    public void addToCard() {
        addToCart.click();
    }

    public void setProceedToCheckout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        proceedToCheckout.click();
    }
    public void setProceedCheckout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        proceedToCheckout.click();
    }


}
