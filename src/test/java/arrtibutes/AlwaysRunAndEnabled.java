package arrtibutes;


import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class AlwaysRunAndEnabled {
	
	
	//When alwaysRun and enabled are in same test enabled will suppress alwaysRun
	@Test(priority = 1, enabled = false, alwaysRun = true ,description = "Logging in to application")
	public void login() {
		System.out.println("Step 1 - Login");
	}
	
	@Test(priority = 2, description = "Searching a product")
	public void searchProduct() {
		System.out.println("Step 2 - Search a product");
		//Intentionally failing a test
		throw new NoSuchElementException("Element no found");
	}
	
	// (alwaysRun = true) runs a test in any situation
	@Test(priority = 3, dependsOnMethods = "arrtibutes.AlwaysRunAndEnabled.searchProduct", 
			alwaysRun = true, description = "adding a product to cart")
	public void addToCart() {
		System.out.println("Step 3 - Add to cart");
	}
	
	@Test(priority = 4, description = "Logging out from application")
	public void logout() {
		System.out.println("Step 4 - Logout");
	}
	
	
}
