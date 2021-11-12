import com.sun.xml.internal.ws.spi.db.BindingContextFactory
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

final class BrowserFactory(browser:String) {


    companion object{
        lateinit var driver: WebDriver

        fun getDriverFireFox(): WebDriver {
            WebDriverManager.firefoxdriver().setup()
            driver = FirefoxDriver()
            return driver
        }

        fun getDriverChrome(): WebDriver {
            WebDriverManager.chromedriver().setup()
            driver = ChromeDriver()
            return driver
        }

        fun closeDriver() {
            driver.quit()
        }



    }
    init { //choose browser on first symbol
        when (browser.substring(0, 1)) {
            "c" -> getDriverChrome()
            "f" -> getDriverFireFox()
            else -> BindingContextFactory.LOGGER.info("this browser not have")
        }
    }
}