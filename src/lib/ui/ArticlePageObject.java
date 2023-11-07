package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String
    TITLE = "pcs-edit-section-title-description",
    FOOTER_ELEMENT = "//android.view.View[@content-desc='View article in browser']",
    OPTIONS_ADD_TO_MY_LIST = "//*[@text ='Add to list']",
    MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_OK_BTN = "//*[@text='OK']",
    CLOSE_ARTICLE_BTN = "//android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on the page", 15);
    }
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("name");
    }
    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of the article",
                20
        );
    }

    public void swipeUpFunction()
    {
     this.swipeUp(2000);
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementPresent(
                By.id("org.wikipedia:id/page_toolbar_button_show_overflow_menu"),
                "Cannot find btn to open article options",
                5
        );
        this.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find save btn",
                10
        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST),
                "Cannot find 'add to list' btn",
                15
        );
        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "cannot put text into articles folder input",
                5
        );
        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BTN),
                "Cannot press OK btn",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BTN),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );

        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BTN),
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );
    }
}
