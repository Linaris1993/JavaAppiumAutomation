package tests;
import lib.ui.WelcomePageObject;
import org.junit.Test;
import lib.CoreTestCase;

public class getStartedTest  extends CoreTestCase {

    @Test
    public void testPassThroughWelcome()
    {
        if (this.Platform.isAndroid()) {
            return;
        }
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWayToExploreTest();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOrEditPreferredLangText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreAboutDataCollectedText();
        WelcomePage.clickGetStartedBtn();
    }
}
