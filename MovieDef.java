package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import driver_Config.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objRep.IMBD_OR;
import objRep.WIKI_OR;

public class MovieDef extends Driver{
	public String imbdDate;
	public String imbdCountry;
	public String wikiDate;
	public String wikiCountry;
	IMBD_OR imd=new IMBD_OR(driver);
	WIKI_OR wiki=new WIKI_OR(driver);
	Actions a=new Actions(driver);
	

@Given("If user is on home page")
public void if_user_is_on_home_page() {
	driver.get(imbdURL);
   
}

@When("Search for Pushpa movie")
public void search_for_pushpa_movie() {
	imd.movieSearch("Pushpa:The Rise");
}

@When("Get release date & country")
public void get_release_date_country() {
	// get release date
			imbdDate=imd.releaseDate.getText();
			System.out.println("Release Date:"+imbdDate);
			// get country
			imbdCountry=imd.country.getText();
			System.out.println("Release Date:"+imbdCountry);
			
}

@When("Load WIKI page")
public void load_wiki_page() {
	driver.get(wikiURL);
}

@When("Search for Pushpa movie in WIKI")
public void search_for_pushpa_movie_in_wiki() {
	wiki.movieSearch("Pushpa:The Rise");
}

@When("Get release date & country IN WIKI")
public void get_release_date_country_in_wiki() {
	wikiDate=wiki.releaseDate.getText();
	System.out.println("Release Date:"+wikiDate);
	wikiCountry=wiki.country.getText();
	System.out.println(wikiDate);
}

@Then("Verify the movie Details")
public void verify_the_movie_details() {
	try {
		assertEquals(imbdDate,wikiDate);
		assertEquals(imbdCountry,wikiCountry);
		Thread.sleep(3000);
		}
	catch (Exception e) 
	{
		 System.out.println(e);
		 Assert.fail();
		 
	}
}

}
