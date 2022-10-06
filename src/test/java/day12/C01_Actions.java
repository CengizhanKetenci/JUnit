package day12;

import Utilities.TestBase_Before_After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class C01_Actions extends TestBase_Before_After {

    @Test
    public void test1() {

        //Automationexercises.com sitesine gidelim
        driver.get("https://www.automationexercise.com");

        //Product bölümüne girelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();

        //ilk ürüne tıklayalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();
    }
}

