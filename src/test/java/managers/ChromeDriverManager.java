package managers;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends WebDriverManager {
	private ChromeDriverService chService;

	@Override
	protected void startService() {
		// TODO Auto-generated method stub
		if (null == chService) {
			try {
				chService = new ChromeDriverService.Builder()
						.usingDriverExecutable(new File("/home/admin12/Desktop/driver/chromedriver_linux64/chromedriver"))
						.usingAnyFreePort().build();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	protected void stopService() {
		// TODO Auto-generated method stub
		if (chService != null && chService.isRunning()) {
			chService.stop();
		}

	}

	@Override
	protected void createDriver() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("test-type");
		driver = new ChromeDriver(chService, option);

	}

}
