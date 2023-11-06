package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
    private static final String
    SEARCH_INIT_ELEMENT = "//android.widget.ImageView[@content-desc='Search Wikipedia']",
    SEARCH_INPUT = "org.wikipedia:id/search_plate",
    SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@text='{SUBSTRING}']",
    SEARCH_CANCEL_BTN = "org.wikipedia:id/search_close_btn";
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
}
