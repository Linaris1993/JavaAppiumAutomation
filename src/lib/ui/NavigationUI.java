package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {
    private static final String
    MY_LIST_LINK = "id:org.wikipedia:id/nav_tab_reading_lists",
    SKIP_LANGUAGE_BTN = "xpath:(//*[contains(@text,'Skip')])";
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
