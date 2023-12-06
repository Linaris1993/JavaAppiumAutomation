package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    @Test
    public void testSaveFirstArticleToMyList() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning Programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();
        NavigationUI.clickMyLists();
        ArticlePageObject.swipeUpFunction();

        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testSavingTwoArticlesAndRemovingOne() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();

        String ArticleOne = "Java";
        String ArticleTwo = "Appium";

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(ArticleOne);
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_ONE_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.saveArticle();
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(ArticleTwo);
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");
        ArticlePageObject.waitForTitleElement();
        String article_TWO_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.saveArticle();
        ArticlePageObject.closeArticle();
        NavigationUI.clickMyLists();

        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
        MyListPageObject.openSavedArticles();
        ArticlePageObject.verifySavedArticles(article_ONE_title);
        ArticlePageObject.verifySavedArticles(article_TWO_title);
        MyListPageObject.swipeByArticleToDelete(article_ONE_title);
        ArticlePageObject.verifySavedArticles(ArticleTwo);
        SearchPageObject.clickByArticleWithSubstring(ArticleTwo);
        ArticlePageObject.waitForTitleElement();
        String notDeletedArticleTitle = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article is different, you probably removed wrong article",
                article_TWO_title,
                notDeletedArticleTitle
        );
}
}
