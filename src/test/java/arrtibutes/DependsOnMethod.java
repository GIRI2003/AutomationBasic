package arrtibutes;

import org.testng.annotations.Test;

public class DependsOnMethod {
	
	//When a method depends on another class's method,
	//Then it should be return as dependsOnMethods = "packageName.className.methodName"

	@Test()
	public void signup() {
		System.out.println("Sign up");
	}
	@Test(dependsOnMethods = "signup")
	public void login() {
		System.out.println("Login");
	}
	@Test(dependsOnMethods = "login")
	public void searchProduct() {
		System.out.println("Search Product");
	}
	@Test(dependsOnMethods = "searchProduct")
	public void addToCart() {
		System.out.println("add to cart");
	}
	@Test(dependsOnMethods = "addToCart")
	public void Logout() {
		System.out.println("Logout");
	}
	
	
}
