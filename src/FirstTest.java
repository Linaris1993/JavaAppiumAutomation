import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ScreenOrientation;

import java.security.SecureRandom;


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

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelBtnToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelBtnToDisappear();
    }

    @Test
    public void testCompareArticleTitle() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "We see unexpected title",
                "Object-oriented programming language",
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

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();
    }

    @Test
    public void testSaveFirstArticleToMyList() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning Programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();
        ArticlePageObject.swipeUpFunction();

        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testAmountOfNotEmptySearch() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Diskography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found few results!",
                amount_of_search_results > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch() {
        WebElement skipLanguage = driver.findElementByXPath("//*[contains(@text,'Skip')]");
        skipLanguage.click();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "asertyjhg";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
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



