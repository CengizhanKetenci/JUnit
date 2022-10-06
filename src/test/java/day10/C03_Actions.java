package day10;

import Utilities.TestBase_Before_After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Actions extends TestBase_Before_After {
    /*
        amazon sayfasına gidelim
        Account menüsünden "create a list" linkine tıklayalım.
    */

    @Test
    public void test1() throws Exception {

        driver.get("https://www.amazon.com");
        WebElement accountButton = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions =new Actions(driver);
        actions.moveToElement(accountButton).perform();
        /*
        Bir web sitesinde bir web elementin mause ile açılan bir web elementine ulaşmak istersek
        Actions.actions.moveToElement(accountButton).perform(); methodunu kullanmamız gerekir.
        aksi takdirde HTML kodları arasında web elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable exception'ı fırlatır.
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }
}
