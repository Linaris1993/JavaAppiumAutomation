import io.appium.java_client.TouchAction;
import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirstTest extends CoreTestCase {

    @Test
    public void testSearch() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
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
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
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
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
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
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Couldn't find an element",
                10
        );

    }

    @Test
    public void testCancelSearchResult() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "apple",
                "Cannot find any article for 'apple'",
                10
        );

        waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text, 'Apple')]"),
                "Cannot find any article associated with 'apple'",
                15
        );

        assertElementLengthIsGreaterThan1(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text, 'Apple')]"),
                "Cannot find any article associated with 'apple'",
                15
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X Cancel search input",
                10
        );

        waitForElementNotPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text, 'Apple')]"),
                "Search result is still displayed",
                10
        );

    }

    @Test
    public void testSwipeArticle() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "Appium",
                "Cannot find 'Appium' topic searching by 'Java'",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Automation for Apps']"),
                "Cannot find 'Automation for Apps' topic searching by 'Appium'",
                15
        );
        waitForElementPresent(
                By.id("pcs-edit-section-title-description"),
                "Cannot find Appium article",
                15
        );

        swipeUpQuick();

        swipeUpToFindElement(
                By.xpath("//android.view.View[@content-desc='View article in browser']"),
                "Cannot find the end of the article",
                20
        );
    }

    @Test
    public void testSaveFirstArticleToMyList() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        waitForElementPresent(
                By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
                "Cannot find Java article",
                15
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"),
                "Cannot find btn to open article options",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find save btn",
                10
        );
        waitForElementAndClick(
                By.xpath("//*[@text ='Add to list']"),
                "Cannot find 'add to list' btn",
                15
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "Learning Programming",
                "cannot put text into articles folder input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK btn",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "Cannot find navigation button to 'My List'",
                5
        );
        swipeUp(2000);

        waitForElementAndClick(
                By.xpath("//*[@text='Learning Programming']"),
                "Cannot find Saved Learnings",
                10
        );

        String name_of_folder = "Java (programming language)";
        swipeElementToTheLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );
        waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot delete saved article",
                5
        );

    }

    @Test
    public void AmountOfNotEmptySearch() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();


        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );

        String search_line = "Linkin Park Diskography";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                search_line,
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup']";
        waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find anything by request " + search_line,
                15
        );

        int amount_of_search_results = getAmountOfElements(
                By.xpath(search_result_locator)
        );
        Assert.assertTrue(
                "We found few results!",
                amount_of_search_results > 0
        );
    }

    @Test
   public void testAmountOfEmptySearch()
    {
    WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );

String search_line = "asertyjhg";
    waitForElementAndSendKeys(
            By.id("org.wikipedia:id/search_plate"),
            search_line,
            "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
            15
    );

String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='asertyjhg']";
String empty_result_label = "//*[@text='No results']";

    waitForElementPresent(
            By.xpath(empty_result_label),
            "Cannot find empty result label by the request" + search_line,
            15
    );
    assertElementNotPresent(
            By.xpath(search_result_locator),
            "We found some results by request " + search_line
    );
}

    @Test
    public void testChangeScreenOrientationOnSearchResults()
{
    WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
    skipLanguage.click();

    waitForElementAndClick(
            By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
            "Cannot find search input",
            5
    );

    String search_line = "Java";
    waitForElementAndSendKeys(
            By.id("org.wikipedia:id/search_plate"),
            search_line,
            "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
            15
    );

    waitForElementAndClick(
            By.xpath("//*[@text='Object-oriented programming language']"),
            "Cannot find 'Object-oriented programming language' topic searching by" + search_line,
            15
    );

    String title_before_rotation = waitForElementAndGetAttribute(
            By.xpath("//*[@class='android.view.View'][@content-desc='Java (programming language)']"),
            "name",
            "Cannot find title of article",
            15
    );

    driver.rotate(ScreenOrientation.LANDSCAPE);

    String title_after_rotation = waitForElementAndGetAttribute(
            By.xpath("//*[@class='android.view.View'][@content-desc='Java (programming language)']"),
            "name",
            "Cannot find title of article",
            15
    );

    Assert.assertEquals(
            "Article title has been changes after screen rotation",
            title_before_rotation,
            title_after_rotation
    );

    driver.rotate(ScreenOrientation.PORTRAIT);

    String title_after_second_rotation = waitForElementAndGetAttribute(
            By.xpath("//*[@class='android.view.View'][@content-desc='Java (programming language)']"),
            "name",
            "Cannot find title of article",
            15
    );

    Assert.assertEquals(
            "Article title has been changes after screen rotation",
            title_before_rotation,
            title_after_second_rotation
    );
}

    @Test
    public void testCheckSearchArticleAndBackground()
    {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
               "Cannot find search input",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        driver.runAppInBackground(5);

        waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find article after returning from background",
                15
        );

    }

    @Test
    public void testCheckIfArticleHasTitle()
    {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );

        String search_line = "Mobile";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                search_line,
                "Cannot find any topic by searching 'Mobile'",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Mobile country code']"),
                "Cannot find 'Mobile country code' topic searching by 'Mobile'",
                15
        );

        assertElementPresent(
                By.xpath("//android.view.View[@content-desc='Mobile country code']"),
                "Title for " + search_line + " is not present"
        );
    }

    @Test
    public void SavingTwoArticlesAndRemovingOne()
    {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        String ArticleOne = "Java";
        String ArticleTwo = "Appium";

        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                ArticleOne,
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by " + ArticleOne,
                15
        );
        waitForElementPresent(
                By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
                "Cannot find Java article",
                15
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"),
                "Cannot find btn to open article options",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find save btn",
                10
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X Cancel search input",
                10
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search input",
                10
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                ArticleTwo,
                "Cannot find 'Appium' topic searching by " + ArticleTwo,
                15
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Automation for Apps']"),
                "Cannot find 'Automation for Apps' topic searching by " + ArticleTwo,
                15
        );
        waitForElementPresent(
                By.id("pcs-edit-section-title-description"),
                "Cannot find " + ArticleTwo,
                15
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find save btn",
                10
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "Cannot find navigation button to 'My List'",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/item_title_container"),
                "Cannot find navigation button to 'My List'",
                5
        );
        String title_before_removingOneArticle = waitForElementAndGetAttribute(
                By.xpath("//android.widget.TextView[@text='Appium']"),
                "text",
                "Cannot find title of article",
                15
        );

        waitForElementPresent(
                By.xpath("//*[@text='Appium']"),
                "Cannot find Saved articles by " + ArticleTwo,
                15
        );

        waitForElementPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find Saved articles by " + ArticleOne,
                15
        );

        swipeElementToTheLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );
        waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot delete " + ArticleOne,
                5
        );
        waitForElementPresent(
                By.xpath("//*[@text='Appium']"),
                ArticleTwo + " is not present",
                15
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Appium']"),
                ArticleTwo + " is not present",
                10
        );
        String title_after_removingOneArticle = waitForElementAndGetAttribute(
                By.xpath("(//android.view.View[@content-desc='Appium'])[1]"),
                "name",
                "Cannot find title of article",
                15
        );
        Assert.assertEquals(
                "Article is different, you probably removed wrong article",
                title_before_removingOneArticle,
                title_after_removingOneArticle
        );
    }

    private WebElement assertElementHasText(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.textToBePresentInElement(by, "Search Wikipedia"));
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement assertElementLengthIsGreaterThan1(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 1));
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

//    private WebElement waitForElementPresent(By by, String error_message)
//    {
//       return waitForElementPresent(by, error_message, 5);
//    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    protected void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
    }

    protected void swipeUpQuick() {
        swipeUp(200);
    }

    protected void swipeUpToFindElement(By by, String error_message, int max_swipes) {
//        driver.findElements(by);
//        driver.findElements(by).size(); //will find amount of elements found in findElements();
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipes) {
                waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }

    protected void swipeElementToTheLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                15
        );

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x - 10, middle_y)
                .waitAction(400)
                .moveTo(left_x + 10, middle_y)
                .release()
                .perform();
    }

    private int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent(By by, String error_message)
    {
    int amount_of_elements = getAmountOfElements(by);
    if (amount_of_elements > 0) {
        String default_message = "An element " + by.toString() + " supposed to be not present";
    throw new AssertionError(default_message + " " + error_message);
        }
    }

    private void assertElementPresent(By by, String error_message)
    {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements <= 0) {
            String default_message = "Title " + by.toString() + " is not present";
        throw new AssertionError(default_message + " " + error_message);
        }
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds)
    {
    WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
    return element.getAttribute(attribute);
    }
}

