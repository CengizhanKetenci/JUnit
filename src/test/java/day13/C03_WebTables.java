package day13;

import Utilities.TestBase_Before_After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C03_WebTables extends TestBase_Before_After {
    @Test
    public void test1() {
        // bir önceki  classdaki adrese gidelim.
        // login() methodunu  kullanarak sayfaya giriş yapalım.
        login();

        int satir = 1;
        int sutun = 5;

        // input olarak verilen satır sayısına ve sutun sayısına  sahip cell deki text'i yazdıralım.
        WebElement cell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("verilen satır ve sutundaki veri = " + cell.getText());

        // baslık satırını yazdır.
        WebElement cell2 = driver.findElement(By.xpath("//thead//tr["+satir+"]"));
        System.out.println("başlık satırındaki veriler = " + cell2.getText());


        // Price başlığındaki tüm numaraları yazdırın

        List<WebElement> priceSutunList = driver.findElements(By.xpath("//tbody//td[6]"));
        String priceSutun = "";
        for (WebElement each:priceSutunList
        ) {
            priceSutun+= each.getText()+" ";
        }
        System.out.println("Price sütunu : "+priceSutun);
        // lambda ile yapalım.
        driver.findElements(By.xpath("//tbody//tr[*]//td[6]")).stream().map(WebElement::getText).forEach(System.out::println);
    }

    private void login() {

            // https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin.
            //  Username : manager
            //  Password : Manager1!

            driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
            driver.findElement(By.xpath("//*[@id='UserName'] "));
            Actions actions = new Actions(driver);
            WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
            actions.click(userName).sendKeys("manager").
                    sendKeys(Keys.TAB).sendKeys("Manager1!").
                    sendKeys(Keys.ENTER).perform();

        }
}


    // WebElement tekilHucre = driver.findElement(By.xpath("//tbody//tr[6]//td[4]"));
    // WebElement arananCell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
    // System.out.println(driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]")).getText());
