package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[text()='Swag Labs']")
    private WebElement swagLabsLogo;

    @FindBy(className = "product_sort_container")
    private WebElement filterClass;

    @FindBy(xpath = "//option[text()='Name (A to Z)']")
    private WebElement dropdown;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private WebElement addToCart;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCart;

    @FindBy(id = "checkout")
    private WebElement checkout;


    String itemLocator = "//div[text()='%s']";

    public void elementPresentLogo(){
        swagLabsLogo.isDisplayed();
    }

    public void tapDropDown(){
        dropdown.click();
    }

    public void selectFilter(String value){
        Select select = new Select(filterClass);
        select.selectByValue(value);
    }

    public void selectItem(String item){
        driver.findElement(By.xpath(String.format(itemLocator,item))).click();
    }

    public void clickAddToCart(){
        addToCart.click();
    }

    public void tapShoppingCart(){
        shoppingCart.click();
    }

    public void verifyCheckout(){
        checkout.isDisplayed();
    }


}
