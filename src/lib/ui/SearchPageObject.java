package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
    private static final String
    SEARCH_INIT_ELEMENT = "xpath://android.widget.ImageView[@content-desc='Search Wikipedia']",
    SEARCH_INPUT = "id:org.wikipedia:id/search_plate",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@text='{SUBSTRING}']",
    SEARCH_CANCEL_BTN = "id:org.wikipedia:id/search_close_btn",
    SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup']",
    SEARCH_EMPTY_RESULT_ELEMENT = "id:org.wikipedia:id/results_text",
    SEARCH_EMPTY_RESULT_LABEL = "xpath://*[@text='No results']",
    SEARCH_INPUT_PLACEHOLDER = "xpath://*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']";

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
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);

    }
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " +  substring, 5);
    }
    public void waitForCancelBtnToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BTN, "Cannot find 'X' cancel btn", 5);
    }

    public void waitForCancelBtnToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BTN, "'X' cancel btn is still present", 5);
    }
    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BTN, "Cannot find an click 'X' cancel btn", 5);
    }
    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " +  substring, 10);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by request",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(
                SEARCH_EMPTY_RESULT_ELEMENT,
                "Cannot find empty result element",
                15
        );
        this.waitForElementPresent(
                SEARCH_EMPTY_RESULT_LABEL,
                "Cannot find empty result label",
                15
        );
    }
    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(
                SEARCH_EMPTY_RESULT_ELEMENT,
                "We found some results"
        );
    }

    public void verifySearchResultsIsGreaterThanOne()
    {
        this.assertElementLengthIsGreaterThan1(
                SEARCH_RESULT_ELEMENT,
                "cannot find any article",
                10
        );
    }
    public void waitForSearchResultToDisappear()
    {
        this.waitForElementNotPresent(
                SEARCH_RESULT_ELEMENT,
                "Search result is still present!",
                10
        );
    }
    public void assertElementHasText()
    {
        this.assertElementHasText(SEARCH_INPUT_PLACEHOLDER,
                "Couldn't find an element",
                10
        );
    }
}
