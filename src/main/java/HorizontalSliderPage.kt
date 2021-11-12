import BrowserFactory.Companion.driver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class HorizontalSliderPage : PageObject() {
    private val slider = By.xpath("//div[@id=\"content\"]/div/div/input")
    private val resultSlider = By.xpath("//span[@id=\"range\"]")

    private val sliderElement: WebElement = driver.findElement(slider)
    private val resultElement: WebElement = driver.findElement(resultSlider)

    fun movingResult(): String {
        val move = Actions(BrowserFactory.driver)
        val action = move.dragAndDropBy(sliderElement, -50, 0).build()
        action.perform()
        return resultElement.text
    }

    fun isDisplayed(): Boolean {
        return sliderElement.isDisplayed
    }
}