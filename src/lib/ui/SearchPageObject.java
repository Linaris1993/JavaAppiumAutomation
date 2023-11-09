package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
    private static final String
    SEARCH_INIT_ELEMENT = "//android.widget.ImageView[@content-desc='Search Wikipedia']",
    SEARCH_INPUT = "org.wikipedia:id/search_plate",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@text='{SUBSTRING}']",
    SEARCH_CANCEL_BTN = "org.wikipedia:id/search_close_btn",
    SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup']",
    SEARCH_EMPTY_RESULT_ELEMENT = "org.wikipedia:id/results_text",
    SEARCH_EMPTY_RESULT_LABEL = "//*[@text='No results']",
    SEARCH_INPUT_PLACEHOLDER = "//*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']";

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    /*TPL (TEMPLATES) method */
    private static String  getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    public void initSearchInput()
    {
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);

    }
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.id(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " +  substring, 5);
    }
    public void waitForCancelBtnToAppear()
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BTN), "Cannot find 'X' cancel btn", 5);
    }

    public void waitForCancelBtnToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BTN), "'X' cancel btn is still present", 5);
    }
    public void clickCancelSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BTN), "Cannot find an click 'X' cancel btn", 5);
    }
    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " +  substring, 10);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by request",
                15
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(
                By.id(SEARCH_EMPTY_RESULT_ELEMENT),
                "Cannot find empty result element",
                15
        );
        this.waitForElementPresent(
                By.xpath(SEARCH_EMPTY_RESULT_LABEL),
                "Cannot find empty result label",
                15
        );
    }
    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(
                By.xpath(SEARCH_EMPTY_RESULT_ELEMENT),
                "We found some results"
        );
    }

    public void verifySearchResultsIsGreaterThanOne()
    {
        this.assertElementLengthIsGreaterThan1(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "cannot find any article",
                10
        );
    }
    public void waitForSearchResultToDisappear()
    {
        this.waitForElementNotPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Search result is still present!",
                10
        );
    }
    public void assertElementHasText()
    {
        this.assertElementHasText( By.xpath(SEARCH_INPUT_PLACEHOLDER),
                "Couldn't find an element",
                10
        );
    }
}
