package stepDefinitions;
import driver_Config.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
		
		@Before
		public void beforeScenario()
		{
			System.out.println("********** Before each scenario ***************");
			Driver.launchBrowser();
		}
		@After
		public void afterScenario()
		{
			System.out.println("********** After each scenario ***************");
			Driver.closeBrowser();
		}
		

}
