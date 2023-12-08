package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import lib.Platform;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
    FOLDER_BY_NAME_TPL,
    SAVED_ARTICLES;

    private static String getFolderXPathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXPathByTitle(String article_title)
    {
        return FOLDER_BY_NAME_TPL.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXPathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name " + name_of_folder,
                10
        );
    }
    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getFolderXPathByName(article_title);
        this.waitForElementPresent(
                article_xpath,
                "Cannot find saved article is still present with title " + article_title,
                15
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getFolderXPathByName(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "Saved article is still present with title " + article_title,
                15
        );
    }
    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getFolderXPathByName(article_title);
        this.swipeElementToTheLeft(
                article_xpath,
                "Cannot find saved article"
        );
        if (Platform.getInstance().isIOS()) {
        this.clickElementToTheRightUpperCorner(article_xpath, "cannot find saved article");
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void openSavedArticles()
    {
        this.waitForElementAndClick(SAVED_ARTICLES,
        "Cannot find navigation button to 'My List'",
        5
        );
    }
}
