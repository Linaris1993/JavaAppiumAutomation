package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
    TITLE,
    FOOTER_ELEMENT,
    OPTIONS_ADD_TO_MY_LIST,
    MY_LIST_NAME_INPUT,
    MY_LIST_OK_BTN,
    CLOSE_ARTICLE_BTN,
    SEARCH_ARTICLE_BY_TEXT_TPL,
    SAVE_BTN,
    ARTICLE_TITLE_TPL;

    public ArticlePageObject (AppiumDriver driver)
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
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("contentDescription");
        } else {
         return    title_element.getAttribute("name");
        }
    }
    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    40
            );
        } else {
            this.swipeUpTillElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
            40
            );
        }
    }

    public void swipeUpFunction()
    {
     this.swipeUp();
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
    public void addArticleToMySaved() {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST, "Cannot find option to add article to reading list", 5);
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
