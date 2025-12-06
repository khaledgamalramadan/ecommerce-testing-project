package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {
    // declare driver
    WebDriver driver;

    // create constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // create methods
    public void MyAccountLocator(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")).click();
    }

    public void RegisterButtonLocator(){
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a")).click();
    }

    public void FirstnameLocator(String firstname){
        driver.findElement(By.id("input-firstname")).sendKeys(firstname);
    }

    public void LastnameLocator(String lastname){
        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
    }

    public void EmailLocator(String email){
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void TelephoneNumberLocator(String telephoneNumber){
        driver.findElement(By.id("input-telephone")).sendKeys(telephoneNumber);
    }

    public void PasswordLocator(String password){
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    public void PasswordConfirmLocator(String PasswordConfirm){
        driver.findElement(By.id("input-confirm")).sendKeys(PasswordConfirm);
    }

    public void PrivacyPolicyLocator(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[1]")).click();
    }

    public void SubmitButton(){
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]")).click();
    }

    public void AssertValidRegister(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
    }

    public void AssertInvalidLogin(){
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
}
