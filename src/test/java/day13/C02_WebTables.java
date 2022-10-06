package day13;

import Utilities.TestBase_Before_After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static sun.security.jgss.GSSUtil.login;

public class C02_WebTables extends TestBase_Before_After {
    @Test
    public void test1() throws InterruptedException {

        // login( ) metodun oluşturun ve oturum açın.
        login();
        //  https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //  Username : manager
        //  Password : Manager1!

        //  table( ) metodu oluşturun
        table();
        //  Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        //  Table’daki tum body’leri ve başlıkları(headers) konsolda yazdırın.

        //  printRows( ) metodu oluşturun.
        printRows();

        //  table body’sinde bulunan toplam satir(row) sayısını bulun.
        //  Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //  4.satirdaki(row) elementleri konsolda yazdırın.
    }

    private void printRows() {

        //  table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir Sayisi = " + satirList.size()); // 10

        //  Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        for (WebElement each :satirList
             ) {
            System.out.println(each.getText());
        }
        // veya lambda ile yazdırmak istersek.
        satirList.forEach(t-> System.out.println(t.getText()));
        // veya lambda ile yazdırmak istersek.
        satirList.stream().map(WebElement::getText).limit(4).skip(3).forEach(System.out::println);


        //  4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4.SATIR ELEMENTLERİ " + driver.findElements(By.xpath("//tbody//tr[4]")));
    }

    private void table() throws InterruptedException {
        /*
        Tabloda  -table- tagı altında tablonun başlığını gösteren -thead- tagı bulunur.
        Eğer başlıkta satır (row) varsa -thead- tagı altında -tr- satır tagı vardır.
        Başlıktaki sütunlara yani hücrelere (cell) -th- tagı ile ulaşılır.
        Başlığın altındaki tablodaki verilere -tbody- tagı ile, altındaki satırlara -tr- tagı ile,
        sütünlara yani hücrelere -td- tagı ile ulaşılır.
         */
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("sutunSayisi.size() = " + sutunSayisi.size());

        //  table body’sinde bulunan toplam satir(row) sayısını bulun.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("basliklar = " + basliklar.getText());
        WebElement body = driver.findElement(By.xpath("//tbody"));
        Thread.sleep(2000);
        System.out.println("Tum body = "+body.getText());
        System.out.println("basliklar.getSize() = " + basliklar.getSize());
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
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }


    }
