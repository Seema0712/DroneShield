package suites.login;

import initialisation.Initialisation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;

public class Login extends Initialisation {

    WebDriver driver;

    @BeforeSuite
    public void openSaucelabs() {
        driver = initialise();
        System.out.println("login to sauce application driver"+driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Parameters({"userName","password"})
    @BeforeTest
    public void loginSaucelabs(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

// currently  the filter button is failing
//    @Parameters({"filter"})
//    public void verifyFilter(String filter){
//        productsPage.elementPresentLogo();
//        productsPage.tapDropDown();
//        productsPage.selectFilter(filter);
//    }

    @Parameters({"item"})
    @Test
    public void AddToCart(String item){
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.selectItem(item);
        productsPage.clickAddToCart();
        productsPage.tapShoppingCart();
        productsPage.verifyCheckout();
    }


        @AfterSuite
        public void closeBrowser(){
         driver.quit();
        }

}
