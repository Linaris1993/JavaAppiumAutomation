package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class iOSMyListsPageObject extends MyListsPageObject {
    static {
        SAVED_ARTICLES = "xpath://XCUIElementTypeLink[contains(@text, '{TITLE}']";
    }
    public iOSMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
