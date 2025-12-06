package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    // declare driver
    WebDriver driver;

    //create constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // create methods
    public void MyAccountLocator(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")).click();
    }

    public void LoginButtonLocator(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();
    }

    public void UsernameLocator(String email){
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void PasswordLocator(String password){
        driver.findElement(By.id("input-password")).sendKeys(password);
    }


    public void SubmitButton(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
    }

    public void RedirectToHomePage(){
        driver.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]/a")).click();
    }

    public void  AssertValidLogin(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=common/home");
    }

    public void AssertInvalidLogin(){
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

}
