package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static java.awt.SystemColor.text;

public class HomePage {
    // Declare Driver
    WebDriver driver;

    // Create Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Click on currency dropdown menu
    public void ClickCurrencyDropdown(){
        driver.findElement(By.xpath("/html/body/nav/div/div[1]/form/div/button/span")).click();
    }

    // Select Euro currency from dropdown
    public void SelectEuro(){
        driver.findElement(By.xpath("/html/body/nav/div/div[1]/form/div/ul/li[1]/button")).click();
    }

    // Select Pound currency from dropdown
    public void SelectPound(){
        driver.findElement(By.xpath("/html/body/nav/div/div[1]/form/div/ul/li[2]/button")).click();
    }

    // Select Dollar currency from dropdown
    public void SelectDollar(){
        driver.findElement(By.xpath("/html/body/nav/div/div[1]/form/div/ul/li[3]/button")).click();
    }

    // Assert that Euro currency symbol is displayed
    public void AssertCurrencyIsEuro(){
        String symbol = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/p[2]")).getText();
        Assert.assertTrue(symbol.contains("€"));
    }

    // Assert that Pound currency symbol is displayed
    public void AssertCurrencyIsPound(){
        String symbol = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/p[2]")).getText();
        Assert.assertTrue(symbol.contains("£"));
    }

    // Assert that Dollar currency symbol is displayed
    public void AssertCurrencyIsDollar(){
        String symbol = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/p[2]")).getText();
        Assert.assertTrue(symbol.contains("$"));
    }

    // Click on My Account button
    public void MyAccountButton(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")).click();
    }

    // Click on Register option from My Account dropdown
    public void RegisterButton(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a")).click();
    }

    // Assert redirect to Register page
    public void AssertToRegisterPage(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/register");
    }

    // Click on Login option from My Account dropdown
    public void LoginButton(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();
    }

    // Assert redirect to Login page
    public void AssertToLoginPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("route=account/login"));
    }

    // Open shopping cart page
    public void OpenShoppingCart(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[4]/a")).click();
    }

    // Assert shopping cart page is opened
    public void AssertOpenShoppingCart(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=checkout/cart");
    }

    // Open checkout page
    public void CheckoutPage(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[5]/a")).click();
    }

    // Assert redirect to checkout page
    public void AssertToCheckoutPage(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=checkout/cart");
    }

    /** ===== Search For Products ===== **/
    public void EnterSearchText(String text){
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(text);
    }

    public void ClickSearchButton(){
        driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/span/button")).click();
    }

    public void SearchForProduct(String productName){
        EnterSearchText(productName);
        ClickSearchButton();
    }

    public void AssertSearchResultsPageOpened() {
        Assert.assertTrue(driver.getCurrentUrl().contains("route=product/search"));
    }

    public void AssertSearchFoundResults() {
        String result = driver.findElement(By.className("product-thumb")).getText();
        Assert.assertFalse(result.contains("There is no product that matches"));
    }

    public void AssertNoResultsFound() {
        String msg = driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]")).getText();
        Assert.assertTrue(msg.contains("There is no product that matches the search criteria."));
    }
    /** ======= **/

    // Click on any product to view details
    public void ClickOFAnyProductToShowDetails(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/h4/a")).click();
    }

    // Assert redirect to product details page
    public void AssertToShowDetailsOfProduct(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=product/product&product_id=43");
    }

    // Click Add to Wishlist button
    public void AddToWishList(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div[3]/button[2]")).click();
    }

    // Assert product added to wishlist successfully
    public void AssertAddToWishList(){
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

    // Click Add to Cart button for a product
    public void AddProductToCartBtn(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[3]/button[1]")).click();
    }

    // Assert product added to cart successfully
    public void AssertAddProductToCart(){
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

    // Click Add to Compare button for a product
    public void AddProductToCompareBtn(){
        driver.findElement(By.cssSelector("div.product-layout:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(3)")).click();
    }

    // Assert product added to compare list successfully
    public void AssertAddProductToCompare(){
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

}
