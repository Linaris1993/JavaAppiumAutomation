package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "xpath://*[@resource-id='pcs-edit-section-title-description']";
        FOOTER_ELEMENT = "xpath://android.view.View[@content-desc='View article in browser']";
        OPTIONS_ADD_TO_MY_LIST = "xpath://*[@text ='Add to list']";
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        MY_LIST_OK_BTN = "xpath://*[@text='OK']";
        CLOSE_ARTICLE_BTN = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        SEARCH_ARTICLE_BY_TEXT_TPL = "xpath://*[@text='{TEXT}']";
        SAVE_BTN = "id:org.wikipedia:id/page_save";
        ARTICLE_TITLE_TPL = "xpath://android.view.View[@content-desc='{TITLE}']";
    }
    public AndroidArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
