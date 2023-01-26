package org.bots.tests;

import org.bots.common.BasePage;
import org.bots.common.publicData;
import org.bots.pages.DreamUi;
import org.testng.annotations.Test;

public class DreamUITest extends BasePage{
	@Test(testName = "calculate loan with default data", description =  "Check if the user can calculate a loan", priority = 1)
	public void calculateLoanWithDefaultData() throws Exception  {
		do {
			getUrl(publicData.ENVIRONMENT_URL);
			DreamUi dreamUi = new DreamUi();
			dreamUi.searchCriteriaInput.sendKeys(getRandomLinesFromTheFile());
			dreamUi.createButton.click();
			dreamUi.expandIcon.click();
			dreamUi.waitForCloseButtonAppear();
			Thread.sleep(3000);
		}while(true);
	}
}
