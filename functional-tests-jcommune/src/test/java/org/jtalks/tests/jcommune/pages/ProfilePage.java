package org.jtalks.tests.jcommune.pages;

import org.jtalks.tests.jcommune.common.JCommuneSeleniumTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @autor masyan
 */
public class ProfilePage {

	public static final String currentUserLinkSel = "//a[@class='currentusername']";

	public static final String userDetailsFormSel = "userdetails";

	public static final String profileLinkFromPMInpoxPageSel = "//a[contains(@href,'" + JCommuneSeleniumTest.contextPath + "/users')]";

	public static final String profileLinkFromTopicPageSel = "//a[contains(@href,'" + JCommuneSeleniumTest.contextPath + "/users') and @class='username']";

    public static final String editProfileButtonSel = "//a[contains(@href,'"+JCommuneSeleniumTest.contextPath+"/users/edit') and @class='button']";

    public static final String emailEditFieldIdSel = "email";

    public static final String saveEditButtonIdSel = "saveChanges";

    public static final String emailErrorMessageIdSel = "email.errors";
    
    public static final String emailSel = "//ul[@id='stylized']/li[4]/span";
    
    @FindBy (xpath = emailSel)
    private WebElement email;

	@FindBy(xpath = currentUserLinkSel)
	private WebElement currentUserLink;

	@FindBy(id = userDetailsFormSel)
	private WebElement userDetailsForm;

	@FindBy(xpath = profileLinkFromPMInpoxPageSel)
	private WebElement profileLinkFromPMInpoxPage;

	@FindBy(xpath = profileLinkFromTopicPageSel)
	private WebElement profileLinkFromTopicPage;

    @FindBy (xpath = editProfileButtonSel)
    private  WebElement editProfileButton;

    @FindBy (id = emailEditFieldIdSel)
    private WebElement emailEditField;

    @FindBy (id = saveEditButtonIdSel)
    private WebElement saveEditButton;

	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Getters
	public WebElement getCurrentUserLink() {
		return currentUserLink;
	}

	public WebElement getUserDetailsForm() {
		return userDetailsForm;
	}

	public WebElement getProfileLinkFromPMInpoxPage() {
		return profileLinkFromPMInpoxPage;
	}

	public WebElement getProfileLinkFromTopicPage() {
		return profileLinkFromTopicPage;
	}

    public WebElement getEditProfileButton() {
        return editProfileButton;
    }

    public WebElement getEmailEditField() {
        return emailEditField;
    }

    public WebElement getSaveEditButton() {
        return saveEditButton;
    }

    public WebElement getEmail() {
        return email;
    }
}
