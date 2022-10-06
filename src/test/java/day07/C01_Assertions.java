package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
     /*
    Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim

     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterClass
    public static void tearDown() throws Exception {
        //driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        // http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(1000);

        // Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();
        Thread.sleep(1000);

        // Email kutusuna @isareti olmayan bir mail yazip enter’a
        // bastigimizda “Invalid email address” uyarisi ciktigini test edelim

        WebElement emailbox = driver.findElement(By.xpath("(//*[@class='is_required validate account_input form-control'])[1]"));
        emailbox.sendKeys("han.google.com");
        Thread.sleep(1000);
        WebElement CreateButton = driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
        CreateButton.click();
        WebElement invalid = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        System.out.println("invalid.getText() = " + invalid.getText());
        Assert.assertTrue(invalid.isDisplayed());

    }



}
