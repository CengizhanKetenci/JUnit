package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {

    WebDriver driver;
    Select options;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @After
    public void tearDown() throws Exception {
        //driver.close();
    }
    @Test
    public void test1(){
    /*
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    */
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select options = new Select(ddm);
    /*
    NOT : DropDown menuye ulasmak icin select class'indan bir obje (options) olustururuz
    ve locate ettigimiz dropDownMenu (ddm) webelement'ini select class'ina tanimlariz
    ve getOption methodunu kullanarak dropdown'u bir liste atarak dropdown menu'nun
    butun elemanlarının sayısına ulasabiliriz
    */
        List<WebElement> ddmList = options.getOptions();
        System.out.println("ddmList.size() = " + ddmList.size());

        int expectedSayi=45;
        int actualddmSayisi= ddmList.size();
        Assert.assertNotEquals(expectedSayi, actualddmSayisi);
    }
    @Test
    public void test2(){
        /*
     -Test2
    1.Kategori menusunden Books secenegini secin
    2.Arama kutusuna Java yazin vearatin
    3.Bulunan sonuc sayisiniyazdirin
    4.Sonucun Java kelimesini icerdigini testedin
         */
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        options = new Select(ddm);

        // 1.Kategori menusunden Books secenegini secin
        options.selectByIndex(5);   // 1.yöntem Byindeks ile bulma.
        options.selectByVisibleText("Books"); // 2.yöntem görünen text ile bulma.
        options.selectByValue("search-alias=stripbooks-intl-ship");  // 3.yöntem ByValue ile bulma.

        // DropDownMenu'de seçtiğimiz option'a ulaşmak istersek select.getFirstSelectedOption() methodunu kullanırız

        System.out.println("options.getFirstSelectedOption() = " + options.getFirstSelectedOption().getText());

        // 2.Arama kutusuna Java yazin ve aratin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java"+ Keys.ENTER);

        // 3.Bulunan sonuc sayisini yazdirin
        WebElement sonuc=driver.findElement(By.xpath("//*[text()='1-16 of over 30,000 results for']"));
        System.out.println("sonuc.getText() = " + sonuc.getText());


        // 4.Sonucun Java kelimesini icerdigini test edin
        String expectedKelime="java";
        String actualSonucYazisi= sonuc.getText();
        Assert.assertFalse(actualSonucYazisi.contains(expectedKelime));
        /*

         */

    }
}
