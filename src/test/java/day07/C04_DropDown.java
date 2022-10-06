package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {
    /*
    Bir class oluşturun: DropDown
    https://the-internet.herokuapp.com/dropdown adresine gidin.
    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Tüm dropdown değerleri(value) yazdırın
    Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
     */
    WebDriver driver;
    Select options;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(1000);
    }
    @After
    public void tearDown() throws Exception {
        // driver.close();
    }
    @Test
    public void test1() throws Exception {
        // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
        WebElement ddmList= driver.findElement(By.xpath("//*[@id='dropdown']"));
        options=new Select(ddmList);
        options.selectByIndex(1); // ByIndex ile
        System.out.println("options.getFirstSelectedOption() = " + options.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        ddmList.sendKeys("Option 1"); // webElement'e direk seceneğin ismini text olarak göndererek de yapabiliriz.

        System.out.println("=========================================");
        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        options.selectByValue("2");
        System.out.println(options.getFirstSelectedOption().getText());
        System.out.println("=========================================");

        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        options.selectByVisibleText("Option 1");
        System.out.println(options.getFirstSelectedOption().getText());
        System.out.println("=========================================");

        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> butunDdm = driver.findElements(By.xpath("//option"));
        butunDdm.forEach(t-> System.out.println(t.getText()));

        System.out.println("====== ForEach ile yazdır ===");

        //List <WebElement> tumDdm = select.getOptions();
        //tumDdm.forEach(t-> System.out.println(t.getText()));
        //for (WebElement w:tumDdm) {
        //    System.out.println(w.getText());
        //}

        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        System.out.println("DropDown Boyutu = "+butunDdm.size());
        if (butunDdm.size()==4){
            System.out.println("True");
        }else System.out.println("False");
        Assert.assertNotEquals(butunDdm.size(),4);
    }

}
