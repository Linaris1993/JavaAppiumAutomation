import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.font.TextAttribute;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.stream.events.Attribute;


public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/13477/OneDrive/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                 "Java",
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15

        );
//        WebElement element_to_init_search = waitForElementPresent(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find search input"
//
//        );
//        element_to_init_search.sendKeys("Java");

        waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
    }
    @Test

    public void testCancelSearch() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                 "Java",
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                10
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X Cancel search input",
                10
        );

        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "X is still present on the page",
                5
        );
    }

    @Test
    public void testCompareArticleTitle() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15

        );

        waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        WebElement title_element = waitForElementPresent(
           By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
                "Cannot find Java article",
                15
        );

        String article_title = title_element.getAttribute("text");

        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );
    }

    @Test
public void testToAssertElementHasText() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        WebElement ElementHasText = assertElementHasText(
                By.xpath("//*[contains(@text,'Search Wikipedia')]") ,
                "Couldn't find an element",
                10
        );

    }
    private WebElement assertElementHasText(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.textToBePresentInElement(by,"Search Wikipedia"));
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
    );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

//    private WebElement waitForElementPresent(By by, String error_message)
//    {
//       return waitForElementPresent(by, error_message, 5);
//    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
       WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
       element.click();
       return element;
    }
    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

}
