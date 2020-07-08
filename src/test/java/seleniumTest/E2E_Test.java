package seleniumTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class E2E_Test {
	private static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/admin12/Desktop/driver/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		caps.setCapability("acceptInsecureCerts", true);
		driver = new ChromeDriver(caps);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.shop.demoqa.com");

		driver.navigate().to("https://shop.demoqa.com/?s=dress&post_type=product");

		List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		items.get(0).click();
		
		Select select = new Select(driver.findElement(By.id("pa_color")));
		select.selectByVisibleText("White");
		 select = new Select(driver.findElement(By.id("pa_size")));
		select.selectByVisibleText("Small");
		WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		addToCart.click();

		WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		cart.click();

		WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
		continueToCheckout.click();

		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		firstName.sendKeys("Lakshay");

		WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
		lastName.sendKeys("Sharma");

		WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
		emailAddress.sendKeys("test@gmail.com");

		WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
		phone.sendKeys("07438862327");

		WebElement countryDropDown = driver.findElement(By.cssSelector("#select2-billing_country-container"));
		countryDropDown.click();	
		Thread.sleep(6000);

		List<WebElement> countryList = driver.findElements(By.cssSelector(".select2-results__option"));
		for (WebElement country : countryList) {
			if (country.getText().equals("India")) {
				country.click();
				Thread.sleep(3000);
				break;
			}
		}
		WebElement stateDropDown = driver.findElement(By.cssSelector("#select2-billing_state-container"));
		stateDropDown.click();	
		Thread.sleep(6000);

		List<WebElement> stateList = driver.findElements(By.cssSelector(".select2-results__option"));
		for (WebElement state : stateList) {
System.out.println(state.getText());
			if (state.getText().equals("Assam")) {
				state.click();
				Thread.sleep(3000);
				break;
			}
		}

		WebElement city = driver.findElement(By.cssSelector("#billing_city"));
		city.sendKeys("Delhi");

		WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
		address.sendKeys("Shalimar Bagh");

		WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
		postcode.sendKeys("110088");

		WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
		shipToDifferetAddress.click();
		Thread.sleep(3000);

		List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
		paymentMethod.get(0).click();

		WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();

		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();

		driver.quit();

	}

}