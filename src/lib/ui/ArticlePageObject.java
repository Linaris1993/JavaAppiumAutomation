package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String
    TITLE = "id:pcs-edit-section-title-description",
    FOOTER_ELEMENT = "xpath://android.view.View[@content-desc='View article in browser']",
    OPTIONS_ADD_TO_MY_LIST = "xpath://*[@text ='Add to list']",
    MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
    MY_LIST_OK_BTN = "xpath://*[@text='OK']",
    CLOSE_ARTICLE_BTN = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
    SEARCH_ARTICLE_BY_TEXT_TPL = "xpath://*[@text='{TEXT}']",
    SAVE_BTN = "id:org.wikipedia:id/page_save",
    ARTICLE_TITLE_TPL = "xpath://android.view.View[@content-desc='{TITLE}']";

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
    private static String  getArticleSearchByText(String text)
    {
        return SEARCH_ARTICLE_BY_TEXT_TPL.replace("{TEXT}", text);
    }

    private static String getArticleTitle(String title)
    {
        return ARTICLE_TITLE_TPL.replace("{TITLE}", title);
    }
    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on the page", 15);
    }
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("name");
    }
    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
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
        this.waitForElementAndClick(
                SAVE_BTN,
                "Cannot find save btn",
                10
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST,
                "Cannot find 'add to list' btn",
                15
        );
        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "cannot put text into articles folder input",
                5
        );
        this.waitForElementAndClick(
                MY_LIST_OK_BTN,
                "Cannot press OK btn",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BTN,
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );

        this.waitForElementAndClick(
                CLOSE_ARTICLE_BTN,
                "Cannot go back from Article, cannot find 'Go Back' Arrow",
                5
        );
    }

    public void saveArticle()
    {
        this.waitForElementAndClick(
                SAVE_BTN,
                "Cannot find save btn",
                10
        );
    }
    public void verifySavedArticles(String text) {
        String search_result_text = getArticleSearchByText(text);
        this.waitForElementPresent(search_result_text, "Cannot find saved article by text " + text, 5);
    }

    public void verifyTitleIsPresent(String title)
    {
        String article_title = getArticleTitle(title);
        this.assertElementPresent(article_title,
                "Title is not present"
        );
    }
}
