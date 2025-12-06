package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.lang.reflect.Method;
import java.time.Duration;

public class HomeTest {

    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;

    HomePage homePage_obj;
    LoginPage loginPage_obj;
    RegisterPage registerPage_obj;
    ForgetPasswordPage forgetPasswordPage;

    @BeforeMethod
    public void OpenBrowser(Method method) {

        // Create extent test
        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());

        // Open browser
        driver = new FirefoxDriver();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Create page objects
        homePage_obj = new HomePage(driver);
        loginPage_obj = new LoginPage(driver);
        registerPage_obj = new RegisterPage(driver);
        forgetPasswordPage = new ForgetPasswordPage(driver);

        test.info("Browser opened successfully");
    }

    /** ====================== Header bar ======================== **/

    @Test(priority = 1)
    public void ChangeCurrency() {
        test.info("Changing currency");

        homePage_obj.ClickCurrencyDropdown();
        homePage_obj.SelectEuro();
        homePage_obj.AssertCurrencyIsEuro();
        test.pass("Euro selected successfully");

        homePage_obj.ClickCurrencyDropdown();
        homePage_obj.SelectPound();
        homePage_obj.AssertCurrencyIsPound();
        test.pass("Pound selected successfully");

        homePage_obj.ClickCurrencyDropdown();
        homePage_obj.SelectDollar();
        homePage_obj.AssertCurrencyIsDollar();
        test.pass("Dollar selected successfully");
    }

    @Test(priority = 2)
    public void ClickOnMyAccountDropdown() {
        test.info("Opening My Account dropdown");

        homePage_obj.MyAccountButton();
        homePage_obj.RegisterButton();
        homePage_obj.AssertToRegisterPage();

        test.pass("Register page opened successfully");
    }

    @Test(priority = 3)
    public void ClickOnShoppingCart() {
        test.info("Opening Shopping Cart");

        homePage_obj.OpenShoppingCart();
        homePage_obj.AssertOpenShoppingCart();

        test.pass("Shopping cart page opened successfully");
    }

    @Test(priority = 4)
    public void ClickOnCheckout() {
        test.info("Opening Checkout Page");

        homePage_obj.CheckoutPage();
        homePage_obj.AssertToCheckoutPage();

        test.pass("Checkout page opened successfully");
    }

    /** ====================== Login & Register ======================== **/

    @Test(priority = 5)
    public void ValidLogin() {
        test.info("Testing valid login");
        loginPage_obj.MyAccountLocator();
        loginPage_obj.LoginButtonLocator();
        loginPage_obj.UsernameLocator("khaledgamal50016@gmail.com");
        loginPage_obj.PasswordLocator("123456");
        loginPage_obj.SubmitButton();
        loginPage_obj.RedirectToHomePage();
        loginPage_obj.AssertValidLogin();

        test.pass("Valid login test passed");
    }

    @Test(priority = 6)
    public void InvalidLogin() {
        test.info("Testing invalid login");
        loginPage_obj.MyAccountLocator();
        loginPage_obj.LoginButtonLocator();
        loginPage_obj.UsernameLocator("Invalid");
        loginPage_obj.PasswordLocator("Invalid");
        loginPage_obj.SubmitButton();
        loginPage_obj.AssertInvalidLogin();
        test.pass("Invalid login validation working correctly");
    }

    @Test(priority = 7)
        public void validRegister() {
            test.info("Testing valid register");

            registerPage_obj.MyAccountLocator();
            registerPage_obj.RegisterButtonLocator();
            registerPage_obj.FirstnameLocator("khaled");
            registerPage_obj.LastnameLocator("gamal");
            registerPage_obj.EmailLocator("khaled1252@gmail.com");
            registerPage_obj.TelephoneNumberLocator("01060151288");
            registerPage_obj.PasswordLocator("123456");
            registerPage_obj.PasswordConfirmLocator("123456");
            registerPage_obj.PrivacyPolicyLocator();
            registerPage_obj.SubmitButton();
            registerPage_obj.AssertValidRegister();

            test.pass("Valid register completed successfully");
        }

    @Test(priority = 8)
    public void InvalidRegister() {
        test.info("Testing invalid register");

        registerPage_obj.MyAccountLocator();
        registerPage_obj.RegisterButtonLocator();
        registerPage_obj.FirstnameLocator("bebo");
        registerPage_obj.LastnameLocator("bebo2");
        registerPage_obj.EmailLocator("khaledgamal50016@gmail.com");
        registerPage_obj.TelephoneNumberLocator("01060151288");
        registerPage_obj.PasswordLocator("1234506");
        registerPage_obj.PasswordConfirmLocator("123456");
        registerPage_obj.PrivacyPolicyLocator();
        registerPage_obj.SubmitButton();
        registerPage_obj.AssertInvalidLogin();

        test.pass("Invalid register error messages shown");
    }

    @Test(priority = 9)
    public void ForgotPassword() {
        test.info("Testing forgotten password");

        forgetPasswordPage.MyAccountLocator();
        forgetPasswordPage.LoginButtonLocator();
        forgetPasswordPage.ClickOnForgottenPassword();
        forgetPasswordPage.enterEmail("khaledgamal50016@gmail.com");
        forgetPasswordPage.SubmitButton();
        forgetPasswordPage.AssertForgetPassword();

        test.pass("Forgot password flow working correctly");
    }

    /** ====================== Search + Product ======================== **/

    @Test(priority = 10)
    public void SearchForExistingProduct() {
        homePage_obj.SearchForProduct("MacBook");
        homePage_obj.AssertSearchResultsPageOpened();
        homePage_obj.AssertSearchFoundResults();

        test.pass("Search for existing product passed");
    }

    @Test(priority = 11)
    public void SearchForNonExistingProduct() {
        homePage_obj.SearchForProduct("Anything");
        homePage_obj.AssertSearchResultsPageOpened();
        homePage_obj.AssertNoResultsFound();

        test.pass("Search for non-existing product passed");
    }

    @Test(priority = 12)
    public void ClickOFAnyProductToShowDetails() {
        homePage_obj.ClickOFAnyProductToShowDetails();
        homePage_obj.AssertToShowDetailsOfProduct();

        test.pass("Product details page opened successfully");
    }

    @Test(priority = 13)
    public void AddProductToShoppingCart() {
        homePage_obj.AddProductToCartBtn();
        homePage_obj.AssertAddProductToCart();

        test.pass("Product added to cart successfully");
    }

    @Test(priority = 14)
    public void AddProductToWishList() {
        homePage_obj.AddToWishList();
        homePage_obj.AssertAddToWishList();

        test.pass("Product added to wishlist successfully");
    }

    @Test(priority = 15)
    public void AddProductToCompare() {
        homePage_obj.AddProductToCompareBtn();
        homePage_obj.AssertAddProductToCompare();

        test.pass("Product added to compare list successfully");
    }

    /** ====================== Tear Down ======================== **/

    @AfterMethod
    public void tearDown(ITestResult result) {

        String screenshotPath = Utils.takeScreenshot(driver, result.getName());

        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.fail(result.getThrowable(),
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test Passed Successfully",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            } else if (result.getStatus() == ITestResult.SKIP) {
                test.skip("Test Skipped",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        extent.flush();
        driver.quit();
    }
}
