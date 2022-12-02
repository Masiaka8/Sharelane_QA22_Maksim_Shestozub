import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SharelaneTask3 {

    WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void negativeSignUpTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Maksim");
        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Shestozub");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("Maksimshmv");
        WebElement password1Input = driver.findElement(By.name("password1"));
        password1Input.sendKeys("12345qwert");
        WebElement password2Input = driver.findElement(By.name("password2"));
        password2Input.sendKeys("12345qwert");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Register]"));
        continueButton.click();
        Thread.sleep(5000);

        firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);

        WebElement errorMessage = driver.findElement(By.cssSelector("[class=\"error_message\"]"));
        Assert.assertEquals(errorMessage.isDisplayed(), true);
    }
}

