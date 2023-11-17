package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelBtnToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelBtnToDisappear();
    }

    @Test
    public void testAmountOfNotEmptySearch() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Diskography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found few results!",
                amount_of_search_results > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "asertyjhg";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    public void testCancelSearchResult() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        String search_line = "apple";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.verifySearchResultsIsGreaterThanOne();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForSearchResultToDisappear();

    }

    @Test
    public void testToAssertElementHasText() {
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.skipLanguage();

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        //SearchPageObject.initSearchInput();
        SearchPageObject.assertElementHasText();
    }
}