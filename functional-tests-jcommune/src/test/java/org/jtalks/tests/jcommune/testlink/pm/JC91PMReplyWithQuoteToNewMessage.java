package org.jtalks.tests.jcommune.testlink.pm;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.CollectionHelp;
import utils.StringHelp;

import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.driver;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.logOut;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.pmPage;
import static org.jtalks.tests.jcommune.common.JCommuneSeleniumTest.signIn;
import static org.testng.Assert.assertEquals;

/**
 * @author masyan
 */
public class JC91PMReplyWithQuoteToNewMessage {
	String title = StringHelp.getRandomString(10);
	String fromUser;
	String message = StringHelp.getRandomString(10);

	@BeforeMethod(alwaysRun = true)
	@Parameters({"app-url", "uUsername", "uPassword", "uUsername2", "uPassword2"})
	public void setupCase(String appUrl, String username, String password, String username2, String password2) {
		driver.get(appUrl);
		signIn(username, password);
		pmPage.getPmInboxLink().click();
		pmPage.getPmNewMessageLink().click();
		pmPage.getToField().sendKeys(username2);
		pmPage.getTitleField().sendKeys(title);
		pmPage.getMessageField().sendKeys(message);
		pmPage.getSendButton().click();
		logOut(appUrl);
		signIn(username2, password2);
		pmPage.getPmInboxLink().click();
		fromUser = username;
	}

	@AfterMethod(alwaysRun = true)
	@Parameters({"app-url"})
	public void destroy(String appUrl) {
		logOut(appUrl);
	}

	@Test
	public void pmReplyWithQuoteToNewMessageTest() {

		CollectionHelp.getFirstWebElementFromCollection(pmPage.getPmSubjectLinks()).click();
		pmPage.getQuoteButton().click();
		String toFieldText = pmPage.getToField().getAttribute("value");
		String subjectFieldText = pmPage.getTitleField().getAttribute("value");
		String messageFieldText = pmPage.getMessageField().getText();
		//check To field
		assertEquals(toFieldText, fromUser, "Not correct value in To field should be '" + fromUser + "' actual='" + toFieldText + "'");
		//check title
		assertEquals(subjectFieldText, "Re: " + title, "Not correct value in Subject field should be '" + "Re: " + title + "' actual='" + subjectFieldText + "'");
		//check message
		String messageWithQuote = "[quote=\"" + fromUser + "\"]" + message + "[/quote]";
		assertEquals(messageFieldText, messageWithQuote, "Not correct value in Subject field should be '" + messageWithQuote + "' actual='" + messageFieldText + "'");
	}
}