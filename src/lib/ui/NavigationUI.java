package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {
    private static final String
    MY_LIST_LINK = "org.wikipedia:id/nav_tab_reading_lists";
    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementAndClick(
                By.id(MY_LIST_LINK),
                "Cannot find navigation button to 'My List'",
                5
        );
    }
}
