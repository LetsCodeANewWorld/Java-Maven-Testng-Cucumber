package stepdefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import main.CucumberRunner;
import pages.HomePage;

public class Home extends CucumberRunner {
	
	HomePage home = new HomePage();

	@Given("^I am on \"(.*?)\" home page$")
	public void verifyPageTitle(String text) throws Throwable {

		String title = driver.getTitle();
		if(text.toLowerCase() == "bbc one") {
			Assert.assertEquals(title.toLowerCase(), "bbc iplayer - bbc one");
		} 	
	}
	

	@When("^I search and select programme \"([^\"]*)\"$")
	public void i_search_and_select_programme(String programmeName) throws Throwable {
		home.searchAndSelectProgramme(programmeName);
	}
	
	@And("^Select the latest available episodes from the programme page$")
	public void select_latest_episode_from_programme_page() throws Throwable {
		home.selectLatestEpisodeFromProgrammeList();
	}
	
	@Then("^I click on programme website link to navigate to \"([^\"]*)\" programme page$")
	public void click_programme_website_link(String programmeName) throws Throwable {
		home.clickProgrammeWebSiteLinkAndValidateProgrammePage(programmeName);
	}
	
	@Then("^I print on console the next avaiable episode date of \"([^\"]*)\"$")
	public void print_next_available_episode_on_console(String programmeName) throws Throwable {
		home.findNextEpisodeDate(programmeName);
	}

}
