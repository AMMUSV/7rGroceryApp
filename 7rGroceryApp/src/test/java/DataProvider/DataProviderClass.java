package DataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider (name = "add_user")
	public Object[][] dpMethod(){
		return new Object[][] {{"albin", "Staff" },{"adithya","Staff"}};
		}
		
	
	@DataProvider (name = "delete_user")
	public Object[][] dpMethod1(){
		return new Object[][] {{"albin", "Staff" },{"adithya","Staff" }};}
	
	
	@DataProvider (name = "add_deliveryBoy")
	public Object[][] dpMethod2(){
		return new Object[][] {{"ammu", "ammusv"}};}
	

	
}
