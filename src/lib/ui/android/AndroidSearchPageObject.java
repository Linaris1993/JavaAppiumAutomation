package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT="xpath://android.widget.ImageView[@content-desc='Search Wikipedia']";
        SEARCH_INPUT="id:org.wikipedia:id/search_src_text";
        SEARCH_RESULT_BY_SUBSTRING_TPL="xpath://*[@text='{SUBSTRING}']";
        SEARCH_CANCEL_BTN="id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_ELEMENT="xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup']";
        SEARCH_EMPTY_RESULT_ELEMENT="id:org.wikipedia:id/results_text";
        SEARCH_EMPTY_RESULT_LABEL="xpath://*[@text='No results']";
        SEARCH_RESULT_LIST="xpath://lib.ui.android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']";
        SEARCH_INPUT_PLACEHOLDER="//*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']";
        }
    public AndroidSearchPageObject (AppiumDriver driver)
    {
        super(driver);
    }
}
