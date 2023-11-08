import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;

public class FirstTest extends CoreTestCase {

//    @Test
//    public void testToAssertElementHasText() {
//        NavigationUI NavigationUI = new NavigationUI(driver);
//        NavigationUI.skipLanguage();
//
//        WebElement ElementHasText = MainPageObject.assertElementHasText(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Couldn't find an element",
//                10
//        );
//
//    }

//    @Test
//    public void testCancelSearchResult() {
//        NavigationUI NavigationUI = new NavigationUI(driver);
//        NavigationUI.skipLanguage();
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
//                "Cannot find search input",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_plate"),
//                "apple",
//                "Cannot find any article for 'apple'",
//                10
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text, 'Apple')]"),
//                "Cannot find any article associated with 'apple'",
//                15
//        );
//
//        MainPageObject.assertElementLengthIsGreaterThan1(
//                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text, 'Apple')]"),
//                "Cannot find any article associated with 'apple'",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "Cannot find X Cancel search input",
//                10
//        );
//
//        MainPageObject.waitForElementNotPresent(
//                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text, 'Apple')]"),
//                "Search result is still displayed",
//                10
//        );
//
//    }


//    @Test
//    public void testCheckIfArticleHasTitle() {
//        NavigationUI NavigationUI = new NavigationUI(driver);
//        NavigationUI.skipLanguage();
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
//                "Cannot find search input",
//                5
//        );
//
//        String search_line = "Mobile";
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_plate"),
//                search_line,
//                "Cannot find any topic by searching 'Mobile'",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='Mobile country code']"),
//                "Cannot find 'Mobile country code' topic searching by 'Mobile'",
//                15
//        );
//
//        MainPageObject.assertElementPresent(
//                By.xpath("//android.view.View[@content-desc='Mobile country code']"),
//                "Title for " + search_line + " is not present"
//        );
//    }

//    @Test
//    public void SavingTwoArticlesAndRemovingOne() {
//        NavigationUI NavigationUI = new NavigationUI(driver);
//        NavigationUI.skipLanguage();
//
//        String ArticleOne = "Java";
//        String ArticleTwo = "Appium";
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc='Search Wikipedia']"),
//                "Cannot find search input",
//                5
//        );
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_plate"),
//                ArticleOne,
//                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
//                15
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='Object-oriented programming language']"),
//                "Cannot find 'Object-oriented programming language' topic searching by " + ArticleOne,
//                15
//        );
//        MainPageObject.waitForElementPresent(
//                By.xpath("//android.view.View[@content-desc='Java (programming language)']"),
//                "Cannot find Java article",
//                15
//        );
//        MainPageObject.waitForElementPresent(
//                By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"),
//                "Cannot find btn to open article options",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/page_save"),
//                "Cannot find save btn",
//                10
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot go back from Article, cannot find 'Go Back' Arrow",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "Cannot find X Cancel search input",
//                10
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Cannot find search input",
//                10
//        );
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_plate"),
//                ArticleTwo,
//                "Cannot find 'Appium' topic searching by " + ArticleTwo,
//                15
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='Automation for Apps']"),
//                "Cannot find 'Automation for Apps' topic searching by " + ArticleTwo,
//                15
//        );
//        MainPageObject.waitForElementPresent(
//                By.id("pcs-edit-section-title-description"),
//                "Cannot find " + ArticleTwo,
//                15
//        );
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/page_save"),
//                "Cannot find save btn",
//                10
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot go back from Article, cannot find 'Go Back' Arrow",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot go back from Article, cannot find 'Go Back' Arrow",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/nav_tab_reading_lists"),
//                "Cannot find navigation button to 'My List'",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/item_title_container"),
//                "Cannot find navigation button to 'My List'",
//                5
//        );
//        String title_before_removingOneArticle = MainPageObject.waitForElementAndGetAttribute(
//                By.xpath("//android.widget.TextView[@text='Appium']"),
//                "text",
//                "Cannot find title of article",
//                15
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[@text='Appium']"),
//                "Cannot find Saved articles by " + ArticleTwo,
//                15
//        );
//
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[@text='Java (programming language)']"),
//                "Cannot find Saved articles by " + ArticleOne,
//                15
//        );
//
//        MainPageObject.swipeElementToTheLeft(
//                By.xpath("//*[@text='Java (programming language)']"),
//                "Cannot find saved article"
//        );
//        MainPageObject.waitForElementNotPresent(
//                By.xpath("//*[@text='Java (programming language)']"),
//                "Cannot delete " + ArticleOne,
//                5
//        );
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[@text='Appium']"),
//                ArticleTwo + " is not present",
//                15
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='Appium']"),
//                ArticleTwo + " is not present",
//                10
//        );
//        String title_after_removingOneArticle = MainPageObject.waitForElementAndGetAttribute(
//                By.xpath("(//android.view.View[@content-desc='Appium'])[1]"),
//                "name",
//                "Cannot find title of article",
//                15
//        );
//        assertEquals(
//                "Article is different, you probably removed wrong article",
//                title_before_removingOneArticle,
//                title_after_removingOneArticle
//        );
    }



