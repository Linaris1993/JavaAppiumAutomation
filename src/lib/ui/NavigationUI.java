package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject {

    protected static String
            MY_LIST_LINK,
            SKIP_LANGUAGE_BTN;


    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementAndClick(
                MY_LIST_LINK,
                "Cannot find navigation button to 'My List'",
                5
        );
    }

    public void skipLanguage()
    {
     this.skipLanguageFunction(
             SKIP_LANGUAGE_BTN,
             "Cannot find 'Skip' btn",
             10
     );
    }
}
