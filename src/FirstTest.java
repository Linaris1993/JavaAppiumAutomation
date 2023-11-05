import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ScreenOrientation;


public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;
    protected void setUp() throws Exception
    {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSearch() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
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

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
    }

    @Test
    public void testCancelSearch() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );

        MainPageObject.waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X Cancel search input",
                10
        );

        MainPageObject.waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "X is still present on the page",
                5
        );
    }

    @Test
    public void testCompareArticleTitle() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        WebElement title_element = MainPageObject.waitForElementPresent(
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

        WebElement ElementHasText = MainPageObject.assertElementHasText(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Couldn't find an element",
                10
        );

    }

    @Test
    public void testCancelSearchResult() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "apple",
                "Cannot find any article for 'apple'",
                10
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text, 'Apple')]"),
                "Cannot find any article associated with 'apple'",
                15
        );

        MainPageObject.assertElementLengthIsGreaterThan1(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text, 'Apple')]"),
                "Cannot find any article associated with 'apple'",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X Cancel search input",
                10
        );

        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text, 'Apple')]"),
                "Search result is still displayed",
                10
        );

    }

    @Test
    public void testSwipeArticle() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "Appium",
                "Cannot find 'Appium' topic searching by 'Java'",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Automation for Apps']"),
                "Cannot find 'Automation for Apps' topic searching by 'Appium'",
                15
        );
        MainPageObject.waitForElementPresent(
                By.id("pcs-edit-section-title-description"),
                "Cannot find Appium article",
                15
        );

        MainPageObject.swipeUpQuick();

        MainPageObject.swipeUpToFindElement(
                By.xpath("//android.view.View[@content-desc='View article in browser']"),
                "Cannot find the end of the article",
                20
        );
    }

    @Test
    public void testSaveFirstArticleToMyList() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        MainPageObject.waitForElementPresent(
                By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
                "Cannot find Java article",
                15
        );
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"),
                "Cannot find btn to open article options",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find save btn",
                10
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text ='Add to list']"),
                "Cannot find 'add to list' btn",
                15
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "Learning Programming",
                "cannot put text into articles folder input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK btn",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "Cannot find navigation button to 'My List'",
                5
        );
        MainPageObject.swipeUp(2000);

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Learning Programming']"),
                "Cannot find Saved Learnings",
                10
        );

        String name_of_folder = "Java (programming language)";
        MainPageObject.swipeElementToTheLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );
        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot delete saved article",
                5
        );

    }

    @Test
    public void AmountOfNotEmptySearch() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();


        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );

        String search_line = "Linkin Park Diskography";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                search_line,
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup']";
        MainPageObject.waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find anything by request " + search_line,
                15
        );

        int amount_of_search_results = MainPageObject.getAmountOfElements(
                By.xpath(search_result_locator)
        );
        Assert.assertTrue(
                "We found few results!",
                amount_of_search_results > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );

        String search_line = "asertyjhg";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                search_line,
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='asertyjhg']";
        String empty_result_label = "//*[@text='No results']";

        MainPageObject.waitForElementPresent(
                By.xpath(empty_result_label),
                "Cannot find empty result label by the request" + search_line,
                15
        );
        MainPageObject.assertElementNotPresent(
                By.xpath(search_result_locator),
                "We found some results by request " + search_line
        );
    }

    @Test
    public void testChangeScreenOrientationOnSearchResults() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );

        String search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                search_line,
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by" + search_line,
                15
        );

        String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.xpath("//*[@class='android.view.View'][@content-desc='Java (programming language)']"),
                "name",
                "Cannot find title of article",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = MainPageObject.waitForElementAndGetAttribute(
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

        String title_after_second_rotation = MainPageObject.waitForElementAndGetAttribute(
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
    public void testCheckSearchArticleAndBackground() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                "Java",
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        driver.runAppInBackground(5);

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find article after returning from background",
                15
        );

    }

    @Test
    public void testCheckIfArticleHasTitle() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );

        String search_line = "Mobile";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                search_line,
                "Cannot find any topic by searching 'Mobile'",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Mobile country code']"),
                "Cannot find 'Mobile country code' topic searching by 'Mobile'",
                15
        );

        MainPageObject.assertElementPresent(
                By.xpath("//android.view.View[@content-desc='Mobile country code']"),
                "Title for " + search_line + " is not present"
        );
    }

    @Test
    public void SavingTwoArticlesAndRemovingOne() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        String ArticleOne = "Java";
        String ArticleTwo = "Appium";

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                ArticleOne,
                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by " + ArticleOne,
                15
        );
        MainPageObject.waitForElementPresent(
                By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
                "Cannot find Java article",
                15
        );
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"),
                "Cannot find btn to open article options",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find save btn",
                10
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X Cancel search input",
                10
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search input",
                10
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_plate"),
                ArticleTwo,
                "Cannot find 'Appium' topic searching by " + ArticleTwo,
                15
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Automation for Apps']"),
                "Cannot find 'Automation for Apps' topic searching by " + ArticleTwo,
                15
        );
        MainPageObject.waitForElementPresent(
                By.id("pcs-edit-section-title-description"),
                "Cannot find " + ArticleTwo,
                15
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find save btn",
                10
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "Cannot find navigation button to 'My List'",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/item_title_container"),
                "Cannot find navigation button to 'My List'",
                5
        );
        String title_before_removingOneArticle = MainPageObject.waitForElementAndGetAttribute(
                By.xpath("//android.widget.TextView[@text='Appium']"),
                "text",
                "Cannot find title of article",
                15
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Appium']"),
                "Cannot find Saved articles by " + ArticleTwo,
                15
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find Saved articles by " + ArticleOne,
                15
        );

        MainPageObject.swipeElementToTheLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );
        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot delete " + ArticleOne,
                5
        );
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Appium']"),
                ArticleTwo + " is not present",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Appium']"),
                ArticleTwo + " is not present",
                10
        );
        String title_after_removingOneArticle = MainPageObject.waitForElementAndGetAttribute(
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


}



