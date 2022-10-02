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
	
@Given("If user is on IMBD page")
public void if_user_is_on_imbd_page() {
	driver.get(imbdURL);
}
@When("Search for {string} movie in IMBD")
public void search_for_movie_in_imbd(String str) {
	imd.movieSearch(str);
    
}
@When("Get release date & country in IMBD")
public void get_release_date_country_in_imbd() {
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

@When("Search for {string} movie in WIKI")
public void search_for_movie_in_wiki(String str) {
	wiki.movieSearch(str);
  
}

@When("Get release date & country IN WIKI")
public void get_release_date_country_in_wiki() {
	wikiDate=wiki.releaseDate.getText();
	System.out.println("Release Date:"+wikiDate);
	wikiCountry=wiki.country.getText();
	System.out.println(wikiDate);
}

@Then("Verify the movie Details in Both IMBD and WIKI")
public void verify_the_movie_details_in_both_imbd_and_wiki() {
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
