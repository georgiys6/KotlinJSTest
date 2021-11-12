import com.sun.xml.internal.ws.spi.db.BindingContextFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class BasicPage : PageObject() {
    private val text = By.xpath("//div[@id=\"content\"]/div/p")

    private val webText: WebElement = BrowserFactory.driver.findElement(text)

    fun loggerInfoPage() {
        result += webText.text.toString() + "; "
        BindingContextFactory.LOGGER.info(result.toString())
    }

    fun getAttribute(text: String?): String? {
        return webText.getAttribute("testInfo")
    }

    fun waitingElement() {
        if (isDisplayed()) {
            val wait = WebDriverWait(BrowserFactory.driver, Duration.ofSeconds(10))
            wait.until(ExpectedConditions.visibilityOfElementLocated(text))
        }
    }

    fun isDisplayed(): Boolean {
        return webText.isDisplayed
    }
}