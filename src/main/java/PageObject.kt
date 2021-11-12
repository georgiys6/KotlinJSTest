import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

abstract class PageObject {
    var result: List<String> = ArrayList()

    protected open fun move(element: WebElement) {
        val move = Actions(BrowserFactory.driver)
        move.moveToElement(element).build().perform()
    }
}