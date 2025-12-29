package arrtibutes;

import org.testng.annotations.Test;

public class LearnPriority {
	
	// Priority starts from maximum value from negative to maximum value from positive
	// Default priority is 0
	// DependsOnMethod will easily suppress priority attribute
	
	@Test(priority = -5)
	public void signup() {
		System.out.println("Sign up");
	}
	@Test(priority = -1, dependsOnMethods = "arrtibutes.LearnPriority.Logout")
	public void login() {
		System.out.println("Login");
	}
	@Test
	public void searchProduct() {
		System.out.println("Search Product");
	}
	@Test(priority = 1)
	public void addToCart() {
		System.out.println("add to cart");
	}
	@Test(priority = 5)
	public void Logout() {
		System.out.println("Logout");
	}

}
