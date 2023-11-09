package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareArticleTitle() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        assertEquals(
                "We see unexpected title",
                "Object-oriented programming language",
                article_title
        );
    }

    @Test
    public void testSwipeArticle() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();
    }

    @Test
    public void testCheckIfArticleHasTitle() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Mobile");
        SearchPageObject.clickByArticleWithSubstring("Mobile country code");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.verifyTitleIsPresent("Mobile country code");
    }
}
