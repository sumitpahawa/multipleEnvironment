package managers;

public class DriverManagerFactory {

	public static WebDriverManager getManager(DriverType type) {

		WebDriverManager driverManager = null;
		switch (type) {
		case Chrome:
			driverManager = new ChromeDriverManager();
			break;
		default:
			break;
		}
		return driverManager;
	}

}
