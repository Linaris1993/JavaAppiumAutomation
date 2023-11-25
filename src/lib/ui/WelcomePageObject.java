package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject {

    private static final String
    STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
    STEP_NEW_WAYS_TO_EXPLORER_TEXT = "id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "id:Add or Edit preferred languages",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "id:Learn More about data collected",
    NEXT_LINK = "id:Next",
    GET_STARTED_BTN = "id:Get started",
    SKIP = "id:Skip";

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find 'Learn more about Wikipedia'", 10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(NEXT_LINK, "Cannot find 'Next' Link", 10);
    }

    public void waitForNewWayToExploreTest()
    {
        this.waitForElementAndClick(STEP_NEW_WAYS_TO_EXPLORER_TEXT, "Cannot find 'New way to explore' link", 10);
    }

    public void waitForAddOrEditPreferredLangText()
    {
        this.waitForElementAndClick(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK,"Cannot find 'Add or Edit preferred languages' link", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText()
    {
        this.waitForElementAndClick(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK, "Cannot find 'Learn More about data collected' link", 10);
    }

    public void clickGetStartedBtn()
    {
        this.waitForElementAndClick(GET_STARTED_BTN, "Cannot find 'Get started' link", 10);
    }

    public void clickSkip()
    {
        this.waitForElementAndClick(SKIP, "Cannot find and click skip btn", 5);
    }
}
