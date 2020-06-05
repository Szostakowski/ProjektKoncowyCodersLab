package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyingProcessPage {

    private WebDriver driver;

    public BuyingProcessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//article")
    private WebElement getAddress;

    @FindBy(name = "confirm-addresses")
    private WebElement button;

    @FindBy(id = "delivery_option_1")
    private WebElement checkPrestaShop;

    @FindBy(xpath = "//*[@id='js-delivery']/button")
    private WebElement clickShippingMetod;

    @FindBy(id = "payment-option-1")
    private WebElement clickPayByCheck;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeButton;

    @FindBy(xpath = "//*[@id='payment-confirmation']/div[1]/button")
    private WebElement obligationPay;


    public void checkAddress(String dataElement) {
        System.out.println(getAddress.getText());
        String actualtext = getAddress.getText();
        Assert.assertTrue(actualtext.contains(dataElement));
        System.out.println("Dane do wysyłki poprawne");
    }

    public void clickButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        button.click();
    }

    public void shippingMethod() {
        clickShippingMetod.click();
    }

    public void payByCheck() {
        clickPayByCheck.click();
    }

    public void clickAgree() {
        agreeButton.click();
    }

    public void clickObligationPay() {
        obligationPay.click();
    }


}
