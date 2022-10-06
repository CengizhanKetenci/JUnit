package day06;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class C01_RadioButton {
    /*
    1-Bir class oluşturun : RadioButtonTest
    2-Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    3-https://www.facebook.com adresine gidin
    4-Cookies’i kabul edin
    “Create an Account” button’una basin
    “radio buttons” elementlerini locate edin
    Secili degilse cinsiyet butonundan size uygun olani secin
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void test1() throws InterruptedException {

        // 3- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        // 4- Cookies’i kabul edin

        // 5- “Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        // 6-  “radio buttons” elementlerini locate edin
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton = driver.findElement(By.xpath("//input[@value='-1']"));

        // 7-  Secili degilse cinsiyet butonundan size uygun olani secin

        if (!maleButton.isSelected()){
            maleButton.click();
        }
        Thread.sleep(2000);
        femaleButton.click();
        Thread.sleep(2000);
        customButton.click();
    }
}