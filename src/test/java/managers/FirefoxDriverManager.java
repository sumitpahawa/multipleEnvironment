package managers;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

public class FirefoxDriverManager extends WebDriverManager {
	private GeckoDriverService gkService;

	@Override
	protected void startService() {
		// TODO Auto-generated method stub
		if (null == gkService) {
			try {
				gkService = new GeckoDriverService.Builder()
						.usingDriverExecutable(new File(
								"install geckodriver"))
						.usingAnyFreePort().build();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	protected void stopService() {
		// TODO Auto-generated method stub
		if (gkService != null && gkService.isRunning()) {
			gkService.stop();
		}

	}

	@Override
	protected void createDriver() {
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("test-type");
		driver = new FirefoxDriver(gkService, option);

	}

}
