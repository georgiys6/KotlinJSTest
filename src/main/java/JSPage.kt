import BrowserFactory.Companion.driver
import com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER
import org.openqa.selenium.By
import org.openqa.selenium.WebElement


class JSPage : PageObject() {

    private val buttonByAlert = By.xpath("//div/ul/li[1]/button")
    private val buttonByConfirm = By.xpath("//div/ul/li[2]/button")
    private val buttonByPrompt = By.xpath("//div/ul/li[3]/button")
    private val text = By.xpath("//p[@id=\"result\"]")

    private val buttonAlert: WebElement = driver.findElement(buttonByAlert)
    private val buttonConfirm: WebElement = driver.findElement(buttonByConfirm)
    private val buttonPrompt: WebElement = driver.findElement(buttonByPrompt)

    private val textField : WebElement = driver.findElement(text)

    companion object{
        fun loggerInfoSetup() {
            LOGGER.info(driver.switchTo().alert().text)
        }

        fun loggerInfoPage(locator: By?) {
            LOGGER.info(driver.findElement(locator).text)
        }
    }

    fun utilManagerClick(element: WebElement) {
        element.click()
        loggerInfoSetup()
        driver.switchTo().alert().accept()
        loggerInfoPage(text)
        result += driver.findElement(text).text + "; "
    }

    fun utilManagerSendText(text: String?) {
        buttonPrompt.click()
        loggerInfoSetup()
        driver.switchTo().alert().sendKeys(text)
        driver.switchTo().alert().accept()
        loggerInfoPage(this.text)
        result += driver.findElement(this.text).text + "; "
    }

    fun isDisplayedAlert(): Boolean {
        return buttonAlert.isDisplayed
    }

    fun isDisplayedConfirm(): Boolean {
        return buttonConfirm.isDisplayed
    }

    fun isDisplayedPrompt(): Boolean {
        return buttonPrompt.isDisplayed
    }

    fun clickAlert() {
        utilManagerClick(buttonAlert)
    }

    fun clickConfirm() {
        utilManagerClick(buttonConfirm)
    }


}