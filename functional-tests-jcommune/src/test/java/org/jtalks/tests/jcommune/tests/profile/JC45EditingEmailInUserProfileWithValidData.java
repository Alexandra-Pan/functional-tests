package org.jtalks.tests.jcommune.tests.profile;

import org.jtalks.tests.jcommune.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.StringHelp;

import static org.jtalks.tests.jcommune.Assert.Exsistence.assertExistById;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.*;

/**
 * author: erik
 * Date: 09.03.12
 * Time: 11:44
 */
public class JC45EditingEmailInUserProfileWithValidData {

    ProfilePage profilePage;

    String uniqEmail = StringHelp.getRandomEmail();
    String validEmail;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"app-url", "uUsername", "uPassword", "uEmail"})
    public void setupCase(String appUrl, String username, String password, String uEmail) {
        driver.get(appUrl);
        validEmail = uEmail;
        signIn(username, password);
        profilePage = new ProfilePage(driver);
        profilePage.getCurrentUserLink().click();
        profilePage.getEditProfileButton().click();
    }

    @Test
    public void testEditEmail() {
        profilePage.getEmailEditField().clear();
        profilePage.getEmailEditField().sendKeys(uniqEmail);
        profilePage.getSaveEditButton().click();
        Assert.assertEquals(profilePage.getEmail().getText(), uniqEmail);
    }

    @AfterMethod(alwaysRun = true)
    @Parameters({"app-url"})
    public void destroy(String appUrl) {
        profilePage.getCurrentUserLink().click();
        profilePage.getEditProfileButton().click();
        profilePage.getEmailEditField().clear();
        profilePage.getEmailEditField().sendKeys(validEmail);
        profilePage.getSaveEditButton().click();
        logOut(appUrl);
    }
}