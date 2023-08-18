package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

//Assertion = validation
// 2 types: Hard Assert and Soft Assert

//homework AssertionsHard

    public class Assertions extends BaseTest {
        String expectedTitle = "Quizzes list";
        String actualTitle;
        String menuList = "//div[@class=\"expertise-areas-list\"]//div";
        int listSizeActual;
        int listSizeExpected = 5;
        String menuItem = "//div[contains(text(),'Development')]";
        String anotherMenuItem = "//div[contains(text(),'Project Management')]";
        boolean expectedMenuItem = true;
        boolean actualMenuItem;
        boolean expectedAnotherMenuItem = false;
        boolean actualAnotherMenuItem;


       @Test
        public void dropdown() {
            driver.get("https://test.my-fork.com/quizzes-list");
            actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);
            System.out.println("title is correct");

            List<WebElement> elementList = driver.findElements(By.xpath(menuList));
            listSizeActual = elementList.size();
            Assert.assertEquals(listSizeActual, listSizeExpected);

            actualMenuItem = driver.findElement(By.xpath(menuItem)).isDisplayed();
            Assert.assertEquals(actualMenuItem, expectedMenuItem);
            System.out.println("Menu item is Development");

            actualAnotherMenuItem = driver.findElement(By.xpath(anotherMenuItem)).isDisplayed();
            Assert.assertEquals(actualAnotherMenuItem, expectedAnotherMenuItem);
            System.out.println("Menu item is Management");

            Assert.assertNotEquals(actualTitle, expectedTitle, "titles match");
            System.out.println("title is different");
        }
    }






