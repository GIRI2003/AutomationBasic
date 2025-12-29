package arrtibutes;

import org.testng.annotations.Test;

public class LearnGroups {
	
	@Test(groups = {"loggingFunction"})
	public void login() {
		System.out.println("Login into application");
	}
	
	@Test(groups = {"ProductFunction"})
	public void searchProduct() {
		System.out.println("Search for a product");
	}

	@Test(groups = {"ProductFunction"})
	public void addToCart() {
		System.out.println("Add the product to Cart");
	}
	
	@Test(groups = {"loggingFunction"})
	public void logout() {
		System.out.println("Logout from application");
	}
}
