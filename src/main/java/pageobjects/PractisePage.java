package pageobjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PractisePage extends BaseMain {

    public PractisePage(ChromeDriver driver) {
        super(driver);
    }

    String websiteURL = "https://test.my-fork.com";
    String webpageURL = "https://test.my-fork.com/quizzes-list";
    String history = "//div[@id='bodyInfoPopup']";
    String history_Btn = "//a[@class='quiz-section-history-button']";
    String emailField = "//input[@id='email']";
    String passwordField = "//input[@id='password']";
    String logIn_Btn = "//div[@id='loginButton']/button']";

    //values:
    String emailValue = "testing@my-fork.com";
    String passwordValue = "Password";
    String domain = "https://test.my-fork.com/";
    String URL = domain + "quiz/661";
    By numberOfAnsweredQuestions = By.xpath("//div[@class='quiz-process-progress-bar']");

// scenario 1
    public void openCourseGallery() {
        driver.get(this.webpageURL);
    }

    public void historyUnavailable() {
        driver.get(this.webpageURL);
    }

    public void openWebsite() {
        driver.get(websiteURL);
    }

    public void openCourseGalleryPage() {
        driver.get(webpageURL);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\GitHub\\TestFrameworkAuto\\src\\test\\Resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.navigate().to(webpageURL);
    }
    public void signInAndValidateHistory() {
        driver.get(websiteURL);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\GitHub\\TestFrameworkAuto\\src\\test\\Resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.findElement(By.xpath(emailField)).sendKeys(emailValue);
        driver.findElement(By.xpath(passwordField)).sendKeys(passwordValue);
        driver.findElement(By.xpath(logIn_Btn)).submit();
        driver.navigate().to(webpageURL);
        WebDriverWait waitForPageToLoad = new WebDriverWait(driver,Duration.ofSeconds(20));
        waitForPageToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(history_Btn)));
        System.out.println(driver.findElement(By.xpath(history_Btn)).isDisplayed());
    }

    public void returnMainPageAfterLogIn() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\GitHub\\TestFrameworkAuto\\src\\test\\Resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.navigate().to(webpageURL);
        driver.navigate().to(websiteURL);
    }
    public void validateHistoryAgain() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\GitHub\\TestFrameworkAuto\\src\\test\\Resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.navigate().to(websiteURL);
        driver.findElement(By.xpath("//a[@class='menu-item log-in-button']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(new CharSequence[]{"testing@my-fork.com"});
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(new CharSequence[]{"Password"});
        driver.findElement(By.xpath("//div[@id='loginButton']/button")).sendKeys(new CharSequence[]{Keys.ENTER});
        driver.navigate().to(webpageURL);
        WebDriverWait waitForPageToLoad = new WebDriverWait(driver,Duration.ofSeconds(20));
        waitForPageToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(history_Btn)));
        System.out.println(driver.findElement(By.xpath(history_Btn)).isDisplayed());
    }

    // scenario 2

    public void openMainPageAndCourseGallery() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\GitHub\\TestFrameworkAuto\\src\\test\\Resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.navigate().to(websiteURL);
        driver.navigate().to(webpageURL);
    }
    public int numberOfAnsweredQuestions() {
        return driver.findElements(numberOfAnsweredQuestions).size();
    }
    public void validateNumberOfAnsweredQuestionsAndTotalNumber() {
        dev.failsafe.internal.util.Assert.assertEquals(validateNumberOfAnsweredQuestionsAndTotalNumber(), 1);

        for (int i = 0; i < 9; i++) {
            System.out.println("iteration number: " + i);
            scrollBy(1600);
            waitForNumberOfAnsweredQuestions(i);
            dev.failsafe.internal.util.Assert.assertEquals(numberOfAnsweredQuestions(), i);
        }
    }
    // scenario 3

    public void openMainPageThenCourseGallery() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Documents\\GitHub\\TestFrameworkAuto\\src\\test\\Resources\\executables\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.navigate().to(websiteURL);
        driver.navigate().to(webpageURL);
    }

    }


