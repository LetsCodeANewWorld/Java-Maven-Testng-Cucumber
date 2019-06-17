package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import main.CucumberRunner;

public class HomePage extends CucumberRunner {	
		
	@FindBy(how = How.XPATH, using = "//input[@id='orb-search-q']")
	public WebElement searchBox;
		
//	@FindBy(how = How.XPATH, using = "//a[@aria-label='EastEnders']")
//	public WebElement programmeNameInSearchList;
	
	@FindBy(how = How.XPATH, using = "//div[@class='grid list__grid']/ul/li[1]")
	public WebElement latestEpisode;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Programme website']")
	public WebElement programmeWebSiteLink;
	
	
	@FindBy (how = How.XPATH, using = "//div[@class='island']/h2[.='Next on']/ancestor::div[@class='map-card-wrap br-box-secondary']//a/span/span")
	public WebElement nextEpisodeDate;
	
	
	@FindBy(how = How.XPATH, using = "//span[@class='timezone timezone--time']")
	public WebElement nextEpisodeTime;
	
	@FindBy(how = How.XPATH, using = "//span[@class='timezone timezone--date']")
	public WebElement nextEpisodeDayDate;
	
	
	public  HomePage() {	
//		driver = new CucumberRunner().driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchAndSelectProgramme(String programmeName) {
		
		searchBox.click();
		searchBox.sendKeys(programmeName);
		WebElement programmeNameInSearchList = driver.findElement(By.xpath("//a[@aria-label='xxxx']".replace("xxxx", programmeName)));
		programmeNameInSearchList.click();
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(@class,'hero-header__title ') and text()= '" + programmeName + "']")).isDisplayed(), true);
			
	}
	
	public void selectLatestEpisodeFromProgrammeList() {		
		latestEpisode.click();	
		Assert.assertEquals(programmeWebSiteLink.isDisplayed(), true);
	}
	
	public void clickProgrammeWebSiteLinkAndValidateProgrammePage(String programmeName) {
		
		String selectorVal = "//a[contains(@class,'br-masthead-logo') and contains(text(),'xxxx')]".replace("xxxx", programmeName);
		
		programmeWebSiteLink.click();
		Assert.assertEquals(driver.findElement(By.xpath(selectorVal)).isDisplayed(), true);
		
	}
	
	public void findNextEpisodeDate(String programmeName) {		
		
		String dateOfNextEpisode = nextEpisodeDate.getText();
		String dayDateOFNextDay = nextEpisodeDayDate.getText();
		String timeOFNextTime = nextEpisodeTime.getText();
		
		System.out.println("Next Episode of " + programmeName + " is available on : ");
		System.out.println(dateOfNextEpisode);
		System.out.println(dayDateOFNextDay);
		System.out.println(timeOFNextTime);
				
		
	}
    
}