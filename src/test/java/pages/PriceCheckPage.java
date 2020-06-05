package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceCheckPage {

    private WebDriver driver;
    static int quantityInteger = 5;


    @FindBy(xpath = "//div[@class='current-price'/span")
    WebElement priceBeforeDiscount;

    @FindBy(xpath = "//div[@class='col-xs-5 text-xs-right bold']")
    WebElement totalPrice;

    public PriceCheckPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void priceForOne(){
        try {
            Assert.assertEquals("28.72", priceBeforeDiscount);
            System.out.println("Cena poprawna");
        }
        catch (Exception e){
            System.out.println("Cena niezgodna z widoczną na stronie");
        }
    }


    public double doublePriceBeforeDiscount() {
        String priceAfterDiscString = priceBeforeDiscount.getAttribute("content");
        return Double.parseDouble(priceAfterDiscString);
    }


    public double checkTotalPrice(){
        Double total = (doublePriceBeforeDiscount()*quantityInteger);
        System.out.println("Suma zakupów: "+total);
        return total;
    }


    public double doubleTotalPrice(){
        String totalPriceString = totalPrice.getAttribute("content");
        double totalPriceDouble = Double.parseDouble(totalPriceString);
        return totalPriceDouble;
    }





}
