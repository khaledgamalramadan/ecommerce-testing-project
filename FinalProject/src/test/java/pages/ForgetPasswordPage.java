package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ForgetPasswordPage {
    // declare driver
    WebDriver driver;

    //create constructor
    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // create method
    public void MyAccountLocator(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")).click();
    }

    public void LoginButtonLocator(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();
    }

    public void ClickOnForgottenPassword(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/div[2]/a")).click();
    }


    public void enterEmail(String email){
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void SubmitButton(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div[2]/input")).click();
    }

    public void AssertForgetPassword(){
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }
}
