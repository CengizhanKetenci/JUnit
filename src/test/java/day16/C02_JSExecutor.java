package day16;

import Utilities.TestBase_Before_After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C02_JSExecutor extends TestBase_Before_After {

    @Test
    public void test1() {

        // amazon sayfasına gidelim.
        driver.get("https://www.amazon.com");

        // aşağıdaki carrers butonunu göürnceye kadar js ile scroll yapalım.
        WebElement carrers = driver.findElement(By.xpath("//*[text()='Careers']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carrers);

        // Carrers butonuna js ile click yapalım.
        jse.executeScript("arguments[0].click();",carrers);

    }
}
