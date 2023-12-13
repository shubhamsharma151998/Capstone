package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import Base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Verification {
	
	WebDriver driver=Base.getDriver();
	
	@Given("User navigates to HomePage and Click on A\\/B Testing link")
	public void user_navigates_to_home_page_and_click_on_a_b_testing_link() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()=\'A/B Testing\']")).click();	}
	
	
	@Then("Verify the page has A/B Test Variation ")
	public void verify_the_page_has_a_b_test_variation()
	{
		
		WebElement text=driver.findElement(By.xpath("//div[@class=\"example\"]/h3"));
		String t=text.getText();
		 
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("A/B Test Variation 1", t);
	}

	@Then("Navigates Back to HomePage and click on dropdown link")
	public void navigates_back_to_home_page_and_click_on_dropdown_link() throws InterruptedException {
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()=\'Dropdown\']")).click();
		Thread.sleep(1000);
		

	}
	
	@Then("Select option1 value from the dropdown")
	public void select_option1_value_from_the_dropdown() throws InterruptedException {

		Select sel=new Select(driver.findElement(By.id("dropdown")));
		sel.selectByVisibleText("Option 1");
		
	}

	@Then("Confirm whether it is selected or not")
	public void confirm_whether_it_is_selected_or_not() {
		Select sel=new Select(driver.findElement(By.id("dropdown")));
		WebElement t=sel.getFirstSelectedOption();
		String text=t.getText();
		Assertion assertion = new Assertion();
		assertion.assertEquals("Option 1", text);
	}

	@Then("Navigates back to HomePage and Click on Frames")
	public void navigates_back_to_home_page_and_click_on_frames() {
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()=\'Frames\']")).click();	}

	@Then("Verify it contain Nested Frames and iFrames hyperlink on the Frame Page")
	public void verify_it_contain_nested_frames_and_i_frames_hyperlink_on_the_frame_page() {
		
		WebElement ele=driver.findElement(By.xpath("//a[text()=\"Nested Frames\"]"));
		boolean t=ele.isDisplayed();
		if(t)
		{
			System.out.println("Nested Frames is Displayed");
		}
		
		
		WebElement element=driver.findElement(By.xpath("//a[text()=\"iFrame\"]"));
		boolean tt=element.isDisplayed();
		if(t)
		{
			System.out.println("iFrames is Displayed");
		}

		
	}
		
	}


