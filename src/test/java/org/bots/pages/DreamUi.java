package org.bots.pages;
import org.bots.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DreamUi extends BasePage {

	public DreamUi()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[label='Enter prompt']")
	public WebElement searchCriteriaInput;
	
	@FindBy(css="[class*='Button__ButtonContainer'] [class*='CreateButton__St']")
	public WebElement createButton;
	
	@FindBy(css="[class*='SelectableItem__ExpandIcon']")
	public WebElement expandIcon;
	
	@FindBy(css="[class*='Modal'] [class*='IconButton__IconContainer']")
	public WebElement closeModalButton;
	
	@SuppressWarnings("deprecation")
	public void waitForCloseButtonAppear()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("[class*='Modal'] [class*='IconButton__IconContainer']")));
	}
}