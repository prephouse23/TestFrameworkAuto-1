package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DriverInteractions extends BaseTest{

    @Test
    public void test1() {
        driver.get("https://test.my-fork.com");
        driver.navigate().refresh();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("keyboard");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        String urlToVerify = driver.getCurrentUrl();
        System.out.println(urlToVerify);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }
    @Test
    public void test2() {
        driver.get("https://test.my-fork.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("keyboard");
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabHandler.size());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        tabHandler = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabHandler.size());
        driver.switchTo().window(tabHandler.get(0));
        driver.switchTo().window(tabHandler.get(4));
        driver.navigate().to("https://test.my-fork.com");
    }
    @Test
    public void test3() {
        /* driver.get("https://test.my-fork.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");
        js.executeScript("window.scrollBy(0,-2500)", ""); */
        int pixels = 2000;
        System.out.println("Value");
        System.out.println("Value" + pixels);
        pixels = 10;
        System.out.println("Value" + pixels);

    }


}


