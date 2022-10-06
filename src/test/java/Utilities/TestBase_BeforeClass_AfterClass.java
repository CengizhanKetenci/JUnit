package Utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public abstract class TestBase_BeforeClass_AfterClass {

   protected static Actions actions;
   protected static WebDriver driver;
   protected static Faker faker;
    protected String tarih;
   @BeforeClass
   public static void setUp() {

       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       Actions actions = new Actions(driver);
       Faker faker = new Faker();
       String tarih;
   }
   @AfterClass
    public static void tearDown() {
      driver.quit();
   }



}
