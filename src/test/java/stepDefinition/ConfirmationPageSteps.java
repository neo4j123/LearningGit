package stepDefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import junit.framework.Assert;
import pageObjects.ConfirmationPage;

@SuppressWarnings("deprecation")
public class ConfirmationPageSteps {

	TestContext testContext;
	ConfirmationPage confirmationPage;
	
	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}
	
	@Then("^verify the order details$")
	public void verify_the_order_details(){
		String productName = (String)testContext.scenarioContext.getContext(Context.PRODUCT_NAME);
		Assert.assertTrue(confirmationPage.getProductNames().stream().filter(x -> x.contains(productName)).findFirst().get().length()>0);		
	}
}
